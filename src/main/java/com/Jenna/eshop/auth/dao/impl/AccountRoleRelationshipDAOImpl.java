package com.Jenna.eshop.auth.dao.impl;

import com.Jenna.eshop.auth.dao.AccountRoleRelationshipDAO;
import com.Jenna.eshop.auth.mapper.AccountRoleRelationshipMapper;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 账号角色关系管理模块的DAO组件
 * @author Jenna C He
 * @date 2023/05/11 16:48
 */
@Repository
public class AccountRoleRelationshipDAOImpl implements AccountRoleRelationshipDAO {
    private static final Logger logger = LoggerFactory.getLogger(AccountRoleRelationshipDAOImpl.class);
    /**
     * 账号角色关系管理模块mapper组件
     */
    private AccountRoleRelationshipMapper accountRoleRelationshipMapper;
    /**
     * 根据角色id来查询记录数
     *
     * @param roleId 角色id
     * @return 记录数
     */
    @Override
    public Long countByRoleId(Long roleId) {
        try {
            return accountRoleRelationshipMapper.countByRoleId(roleId);
        } catch (Exception e) {
            logger.error("error", e);
            return 0L;
        }
    }
}
