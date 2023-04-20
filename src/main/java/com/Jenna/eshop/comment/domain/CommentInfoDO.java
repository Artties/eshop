package com.Jenna.eshop.comment.domain;

import java.util.Date;

/**
 * 评论信息
 * @author Jenna C He
 * @date 2023/1/6 11:24
 */
public class CommentInfoDO {
    /**
     * id
     */
    private Long id;
    /**
     * 用户账号id
     */
    private Long userAccountId;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getCustomerServiceScore() {
        return customerServiceScore;
    }

    public void setCustomerServiceScore(Integer customerServiceScore) {
        this.customerServiceScore = customerServiceScore;
    }

    /**
     * 用户名
     */
    private String username;
    /**
     *订单信息id
     */
    private Long orderInfoId;
    /**
     * 订单条目id
     */
    private Long orderItemId;
    /**
     * 订单条目对应商品id
     */
    private Long goodsId;
    /**
     * 订单条目对应Sku id
     */
    private Long goodsSkuId;
    /**
     * 商品Sku销售属性
     */
    private String goodsSkuSaleProperties;
    /**
     * 总评分
     */
    private Integer totalScore;
    /**
     * 商品评分
     */
    private Integer goodsScore;
    /**
     * 客服评分
     */
    private Integer customerServiceScore;
    /**
     *物流评分
     */
    private Integer logisticsScore;
    /**
     * 评论内容
     */
    private String commentContent;
    /**
     * 是否晒图
     */
    private Integer showPictures;
    /**
     * 是否是默认评论
     */
    private Integer defaultComment;
    /**
     * 评论状态
     */
    private Integer commentStatus;
    /**
     * 评论类型
     */
    private Integer commentType;
    /**
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 修改时间
     */
    private Date gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(Long userAccountId) {
        this.userAccountId = userAccountId;
    }



    public Long getOrderInfoId() {
        return orderInfoId;
    }

    public void setOrderInfoId(Long orderInfoId) {
        this.orderInfoId = orderInfoId;
    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getGoodsSkuId() {
        return goodsSkuId;
    }

    public void setGoodsSkuId(Long goodsSkuId) {
        this.goodsSkuId = goodsSkuId;
    }

    public String getGoodsSkuSaleProperties() {
        return goodsSkuSaleProperties;
    }

    public void setGoodsSkuSaleProperties(String goodsSkuSaleProperties) {
        this.goodsSkuSaleProperties = goodsSkuSaleProperties;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public Integer getGoodsScore() {
        return goodsScore;
    }

    public void setGoodsScore(Integer goodsScore) {
        this.goodsScore = goodsScore;
    }

    public Integer getCustomerService() {
        return customerServiceScore;
    }

    public void setCustomerService(Integer customerServiceScore) {
        this.customerServiceScore = customerServiceScore;
    }

    public Integer getLogisticsScore() {
        return logisticsScore;
    }

    public void setLogisticsScore(Integer logisticsScore) {
        this.logisticsScore = logisticsScore;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Integer getShowPictures() {
        return showPictures;
    }

    public void setShowPictures(Integer showPictures) {
        this.showPictures = showPictures;
    }

    public Integer getDefaultComment() {
        return defaultComment;
    }

    public void setDefaultComment(Integer defaultComment) {
        this.defaultComment = defaultComment;
    }

    public Integer getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(Integer commentStatus) {
        this.commentStatus = commentStatus;
    }

    public Integer getCommentType() {
        return commentType;
    }

    public void setCommentType(Integer commentType) {
        this.commentType = commentType;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}
