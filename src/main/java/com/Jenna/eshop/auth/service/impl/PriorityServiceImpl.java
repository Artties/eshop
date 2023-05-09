package com.Jenna.eshop.auth.service.impl;

import com.Jenna.eshop.auth.composite.PriorityNode;
import com.Jenna.eshop.auth.dao.AccountPriorityRelationshipDAO;
import com.Jenna.eshop.auth.dao.PriorityDAO;
import com.Jenna.eshop.auth.dao.RolePriorityRelationshipDAO;
import com.Jenna.eshop.auth.domain.PriorityDTO;
import com.Jenna.eshop.auth.domain.PriorityDO;
import com.Jenna.eshop.auth.visitor.PriorityNodeRelateCheckVisitor;
import com.Jenna.eshop.auth.visitor.PriorityNodeRemoveVisitor;
import com.Jenna.eshop.auth.visitor.PriorityNodeVisitor;
import com.Jenna.eshop.common.util.DateProvider;
import org.apache.ibatis.annotations.Mapper;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 权限管理模块的service组件
 */
@Service
public class PriorityServiceImpl implements PriorityService {
    private static final Logger logger = LoggerFactory.getLogger(PriorityDAO.class);
    /**
     * 权限管理模块的DAO组件
     * @return 根权限集合
     */
    @Autowired
    private PriorityDAO priorityDAO;

    /**
     * 角色和权限关系管理模块的DAO组件
     */
    @Autowired
    private RolePriorityRelationshipDAO rolePriorityRelationshipDAO;

    /**
     *
     * 账号和权限关系管理模块的DAO组件
     */
    @Autowired
    private AccountPriorityRelationshipDAO accountPriorityRelationshipDAO;
    /**
     * 时间辅助组件
     */
    @Autowired
    private DateProvider dateProvider;
    /**
     * 查询根权限
     * @return 根权限集合
     */
    public List<PriorityDTO> listRootPriorities(){
        try{
            List<PriorityDO> priorityDOs = priorityDAO.listRootPriorities();
            if (priorityDOs == null){
                return null;
            }

            List<PriorityDTO> priorityDTOs = new ArrayList<PriorityDTO>(priorityDOs.size());
            for(PriorityDO priorityDO:priorityDOs){
                priorityDTOs.add(priorityDO.clone(PriorityDTO.class));
            }
        }catch (Exception e){
            logger.error("error",e);
        }
        return null;
    }

    /**
     * 根据父权限id查询子权限
     * @param parentId 父权限id
     * @return 子权限
     */
    public List<PriorityDTO> listChildPriorities(Long parentId){
        try{
            List<PriorityDO> priorityDOs = priorityDAO.listRootPriorities();
            if (priorityDOs == null){
                return null;
            }

            List<PriorityDTO> priorityDTOs = new ArrayList<PriorityDTO>(priorityDOs.size());
            for(PriorityDO priorityDO:priorityDOs){
                priorityDTOs.add(priorityDO.clone(PriorityDTO.class));
            }
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
    public PriorityDTO getPriorityById(Long id){
        try{
            PriorityDO priorityDO = priorityDAO.getPriorityById(id);
            if (priorityDO == null){
                return null;
            }
            return priorityDO.clone(PriorityDTO.class);
        }catch (Exception e){
            logger.error("error",e);
        }
        return null;
    }

    /**
     * 新增权限
     * @param priorityDTO 权限DO对象
     */
    public Boolean savePriority(PriorityDTO priorityDTO){
        try{
            priorityDTO.setGmtCreate(dateProvider.getCurrentTime());
            priorityDTO.setGmtModified(dateProvider.getCurrentTime());
            priorityDAO.savePriority(priorityDTO.clone(PriorityDO.class));
        }catch (Exception e){
            logger.error("error",e);
            return false;
        }
        return true;
    }

    /**
     * 更新权限
     * @param priorityDTO 权限DO对象
     */
    public Boolean updatePriority(PriorityDTO priorityDTO){
        try{
            priorityDTO.setGmtModified(dateProvider.getCurrentTime());
            priorityDAO.updatePriority(priorityDTO.clone(PriorityDO.class));
        }catch (Exception e){
            logger.error("error",e);
            return false;
        }
        return true;
    }

    /**
     * 删除权限
     * @param id 权限id
     * @return 处理结果
     */
    public Boolean removePriority(Long id){
        try {
            //根据id查询权限
            PriorityDO priorityDO = priorityDAO.getPriorityById(id);
            PriorityNode priorityNode = priorityDO.clone(PriorityNode.class);

            //检查这个权限以及其下任何一个子权限，是否被角色或者账号给关联着
            PriorityNodeRelateCheckVisitor relateCheckVisitor = new PriorityNodeRelateCheckVisitor(priorityDAO,rolePriorityRelationshipDAO,accountPriorityRelationshipDAO);

            relateCheckVisitor.visit(priorityNode);
            Boolean relateCheckResult = relateCheckVisitor.getRelateCheckResult();

            //递归删除当前权限以及其下所有的子权限
            if (relateCheckResult){
                return false;
            }
            PriorityNodeRemoveVisitor removeVisitor = new PriorityNodeRemoveVisitor(priorityDAO);
            removeVisitor.visit(priorityNode);
        }catch (Exception e){
            logger.error("error",e);
        }
        return true;
    }

}
