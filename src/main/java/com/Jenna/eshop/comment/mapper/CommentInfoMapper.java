package com.Jenna.eshop.comment.mapper;

import com.Jenna.eshop.comment.domain.CommentInfoDO;
import com.Jenna.eshop.comment.domain.CommentInfoQuery;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 评论信息管理模块的mapper组件
 * @author Jenna C He
 * @date 2023/1/6 11:14
 */
@Mapper
@Repository
public interface CommentInfoMapper {
    /**
     * 新增评论信息
     * @param commentInfoDO 评论信息DO对象
     */
    @Insert("INSERT INTO comment_info("
    +"user_account_id,"
    +"username,"
    + "order_item_id,"
            +"goods_sku_id,"
            +"goods_sku_sale_properties,"
            +"total_score,"
            +"goods_score,"
            +"customer_service_score,"
            +"logistics_score,"
            +"comment_content,"
            +"is_show_pictures,"
            +"is_default_comment,"
            +"comment_status,"
            +"comment_type,"
            +"gmt_create,"
            +"gmt_modified,"
    +")"
    +"VALUES("
            +"#{userAccountId},"
            +"#{userName},"
            +"#{orderInfoId},"
            +"#{orderItemId},"
            +"#{goodsId},"
            +"#{goodsSkuId},"
            +"#{goodsSkuSaleProperties},"
            +"#{totalScore},"
            +"#{goodsScore},"
            +"#{customerServiceScore},"
            +"#{logisticsScore},"
            +"#{showPictures},"
            +"#{defaultComment},"
            +"#{commentStatus},"
            +"#{commentType},"
            +"#{gmtCreate},"
            +"#{gmtModified},"
            +")")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void saveCommentInfo(CommentInfoDO commentInfoDO);

    /**
     * 分页查询评论信息
     * @param query 评论查询条件
     * @return 评论信息
     */
    @Select("<script>"
            + "SELECT"
                + "a.id,"
                + "a.user_account_id,"
                + "a.username,"
                + "a.order_info_id,"
                + "a.order_item_id,"
                + "a.goods_id,"
                + "a.goods_sku_id,"
                + "a.goods_sku_sale_properties,"
                + "a.total_score,"
                + "a.goods_score,"
                + "a.customer_service_score,"
                + "a.logistic_score,"
                + "a.comment_content,"
                + "a.is_show_pictures,"
                + "a.is_default_comment,"
                + "a.comment_status,"
                + "a.comment_type,"
                + "a.gmt_create,"
                + "a.gmt_modified"
            + "FROM comment_info a,"
            + "("
                + "SELECT id" +
            " FROM comment_info " +
            "WHERE 1=1"

            + "<if test='startTime != null'>"
            + "AND gmt_create >=#{startTime}"
            + "</if>"

            + "<if test='endTime != null'>"
            + "AND gmt_create <=#{endTime}"
            + "</if>"

            + "<if test='totalScore != null'>"
            + "AND total_score <=#{totalScore}"
            + "</if>"

            + "<if test='commentStatus != null'>"
            + "AND total_score <=#{totalScore}"
            + "</if>"

            + ") b "
            + "WHERE a.id = b.id "
            + "</script>"
    )
    @Results({
            @Result(column = "id",property = "id",id = true),
            @Result(column = "user_account_id",property = "userAccountId"),
            @Result(column = "username",property = "username"),
            @Result(column = "order_info_id",property = "OrderInfoId"),
            @Result(column = "order_item_id",property = "OrderItemId"),
            @Result(column = "goods_id",property = "goodsId"),
            @Result(column = "goods_sku_id",property = "goodsSkuId"),
            @Result(column = "goods_sku_sale_properties",property = "goodsSkuSaleProperties"),
            @Result(column = "total_score",property = "totalScore"),
            @Result(column = "goods_score",property = "goodsScore"),
            @Result(column = "customer_service_score",property = "customerServiceScore"),
            @Result(column = "logistics_score",property = "logisticsScore"),
            @Result(column = "comment_content",property = "commentContent"),
            @Result(column = "is_show_pictures",property = "showPictures"),
            @Result(column = "is_default_comment",property = "defaultComment"),
            @Result(column = "comment_status",property = "commentStatus"),
            @Result(column = "comment_type",property = "commentType"),
            @Result(column = "gmt_create",property = "gmtCreate"),
            @Result(column = "gmt_modified",property = "gmtModified")

    })
    List<CommentInfoDO> listByPage(CommentInfoQuery query);

    /**
     * 根据id查询评论信息
     * @param id 评论id
     * @return 评论信息
     */
    @Select("SELECT"
                + "id,"
                + "user_account_id,"
                + "username,"
                + "order_info_id,"
                + "order_item_id,"
                + "goods_id,"
                + "goods_sku_id,"
                + "goods_sku_sale_properties,"
                + "total_score,"
                + "goods_score,"
                + "customer_service_score,"
                + "logistic_score,"
                + "comment_content,"
                + "is_show_pictures,"
                + "is_default_comment,"
                + "comment_status,"
                + "comment_type,"
                + "gmt_create,"
                + "gmt_modified"
            + "FROM comment_info"
            + "WHERE id=#{id}")
    @Results({
            @Result(column = "id",property = "id",id = true),
            @Result(column = "user_account_id",property = "userAccountId"),
            @Result(column = "username",property = "username"),
            @Result(column = "order_info_id",property = "OrderInfoId"),
            @Result(column = "order_item_id",property = "OrderItemId"),
            @Result(column = "goods_id",property = "goodsId"),
            @Result(column = "goods_sku_id",property = "goodsSkuId"),
            @Result(column = "goods_sku_sale_properties",property = "goodsSkuSaleProperties"),
            @Result(column = "total_score",property = "totalScore"),
            @Result(column = "goods_score",property = "goodsScore"),
            @Result(column = "customer_service_score",property = "customerServiceScore"),
            @Result(column = "logistics_score",property = "logisticsScore"),
            @Result(column = "comment_content",property = "commentContent"),
            @Result(column = "is_show_pictures",property = "showPictures"),
            @Result(column = "is_default_comment",property = "defaultComment"),
            @Result(column = "comment_status",property = "commentStatus"),
            @Result(column = "comment_type",property = "commentType"),
            @Result(column = "gmt_create",property = "gmtCreate"),
            @Result(column = "gmt_modified",property = "gmtModified")

    })
    CommentInfoDO getById(@Param("id") Long id);
}
