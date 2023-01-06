package com.Jenna.eshop.comment.controller;

import com.Jenna.eshop.comment.domain.CommentInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import static org.slf4j.LoggerFactory.*;

/**
 * 评论管理模块的controller组件
 * @author Jenna C He
 * @date 2023/1/6 10:49
 */
@RestController
@RequestMapping("/comment")
public class CommentController {
    private  static final Logger logger = getLogger(CommentController.class);
    /**
     * 手动发表评论
     * @param commentInfoVO 评论信息的VO对象
     * @return 处理结果
     */
    @PostMapping("/")
    public Boolean publishComment(CommentInfoVO commentInfoVO, MultipartFile[] files){
        try {
            //保存评论信息

        }catch (Exception e) {
            logger.error("error",e);
            return false;
        }
        return true;
    }

}
