package com.Jenna.eshop.service;

import com.Jenna.eshop.comment.domain.CommentInfoDTO;

/**
 * 评论统计信息管理模块的service组件接口
 * @author Jenna C He
 * @date 2023/3/7 15:42
 */

public interface CommentAggregateService {
    /**
     * 更新评论统计信息
     * @param commentInfoDTO 评论信息
     * @return 处理结果
     */
    Boolean updateCommentAggregate(CommentInfoDTO commentInfoDTO);
}
