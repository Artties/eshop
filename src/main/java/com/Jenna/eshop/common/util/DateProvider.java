package com.Jenna.eshop.common.util;

import java.util.Date;

/**
 * 日期辅助组件接口
 * @author Jenna C He
 * @date 2023/04/07 12:06
 */
public interface DateProvider {
    /**
     * 获取当前时间
     * @return 当前时间
     * @throws Exception 抛出异常
     */
    Date getCreateTime() throws Exception;
}
