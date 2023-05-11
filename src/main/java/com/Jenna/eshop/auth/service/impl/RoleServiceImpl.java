package com.Jenna.eshop.auth.service.impl;

import com.Jenna.eshop.auth.dao.RoleDAO;
import com.Jenna.eshop.auth.domain.RoleDO;
import com.Jenna.eshop.auth.domain.RoleDTO;
import com.Jenna.eshop.auth.domain.RoleQuery;
import com.Jenna.eshop.auth.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 角色管理模块的service组件
 * @author Jenna C He
 * @date 2023/05/10 16:12
 */
@Service
public class RoleServiceImpl implements RoleService {

    private static final Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);
    /**
     * 角色管理模块的DAO组件
     */
    @Autowired
    private RoleDAO roleDAO;
    /**
     * 分页查询角色
     *
     * @param query 查询的条件
     * @return 角色DO对象集合
     */
    @Override
    public List<RoleDTO> listByPage(RoleQuery query) {
        try {
            List<RoleDTO> resultRoles = new ArrayList<RoleDTO>();

            List<RoleDO> roles = roleDAO.listByPage(query);
            for (RoleDO role : roles) {
//                resultRoles.add(role.)
            }
            return null;
        } catch (Exception e) {
            logger.error("error", e);
            return null;
        }
    }

    /**
     * 根据id查询角色DO对象
     *
     * @param id 角色id
     * @return 角色DO对象
     */
    @Override
    public RoleDTO getById(Long id) {
        return null;
    }

    /**
     * 新增角色
     *
     * @param role 角色DO对象
     */
    @Override
    public Boolean save(RoleDTO role) {
        return true;
    }

    /**
     * 更新角色
     *
     * @param role 角色DO对象
     */
    @Override
    public Boolean update(RoleDTO role) {
        return true;
    }

    /**
     * 删除角色
     *
     * @param id 角色id
     */
    @Override
    public Boolean remove(Long id) {
        return true;
    }
}
