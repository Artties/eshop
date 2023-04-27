package com.Jenna.eshop.auth.domain;

import com.Jenna.eshop.common.util.BeanCopierUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 *权限的DTO类
 */

public class PriorityDTO {
    private static final Logger logger = LoggerFactory.getLogger(PriorityDTO.class);
    /**
     * id
     */
    private Long id;
    /**
     * 权限编号
     */
    private String code;
    /**
     * 权限url
     */
    private String url;
    /**
     * 权限备注
     */
    private String priorityComment;
    /**
     * 权限类型
     */
    private Integer priorityType;
    /**
     * 父权限id
     */
    private Long parentId;
    /**
     * 权限的创建时间
     */
    private Date gmtCreate;
    /**
     * 权限的修改时间
     */
    private Date gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPriorityComment() {
        return priorityComment;
    }

    public void setPriorityComment(String priorityComment) {
        this.priorityComment = priorityComment;
    }

    public Integer getPriorityType() {
        return priorityType;
    }

    public void setPriorityType(Integer priorityType) {
        this.priorityType = priorityType;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
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
     * 克隆方法
     * @param clazz 目标class对象
     * @return 克隆后的对象
     * @param <T> 泛型 T
     */
    public <T> T clone(Class<T> clazz){
        T target = null;
        try{
            target = clazz.getDeclaredConstructor().newInstance();
        }catch (Exception e){
            logger.error("PriorityDTO中克隆对象的时候出错",e);
        }

        BeanCopierUtils.copyProperties(this,target);
        return target;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PriorityDTO)) return false;
        PriorityDTO that = (PriorityDTO) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getCode(), that.getCode()) && Objects.equals(getUrl(), that.getUrl()) && Objects.equals(getPriorityComment(), that.getPriorityComment()) && Objects.equals(getPriorityType(), that.getPriorityType()) && Objects.equals(getParentId(), that.getParentId()) && Objects.equals(getGmtCreate(), that.getGmtCreate()) && Objects.equals(getGmtModified(), that.getGmtModified());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCode(), getUrl(), getPriorityComment(), getPriorityType(), getParentId(), getGmtCreate(), getGmtModified());
    }
}
