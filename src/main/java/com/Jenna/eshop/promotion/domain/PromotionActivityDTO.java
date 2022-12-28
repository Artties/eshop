package com.Jenna.eshop.promotion.domain;

import javax.xml.crypto.Data;

/**
 * 促销活动DTO
 */
public class PromotionActivityDTO {
    /**
     * id
     */
    private Long id;
    /**
     * 促销活动名称
     */
    private String promotionActivityName;

    /**
     * 促销活动开始时间
     */
    private Data promotionActivityStartTime;

    /**
     * 促销活动结束时间
     */
    private Data promotionActivityEndTime;

    /**
     * 促销活动备注
     */
    private String promotionActivityComment;

    /**
     * 促销活动状态
     */
    private Integer promotionActivityStatus;

    /**
     * 促销活动规则
     */
    private String promotionActivityRule;

    /**
     * 促销活动创建时间
     */
    private Data gmtCreate;

    /**
     * 促销活动修改时间
     */
    private Data gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPromotionActivityName() {
        return promotionActivityName;
    }

    public void setPromotionActivityName(String promotionActivityName) {
        this.promotionActivityName = promotionActivityName;
    }

    public Data getPromotionActivityStartTime() {
        return promotionActivityStartTime;
    }

    public void setPromotionActivityStartTime(Data promotionActivityStartTime) {
        this.promotionActivityStartTime = promotionActivityStartTime;
    }

    public Data getPromotionActivityEndTime() {
        return promotionActivityEndTime;
    }

    public void setPromotionActivityEndTime(Data promotionActivityEndTime) {
        this.promotionActivityEndTime = promotionActivityEndTime;
    }

    public String getPromotionActivityComment() {
        return promotionActivityComment;
    }

    public void setPromotionActivityComment(String promotionActivityComment) {
        this.promotionActivityComment = promotionActivityComment;
    }

    public Integer getPromotionActivityStatus() {
        return promotionActivityStatus;
    }

    public void setPromotionActivityStatus(Integer promotionActivityStatus) {
        this.promotionActivityStatus = promotionActivityStatus;
    }

    public String getPromotionActivityRule() {
        return promotionActivityRule;
    }

    public void setPromotionActivityRule(String promotionActivityRule) {
        this.promotionActivityRule = promotionActivityRule;
    }

    public Data getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Data gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Data getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Data gmtModified) {
        this.gmtModified = gmtModified;
    }
}
