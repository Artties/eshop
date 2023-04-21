package com.Jenna.eshop.comment.dao.impl;

import com.Jenna.eshop.comment.dao.CommentPictureDAO;
import com.Jenna.eshop.comment.domain.CommentPictureDO;
import com.Jenna.eshop.comment.mapper.CommentPictureMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * 评论晒图管理模块的DAO组件
 * @author Jenna C He
 * @date 2023/1/10 15:13
 */
@Repository
public class CommentPictureDAOImpl implements CommentPictureDAO {
    private static final Logger logger = LoggerFactory.getLogger(CommentPictureDAOImpl.class);

    /**
     * 评论晒图管理模块的
     */
    @Autowired
    private CommentPictureMapper commentPictureMapper;
    /**
     * 新增评论晒图
     * @param commentPictureDO 评论信息DO对象
     */
    public Long saveCommentPicture(CommentPictureDO commentPictureDO){
        try {
            commentPictureMapper.saveCommentPicture(commentPictureDO);
        }catch (Exception e) {
            logger.error("error",e);
            return null;
        }
        return commentPictureDO.getId();
    }
}
