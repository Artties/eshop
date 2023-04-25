
package com.Jenna.eshop.common.util;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间日期工具类
 * @author Jenna C He
 * @date 2023/04/05 10:26
 */
@Component
public class DateProviderImpl implements DateProvider {

    /**
     * 获取当前时间
     *
     * @return 当前时间
     * @throws Exception 抛出异常
     */
    public Date getCurrentTime() throws Exception {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormatter.parse(dateFormatter.format(new Date()));
    }

    /**
     * 将Date对象格式化成：yyyy-mm-dd HH:mm:ss
     *
     * @param date Date对象
     * @return 格式化日期字符串
     * @throws Exception 抛出异常
     */
    @Override
    public String formatDatetime(Date date) throws Exception {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormatter.format(date);
    }

    /**
     * 将日期字符串转换为Date对象
     *
     * @param datetime 日期字符串
     * @return date对象
     * @throws Exception 抛出异常
     */
    @Override
    public Date parseDatetime(String datetime) throws Exception {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormatter.parse(datetime);
    }
}