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
public interface DateProvider {

    public Date getCurrentTime() throws Exception;

}