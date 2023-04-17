package com.Jenna.eshop.auth.mapper;

import com.Jenna.eshop.auth.domain.RolePriorityRelationshipDO;
import org.apache.ibatis.annotations.*;

/**
 * 角色和权限之间的关系管理模块的mapper组件
 * @author Artties
 */
@Mapper
public interface RolePriorityRelationshipMapper {

    /**
     * 新增角色和权限的关联关系
     * @param rolePriorityRelationshipDO 新增角色和权限的关联关系DO对象
     */
    @Insert("INSERT INTO  auth_role_priority_relationship("
            + "role_id,"
            + "priority_id,"
            + "gmt_create,"
            + "gmt_modified"
            + ") VALUES("
            + "#{roleId,}"
            + "#{priorityId,}"
            + "#{gmtCreate,}"
            + "#{gmtModified}"
            + ")")
    @Options(keyColumn = "id",keyProperty = "id",useGeneratedKeys = true)
    void save(RolePriorityRelationshipDO rolePriorityRelationshipDO);


    /**
     * 根据权限id查询记录数
     * @param priorityId 权限id
     * @return 记录数
     */
    @Select("SELECT COUNT(*) "
            + "FROM auth_role_priority_relationship "
            + "WHERE priority_id = #{priorityId}")
    Long countByPriorityId(@Param("priorityId") Long priorityId);
}
