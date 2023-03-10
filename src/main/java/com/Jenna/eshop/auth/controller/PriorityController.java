package com.Jenna.eshop.auth.controller;

import com.Jenna.eshop.auth.domain.PriorityDO;
import com.Jenna.eshop.auth.domain.PriorityDTO;
import com.Jenna.eshop.auth.domain.PriorityVO;
import com.Jenna.eshop.auth.service.impl.PriorityService;
import org.apache.ibatis.annotations.Update;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;


/**
 * 权限管理模块的controller组件
 */
@RestController
@RequestMapping("/auth/priority")

public class PriorityController {
    private static final Logger logger = LoggerFactory.getLogger(PriorityDO.class);
    /**
     * 权限管理模块的service组件
     */
    @Autowired
    private PriorityService priorityService;

    /**
     * 查询根权限
     * @return 根权限集合
     */
    @GetMapping("/root")
    public List<PriorityVO> listRootPriorities(){
        try {
            List<PriorityDTO> priorityDTOs = priorityService.listRootPriorities();
            if (priorityDTOs == null){
                priorityDTOs = new ArrayList<PriorityDTO>();
            }
            List<PriorityVO> priorityVOs = new ArrayList<PriorityVO>(priorityDTOs.size());
            for(PriorityDTO priorityDTO:priorityDTOs){
                priorityVOs.add(priorityDTO.clone(PriorityVO.class));
            }

            return priorityVOs;
        }catch (Exception e){
            logger.error("error",e);
        }
        return new ArrayList<PriorityVO>();
    }

    /**
     * 根据父权限id查询子权限
     * @param parentId 父权限id
     * @return 子权限
     */
    @GetMapping("/child/{parentId}")
    public List<PriorityVO> listChildPriorities(
            @PathVariable("parentId") Long parentId){
        try {
            List<PriorityDTO> priorityDTOs = priorityService.listChildPriorities(parentId);
            if (priorityDTOs == null){
                priorityDTOs = new ArrayList<PriorityDTO>();
            }
            List<PriorityVO> priorityVOs = new ArrayList<PriorityVO>(priorityDTOs.size());

            for(PriorityDTO priorityDTO:priorityDTOs){
                priorityVOs.add(priorityDTO.clone(PriorityVO.class));
            }

            return priorityVOs;
        }catch (Exception e){
            logger.error("error",e);
        }
        return new ArrayList<>();
    }
    /**
     * 根据id查询权限
     * @param id 权限id
     * @return 权限
     */
    @GetMapping("/{id}")
    public PriorityVO getPriorityById(@PathVariable("id") Long id){
        try {
            PriorityDTO priorityDTO = priorityService.getPriorityById(id);
            if (priorityDTO == null){
                priorityDTO = new PriorityDTO();
            }
            return priorityDTO.clone(PriorityVO.class);
        }catch (Exception e){
            logger.error("error",e);
        }
        return new PriorityVO();
    }

    /**
     * 新增权限
     * @param priorityVO 权限VO对象
     */
    @PostMapping("/")
    public Boolean savePriority(@RequestBody PriorityVO priorityVO){
        try {
            PriorityDTO priorityDTO = priorityVO.clone(PriorityDTO.class);
            priorityService.savePriority(priorityDTO);
        }catch (Exception e){
            logger.error("error",e);
            return false;
        }
        return true;
    }

    /**
     * 更新权限
     * @param priorityVO 权限VO对象
     */
   @PutMapping("/{id}")
    public Boolean updatePriority(@RequestBody PriorityVO priorityVO){
        try {
            PriorityDTO priorityDTO = priorityVO.clone(PriorityDTO.class);
            priorityService.updatePriority(priorityDTO);
        }catch (Exception e){
            logger.error("error",e);
            return false;
        }
        return true;
    }
    /**
     * 删除权限
     */
    @DeleteMapping("/{id}")
    public Boolean removePriority(@PathVariable("id") Long id){
        try {
            return priorityService.removePriority(id);
        }catch (Exception e){
            logger.error("error",e);
        }
        return false;
    }
}
