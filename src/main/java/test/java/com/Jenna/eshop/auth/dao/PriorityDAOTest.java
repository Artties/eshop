package test.java.com.Jenna.eshop.auth.dao;


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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.*;

/**
 * 权限管理模块的DAO组件的单元测试类
 * @author Jenna C He
 * @date 2023/04/13 17:33
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(true)

public class PriorityDAOTest {
    /**
     * 权限管理模块的DAO组件
     */
    @Autowired
    private PriorityDAO priorityDAO;

    @Autowired
    private DateProvider dateProvider;

    /**
     * 测试新增权限
     *
     * @throws Exception 抛出异常
     */
    @Test
    public void testSavePriority() throws Exception {
        Long parentId = 1L;
        PriorityDO priorityDO = createPriorityDO(parentId);

        assertNotNull(priorityDO.getId());
        assertThat(priorityDO.getId(), greaterThan(0L));

    }

    /**
     * 测试更新权限
     * @throws Exception 抛出异常
     */
    @Test
    public void testUpdatePriority() throws Exception {
        Long parentId = 1L;
        PriorityDO priorityDO = createPriorityDO(parentId);

        priorityDO.setCode(priorityDO.getCode() + "_modified");
        priorityDO.setGmtModified(dateProvider.getCurrentTime());
        priorityDO.setPriorityComment(priorityDO.getPriorityComment() + "_modified");
        priorityDO.setUrl(priorityDO.getUrl() + "_modified");

        priorityDAO.updatePriority(priorityDO);

        PriorityDO resultPriorityDO = priorityDAO.getPriorityById(priorityDO.getId());

        assertEquals(priorityDO,resultPriorityDO);

    }

    /**
     * 测试删除权限
     * @throws Exception 抛出异常
     */
    @Test
    public void testRemovePriority() throws Exception {
        Long parentId = 1L;
        PriorityDO priorityDO = createPriorityDO(parentId);

        priorityDAO.removePriority(priorityDO.getId());

        PriorityDO resultPriorityDO = priorityDAO.getPriorityById(priorityDO.getId());

        assertNull(resultPriorityDO);
    }


    /**
     * 测试查询根权限
     *
     * @throws Exception 抛出异常
     */
    @Test
    public void testListRootPriorities() throws Exception {
        Long parentId = null;
        Map<Long, PriorityDO> priorityDOMap = createPriorityDOMap(parentId);
        //查询根权限集合
        List<PriorityDO> priorityDOs = priorityDAO.listRootPriorities();
        comparePriorityDOs(priorityDOMap,priorityDOs);

    }

    /**
     * 测试根据父权限id查询子权限
     *
     * @throws Exception 抛出异常
     */
    @Test
    public void testListChildPriorities() throws Exception {
        //构造数据
        Long parentId = 1L;
        Map<Long, PriorityDO> priorityDOMap = createPriorityDOMap(parentId);

        //执行方法
        List<PriorityDO> priorityDOs = priorityDAO.listChildPriorities(parentId);
        comparePriorityDOs(priorityDOMap,priorityDOs);

    }

    /**
     * 测试根据id查询权限
     * @throws Exception 抛出异常
     */
    @Test
    public void testGetPriorityById() throws Exception {
        Long parentId = 1L;
        PriorityDO priorityDO = createPriorityDO(parentId);
        PriorityDO resultPriorityDO = priorityDAO.getPriorityById(priorityDO.getId());

        assertEquals(priorityDO,resultPriorityDO);
    }


    /**
     * 构造一个权限DO对象集合
     *
     * @param parentId 父权限id
     * @return 权限DO对象集合
     * @throws Exception 抛出异常
     */
    private Map<Long, PriorityDO> createPriorityDOMap(Long parentId) throws Exception {
        PriorityDO rootPriorityDO1 = createPriorityDO(parentId);
        PriorityDO rootPriorityDO2 = createPriorityDO(parentId);

        Map<Long, PriorityDO> priorityDOMap = new HashMap<Long, PriorityDO>();
        priorityDOMap.put(rootPriorityDO1.getId(), rootPriorityDO1);
        priorityDOMap.put(rootPriorityDO2.getId(), rootPriorityDO2);

        return priorityDOMap;
    }

    /**
     * 构造一个权限DO对象
     *
     * @return 权限DO对象
     * @throws Exception 抛出异常
     */
    private PriorityDO createPriorityDO(Long parentId) throws Exception {
        Random random = new Random();
        int randomInt = random.nextInt() * 100;

        PriorityDO priorityDO = new PriorityDO();
        priorityDO.setCode("TEST_" + randomInt);
        priorityDO.setGmtCreate(dateProvider.getCurrentTime());
        priorityDO.setGmtModified(dateProvider.getCurrentTime());
        priorityDO.setParentId(null);
        priorityDO.setPriorityComment("TEST_" + randomInt);
        priorityDO.setPriorityType(PriorityType.MENU);
        priorityDO.setUrl("http://127.0.0.1/" + randomInt);

        priorityDAO.savePriority(priorityDO);

        return priorityDO;
    }

    /**
     * 比较两个权限DO集合
     *
     * @param priorityDOMap 权限DO集合1
     * @param priorityDOs   权限DO集合2
     */
    private void comparePriorityDOs(Map<Long, PriorityDO> priorityDOMap,
                                    List<PriorityDO> priorityDOs) {


        assertEquals(priorityDOMap.size(), priorityDOs.size());

        for (PriorityDO priorityDO : priorityDOs) {
            PriorityDO targetPriorityDO = priorityDOMap.get(priorityDO.getId());
            assertEquals(targetPriorityDO, priorityDO);

        }
    }
}
