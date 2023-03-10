package com.Jenna.eshop.auth.dao.impl;


import com.Jenna.eshop.auth.dao.AccountPriorityRelationshipDAO;
import com.Jenna.eshop.auth.mapper.AccountPriorityRelationshipMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 账号和权限关系管理模块的DAO组件
 */
public class AccountPriorityRelationshipDAOImpl implements AccountPriorityRelationshipDAO {

    /**
     * 角色和权限关系管理的mapper组件
     */
    @Autowired
    private AccountPriorityRelationshipMapper accountPriorityRelationshipMapper;

    /**
     * 根据权限id查询记录数
     * @param priorityId 权限id
     * @return 记录数
     */
    public Long getCountByPriorityId(Long priorityId){
        return accountPriorityRelationshipMapper.getCountByPriorityId(priorityId);
    }

}
