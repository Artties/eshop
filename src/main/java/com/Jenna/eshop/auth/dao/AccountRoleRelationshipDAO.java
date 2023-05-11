package com.Jenna.eshop.auth.dao;


/**
 * 账号角色关系管理模块DAO组件接口
 * @author Jenna C He
 * @date 2023/05/11 16:46
 */
public interface AccountRoleRelationshipDAO {
    /**
     * 根据角色id来查询记录数
     * @param roleId 角色id
     * @return 记录数
     */
    Long countByRoleId(Long roleId);
}
