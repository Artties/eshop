package com.Jenna.eshop.comment.service.impl;

import com.Jenna.eshop.comment.dao.CommentInfoDAO;
import com.Jenna.eshop.comment.domain.CommentInfoDTO;
import com.Jenna.eshop.comment.domain.CommentInfoDO;
import com.Jenna.eshop.comment.service.CommentInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 评论信息管理模块的service组件
 * @author Jenna C He
 * @date 2023/1/6 13:13
 */
@Service
public class CommentInfoServiceImpl implements CommentInfoService {

    private static final Logger logger = LoggerFactory.getLogger(CommentInfoServiceImpl.class);


    /**
     * 评论信息管理模块的DAO组件
     */
    @Autowired
    private CommentInfoDAO commentInfoDAO;
    /**
     * 新增评论信息
     * @param commentInfoDTO 评论信息DTO对象
     * @return 是否保存评论信息
     */
    public Boolean saveCommentInfo(CommentInfoDTO commentInfoDTO){
        try {
            CommentInfoDO commentInfoDO = commentInfoDTO.clone(CommentInfoDO.class);
            commentInfoDAO.saveCommentInfo(commentInfoDO);
        }catch (Exception e) {
            logger.error("error",e);
            return false;
        }
        return true;
    }
}
