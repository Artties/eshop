package com.Jenna.eshop.auth.controller;

import com.Jenna.eshop.auth.domain.*;
import com.Jenna.eshop.auth.service.RoleService;
import com.Jenna.eshop.common.util.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 角色管理模块controller组件
 * @author Jenna C He
 * @date 2023/05/11 17:10
 */
@RestController
@RequestMapping("/auth/role")
public class RoleController {

    private static final Logger logger = LoggerFactory.getLogger(RoleController.class);

    /**
     *角色管理模块的service组件
     */
    @Autowired
    private RoleService roleService;
    /**
     * 分页查询角色
     * @param query 查询条件
     * @return 角色VO集合
     */

    @GetMapping("/")
    public List<RoleVO> listByPage(RoleQuery query) {
        try {
            List<RoleDTO> roles = roleService.listByPage(query);
            Map<Long,RoleDTO> roleMap = convertList2Map(roles);
            List<RoleVO> resultRoles = ObjectUtils.convertList(roles,RoleVO.class);
            for (RoleVO resultRole : resultRoles) {
                List<RolePriorityRelationshipDTO> relations =
                        roleMap.get(resultRole.getId()).getRolePriorityRelations();
                resultRole.setRolePriorityRelations(
                        ObjectUtils.convertList(relations, RolePriorityRelationshipVO.class));
            }
        } catch (Exception e) {
            logger.error("error", e);
            return null;
        }
    }

    /**
     * 将角色list转换为map
     * @param roles 角色list
     * @return 角色map
     */
    private Map<Long,RoleDTO> convertList2Map(List<RoleDTO> roles){
        Map<Long,RoleDTO> rolesMap = new HashMap<Long,RoleDTO>();
        for(RoleDTO role : roles){
            rolesMap.put(role.getId(), role);
        }
        return rolesMap;
    }

}
