package com.Jenna.eshop.comment.domain;

import com.Jenna.eshop.common.util.BeanCopierUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * 评论信息
 * @author Jenna C He
 * @date 2023/1/6 13:49
 */
public class CommentInfoVO {
    private static final Logger logger = LoggerFactory.getLogger(CommentInfoVO.class);
    /**
     * id
     */
    private Long id;
    /**
     * 用户账号id
     */
    private Long userAccountId;
    /**
     * 用户名
     */
    private String Name;
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
    private Long goodsSkuSaleProperties;
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
    private Integer customerService;
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

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
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

    public Long getGoodsSkuSaleProperties() {
        return goodsSkuSaleProperties;
    }

    public void setGoodsSkuSaleProperties(Long goodsSkuSaleProperties) {
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
        return customerService;
    }

    public void setCustomerService(Integer customerService) {
        this.customerService = customerService;
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

    /**
     * 将自己的数据克隆到指定类型的对象中
     * @param clazz 指定类型
     * @return 指定类型的对象
     * @param <T> 泛型
     */
    public <T> T clone(Class<T> clazz){
        T target = null;
        try {
            target = clazz.getConstructor().newInstance();
            BeanCopierUtils.copyProperties(this,target);

        }catch (Exception e) {
            logger.error("error",e);
            return null;
        }
        return target;
    }
}