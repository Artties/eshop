package com.Jenna.eshop.auth.dao;

import com.Jenna.eshop.auth.domain.PriorityDO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 权限管理模块的DAO组件接口
 */
@Service
public interface PriorityDAO {
    /**
     * 查询根权限
     * @return 根权限集合
     */
    List<PriorityDO> listRootPriorities();
}
