package com.Jenna.eshop.auth.dao.impl;

import com.Jenna.eshop.auth.dao.PriorityDAO;
import com.Jenna.eshop.auth.domain.PriorityDO;
import com.Jenna.eshop.auth.mapper.PriorityMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 权限管理模块的DAO组件
 */
public class PriorityDAOImpl implements PriorityDAO {
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
        return priorityMapper.listRootPriorities();
    }
}
