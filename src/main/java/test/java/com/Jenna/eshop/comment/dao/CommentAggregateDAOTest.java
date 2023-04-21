package test.java.com.Jenna.eshop.comment.dao;

import com.Jenna.eshop.comment.dao.CommentAggregateDAO;
import com.Jenna.eshop.comment.domain.CommentAggregateDO;
import com.Jenna.eshop.common.util.DateProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * 评论统计管理模块的DAO组件的单元测试类
 * @author Jenna C He
 * @date 2023/04/20 16:48
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(true)
public class CommentAggregateDAOTest {
    /**
     * 评论统计管理模块的DAO组件
     */
    @Autowired
    private CommentAggregateDAO commentAggregateDAO;

    /**
     * 日期辅助组件
     */
    @Autowired
    private DateProvider dateProvider;

    /**
     * 测试新增评论信息
     * @throws Exception
     */
    @Test
    public void testSaveCommentAggregate() throws Exception {
        Long goodsId = 1L;
        CommentAggregateDO commentAggregateDO = createCommentAggregateDO(goodsId);

        assertNotNull(commentAggregateDO.getId());
        assertThat(commentAggregateDO.getId(),greaterThan(0L));
    }

    /**
     * 测试根据商品id查询评论统计信息
     * @throws Exception 抛出异常
     */
    @Test
    public void testGetCommentAggregateByGoodsId() throws Exception {
        Long goodsId = 1L;
        CommentAggregateDO commentAggregateDO = createCommentAggregateDO(goodsId);
        CommentAggregateDO resultCommentAggregateDO = commentAggregateDAO
                .getCommentAggregateByGoodsId(goodsId);

        assertEquals(commentAggregateDO, resultCommentAggregateDO);
    }

    /**
     * 测试更新评论统计信息
     * @throws Exception 抛出异常
     */
    @Test
    public void testUpdateCommentAggregate() throws Exception {
        Long goodsId = 1L;
        CommentAggregateDO commentAggregateDO = createCommentAggregateDO(goodsId);

        commentAggregateDO.setGoodCommentCount(1L);
        commentAggregateDAO.updateCommentAggregate(commentAggregateDO);

        CommentAggregateDO resultCommentAggregateDO = commentAggregateDAO
                .getCommentAggregateByGoodsId(goodsId);

        assertEquals(commentAggregateDO, resultCommentAggregateDO);
    }

    /**
     * 创建评论统计DO对象
     * @return 评论统计DO对象
     * @throws Exception 抛出异常
     */
    private CommentAggregateDO createCommentAggregateDO(Long goodsId) throws Exception {
        CommentAggregateDO commentAggregateDO = new CommentAggregateDO();
        commentAggregateDO.getBadCommentCount(1L);
        commentAggregateDO.setGmtCreate(dateProvider.getCurrentTime());
        commentAggregateDO.setGmtModified(dateProvider.getCurrentTime());
        commentAggregateDO.setGoodCommentCount(1L);
        commentAggregateDO.setGoodCommentRate(1.0);
        commentAggregateDO.setGoodsId(goodsId);
        commentAggregateDO.setMediumCommentCount(1L);
        commentAggregateDO.setShowPicturesCommentCount(1L);
        commentAggregateDO.setTotalCommentCount(5L);

        commentAggregateDAO.saveCommentAggregate(commentAggregateDO);

        return commentAggregateDO;
    }
}
