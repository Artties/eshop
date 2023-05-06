//package com.Jenna.eshop.commondity.mapper;
//
//import com.Jenna.eshop.commondity.domain.PropertyQuery;
//import org.apache.ibatis.jdbc.SQL;
//
///**
// * @author Jenna C He
// * @date 2023/3/10 14:50
// */
//public class PropertySelectProvider {
//    public SQL getSelectSQL(final PropertyQuery propertyQuery){
//        String sql= "select 999";
//
//        return new SQL() {{
//            SELECT("id,name");
//            FROM("commodity_property");
//            if (propertyQuery.getPropertyName() != null) {
//                WHERE("property_name like '#{propertyName}%'");
//            }
//
//        }};
//    }
//}

/**
 * 使用     * 3.基于纯注解+XProvider(SelectProvider、InsertProvider、UpdateProvider) 保留这个文件但是不使用
 */
