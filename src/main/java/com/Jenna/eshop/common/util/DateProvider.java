package com.Jenna.eshop.common.util;


import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期辅助组件
 * @author Jenna C He
 *
 */
@Component
public class DateProvider {

    /**
     * 获取当前时间
     * @return 当前时间
     * @throws Exception 抛出异常
     */
    public static Date getCurrentTime() throws Exception{
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormatter.parse(dateFormatter.format(new Date()));
    }

}