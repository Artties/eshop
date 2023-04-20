package test.java.com.Jenna.eshop;

import com.Jenna.eshop.listener.MyApplicationStartedEventListener;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.Jenna.eshop.common.config.DruidDataSourceConfig;
/**
 * @author Jenna C He
 * @date 2023/04/17 11:13
 *
 */
@SpringBootApplication
@EnableScheduling
@ServletComponentScan
@Import(DruidDataSourceConfig.class)
@MapperScan(basePackages = {"com.Jenna.eshop.auth.mapper.PriorityMapper"})
public class ApplicationTest {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationTest.class, args);
        SpringApplication app = new SpringApplication(ApplicationTest.class);
        app.addListeners(new MyApplicationStartedEventListener());
        app.run(args);
    }

}