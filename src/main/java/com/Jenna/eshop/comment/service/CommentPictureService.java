package com.Jenna.eshop.comment.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * 评论晒图管理模块的service组件接口
 * @author Jenna C He
 * @date 2023/3/6 17:05
 */
public interface CommentPictureService {
    /**
     * 保存评论晒图
     * @param appBasePath 当先应用的根路径
     * @param commentInfoId 评论信息id
     * @param files 评论晒图
     * @return 处理结果
     */
    Boolean saveCommentPictures(String appBasePath,Long commentInfoId, MultipartFile[] files);

}
