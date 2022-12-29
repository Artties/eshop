package com.Jenna.eshop.auth.domain;

import org.springframework.beans.BeanUtils;

import java.lang.reflect.Method;
import java.util.*;

/**
 *权限的DO类
 */

public class PriorityDO {
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
    private Integer parentId;
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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
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
        //比如clazz是PriorityDTO.class

        T target = null;
        try{
            target = clazz.getDeclaredConstructor().newInstance();

            Method setIdMethod = clazz.getMethod("setId",Long.class);
            setIdMethod.invoke(target,id);

            Method setCodeMethod = clazz.getMethod("setCode",Long.class);
            setIdMethod.invoke(target,code);

            BeanUtils.copyProperties(this,clazz.getDeclaredConstructor().newInstance());

        } catch (Exception e){
            e.printStackTrace();
        }
        return target;
    }
}
