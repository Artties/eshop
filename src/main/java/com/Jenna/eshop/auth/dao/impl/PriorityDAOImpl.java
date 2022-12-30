package com.Jenna.eshop.auth.dao.impl;

import com.Jenna.eshop.auth.dao.PriorityDAO;
import com.Jenna.eshop.auth.domain.PriorityDO;
import com.Jenna.eshop.auth.mapper.PriorityMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 权限管理模块的DAO组件
 */
public class PriorityDAOImpl implements PriorityDAO {
    private static final Logger logger = LoggerFactory.getLogger(PriorityDAO.class);


    /**
     * 权限管理模块的Mapper组件
     */
    @Autowired
    private PriorityMapper priorityMapper;

    /**
     * 查询根权限
     * @return 根权限集合
     */
    public List<PriorityDO> listRootPriorities(){

        try{
            return priorityMapper.listRootPriorities();
        }catch(Exception e){
            logger.error("error",e);
        }
        return null;
    }


    /**
     * 根据父权限id查询子权限
     * @param parentId 父权限id
     * @return 子权限
     */
    @Override
    public List<PriorityDO> listChildPriorities(Long parentId) {
        try{
            return priorityMapper.listChildPriorities(parentId);
        }catch (Exception e){
            logger.error("error",e);
        }
        return null;
    }

    /**
     * 根据id查询权限
     * @param id 权限id
     * @return 权限
     */
    public PriorityDO getPriorityById(Long id){
        try{
            return priorityMapper.getPriorityById(id);
        }catch (Exception e){
            logger.error("error",e);
        }
        return null;
    }

    /**
     * 新增权限
     * @param priorityDO 权限DO对象
     */
    public Boolean savePriority(PriorityDO priorityDO){
        try{
            priorityMapper.savePriority(priorityDO);
        }catch (Exception e){
            logger.error("error",e);
            return false;
        }
        return true;
    }

    /**
     * 更新权限
     * @param priorityDO 权限DO对象
     */
    public Boolean updatePriority(PriorityDO priorityDO){
        try{
            priorityMapper.savePriority(priorityDO);
        }catch (Exception e){
            logger.error("error",e);
            return false;
        }
        return true;
    }
}
