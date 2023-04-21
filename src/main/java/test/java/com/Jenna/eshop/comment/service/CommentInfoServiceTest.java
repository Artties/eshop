package test.java.com.Jenna.eshop.comment.service;

import com.Jenna.eshop.comment.constant.*;
import com.Jenna.eshop.comment.dao.CommentInfoDAO;
import com.Jenna.eshop.comment.domain.CommentInfoDO;
import com.Jenna.eshop.comment.domain.CommentInfoDTO;
import com.Jenna.eshop.comment.service.CommentInfoService;
import com.Jenna.eshop.common.util.DateProvider;
import com.Jenna.eshop.order.domain.OrderInfoDTO;
import com.Jenna.eshop.order.domain.OrderItemDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

/**
 * 评论信息管理模块service组件的单元测试类
 * @author Jenna C He
 * @date 2023/04/21 10:56
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentInfoServiceTest {
    /**
     * 评论信息管理模块的service组件
     */
    @Autowired
    private CommentInfoService commentInfoService;
    /**
     * 评论信息管理模块的DAO组件
     */
    @MockBean
    private CommentInfoDAO commentInfoDAO;
    /**
     * 日期辅助组件
     */
    @MockBean
    private DateProvider dateProvider;

    /**
     * 初始化
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currentTime = dateFormatter.parse(dateFormatter.format(new Date()));
        when(dateProvider.getCurrentTime()).thenReturn(currentTime);
    }

    /**
     * 测试新增手动发表评论信息
     * @throws Exception
     */
    @Test
    public void testSaveAutoPublishedCommentInfo() throws Exception {
        Long commentInfoId = 1L;
        CommentInfoDTO partialCommentInfoDTO = createPartialCommentInfoDTO();
        CommentInfoDTO commentInfoDTO = createFullCommentInfoDTO(partialCommentInfoDTO);
        CommentInfoDO commentInfoDO = convertCommentInfoDTO2DO(commentInfoDTO);

        when(commentInfoDAO.saveCommentInfo(commentInfoDO)).thenReturn(commentInfoId);

        Boolean result = commentInfoService.saveManualPublishedCommentInfo(partialCommentInfoDTO);

        verify(commentInfoDAO,times(1)).saveCommentInfo(commentInfoDO);
        assertTrue(result);
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void testSaveAutoPublishedCommentInfo() throws Exception {
        OrderInfoDTO orderInfoDTO =
    }


    /**
     * 创建一个含有部分数据的评论信息DTO对象
     * @return 评论信息DTO对象
     * @throws Exception 抛出异常
     */
    private CommentInfoDTO createPartialCommentInfoDTO() throws Exception {
        CommentInfoDTO commentInfoDTO = new CommentInfoDTO();

        commentInfoDTO.setCommentContent("测试评论");
        commentInfoDTO.setCustomerServiceScore(CommentInfoScore.FOUR);
        commentInfoDTO.setLogisticsScore(CommentInfoScore.THREE);
        commentInfoDTO.setGoodsId(1L);
        commentInfoDTO.setGoodsSkuId(1L);
        commentInfoDTO.setGoodsSkuSaleProperties("测试销售属性");
        commentInfoDTO.setOrderInfoId(1L);
        commentInfoDTO.setOrderItemId(1L);
        commentInfoDTO.setShowPictures(ShowPictures.YES);
        commentInfoDTO.setUserAccountId(1L);
        commentInfoDTO.setUsername("test");

        return commentInfoDTO;
    }


    /**
     * 创建一个完整的评论信息DTO对象
     * @param partialCommentInfoDTO 评论信息DTO对象
     * @return 评论信息DTO对象
     * @throws Exception 抛出异常
     */
    private CommentInfoDTO createFullCommentInfoDTO(CommentInfoDTO partialCommentInfoDTO) throws Exception {
        CommentInfoDTO commentInfoDTO = new CommentInfoDTO();

        commentInfoDTO.setCommentContent(partialCommentInfoDTO.getCommentContent());
        commentInfoDTO.setCustomerServiceScore(partialCommentInfoDTO.getCustomerServiceScore());
        commentInfoDTO.setLogisticsScore(partialCommentInfoDTO.getLogisticsScore());
        commentInfoDTO.setGoodsId(partialCommentInfoDTO.getGoodsId());
        commentInfoDTO.setGoodsSkuId(partialCommentInfoDTO.getGoodsSkuId());
        commentInfoDTO.setGoodsSkuSaleProperties(partialCommentInfoDTO.getGoodsSkuSaleProperties());
        commentInfoDTO.setOrderInfoId(partialCommentInfoDTO.getOrderInfoId());
        commentInfoDTO.setOrderItemId(partialCommentInfoDTO.getOrderItemId());
        commentInfoDTO.setShowPictures(partialCommentInfoDTO.getShowPictures());
        commentInfoDTO.setUserAccountId(partialCommentInfoDTO.getUserAccountId());
        commentInfoDTO.setUsername(partialCommentInfoDTO.getUsername());

        commentInfoDTO.setTotalScore(CommentInfoScore.FOUR);
        commentInfoDTO.setDefaultComment(DefaultComment.NO);
        commentInfoDTO.setCommentStatus(CommentStatus.APPROVING);
        commentInfoDTO.setCommentType(CommentType.GOOD_COMMENT);
        commentInfoDTO.setGmtCreate(dateProvider.getCurrentTime());
        commentInfoDTO.setGmtModified(dateProvider.getCurrentTime());


        return commentInfoDTO;

    }

    /**
     * 将评论信息DTO对象转换为DO对象
     * @param commentInfoDTO 评论信息DTO对象
     * @return 评论信息DO对象
     */
    private CommentInfoDO convertCommentInfoDTO2DO(CommentInfoDTO commentInfoDTO) throws Exception {
        CommentInfoDO commentInfoDO = new CommentInfoDO();

        commentInfoDO.setCommentContent(commentInfoDTO.getCommentContent());
        commentInfoDO.setCustomerServiceScore(commentInfoDTO.getCustomerServiceScore());
        commentInfoDO.setLogisticsScore(commentInfoDTO.getLogisticsScore());
        commentInfoDO.setGoodsId(commentInfoDTO.getGoodsId());
        commentInfoDO.setGoodsSkuId(commentInfoDTO.getGoodsSkuId());
        commentInfoDO.setGoodsSkuSaleProperties(commentInfoDTO.getGoodsSkuSaleProperties());
        commentInfoDO.setOrderInfoId(commentInfoDTO.getOrderInfoId());
        commentInfoDO.setOrderItemId(commentInfoDTO.getOrderItemId());
        commentInfoDO.setShowPictures(commentInfoDTO.getShowPictures());
        commentInfoDO.setUserAccountId(commentInfoDTO.getUserAccountId());
        commentInfoDO.setUsername(commentInfoDTO.getUsername());

        commentInfoDO.setTotalScore(commentInfoDTO.getTotalScore());
        commentInfoDO.setDefaultComment(commentInfoDTO.getDefaultComment());
        commentInfoDO.setCommentStatus(commentInfoDTO.getCommentStatus());
        commentInfoDO.setCommentType(commentInfoDTO.getCommentType());
        commentInfoDO.setGmtCreate(commentInfoDTO.getGmtCreate());
        commentInfoDO.setGmtModified(commentInfoDTO.getGmtModified());


        return commentInfoDO;
    }

    /**
     * 创建一个订单信息DTO对象
     * @return 订单信息DTO对象
     * @throws Exception 抛出异常
     */
    private OrderInfoDTO createOrderInfoDTO() throws Exception{
        OrderInfoDTO orderInfoDTO = new OrderInfoDTO();
        orderInfoDTO.setId(1L);
        orderInfoDTO.setUserAccountId(1L);
        orderInfoDTO.setUsername("test");

        return orderInfoDTO;
    }

    /**
     * 创建一个订单条目DTO对象
     * @return 订单条目DTO对象
     * @throws Exception 抛出异常
     */
    private OrderItemDTO createOrderItemDTO() throws Exception {
        OrderItemDTO orderItemDTO = new OrderItemDTO();
        orderItemDTO.setId(1L);
        orderItemDTO.setGoodsId(1L);
        orderItemDTO.setSaleProperties("测试销售属性");

        return orderItemDTO;
    }

}
