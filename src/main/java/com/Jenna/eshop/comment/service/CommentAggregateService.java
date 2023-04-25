package com.Jenna.eshop.comment.service;

import com.Jenna.eshop.comment.domain.CommentAggregateDO;
import com.Jenna.eshop.comment.domain.CommentAggregateDTO;
import com.Jenna.eshop.comment.domain.CommentInfoDTO;

/**
 * 评论统计信息管理模块的service组件接口
 * @author Jenna C He
 * @date 2023/04/24 09:36
 */
public interface CommentAggregateService {
    /**
     * 更新评论统计信息
     *
     * @param commentInfoDTO 评论信息
     * @return 处理结果
     * @throws Exception
     */
    CommentAggregateDO refreshCommentAggregate(
            CommentInfoDTO commentInfoDTO) throws Exception;

    /**
     * 根据商品id查询评论统计信息
     * @param goodsId 商品id
     * @return 评论统计信息
     * @throws Exception
     */
    CommentAggregateDTO getCommentAggregateByGoodsId(
            Long goodsId) throws Exception;
}
