package com.Jenna.eshop.auth.mapper;

import com.Jenna.eshop.auth.domain.AccountPriorityRelationshipDO;
import org.apache.ibatis.annotations.*;


/**
 * 账号和权限之间的关系管理模块的mapper组件
 */
@Mapper
public interface AccountPriorityRelationshipMapper {
    /**
     * 新增账号和权限的关联关系
     * @param accountPriorityRelationshipDO 新增账号和权限的关联关系DO对象
     */
    @Insert("INSERT INTO  auth_account_priority_relationship("
            + "account_id,"
            + "priority_id,"
            + "gmt_create,"
            + "gmt_modified"
            + ") VALUES("
            + "#{accountId,}"
            + "#{priorityId,}"
            + "#{gmtCreate,}"
            + "#{gmtModified}"
            + ")")
    @Options(keyColumn = "id",keyProperty = "id",useGeneratedKeys = true)
    void save(AccountPriorityRelationshipDO accountPriorityRelationshipDO);

    /**
     * 根据权限id查询记录数
     * @param priorityId 权限id
     * @return 记录数
     */
    @Select("SELECT COUNT(*) "
            + "FROM auth_account_priority_relationship "
            + "WHERE priority_id = #{priorityId}")
    Long countByPriorityId(@Param("priorityId") Long priorityId);
}
