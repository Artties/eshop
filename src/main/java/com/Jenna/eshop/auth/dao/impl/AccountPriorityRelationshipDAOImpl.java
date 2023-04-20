package com.Jenna.eshop.auth.dao.impl;


import com.Jenna.eshop.auth.dao.AccountPriorityRelationshipDAO;
import com.Jenna.eshop.auth.domain.AccountPriorityRelationshipDO;
import com.Jenna.eshop.auth.mapper.AccountPriorityRelationshipMapper;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 账号和权限关系管理模块的DAO组件
 * @author Artties
 */
public class AccountPriorityRelationshipDAOImpl implements AccountPriorityRelationshipDAO {

    private static Logger logger = LoggerFactory.getLogger(AccountPriorityRelationshipDAOImpl.class);
    /**
     * 角色和权限关系管理的mapper组件
     */
    @Autowired
    private AccountPriorityRelationshipMapper accountPriorityRelationshipMapper;


    /**
     * 新增账号和权限的关联关系
     * @param accountPriorityRelationshipDO 新增账号和权限的关联关系DO对象
     */
    public Boolean save(AccountPriorityRelationshipDO accountPriorityRelationshipDO){
        try{
            accountPriorityRelationshipMapper.save(accountPriorityRelationshipDO);
        }catch (Exception e) {
            logger.error("error",e);
            return false;
        }
        return true;
    }


    /**
     * 根据权限id查询记录数
     * @param priorityId 权限id
     * @return 记录数
     */
    public Long countByPriorityId(Long priorityId){
        try {
            return accountPriorityRelationshipMapper.countByPriorityId(priorityId);
        }catch (Exception e) {
            logger.error("error",e);
        }
        return 0L;
    }
}
