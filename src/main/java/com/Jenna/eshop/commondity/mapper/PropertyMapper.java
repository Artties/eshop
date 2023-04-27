package com.Jenna.eshop.commondity.mapper;

import com.Jenna.eshop.commondity.domain.PropertyDO;
import com.Jenna.eshop.commondity.domain.PropertyQuery;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 商品属性管理模块的Mapper组件
 * @author Jenna C He
 * @date 2023/3/10 11:22
 */
@Mapper
public interface PropertyMapper {
    /**
     * 分页查询商品属性
     * @param propertyQuery 查询条件
     * @return 商品属性
     */
    @Select(
            "<script>"
            +"SELECT"
                +"a.id,"
                +"a.property_name,"
                +"a.property_desc,"
                +"a.input_type,"
                +"a.input_values,"
                +"a.gmt_create,"
                +"a.gmt_modified"
            +"FROM  commodity_property a,"
                    + "("
                    + "SELECT id FROM commodity_property "
                    +"<if test='propertyName != null'>"
        +"WHERE property_name like '${propertyName}%'"
                    +"</if test='propertyName != null'>"
        +"LIMIT #{offset},#{size}"
                    + ") b"
                    + "WHERE a.id = b.id"
           + "</script>")
    //@SelectProvider(type = PropertySelectProvider.class,method = "getSelectSQL")
    @Results({
            @Result(column = "id",property = "id",id = true),
            @Result(column = "property_name",property = "propertyName"),
            @Result(column = "property_desc",property = "property_desc"),
            @Result(column = "inputType",property = "inputType"),
            @Result(column = "inputValues",property = "inputValues"),
            @Result(column = "gmt_create",property = "gmt_create"),
            @Result(column = "gmt_modified",property = "gmt_modified")
    })
    List<PropertyDO> listPropertyByPage(PropertyQuery propertyQuery);

    /**
     * mybatis 使用查询SQL的方法
     * 1.mapper.xml去写sql
     * 2.基于纯注解+<script>标签实现动态SQL
     * 3.基于纯注解+XProvider(SelectProvider、InsertProvider、UpdateProvider)
     */

    /**
     * 新增商品属性
     * @param propertyDO 商品属性DO对象
     */
    @Insert("INSERT INTO commodity_property("
            + "property_name,"
            + "property_desc,"
            + "input_type,"
            + "input+values,"
            + "gmt_create,"
            + "gmt_modified"
            + ") VALUES ("
            + "#{propertyName},"
            + "#{propertyDesc},"
            + "#{inputType},"
            + "#{inputValues},"
            + "#{gmtCreate},"
            + "#{gmtModified}"
            + ")")
    @Options(keyColumn = "id",keyProperty = "id",useGeneratedKeys = true)
    void saveProperty(PropertyDO propertyDO);

    /**
     * 根据id查询商品属性
     * @param id 商品属性id
     * @return 商品属性
     */
    @Select(
                    "id,"
                    +"property_name,"
                    +"property_desc,"
                    +"input_type,"
                    +"input_values,"
                    +"gmt_create,"
                    +"gmt_modified"
                    +"FROM  commodity_property "
                    + "WHERE id = #{id}")
    @Results({
            @Result(column = "id",property = "id",id = true),
            @Result(column = "property_name",property = "propertyName"),
            @Result(column = "property_desc",property = "property_desc"),
            @Result(column = "inputType",property = "inputType"),
            @Result(column = "inputValues",property = "inputValues"),
            @Result(column = "gmt_create",property = "gmt_create"),
            @Result(column = "gmt_modified",property = "gmt_modified")
    })
    PropertyDO getPropertyById(@Param("id") Long id);

    /**
     * 更新商品属性
     * @param propertyDO 商品属性DO对象
     */
    @Update("UPDATE commodity_property SET"
            + "property_desc = #{propertyDesc},"
            + "gmt_modified = #{gmtModified}"
            + "WHERE id = #{id}")
    void updateProperty(PropertyDO propertyDO);

    //TODO @Delete 太复杂 暂时不做
}
