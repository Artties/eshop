package com.Jenna.eshop.common.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 对象工具类
 * @author Jenna C He
 * @date 2023/05/11 09:34
 */
public class ObjectUtils {
    /**
     * 转换集合
     * @param sourceList 源集合
     * @param targetClazz 目标集合元素类型
     * @return 转换后的集合
     * @param <T> 泛型
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> convertList(
            List<? extends AbstractObject> sourceList,Class<T> targetClazz) throws Exception {
        List<T> targetList = new ArrayList<T>();
        for (AbstractObject sourceObject : sourceList){
            targetList.add(sourceObject.clone(targetClazz));
        }
        return targetList;
    }
}
