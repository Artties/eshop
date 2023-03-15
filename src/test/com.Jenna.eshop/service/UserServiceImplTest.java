package service;

import com.Jenna.eshop.domain.User;
import com.Jenna.eshop.service.UserService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 用户管理模块的service组件的单元测试类
 * @author Jenna C He
 * @date 2023/03/15 11:26
 */

/**
 * 这个注解是说，在执行单元测试的时候，不是直接去执行里面的单元测试的方法
 * 因为那些方法执行之前，是需要做一些准备工作的，它是需要先初始化一个spring容器的
 * 所以得找这个SpringRunner这个类，来先准备好spring容器，再执行各个测试方法
 */
@RunWith(SpringRunner.class)
/**
 * 这个是说，会从最顶层的包结构开始找，
 * 找到一个标注了@SpringBootApplication注解的一个类，算是启动类
 * 然后会执行这个启动类的main方法，就可以创建spring容器，给后面的单元测试提供完整的这个环境
 */
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;
}
