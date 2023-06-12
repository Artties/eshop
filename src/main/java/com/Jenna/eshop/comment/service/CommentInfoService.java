package com.Jenna.eshop.comment.service;

import com.Jenna.eshop.comment.domain.CommentInfoDO;
import com.Jenna.eshop.comment.domain.CommentInfoDTO;
import com.Jenna.eshop.comment.domain.CommentInfoQuery;
import com.Jenna.eshop.order.domain.OrderInfoDTO;
import com.Jenna.eshop.order.domain.OrderItemDTO;

import java.util.List;

/**
 * 评论信息管理模块service组件接口
 * @author Jenna C He
 * @date 2023/1/6 13:09
 */
public interface CommentInfoService {

    /**
     * 新增手动发表评论信息
     * @param commentInfoDTO 评论信息DTO对象
     * @return 是否保存评论信息
     */
    Boolean saveManualPublishedCommentInfo(CommentInfoDTO commentInfoDTO);

    /**
     * 新增自动发表的评论信息
     * @param orderInfoDTO 订单信息DTO对象
     * @param orderItemDTO 订单条目DTO对象
     * @return 处理结果
     */

    CommentInfoDTO saveAutoPublishedCommentInfo(OrderInfoDTO orderInfoDTO, OrderItemDTO orderItemDTO);

    /**
     * 分页查询评论信息
     * @param query 评论查询条件
     * @return 评论信息
     */
    List<CommentInfoDTO> listByPage(CommentInfoQuery query);

    /**
     * 根据id查询评论信息
     * @param id 评论信息id
     * @return 评论信息
     */
    CommentInfoDTO getById(Long id);
}
