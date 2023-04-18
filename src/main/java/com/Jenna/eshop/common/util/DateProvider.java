package com.Jenna.eshop.common.util;


import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 日期辅助组件接口
 * @author Jenna C He
 *
 */
@Component
public interface DateProvider {
    /**
     * 获取当前时间
     * @return 当前时间
     * @throws Exception 抛出异常
     */
    public Date getCurrentTime() throws Exception;

    /**
     * 将Date对象格式化成：yyyy-mm-dd HH:mm:ss
     * @param date Date对象
     * @return 格式化日期字符串
     * @throws Exception 抛出异常
     */
    String formatDatetime(Date date) throws Exception;

}