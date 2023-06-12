package com.Jenna.eshop.comment.dao.impl;

import com.Jenna.eshop.comment.dao.CommentInfoDAO;
import com.Jenna.eshop.comment.domain.CommentInfoDO;
import com.Jenna.eshop.comment.domain.CommentInfoDTO;
import com.Jenna.eshop.comment.domain.CommentInfoQuery;
import com.Jenna.eshop.comment.mapper.CommentInfoMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


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
    public Long saveCommentInfo(CommentInfoDO commentInfoDO){
        try {
             commentInfoMapper.saveCommentInfo(commentInfoDO);
        }catch (Exception e) {
            logger.error("error",e);
            return null;
        }
        return commentInfoDO.getId();
    }

    /**
     * 根据id查询评论信息
     *
     * @param id 评论信息id
     * @return 评论信息
     */
    @Override
    public CommentInfoDO getById(Long id) {
        try {
            return commentInfoMapper.getById(id);
        } catch (Exception e) {
            logger.error("error", e);
            return null;
        }
    }

    /**
     * 分页查询评论信息
     *
     * @param query 评论查询条件
     * @return 评论信息
     */
    @Override
    public List<CommentInfoDTO> listByPage(CommentInfoQuery query) {
        return null;
    }
}
