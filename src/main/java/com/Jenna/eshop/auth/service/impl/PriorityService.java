package com.Jenna.eshop.auth.service.impl;



import com.Jenna.eshop.auth.domain.PriorityDTO;

import java.util.List;

public interface PriorityService {
    /**
     * 查询根权限
     * @return 根权限集合
     */
    List<PriorityDTO> listRootPriorities();

    /**
     * 根据父权限id查询子权限
     * @param parentId 父权限id
     * @return 子权限
     */
    List<PriorityDTO> listChildPriorities(Long parentId);

    /**
     * 根据id查询权限
     * @param id 权限id
     * @return 权限
     */
    PriorityDTO getPriorityById(Long id);

    /**
     * 新增权限
     * @param priorityDTO 权限DO对象
     */
    Boolean savePriority(PriorityDTO priorityDTO);

    /**
     * 更新权限
     * @param priorityDTO 权限DO对象
     */
    Boolean updatePriority(PriorityDTO priorityDTO);
}
