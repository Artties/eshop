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

}