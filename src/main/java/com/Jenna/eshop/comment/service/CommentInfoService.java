package com.Jenna.eshop.comment.service;

import com.Jenna.eshop.comment.domain.CommentInfoDTO;

/**
 * 评论信息管理模块service组件接口
 * @author Jenna C He
 * @date 2023/1/6 13:09
 */
public interface CommentInfoService {
    /**
     * 新增评论信息
     * @param commentInfoDTO 评论信息DTO对象
     * @return 是否保存评论信息
     */
    Boolean saveCommentInfo(CommentInfoDTO commentInfoDTO);

}
