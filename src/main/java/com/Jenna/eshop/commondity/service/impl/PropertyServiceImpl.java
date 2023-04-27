package com.Jenna.eshop.commondity.service.impl;

import com.Jenna.eshop.common.util.DateProvider;
import com.Jenna.eshop.commondity.dao.PropertyDAO;
import com.Jenna.eshop.commondity.domain.PropertyDO;
import com.Jenna.eshop.commondity.domain.PropertyDTO;
import com.Jenna.eshop.commondity.domain.PropertyQuery;
import com.Jenna.eshop.commondity.service.PropertyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品属性管理模块的service组件
 * @author Jenna C He
 * @date 2023/3/12 16:57
 */
@Service
public class PropertyServiceImpl implements PropertyService {

    private static final Logger logger = LoggerFactory.getLogger(PropertyServiceImpl.class);
    /**
     * 商品属性管理模块的DAO组件
     */
    @Autowired
    private PropertyDAO propertyDAO;
    /**
     * 日期辅助组件
     */
    @Autowired
    private DateProvider dateProvider;

    /**
     * 分页查询商品属性
     *
     * @param propertyQuery 查询条件
     * @return 商品属性
     */
    public List<PropertyDTO> listPropertyByPage(PropertyQuery propertyQuery) {
        try {
            List<PropertyDO> propertyDOs = propertyDAO.listPropertyByPage(propertyQuery);
            List<PropertyDTO> propertyDTOs = new ArrayList<PropertyDTO>(propertyDOs.size());
            for (PropertyDO propertyDO:propertyDOs) {
                propertyDTOs.add(propertyDO.clone(PropertyDTO.class));
            }
            return propertyDTOs;
        }catch (Exception e) {
            logger.error("error",e);
        }
        return new ArrayList<PropertyDTO>();
    }

    /**
     * 新增商品属性
     *
     * @param propertyDTO 商品属性DO对象
     */
    public Boolean saveProperty(PropertyDTO propertyDTO) {
        try {
            propertyDTO.setGmtCreate(dateProvider.getCurrentTime());
            propertyDTO.setGmtModified(dateProvider.getCurrentTime());
            PropertyDO propertyDO = propertyDTO.clone(PropertyDO.class);
            propertyDAO.saveProperty(propertyDO);
        }catch (Exception e) {
            logger.error("error",e);
            return false;
        }
        return true;
    }

    /**
     * 根据id查询商品属性
     *
     * @param id 商品属性id
     * @return 商品属性
     */
    public PropertyDTO getPropertyById(Long id) {
        try {
            PropertyDO propertyDO = propertyDAO.getPropertyById(id);
            return propertyDO.clone(PropertyDTO.class);
        }catch (Exception e) {
            logger.error("error",e);
        }
        return new PropertyDTO();
    }

    /**
     * 更新商品属性
     *
     * @param propertyDTO 商品属性DO对象
     */
    public Boolean updateProperty(PropertyDTO propertyDTO) {
        try {
            propertyDTO.setGmtCreate(dateProvider.getCurrentTime());
            propertyDTO.setGmtModified(dateProvider.getCurrentTime());
            PropertyDO propertyDO = propertyDTO.clone(PropertyDO.class);
            propertyDAO.saveProperty(propertyDO);
        } catch (Exception e) {
            logger.error("error", e);
            return false;
        }
        return true;
    }
}
