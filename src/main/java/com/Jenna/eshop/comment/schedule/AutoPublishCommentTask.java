/**
 * @author Jenna C He
 * @date 2023/3/8 18:56
 */
package com.Jenna.eshop.comment.schedule;

import com.Jenna.eshop.comment.domain.CommentInfoDTO;
import com.Jenna.eshop.comment.service.CommentInfoService;
import com.Jenna.eshop.comment.service.impl.CommentInfoServiceImpl;
import com.Jenna.eshop.order.domain.OrderInfoDTO;
import com.Jenna.eshop.order.domain.OrderItemDTO;
import com.Jenna.eshop.order.service.OrderFacadeService;
import com.Jenna.eshop.service.CommentAggregateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AutoPublishCommentTask {
    private static final Logger logger = LoggerFactory.getLogger(AutoPublishCommentTask.class);
    /**
     * 订单中心的service组件
     */
    @Autowired
    private OrderFacadeService orderFacadeService;
    /**
     * 评论信息管理模块的service组件
     */
    @Autowired
    private CommentInfoService commentInfoService;
    /**
     * 评论统计信息模块的service组件
     */
    @Autowired
    private CommentAggregateService commentAggregateService;

    @Scheduled(fixedRate = 10 * 60 * 1000)
    public void execute() {
        try {
            //先从订单中心查询确认时间超过7天，而且还没有发表评论的订单
            List<OrderInfoDTO> orderInfoDTOs = orderFacadeService.listNotPublishedCommentOrders();
            List<Long> orderInfoIds = new ArrayList<Long>(orderInfoDTOs.size());

            if(orderInfoDTOs != null && orderInfoDTOs.size() > 0){
                for (OrderInfoDTO orderInfoDTO: orderInfoDTOs) {
                    if(orderInfoDTO.getOrderItems() == null ||
                            orderInfoDTO.getOrderItems().size() == 0) {
                     continue;
                    }
                    orderInfoIds.add(orderInfoDTO.getId());
                    //遍历订单中的订单项
                    for (OrderItemDTO orderItemDTO: orderInfoDTO.getOrderItems()){
                        //先保存自动发表的评论信息
                        CommentInfoDTO commentInfoDTO = commentInfoService
                                .saveAutoPublishedCommentInfo(orderInfoDTO,orderItemDTO);
                        //更新统计信息
                        commentAggregateService.refreshCommentAggregate(commentInfoDTO);

                    }
                }
            }
            //通知订单中心，批量发表了评论
            orderFacadeService.informBatchPublishCommentEvent(orderInfoIds);
        }catch (Exception e) {
            logger.error("error",e);
            //return false;
        }
        //return true;
    }

}
