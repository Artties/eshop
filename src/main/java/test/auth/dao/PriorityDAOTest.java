package test.auth.dao;


import com.Jenna.eshop.auth.constant.PriorityType;
import com.Jenna.eshop.auth.dao.PriorityDAO;
import com.Jenna.eshop.auth.domain.PriorityDO;
import com.Jenna.eshop.common.util.DateProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

/**
 * 权限管理模块的DAO组件的单元测试类
 * @author Jenna C He
 * @date 2023/04/13 17:33
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(true)

public class PriorityDAOTest{
    /**
     * 权限管理模块的DAO组件
     */
    @Autowired
    private PriorityDAO priorityDAO;

    @Autowired
    private DateProvider dateProvider;

    /**
     * 测试新增权限
     * @throws Exception 抛出异常
     */
    @Test
    public void testSavePriority() throws Exception {

    }
    /**
     * 测试查询根权限
     * @throws Exception 抛出异常
     */
    @Test
    public void testListRootPriorities() throws Exception{
        //构造两个根权限
    }

    /**
     * 构造一个根权限DO对象
     * @return 根权限DO对象
     * @throws Exception 抛出异常
     */
    private PriorityDO priorityDO() throws Exception {
        Random random = new Random();
        int randomInt = random.nextInt() * 100;
        PriorityDO priorityDO = new PriorityDO();
        priorityDO.setCode("TEST_" + randomInt);
        priorityDO.setGmtCreate(dateProvider.getCurrentTime());
        priorityDO.setGmtModified(dateProvider.getCurrentTime());
        priorityDO.setParentId(null);
        priorityDO.setPriorityComment("TEST_" + randomInt);
        priorityDO.setPriorityType(PriorityType.MENU);
        priorityDO.setUrl(null);

        return priorityDO;
    }


}
