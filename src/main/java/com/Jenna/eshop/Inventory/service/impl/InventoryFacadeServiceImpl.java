package com.Jenna.eshop.Inventory.service.impl;


import com.Jenna.eshop.Inventory.async.StockUpdateResultManager;
import com.Jenna.eshop.Inventory.async.StockUpdateMessage;
import com.Jenna.eshop.Inventory.async.StockUpdateQueue;
import com.Jenna.eshop.Inventory.constant.GoodsStockUpdateOperation;
import com.Jenna.eshop.Inventory.dao.GoodsStockDAO;
import com.Jenna.eshop.Inventory.domain.GoodsStockDO;
import com.Jenna.eshop.Inventory.updater.*;
import com.Jenna.eshop.Inventory.service.InventoryFacadeService;
import com.Jenna.eshop.order.domain.OrderInfoDTO;
import com.Jenna.eshop.wms.domain.PurchaseInputOrderDTO;
import com.Jenna.eshop.wms.domain.ReturnGoodsInputOrderDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * 库存中心对外提供接口的service组件
 * @author Jenna C He
 * @date 2023/04/13 15:49
 */
@Service
public class InventoryFacadeServiceImpl implements InventoryFacadeService {
    private static final Logger logger = LoggerFactory.getLogger(InventoryFacadeServiceImpl.class);
    /**
     * 采购入库库存更新命令工厂
     */
    @Autowired
    private PurchaseInputStockUpdaterFactory<PurchaseInputOrderDTO>
            purchaseInputStockUpdateCommandFactory;

    /**
     * 退货入库库存更新命令工厂
     */
    @Autowired
    private ReturnInputStockUpdaterFactory<ReturnGoodsInputOrderDTO>
            returnGoodsInputStockUpdateCommandFactory;

    /**
     * 提交订单库存更新组件工厂
     */
    @Autowired
    private SubmitOrderStockUpdaterFactory<OrderInfoDTO>
            submitOrderStockUpdaterFactory;

    /**
     * 支付订单库存更新组件工厂
     */
    @Autowired
    private PayOrderStockUpdaterFactory<OrderInfoDTO>
            payOrderStockUpdaterFactory;

    /**
     * 取消订单库存更新组件工厂
     */
    @Autowired
    private CancelOrderStockUpdaterFactory<OrderInfoDTO>
            cancelOrderStockUpdaterFactory;

    /**
     * 商品库存管理模块的DAO组件
     */
    @Autowired
    private GoodsStockDAO goodsStockDAO;

    /**
     * 商品库存更新队列
     */
    @Autowired
    private StockUpdateQueue stockUpdateQueue;

    /**
     * 商品库存更新管理组件
     */
    @Autowired
    private StockUpdateResultManager stockUpdateResultManager;

    /**
     * 通知库存中心，"采购入库完成"事件发生了
     *
     * @param purchaseInputOrderDTO 采购入库单DTO
     * @return 处理结果
     */
    @Override
    public Boolean informPurchaseInputFinished(
            PurchaseInputOrderDTO purchaseInputOrderDTO) {
        try {
            StockUpdater stockUpdater =
                    purchaseInputStockUpdateCommandFactory.create(purchaseInputOrderDTO);
            stockUpdater.updateGoodsStock();
        }catch (Exception e) {
            logger.error("error",e);
            return false;
        }
        return true;
    }

    /**
     * 通知库存中心，"提交订单"事件发生了
     *
     * @param orderInfoDTO 订单DTO
     * @return 处理结果
     */
    @Override
    public Boolean informSubmitOrderEvent(OrderInfoDTO orderInfoDTO) {
        try {
            //更新本地库存
            StockUpdater stockUpdater =
                    submitOrderStockUpdaterFactory.create(orderInfoDTO);
            stockUpdater.updateGoodsStock();

            //发送异步消息到内存队列
            StockUpdateMessage message = new StockUpdateMessage();
            message.setId(UUID.randomUUID().toString().replace("-",""));
            message.setOperation(GoodsStockUpdateOperation.SUBMIT_ORDER);
            message.setParameter(orderInfoDTO);

            stockUpdateQueue.put(message);

            //监听异步处理结果
            stockUpdateResultManager.observe(message.getId());

        }catch (Exception e) {
            logger.error("error",e);
            return false;
        }
        return true;
    }

    /**
     * 通知库存中心，"支付订单"事件发生了
     *
     * @param orderInfoDTO 订单DTO
     * @return 处理结果
     */
    @Override
    public Boolean informPayOrderEvent(OrderInfoDTO orderInfoDTO) {
        try {
            //更新本地库存
            StockUpdater stockUpdater =
                    payOrderStockUpdaterFactory.create(orderInfoDTO);
            stockUpdater.updateGoodsStock();

            //发送异步消息到内存队列
            StockUpdateMessage message = new StockUpdateMessage();
            message.setId(UUID.randomUUID().toString().replace("-",""));
            message.setOperation(GoodsStockUpdateOperation.PAY_ORDER);
            message.setParameter(orderInfoDTO);

            stockUpdateQueue.put(message);

            //监听异步处理结果
            stockUpdateResultManager.observe(message.getId());
        }catch (Exception e) {
            logger.error("error",e);
            return false;
        }
        return true;
    }

    /**
     * 通知库存中心，"取消订单"事件发生了
     *
     * @param orderInfoDTO 订单DTO
     * @return 处理结果
     */
    @Override
    public Boolean informCancelOrderEvent(OrderInfoDTO orderInfoDTO) {
        try {
            //更新本地库存
            StockUpdater stockUpdater =
                    cancelOrderStockUpdaterFactory.create(orderInfoDTO);
            stockUpdater.updateGoodsStock();

            //发送异步消息到内存队列
            StockUpdateMessage message = new StockUpdateMessage();
            message.setId(UUID.randomUUID().toString().replace("-",""));
            message.setOperation(GoodsStockUpdateOperation.CANCEL_ORDER);
            message.setParameter(orderInfoDTO);
            stockUpdateQueue.put(message);

            //监听异步处理结果
            stockUpdateResultManager.observe(message.getId());

        }catch (Exception e) {
            logger.error("error",e);
            return false;
        }
        return true;
    }

    /**
     * 通知库存中心，"完成退货入库"事件发生了
     *
     * @param returnGoodsInputOrderDTO 退货入库单DTO
     * @return 处理结果
     */
    @Override
    public Boolean informReturnGoodsInputFinished(
            ReturnGoodsInputOrderDTO returnGoodsInputOrderDTO) {
        try {
            StockUpdater stockUpdater =
                    returnGoodsInputStockUpdateCommandFactory.create(returnGoodsInputOrderDTO);
            stockUpdater.updateGoodsStock();
        }catch (Exception e) {
            logger.error("error",e);
            return false;
        }
        return true;
    }

    /**
     * 查询商品sku的库存
     *
     * @param goodsSkuId 商品sku id
     * @return 商品sku的库存
     */
    @Override
    public Long getSaleStockQuantity(Long goodsSkuId) {
        try {

            GoodsStockDO goodsStockDO = goodsStockDAO
                    .getGoodsStockBySkuId(goodsSkuId);
            if (goodsStockDO == null){
                return 0L;
            }
            return goodsStockDO.getSaleStockQuantity();
        } catch (Exception e) {
            logger.error("error",e);
        }
        return 0L;
    }
}
