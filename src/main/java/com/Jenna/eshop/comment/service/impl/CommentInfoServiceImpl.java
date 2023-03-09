package com.Jenna.eshop.comment.service.impl;

import com.Jenna.eshop.comment.constant.*;
import com.Jenna.eshop.comment.dao.CommentInfoDAO;
import com.Jenna.eshop.comment.domain.CommentInfoDTO;
import com.Jenna.eshop.comment.domain.CommentInfoDO;
import com.Jenna.eshop.comment.service.CommentInfoService;
import com.Jenna.eshop.order.domain.OrderInfoDTO;
import com.Jenna.eshop.order.domain.OrderItemDTO;
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
    public Boolean saveManualPublishedCommentInfo(CommentInfoDTO commentInfoDTO){
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
            } else if (totalScore > 0 && totalScore <= 2) {
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

    /**
     * 新增自动发表的评论信息
     * @param orderInfoDTO 订单信息DTO对象
     * @param orderItemDTO 订单条目DTO对象
     * @return 处理结果
     */
    public CommentInfoDTO saveAutoPublishedCommentInfo(
            OrderInfoDTO orderInfoDTO, OrderItemDTO orderItemDTO) {
        CommentInfoDTO commentInfoDTO = null;
        try {
            //创建评论信息DTO对象
            commentInfoDTO = createCommentInfoDTO(orderInfoDTO,orderItemDTO);

            //评论信息保存到数据库中
            CommentInfoDO commentInfoDO = commentInfoDTO.clone(CommentInfoDO.class);
            commentInfoDAO.saveCommentInfo(commentInfoDO);

            //设置评论信息的id
            commentInfoDTO.setId(commentInfoDO.getId());
        }catch (Exception e) {
            logger.error("error",e);
            return null;
        }
        return commentInfoDTO;
    }

    /**
     * 创建评论信息DTO对象
     * @param orderInfoDTO 订单信息DTO对象
     * @param orderItemDTO 订单条目DTO对象
     * @return 评论信息DTO对象
     */
    private CommentInfoDTO createCommentInfoDTO(OrderInfoDTO orderInfoDTO, OrderItemDTO orderItemDTO){
        //创建评论信息DTO对象
        CommentInfoDTO commentInfoDTO = new CommentInfoDTO();

        commentInfoDTO.setUserAccountId(orderInfoDTO.getUserAccountId());
        commentInfoDTO.setOrderInfoId(orderInfoDTO.getId());
        commentInfoDTO.setOrderItemId(orderItemDTO.getId());
        commentInfoDTO.setGoodsId(orderItemDTO.getGoodsId());
        commentInfoDTO.setGoodsSkuId(orderItemDTO.getGoodsSkuId());
        commentInfoDTO.setGoodsSkuSaleProperties(orderItemDTO.getSaleProperties());
        //如果这里写成阿拉伯数字5的话 后面就会成为魔法数字 就没有当初的意义了
        commentInfoDTO.setTotalScore(CommentInfoScore.FIVE);
        commentInfoDTO.setGoodsScore(CommentInfoScore.FIVE);
        commentInfoDTO.setCustomerServiceScore(CommentInfoScore.FIVE);
        commentInfoDTO.setLogisticsScore(CommentInfoScore.FIVE);
        commentInfoDTO.setCommentContent(CommentContent.DEFAULT);
        commentInfoDTO.setDefaultComment(DefaultComment.YES);
        commentInfoDTO.setShowPictures(ShowPictures.NO);
        commentInfoDTO.setCommentStatus(CommentStatus.APPROVED);
        commentInfoDTO.setCommentType(CommentType.GOOD_COMMENT);
        commentInfoDTO.setGmtCreate(new Date());
        commentInfoDTO.setGmtModified(new Date());

        return commentInfoDTO;
    }

}


