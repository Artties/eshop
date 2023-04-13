package com.Jenna.eshop.auth.dao.impl;


import com.Jenna.eshop.auth.dao.RolePriorityRelationshipDAO;
import com.Jenna.eshop.auth.mapper.RolePriorityRelationshipMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 角色和权限关系管理模块的DAO组件
 */
public class RolePriorityRelationshipDAOImpl implements RolePriorityRelationshipDAO {

    /**
     * 角色和权限关系管理的mapper组件
     */
    @Autowired
    private RolePriorityRelationshipMapper rolePriorityRelationshipMapper;

    /**
     * 根据权限id查询记录数
     * @param priorityId 权限id
     * @return 记录数
     */
    public Long getCountByPriorityId(Long priorityId){
        return rolePriorityRelationshipMapper.getCountByPriorityId(priorityId);
    }

}
