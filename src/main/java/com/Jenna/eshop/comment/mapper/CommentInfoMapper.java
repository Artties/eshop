package com.Jenna.eshop.comment.mapper;

import com.Jenna.eshop.comment.domain.CommentInfoDO;
import com.Jenna.eshop.comment.domain.CommentInfoQuery;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
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

            + ") b " +
            ""
            "</script>"
    )

    List<CommentInfoDO> listByPage(CommentInfoQuery query);
}
