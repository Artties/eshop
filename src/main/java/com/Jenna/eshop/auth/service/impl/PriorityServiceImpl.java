package com.Jenna.eshop.auth.service.impl;

import com.Jenna.eshop.auth.dao.PriorityDAO;
import com.Jenna.eshop.auth.domain.PriorityDTO;
import com.Jenna.eshop.auth.domain.PriorityDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 权限管理模块的service组件
 */
@Service
public class PriorityServiceImpl implements PriorityService {
    /**
     * 权限管理模块的DAO组件
     * @return 根权限集合
     */
    @Autowired
    private PriorityDAO priorityDAO;

    /**
     * 查询根权限
     * @return 根权限集合
     */
    public List<PriorityDTO> listRootPriorities(){
//        List<PriorityDO> priorityDos = priorityDAO.listRootPriorities();
//
//        List<PriorityDTO> priorityDTOs = new ArrayList<>();
//        for(PriorityDO priorityDO:priorityDos){
//            priorityDTOs.add(priorityDO.clone(PriorityDTO.class));
//        }
//
//        ObjectUtils.cloneList(prorityDOs,PriorityDTO.class);
//
//        return ObjectUtils.cloneList(priorityDAO.listRootPriorities(),PriorityDTO.class);

        return null;
    }
}
