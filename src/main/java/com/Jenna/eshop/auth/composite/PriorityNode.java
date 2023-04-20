package com.Jenna.eshop.auth.composite;

import com.Jenna.eshop.auth.visitor.PriorityNodeVisitor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 权限树节点
 */
public class PriorityNode {

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
    /**
     * 子权限节点
     */
    private List<PriorityNode> children = new ArrayList<>();

    /**
     * 接收一个权限树访问者
     * @param visitor 权限树访问者
     */
    public void accept(PriorityNodeVisitor visitor){
        visitor.visit(this);//可以访问所有权限数据

    }
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

    public List<PriorityNode> getChildren() {
        return children;
    }

    public void setChildren(List<PriorityNode> children) {
        this.children = children;
    }


}