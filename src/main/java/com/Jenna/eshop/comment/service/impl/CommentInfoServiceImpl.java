package com.Jenna.eshop.comment.service.impl;

import com.Jenna.eshop.comment.constant.CommentStatus;
import com.Jenna.eshop.comment.constant.CommentType;
import com.Jenna.eshop.comment.constant.DefaultComment;
import com.Jenna.eshop.comment.dao.CommentInfoDAO;
import com.Jenna.eshop.comment.domain.CommentInfoDTO;
import com.Jenna.eshop.comment.domain.CommentInfoDO;
import com.Jenna.eshop.comment.service.CommentInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


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
            //计算评论的总分数

            Integer totalScore = Math.round((commentInfoDTO.getCustomerServiceScore()
                    + commentInfoDTO.getGoodsScore()
                    + commentInfoDTO.getLogisticsScore())/3);

            commentInfoDTO.setTotalScore(totalScore);

            //设置是否为默认评论

            commentInfoDTO.setDefaultComment(DefaultComment.NO);

            //设置评论的状态
            commentInfoDTO.setCommentStatus(CommentStatus.APPROVING);

            //设置评论类型
            Integer commentType = 0;

            if (totalScore >= 4) {
                commentType = CommentType.GOOD_COMMENT;
            } else if (totalScore == 3) {
                commentType = CommentType.MEDIUM_COMMENT;
            } else if (totalScore >0 && totalScore <= 2) {
                commentType = CommentType.BAD_COMMENT;
            }

            commentInfoDTO.setCommentType(commentType);

            //设置创建时间和修改时间
            commentInfoDTO.setGmtCreate(new Date());
            commentInfoDTO.setGmtModified(new Date());


            //评论信息保存到数据库中
            CommentInfoDO commentInfoDO = commentInfoDTO.clone(CommentInfoDO.class);
            commentInfoDAO.saveCommentInfo(commentInfoDO);

            //设置评论信息的id
            commentInfoDTO.setId(commentInfoDO.getId());
        }catch (Exception e) {
            logger.error("error",e);
            return false;
        }
        return true;
    }


}
