package test.java.com.Jenna.eshop.comment.schedule;

import com.Jenna.eshop.comment.domain.CommentInfoDTO;
import com.Jenna.eshop.comment.schedule.AutoPublishCommentTask;
import com.Jenna.eshop.comment.service.CommentAggregateService;
import com.Jenna.eshop.comment.service.CommentInfoService;
import com.Jenna.eshop.order.domain.OrderInfoDTO;
import com.Jenna.eshop.order.domain.OrderItemDTO;
import com.Jenna.eshop.order.service.OrderFacadeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

/**
 * 自动发表评论调度任务的单元测试类
 * @author Jenna C He
 * @date 2023/04/24 17:43
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AutoPublishCommentTaskTest {
    /**
     * 自动发表评论调度任务
     */
    @Autowired
    private AutoPublishCommentTask autoPublishCommentTask;
    /**
     * 订单中心对外接口service组件
     */
    @MockBean
    private OrderFacadeService orderFacadeService;
    /**
     * 评论信息管理模块service组件
     */
    @MockBean
    private CommentInfoService commentInfoService;
    /**
     * 评论统计信息管理模块service组件
     */
    @MockBean
    private CommentAggregateService commentAggregateService;

    /**
     * 测试每隔10分钟检查一次
     * @throws Exception 抛出异常
     */
    @Test
    public void testExecute() throws Exception {
        List<OrderInfoDTO> orderInfoDTOs = createOrderInfoDTOs();

        List<Long> orderIds = new ArrayList<Long>();
        for(OrderInfoDTO orderInfoDTO : orderInfoDTOs){
            orderIds.add(orderInfoDTO.getId());
        }

        when(orderFacadeService.listNotPublishedCommentOrders()).thenReturn(orderInfoDTOs);

        CommentInfoDTO commentInfoDTO1 = new CommentInfoDTO();
        when(commentInfoService.saveAutoPublishedCommentInfo(orderInfoDTOs.get(0),
                orderInfoDTOs.get(0).getOrderItems().get(0))).thenReturn(commentInfoDTO1);


        CommentInfoDTO commentInfoDTO2 = new CommentInfoDTO();
        when(commentInfoService.saveAutoPublishedCommentInfo(orderInfoDTOs.get(0),
                orderInfoDTOs.get(0).getOrderItems().get(1))).thenReturn(commentInfoDTO2);

        CommentInfoDTO commentInfoDTO3 = new CommentInfoDTO();
        when(commentInfoService.saveAutoPublishedCommentInfo(orderInfoDTOs.get(1),
                orderInfoDTOs.get(1).getOrderItems().get(0))).thenReturn(commentInfoDTO3);

        CommentInfoDTO commentInfoDTO4 = new CommentInfoDTO();
        when(commentInfoService.saveAutoPublishedCommentInfo(orderInfoDTOs.get(1),
                orderInfoDTOs.get(1).getOrderItems().get(1))).thenReturn(commentInfoDTO4);

        autoPublishCommentTask.execute();

        verify(commentInfoService,times(1)).saveAutoPublishedCommentInfo(orderInfoDTOs.get(0),
                orderInfoDTOs.get(0).getOrderItems().get(0));
        verify(commentInfoService,times(1)).saveAutoPublishedCommentInfo(orderInfoDTOs.get(0),
                orderInfoDTOs.get(0).getOrderItems().get(1));
        verify(commentInfoService,times(1)).saveAutoPublishedCommentInfo(orderInfoDTOs.get(1),
                orderInfoDTOs.get(1).getOrderItems().get(0));
        verify(commentInfoService,times(1)).saveAutoPublishedCommentInfo(orderInfoDTOs.get(1),
                orderInfoDTOs.get(1).getOrderItems().get(1));

        verify(commentAggregateService,times(4)).refreshCommentAggregate(commentInfoDTO1);
        verify(orderFacadeService,times(1)).informBatchPublishCommentEvent(orderIds);


    }

    /**
     * 创建订单信息DTO集合
     * @return 订单信息DTO集合
     * @throws Exception 抛出异常
     */
    private List<OrderInfoDTO> createOrderInfoDTOs() throws Exception {
        //构造第一个订单信息DTO
        OrderInfoDTO orderInfoDTO1 = new OrderInfoDTO();
        orderInfoDTO1.setId(1L);

        OrderItemDTO orderItemDTO1 = new OrderItemDTO();
        orderItemDTO1.setId(1L);

        OrderItemDTO orderItemDTO2 = new OrderItemDTO();
        orderItemDTO2.setId(2L);

        List<OrderItemDTO> orderItemDTOs1 = new ArrayList<OrderItemDTO>();
        orderItemDTOs1.add(orderItemDTO1);
        orderItemDTOs1.add(orderItemDTO2);


        orderItemDTO1.setOrderItems(orderItemDTOs1);

        //构造第二个订单信息DTO
        OrderInfoDTO orderInfoDTO2 = new OrderInfoDTO();
        orderInfoDTO2.setId(2L);

        OrderItemDTO orderItemDTO3 = new OrderItemDTO();
        orderItemDTO3.setId(3L);

        OrderItemDTO orderItemDTO4 = new OrderItemDTO();
        orderItemDTO4.setId(4L);

        List<OrderItemDTO> orderItemDTOs2 = new ArrayList<OrderItemDTO>();
        orderItemDTOs2.add(orderItemDTO3);
        orderItemDTOs2.add(orderItemDTO4);

        orderInfoDTO2.setOrderItems(orderItemDTOs2);

        //构造订单DTO集合
        List<OrderInfoDTO> orderInfoDTOs = new ArrayList<OrderInfoDTO>();
        orderInfoDTOs.add(orderInfoDTO1);
        orderInfoDTOs.add(orderInfoDTO2);

        return orderInfoDTOs;
    }
}
