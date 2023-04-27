package com.Jenna.eshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.Jenna.eshop.common.config.DruidDataSourceConfig;
/**
 * 系统启动类
 * @author Jenna C He
 * @date 2023/04/19 11:18
 */
@SpringBootApplication
@EnableScheduling
@ServletComponentScan
@Import(DruidDataSourceConfig.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}