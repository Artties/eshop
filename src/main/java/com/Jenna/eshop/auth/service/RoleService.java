package com.Jenna.eshop.auth.service;

import com.Jenna.eshop.auth.domain.RoleDTO;
import com.Jenna.eshop.auth.domain.RoleQuery;

import java.util.List;

/**
 * 角色管理模块service组件接口
 * @author Jenna C He
 * @date 2023/05/10 16:09
 */
public interface RoleService {
    /**
     * 分页查询角色
     * @param query 查询的条件
     * @return 角色DO对象集合
     */
    List<RoleDTO> listByPage(RoleQuery query);

    /**
     * 根据id查询角色DO对象
     * @param id 角色id
     * @return 角色DO对象
     */
    RoleDTO getById( Long id);

    /**
     * 新增角色
     * @param role 角色DO对象
     */
    Boolean save(RoleDTO role);

    /**
     * 更新角色
     * @param role 角色DO对象
     */
    Boolean update(RoleDTO role);

    /**
     * 删除角色
     * @param id 角色id
     */
    Boolean remove(Long id);
}
