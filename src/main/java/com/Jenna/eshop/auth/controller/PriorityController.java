package com.Jenna.eshop.auth.controller;

import com.Jenna.eshop.auth.domain.PriorityVO;
import com.Jenna.eshop.auth.service.impl.PriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 权限管理模块的controller组件
 */
@RestController
@RequestMapping("/auth")

public class PriorityController {
    /**
     * 权限管理模块的service组件
     */
    @Autowired
    private PriorityService priorityService;

    /**
     * 查询根权限
     * @return 根权限集合
     */
    @GetMapping("/priority/root")
    public List<PriorityVO> listRootPriorities(){
        return null;
    }



}
