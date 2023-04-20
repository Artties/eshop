package test.java.com.Jenna.eshop.comment.dao;

import com.Jenna.eshop.comment.constant.*;
import com.Jenna.eshop.comment.dao.CommentInfoDAO;
import com.Jenna.eshop.comment.domain.CommentInfoDO;
import com.Jenna.eshop.common.util.DateProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * 评论信息管理模块的DAO组件的单元测试类
 * @author Jenna C He
 * @date 2023/04/20 11:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public class CommentInfoDAOTest {
    /**
     * 评论信息管理模块的DAO组件
     */
    @Autowired
    private CommentInfoDAO commentInfoDAO;
    /**
     * 日期辅助组件
     */
    @Autowired
    private DateProvider dateProvider;

    /**
     * 测试新增评论信息
     * @throws Exception 抛出异常
     */
    @Test
    public void testSaveCommentInfo() throws Exception {
        CommentInfoDO commentInfoDO = createCommentInfo();
        Long commentInfoId = commentInfoDAO.saveCommentInfo(commentInfoDO);
        assertNotNull(commentInfoDO.getId());
        assertThat(commentInfoId,greaterThan(0L));
    }

    /**
     * 创建一个评论信息DO对象
     * @return 评论信息DO对象
     * @throws Exception 抛出异常
     */

    private CommentInfoDO createCommentInfo() throws Exception{
        CommentInfoDO commentInfoDO = new CommentInfoDO();
        commentInfoDO.setCommentContent("测试评论");
        commentInfoDO.setCommentStatus(CommentStatus.APPROVING);
        commentInfoDO.setCommentType(CommentType.GOOD_COMMENT);
        commentInfoDO.setCustomerService(CommentInfoScore.FIVE);
        commentInfoDO.setDefaultComment(DefaultComment.NO);
        commentInfoDO.setGmtCreate(dateProvider.getCurrentTime());
        commentInfoDO.setGmtModified(dateProvider.getCurrentTime());
        commentInfoDO.setGoodsId(1L);
        commentInfoDO.setGoodsScore(CommentInfoScore.FIVE);
        commentInfoDO.setGoodsId(1L);
        commentInfoDO.setGoodsSkuSaleProperties("测试销售属性");
        commentInfoDO.setLogisticsScore(CommentInfoScore.FIVE);
        commentInfoDO.setOrderInfoId(1L);
        commentInfoDO.setOrderItemId(1L);
        commentInfoDO.setShowPictures(ShowPictures.YES);
        commentInfoDO.setTotalScore(CommentInfoScore.FIVE);
        commentInfoDO.setUserAccountId(1L);
        commentInfoDO.setUsername("test");


        return commentInfoDO;
    }
}
