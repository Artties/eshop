package com.Jenna.eshop.commondity.domain;

import com.Jenna.eshop.common.util.BeanCopierUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * 商品属性DO类
 * @author Jenna C He
 * @date 2023/3/10 11:14
 */
public class PropertyDO {
    private static final Logger logger = LoggerFactory.getLogger(PropertyDO.class);
    /**
     * id
     */
    private Long id;
    /**
     * 属性名称
     */
    private String propertyName;
    /**
     * 属性描述
     */
    private String propertyDesc;
    /**
     * 输入类型
     */
    private Integer inputType;
    /**
     * 输入可选值
     */
    private String inputValues;
    /**
     * 商品属性的创建时间
     */
    private Date gmtCreate;
    /**
     * 商品属性的修改时间
     */
    private Date gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyDesc() {
        return propertyDesc;
    }

    public void setPropertyDesc(String propertyDesc) {
        this.propertyDesc = propertyDesc;
    }

    public Integer getInputType() {
        return inputType;
    }

    public void setInputType(Integer inputType) {
        this.inputType = inputType;
    }

    public String getInputValues() {
        return inputValues;
    }

    public void setInputValues(String inputValues) {
        this.inputValues = inputValues;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * 将自己的数据克隆到指定类型对象中
     * @param clazz 指定类型
     * @return 执行类型对象
     * @param <T> 泛型定义
     */
    public <T> T clone(Class<T> clazz){
        T target = null;
        try {
            target = clazz.getDeclaredConstructor().newInstance();
            BeanCopierUtils.copyProperties(this,target);
        }catch (Exception e) {
            logger.error("error",e);
            return null;
        }
        return target;
    }
}
