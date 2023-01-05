package com.Jenna.eshop.comment.domain;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 * 评论聚合统计信息
 * @author Artties
 */
public class CommentAggregate {
    /**
     * id
     */
    private Long id;
    /**
     * 商品id
     */
    private Long goodsId;
    /**
     * 总评论数
     */
    private Long totalCommentCount;
    /**
     * 好评数
     */
    private Long goodCommentCount;
    /**
     * 好评率
     */
    private Double goodCommentRate;
    /**
     * 晒图评论数
     */
    private Long showPicturesComment;
    /**
     * 中评评论数
     */
    private Long mediumCommentCount;
    /**
     * 差评评论数
     */
    private Long badCommentCount;
    /**
     * 评论聚合统计信息创建时间
     */
    private Date gmtCreate;
    /**
     * 评论聚合统计信息修改时间
     */
    private Date gmtModified;

}
