package com.Jenna.eshop.Inventory.service.impl;


import com.Jenna.eshop.Inventory.async.GoodsStockUpdateMessage;
import com.Jenna.eshop.Inventory.async.GoodsStockUpdateQueue;
import com.Jenna.eshop.Inventory.constant.GoodsStockUpdateOperation;
import com.Jenna.eshop.Inventory.dao.GoodsStockDAO;
import com.Jenna.eshop.Inventory.domain.GoodsStockDO;
import com.Jenna.eshop.Inventory.updater.*;
import com.Jenna.eshop.Inventory.service.InventoryFacadeService;
import com.Jenna.eshop.order.domain.OrderInfoDTO;
import com.Jenna.eshop.wms.domain.PurchaseInputOrderDTO;
import com.Jenna.eshop.wms.domain.ReturnGoodsInputOrderDTO;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private ReturnGoodsInputStockUpdaterFactory<ReturnGoodsInputOrderDTO>
            returnGoodsInputStockUpdateCommandFactory;

    /**
     * 提交订单库存更新组件工厂
     */
    @Autowired
    private SubmitOrderStockUpdaterFactory<ReturnGoodsInputOrderDTO>
            submitOrderStockUpdaterFactory;

    /**
     * 支付订单库存更新组件工厂
     */
    @Autowired
    private PayOrderStockUpdaterFactory<ReturnGoodsInputOrderDTO>
            payOrderStockUpdaterFactory;

    /**
     * 取消订单库存更新组件工厂
     */
    @Autowired
    private CancelOrderStockUpdaterFactory<ReturnGoodsInputOrderDTO>
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
    private GoodsStockUpdateQueue goodsStockUpdateQueue;

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
            GoodsStockUpdater goodsStockUpdater =
                    purchaseInputStockUpdateCommandFactory.create(purchaseInputOrderDTO);
            goodsStockUpdater.updateGoodsStock();
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
            GoodsStockUpdater goodsStockUpdater =
                    submitOrderStockUpdaterFactory.create(orderInfoDTO);
            goodsStockUpdater.updateGoodsStock();

            GoodsStockUpdateMessage message = new GoodsStockUpdateMessage();
            message.setOperation(GoodsStockUpdateOperation.SUBMIT_ORDER);
            message.setParameter(orderInfoDTO);
            goodsStockUpdateQueue.put(message);
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
            GoodsStockUpdater goodsStockUpdater =
                    payOrderStockUpdaterFactory.create(orderInfoDTO);
            goodsStockUpdater.updateGoodsStock();

            GoodsStockUpdateMessage message = new GoodsStockUpdateMessage();
            message.setOperation(GoodsStockUpdateOperation.PAY_ORDER);
            message.setParameter(orderInfoDTO);
            goodsStockUpdateQueue.put(message);
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
            GoodsStockUpdater goodsStockUpdater =
                    cancelOrderStockUpdaterFactory.create(orderInfoDTO);
            goodsStockUpdater.updateGoodsStock();

            GoodsStockUpdateMessage message = new GoodsStockUpdateMessage();
            message.setOperation(GoodsStockUpdateOperation.CANCEL_ORDER);
            message.setParameter(orderInfoDTO);
            goodsStockUpdateQueue.put(message);

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
            GoodsStockUpdater goodsStockUpdater =
                    returnGoodsInputStockUpdateCommandFactory.create(returnGoodsInputOrderDTO);
            goodsStockUpdater.updateGoodsStock();
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
