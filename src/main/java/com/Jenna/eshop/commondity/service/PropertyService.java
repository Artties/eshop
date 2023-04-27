package com.Jenna.eshop.commondity.service;

import com.Jenna.eshop.commondity.domain.PropertyDTO;
import com.Jenna.eshop.commondity.domain.PropertyQuery;

import java.util.List;

/**
 * 商品属性管理模块的service组件接口
 * @author Jenna C He
 * @date 2023/3/12 16:55
 */
public interface PropertyService {
    /**
     * 分页查询商品属性
     * @param propertyQuery 查询条件
     * @return 商品属性
     */
    List<PropertyDTO> listPropertyByPage(PropertyQuery propertyQuery);
    /**
     * 新增商品属性
     * @param propertyDTO 商品属性DO对象
     */
    Boolean saveProperty(PropertyDTO propertyDTO);
    /**
     * 根据id查询商品属性
     * @param id 商品属性id
     * @return 商品属性
     */
    PropertyDTO getPropertyById(Long id);
    /**
     * 更新商品属性
     * @param propertyDTO 商品属性DO对象
     */
    Boolean updateProperty(PropertyDTO propertyDTO);
}
