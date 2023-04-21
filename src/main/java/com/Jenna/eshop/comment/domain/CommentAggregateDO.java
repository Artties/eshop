package com.Jenna.eshop.comment.domain;

import java.util.Date;
import java.util.Objects;

public class CommentAggregateDO {
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
    private Long ShowPicturesCommentCount;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getTotalCommentCount() {
        return totalCommentCount;
    }

    public void setTotalCommentCount(Long totalCommentCount) {
        this.totalCommentCount = totalCommentCount;
    }

    public Long getGoodCommentCount() {
        return goodCommentCount;
    }

    public void setGoodCommentCount(Long goodCommentCount) {
        this.goodCommentCount = goodCommentCount;
    }

    public Double getGoodCommentRate() {
        return goodCommentRate;
    }

    public void setGoodCommentRate(Double goodCommentRate) {
        this.goodCommentRate = goodCommentRate;
    }

    public Long getShowPicturesCommentCount() {
        return ShowPicturesCommentCount;
    }

    public void setShowPicturesCommentCount(Long ShowPicturesCommentCount) {
        this.ShowPicturesCommentCount = ShowPicturesCommentCount;
    }

    public Long getMediumCommentCount() {
        return mediumCommentCount;
    }

    public void setMediumCommentCount(Long mediumCommentCount) {
        this.mediumCommentCount = mediumCommentCount;
    }

    public Long getBadCommentCount(long l) {
        return badCommentCount;
    }

    public void setBadCommentCount(Long badCommentCount) {
        this.badCommentCount = badCommentCount;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CommentAggregateDO)) {
            return false;
        }
        CommentAggregateDO that = (CommentAggregateDO) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getGoodsId(), that.getGoodsId()) && Objects.equals(getTotalCommentCount(), that.getTotalCommentCount()) && Objects.equals(getGoodCommentCount(), that.getGoodCommentCount()) && Objects.equals(getGoodCommentRate(), that.getGoodCommentRate()) && Objects.equals(getShowPicturesCommentCount(), that.getShowPicturesCommentCount()) && Objects.equals(getMediumCommentCount(), that.getMediumCommentCount()) && Objects.equals(badCommentCount, that.badCommentCount) && Objects.equals(getGmtCreate(), that.getGmtCreate()) && Objects.equals(getGmtModified(), that.getGmtModified());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getGoodsId(), getTotalCommentCount(), getGoodCommentCount(), getGoodCommentRate(), getShowPicturesCommentCount(), getMediumCommentCount(), badCommentCount, getGmtCreate(), getGmtModified());
    }
}
