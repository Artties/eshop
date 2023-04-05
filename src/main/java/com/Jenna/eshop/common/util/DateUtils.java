package com.Jenna.eshop.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间日期工具类
 * @author Jenna C He
 * @date 2023/04/05 10:26
 */
public class DateUtils {

    /**
     * 以线程安全的方式获取DateFormat
     * @return
     */
    public static Date getCreateTime() throws Exception{
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormatter.parse(dateFormatter.format(new Date()));
    }

}
