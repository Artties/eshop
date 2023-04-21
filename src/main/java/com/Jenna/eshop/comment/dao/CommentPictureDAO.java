package com.Jenna.eshop.comment.dao;

import com.Jenna.eshop.comment.domain.CommentPictureDO;

/**
 * 评论晒图管理模块的DAO组件接口
 * @author Jenna C He
 * @date 2023/1/10 15:09
 */

public interface CommentPictureDAO {

    /**
     * 新增评论晒图
     * @param commentPictureDO 评论晒图DO对象
     * @return 处理结果
     */
    Long saveCommentPicture(CommentPictureDO commentPictureDO);
}
