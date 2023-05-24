package com.Jenna.eshop.comment.domain;

import java.util.Date;

/**
 * 评论信息的查询条件
 * @author Jenna C He
 * @date 2023/05/17 17:18
 */
public class CommentInfoQuery {
    /**
     * 开始时间
     */
    private Date startTime;
    /**
     * 结束时间
     */
    private Date endTime;
    /**
     * 总评分
     */
    private Integer totalScore;
    /**
     * 评论状态
     */
    private Integer commentStatus;
    /**
     * 评论类型
     */
    private Integer commentType;
    /**
     * 是否晒图
     */
    private Integer showPictures;
    /**
     * 是否默认评论
     */
    private Integer defaultComment;

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
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
}
