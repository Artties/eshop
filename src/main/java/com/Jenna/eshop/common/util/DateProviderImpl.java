
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
}

