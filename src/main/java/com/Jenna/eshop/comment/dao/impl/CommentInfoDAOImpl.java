package com.Jenna.eshop.comment.dao.impl;

import com.Jenna.eshop.comment.dao.CommentInfoDAO;
import com.Jenna.eshop.comment.domain.CommentInfoDO;
import com.Jenna.eshop.comment.mapper.CommentInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * 评论信息管理模块的DAO组件
 * @author Jenna C He
 * @date 2023/1/6 11:51
 */
@Repository
public class CommentInfoDAOImpl implements CommentInfoDAO {
    private static final Logger logger = LoggerFactory.getLogger(CommentInfoDAOImpl.class);
    /**
     * 评论信息管理模块的mapper组件
     */
    @Autowired
    private CommentInfoMapper commentInfoMapper;

    /**
     * 新增评论信息
     * @param commentInfoDO 评论信息DO对象
     */
    public Boolean saveCommentInfo(CommentInfoDO commentInfoDO){
        try {
            commentInfoMapper.saveCommentInfo(commentInfoDO);
        }catch (Exception e) {
            logger.error("error",e);
            return false;
        }
        return true;
    }
}
