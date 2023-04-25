package com.Jenna.eshop.comment.dao;

import com.Jenna.eshop.comment.domain.CommentInfoDO;

/**
 * 评论信息管理模块的DAO组件接口
 * @author Jenna C He
 * @date 2023/1/6 11:44
 */
public interface CommentInfoDAO {
    /**
     * 新增评论信息
     * @param commentInfoDO 评论信息DO对象
     * @return 是否保存评论信息
     */
    Boolean saveCommentInfo(CommentInfoDO commentInfoDO);
}
