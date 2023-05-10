package com.Jenna.eshop.auth.domain;

import java.util.Date;
import java.util.List;

/**
 * 角色DO类
 * @author Jenna C He
 * @date 2023/05/10 10:35
 */
public class RoleDTO {
    /**
     * id
     */
    private Long id;
    /**
     * 角色编号
     */
    private Long code;
    /**
     * 角色名称
     */
    private String name;
    /**
     * 角色备注
     */
    private String remark;
    /**
     * 角色的创建时间
     */
    private Date gmt_created;
    /**
     * 角色的修改时间
     */
    private Date gmt_modified;
    /**
     * 角色权限关系集合
     */
    private List<RolePriorityRelationshipDTO> rolePriorityRelations;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getGmt_created() {
        return gmt_created;
    }

    public void setGmt_created(Date gmt_created) {
        this.gmt_created = gmt_created;
    }

    public Date getGmt_modified() {
        return gmt_modified;
    }

    public void setGmt_modified(Date gmt_modified) {
        this.gmt_modified = gmt_modified;
    }

    public List<RolePriorityRelationshipDTO> getRolePriorityRelations() {
        return rolePriorityRelations;
    }

    public void setRolePriorityRelations(List<RolePriorityRelationshipDTO> rolePriorityRelations) {
        this.rolePriorityRelations = rolePriorityRelations;
    }
}
