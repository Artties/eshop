package com.Jenna.eshop.auth.dao.impl;


import com.Jenna.eshop.auth.dao.RolePriorityRelationshipDAO;
import com.Jenna.eshop.auth.domain.AccountPriorityRelationshipDO;
import com.Jenna.eshop.auth.domain.RolePriorityRelationshipDO;
import com.Jenna.eshop.auth.mapper.RolePriorityRelationshipMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 角色和权限关系管理模块的DAO组件
 * @author Artties
 */
public class RolePriorityRelationshipDAOImpl implements RolePriorityRelationshipDAO {
    private static final Logger logger = LoggerFactory.getLogger(RolePriorityRelationshipDAOImpl.class);

    /**
     * 角色和权限关系管理的mapper组件
     */
    @Autowired
    private RolePriorityRelationshipMapper rolePriorityRelationshipMapper;

    /**
     * 新增账号和权限的关联关系
     * @param rolePriorityRelationshipDO 新增账号和权限的关联关系DO对象
     * @return 处理结果
     */
    public Boolean save(RolePriorityRelationshipDO rolePriorityRelationshipDO){

        try{
            rolePriorityRelationshipMapper.save(rolePriorityRelationshipDO);
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
        try{
            return rolePriorityRelationshipMapper.countByPriorityId(priorityId);
        }catch (Exception e) {
            logger.error("error",e);
        }
        return 0L;
    }

}
