package com.Jenna.eshop.listener;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
/**
 * @author Jenna C He
 * @date 2023/1/6 13:54
 */
@SuppressWarnings("deprecation")
public class MyApplicationStartedEventListener implements ApplicationListener<ApplicationStartedEvent> {

    public void onApplicationEvent(ApplicationStartedEvent event) {
        System.out.println("系统启动了。。。");
    }

}