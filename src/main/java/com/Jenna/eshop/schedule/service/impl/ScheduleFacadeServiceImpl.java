package com.Jenna.eshop.schedule.service.impl;

import com.Jenna.eshop.customer.domain.ReturnGoodsWorksheetDTO;
import com.Jenna.eshop.order.domain.OrderInfoDTO;
import com.Jenna.eshop.schedule.service.ScheduleFacadeService;
import com.Jenna.eshop.wms.domain.PurchaseInputOrderDTO;
import com.Jenna.eshop.wms.domain.ReturnGoodsInputOrderDTO;

/**
 * @author Jenna C He
 * @date 2023/05/08 11:35
 */
public class ScheduleFacadeServiceImpl implements ScheduleFacadeService {
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
     * 调度采购入库
     *
     * @param purchaseInputOrderDTO 采购单DTO
     * @return 处理结果
     */
    @Override
    public Boolean schedulePurchaseInput(PurchaseInputOrderDTO purchaseInputOrderDTO) {
        return true;
    }

    /**
     * 调度销售出库
     *
     * @param orderInfoDTO 订单DTO
     * @return 处理结果
     */
    @Override
    public Boolean scheduleSaleDelivery(OrderInfoDTO orderInfoDTO) {
        return true;
    }

    /**
     * 调度退货入库
     *
     * @param orderInfoDTO            订单DTO
     * @param returnGoodsWorksheetDTO 退货工单DTO
     * @return 处理结果
     */
    @Override
    public Boolean scheduleReturnGoodsInput(OrderInfoDTO orderInfoDTO, ReturnGoodsWorksheetDTO returnGoodsWorksheetDTO) {
        return true;
    }
}
