package com.Jenna.eshop.auth.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


/**
 * 账号和权限之间的关系管理模块的mapper组件
 */
@Mapper
public interface AccountPriorityRelationshipMapper {
    /**
     * 根据权限id查询记录数
     * @param priorityId 权限id
     * @return 记录数
     */
    @Select("SELECT COUNT(*) "
            + "FROM auth_account_priority_relationship "
            + "WHERE priority_id = #{priorityId}")
    Long getCountByPriorityId(@Param("priorityId") Long priorityId);
}
