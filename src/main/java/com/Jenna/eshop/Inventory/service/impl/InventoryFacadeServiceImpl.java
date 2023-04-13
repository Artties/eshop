package com.Jenna.eshop.Inventory.service.impl;

import com.Jenna.eshop.Inventory.command.GoodsStockUpdateCommand;
import com.Jenna.eshop.Inventory.command.PurchaseInputStockUpdateCommandFactory;
import com.Jenna.eshop.Inventory.command.ReturnGoodsInputStockUpdateCommandFactory;
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
    private PurchaseInputStockUpdateCommandFactory<PurchaseInputOrderDTO>
            purchaseInputStockUpdateCommandFactory;


    /**
     * 退货入库库存更新命令工厂
     */
    @Autowired
    private ReturnGoodsInputStockUpdateCommandFactory<ReturnGoodsInputOrderDTO>
            returnGoodsInputStockUpdateCommandFactory;


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
            GoodsStockUpdateCommand goodsStockUpdateCommand =
                    purchaseInputStockUpdateCommandFactory.create(purchaseInputOrderDTO);
            goodsStockUpdateCommand.updateGoodsStock();
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
        return false;
    }

    /**
     * 通知库存中心，"支付订单"事件发生了
     *
     * @param orderInfoDTO 订单DTO
     * @return 处理结果
     */
    @Override
    public Boolean informPayOrderEvent(OrderInfoDTO orderInfoDTO) {
        return false;
    }

    /**
     * 通知库存中心，"取消订单"事件发生了
     *
     * @param orderInfoDTO 订单DTO
     * @return 处理结果
     */
    @Override
    public Boolean informCancelOrderEvent(OrderInfoDTO orderInfoDTO) {
        return false;
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
            GoodsStockUpdateCommand goodsStockUpdateCommand =
                    returnGoodsInputStockUpdateCommandFactory.create(returnGoodsInputOrderDTO);
            goodsStockUpdateCommand.updateGoodsStock();
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
        return 0L;
    }
}
