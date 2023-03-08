/**
 * @author Jenna C He
 * @date 2023/3/8 18:56
 */
package com.Jenna.eshop.comment.schedule;

import com.Jenna.eshop.order.domain.OrderInfoDTO;
import com.Jenna.eshop.order.domain.OrderItemDTO;
import com.Jenna.eshop.order.service.OrderFacadeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

public class AutoPublishCommentTask {
    private static final Logger logger = LoggerFactory.getLogger(AutoPublishCommentTask.class);
    /**
     * 订单中心的service组件
     */
    @Autowired
    private OrderFacadeService orderFacadeService;

    @Scheduled(fixedRate = 10 * 60 * 1000)
    public void execute() {
        try {
            //先从订单中心查询确认时间超过7天，而且还没有发表评论的订单
            List<OrderInfoDTO> orderInfoDTOs = orderFacadeService.listNotPublishedCommentOrders();

            if(orderInfoDTOs != null && orderInfoDTOs.size() > 0){
                for (OrderInfoDTO orderInfoDTO: orderInfoDTOs) {
                    if(OrderInfoDTO.getOrderItems() == null ||
                            orderInfoDTO.getOrderItems().size() == 0) {
                     continue;
                    }
                    //遍历订单中的订单项
                    for (OrderItemDTO orderItemDTO:orderInfoDTO.getOrderItems()){

                    }
                }
            }

        }catch (Exception e) {
            logger.error("error",e);
            //return false;
        }
        //return true;
    }

}
