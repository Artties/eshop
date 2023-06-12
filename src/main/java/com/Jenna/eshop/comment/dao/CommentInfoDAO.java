package com.Jenna.eshop.comment.dao;

import com.Jenna.eshop.comment.domain.CommentInfoDO;
import com.Jenna.eshop.comment.domain.CommentInfoDTO;
import com.Jenna.eshop.comment.domain.CommentInfoQuery;

import java.util.List;


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
    Long saveCommentInfo(CommentInfoDO commentInfoDO);

    /**
     * 根据id查询评论信息
     * @param id 评论信息id
     * @return 评论信息
     */
    CommentInfoDO getById(Long id);

    /**
     * 分页查询评论信息
     * @param query 评论查询条件
     * @return 评论信息
     */
    List<CommentInfoDTO> listByPage(CommentInfoQuery query);

}
