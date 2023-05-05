package com.Jenna.eshop.Inventory.service.impl;

import com.Jenna.eshop.Inventory.service.InventoryFacadeService;
import com.Jenna.eshop.order.domain.OrderInfoDTO;
import com.Jenna.eshop.wms.domain.PurchaseInputOrderDTO;
import com.Jenna.eshop.wms.domain.ReturnGoodsInputOrderDTO;

/**
 * 库存中心对外接口service组件
 * @author Jenna C He
 * @date 2023/05/05 10:03
 */
public class InventoryFacadeServiceImpl implements InventoryFacadeService {
    /**
     * 通知库存中心，"采购入库完成"事件发生了
     *
     * @param purchaseInputOrderDTO 采购入库单DTO
     * @return 处理结果
     */
    @Override
    public Boolean informPurchaseInputFinished(PurchaseInputOrderDTO purchaseInputOrderDTO) {
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
        return true;
    }

    /**
     * 通知库存中心，"完成退货入库"事件发生了
     *
     * @param returnGoodsInputOrderDTO 退货入库单DTO
     * @return 处理结果
     */
    @Override
    public Boolean informReturnGoodsInputFinished(ReturnGoodsInputOrderDTO returnGoodsInputOrderDTO) {
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
        return 1159L;
    }
}
