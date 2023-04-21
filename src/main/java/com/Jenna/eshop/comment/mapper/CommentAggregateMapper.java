package com.Jenna.eshop.comment.mapper;

import com.Jenna.eshop.comment.domain.CommentAggregateDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * 评论统计信息管理模块的mapper组件
 * @author Jenna C He
 * @date 2023/3/7 10:30
 */
@Mapper
@Repository
public interface CommentAggregateMapper {
    /**
     * 根据商品id查询评论统计信息
     * @param goodsId 商品id
     * @return 评论统计信息
     */
    @Select("SELECT"
            +"id,"
            +"goods_id,"
            +"total_comment_count,"
            +"good_comment_count,"
            +"good_comment_rate,"
            +"show_pictures_comment_count,"
            +"medium_comment_count,"
            +"bad_comment_count,"
            +"gmt_create,"
            +"gmt_modified "
    +"FROM comment_aggregate"
    +"WHERE goods_id = #{goodsId}")
    @Results(
            {       @Result(column = "id", property = "id", id = true),
                    @Result(column = "goods_id", property = "goods_id"),
                    @Result(column = "total_comment_count",property = "total_comment_count"),
                    @Result(column = "good_comment_count",property = "good_comment_count"),
                    @Result(column = "good_comment_rate",property = "good_comment_rate"),
                    @Result(column = "show_pictures_comment_count",property = "show_pictures_comment_count"),
                    @Result(column = "medium_comment_count",property = "medium_comment_count"),
                    @Result(column = "bad_comment_count",property = "bad_comment_count"),
                    @Result(column = "gmt_create",property = "gmt_create"),
                    @Result(column = "gmt_modified",property = "gmt_modified"),
            })
    CommentAggregateDO getCommentAggregateByGoodsId(@Param("goodsId") Long goodsId);

    /**
     * 新增评论统计信息
     * @param commentAggregateDO 评论统计信息DO对象
     */
    @Insert("INSERT INTO comment_aggregate("
                                      +"goods_id,"
                                      +"total_comment_count,"
                                      +"good_comment_count,"
                                      +"good_comment_rate,"
                                      +"show_pictures_comment_count,"
                                      +"medium_comment_count,"
                                      +"bad_comment_count,"
                                      +"gmt_create,"
                                      +"gmt_modified"
                                      +")"
                                      +"VALUES("
                                      +"#{goods_id},"
                                      +"#{total_comment_count},"
                                      +"#{good_comment_count},"
                                      +"#{good_comment_rate},"
                                      +"#{show_pictures_comment_count},"
                                      +"#{medium_comment_count},"
                                      +"#{bad_comment_count},"
                                      +"#{gmt_create},"
                                      +"#{gmt_modified}"
                                      +")")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void saveCommentAggregate(CommentAggregateDO commentAggregateDO);

    /**
     * 更新评论统计信息
     * @param commentAggregateDO 评论统计信息DO对象
     */
    @Update("UPDATE comment_aggregate SET"
            +"goods_id=#{goods_id},"
            +"total_comment_count=#{total_comment_count},"
            +"good_comment_count=#{good_comment_count},"
            +"good_comment_rate=#{good_comment_rate},"
            +"show_pictures_comment_count=#{show_pictures_comment_count},"
            +"medium_comment_count=#{medium_comment_count},"
            +"bad_comment_count=#{bad_comment_count},"
            +"gmt_create=#{gmt_create},"
            +"gmt_modified=#{gmt_modified}"
            +"WHERE id = #{id}")
    void updateCommentAggregate(CommentAggregateDO commentAggregateDO);
}
