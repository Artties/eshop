package com.Jenna.eshop.schedule.service;

import com.Jenna.eshop.customer.domain.ReturnGoodsWorksheetDTO;
import com.Jenna.eshop.order.domain.OrderDTO;
import com.Jenna.eshop.wms.domain.PurchaseInputOrderDTO;
import com.Jenna.eshop.wms.domain.ReturnGoodsInputOrderDTO;

/**
 * 调度中心对外提供的接口
 */
public interface ScheduleFacadeService {
    /**
     * 通知库存中心，"采购入库完成"事件发生了
     * @param purchaseInputOrderDTO 采购入库单DTO
     * @return 处理结果
     */
    Boolean informPurchaseInputFinished(PurchaseInputOrderDTO purchaseInputOrderDTO);

    /**
     * 通知库存中心，"提交订单"事件发生了
     * @param orderDTO 订单DTO
     * @return 处理结果
     */
    Boolean informSubmitOrderEvent(OrderDTO orderDTO);

    /**
     * 通知库存中心，"支付订单"事件发生了
     * @param orderDTO 订单DTO
     * @return 处理结果
     */
    Boolean informPayOrderEvent(OrderDTO orderDTO);

    /**
     * 通知库存中心，"取消订单"事件发生了
     * @param orderDTO 订单DTO
     * @return 处理结果
     */
    Boolean informCancelOrderEvent(OrderDTO orderDTO);

    /**
     * 通知库存中心，"完成退货入库"事件发生了
     * @param returnGoodsInputOrderDTO 退货入库单DTO
     * @return 处理结果
     */
    Boolean informReturnGoodsInputFinished(ReturnGoodsInputOrderDTO returnGoodsInputOrderDTO);

    /**
     *调度采购入库
     * @param purchaseInputOrderDTO 采购单DTO
     * @return 处理结果
     */
    Boolean schedulePurchaseInput(PurchaseInputOrderDTO purchaseInputOrderDTO);

    /**
     * 调度销售出库
     * @param orderDTO 订单DTO
     * @return 处理结果
     */
    Boolean scheduleSaleDelivery(OrderDTO orderDTO);

    /**
     * 调度退货入库
     * @param orderDTO 订单DTO
     * @param returnGoodsWorksheetDTO 退货工单DTO
     * @return 处理结果
     */
    Boolean scheduleReturnGoodsInput(OrderDTO orderDTO, ReturnGoodsWorksheetDTO returnGoodsWorksheetDTO);

}
