<<<<<<< HEAD

=======
>>>>>>> b5c4cbbf26d3c5bff093c82c85a2627e7dce90d2
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
<<<<<<< HEAD
     * 获取当前时间
     * @return 当前时间
     * @throws Exception 抛出异常
     */
    public Date getCurrentTime() throws Exception{
=======
     * 以线程安全的方式获取DateFormat
     * @return
     */
    public Date getCreateTime() throws Exception{
>>>>>>> b5c4cbbf26d3c5bff093c82c85a2627e7dce90d2
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormatter.parse(dateFormatter.format(new Date()));
    }

<<<<<<< HEAD
}
=======
}
>>>>>>> b5c4cbbf26d3c5bff093c82c85a2627e7dce90d2
