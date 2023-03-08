package com.Jenna.eshop.order.service.impl;

import com.Jenna.eshop.order.domain.OrderInfoDTO;
import com.Jenna.eshop.order.service.OrderFacadeService;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author Jenna C He
 * @date 2023/3/8 12:15
 */
@Service
public class OrderFacadeServiceImpl implements OrderFacadeService {
    /**
     * 通知订单中心，"商品完成发货"事件发生了
     *
     * @param orderId 订单id
     * @return 处理结果
     */
    @Override
    public Boolean informGoodsDeliveryFinishedEvent(Long orderId) {
        return null;
    }

    /**
     * 通知订单中心，"退货工单审核被拒，审核不通过"事件发生了
     *
     * @param orderId 订单id
     * @return 处理结果
     */
    @Override
    public Boolean informReturnGoodsWorksheetRejectedEvent(Long orderId) {
        return null;
    }

    /**
     * 通知订单中心，"退货工单审核通过"事件发生了
     *
     * @param orderId 订单id
     * @return 处理结果
     */
    @Override
    public Boolean informReturnGoodsWorksheetApprovedEvent(Long orderId) {
        return null;
    }

    /**
     * 通知订单中心，"确认收到退货商品"事件发生了
     *
     * @param orderId 订单id
     * @return 处理结果
     */
    @Override
    public Boolean informReturnGoodsReceivedEvent(Long orderId) {
        return null;
    }

    /**
     * 通知订单中心，"退货入库单审核通过"事件发生了
     *
     * @param orderId 订单id
     * @return 处理结果
     */
    @Override
    public Boolean informReturnGoodsInputOrderApprovedEvent(Long orderId) {
        return null;
    }

    /**
     * 通知订单中心，"完成退款"事件发生了
     *
     * @param orderId 订单id
     * @return 处理结果
     */
    @Override
    public Boolean informRefundFinishedEvent(Long orderId) {
        return null;
    }

    /**
     * 通知订单中心，订单发表评论事件发生了
     *
     * @param orderId 订单id
     * @return 处理结果
     */
    @Override
    public Boolean informPublishCommentEvent(Long orderId) {
        return null;
    }

    /**
     * 从订单中心获取，确认收货时间超过了7天，而且还没有发表评论的订单
     *
     * @return 订单信息DTO集合
     */
    @Override
    public List<OrderInfoDTO> listNotPublishedCommentOrders() {
        return null;
    }

    /**
     * 通知订单中心，"订单批量发表评论事件"发生了
     *
     * @param orderIds 订单id集合
     * @return 处理结果
     */
    @Override
    public Boolean informBatchPublishCommentEvent(List<Long> orderIds) {
        return null;
    }
}