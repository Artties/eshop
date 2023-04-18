package com.Jenna.eshop.auth.dao;

import com.Jenna.eshop.auth.domain.AccountPriorityRelationshipDO;
import org.springframework.stereotype.Service;

/**
 * 账号和权限关系管理模块的DAO组件接口
 * @author Artties
 */
@Service
public interface AccountPriorityRelationshipDAO {

    /**
     * 新增账号和权限的关联关系
     * @param accountPriorityRelationshipDO 新增账号和权限的关联关系DO对象
     */
    Boolean save(AccountPriorityRelationshipDO accountPriorityRelationshipDO);

    /**
     * 根据权限id查询记录数
     * @param priorityId 权限id
     * @return 记录数
     */
    Long countByPriorityId(Long priorityId);


}