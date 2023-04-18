package test.java.com.Jenna.eshop.auth.dao;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;


import com.Jenna.eshop.auth.dao.AccountPriorityRelationshipDAO;
import com.Jenna.eshop.auth.domain.AccountPriorityRelationshipDO;
import com.Jenna.eshop.common.util.DateProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * 账号和权限关系管理模块的DAO组件的单元测试类
 * @author Jenna C He
 * @date 2023/04/14 15:52
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(true)
public class AccountPriorityRelationshipDAOTest {
    /**
     * 账号和权限关系管理模块的DAO组件
     */
    @Autowired
    private AccountPriorityRelationshipDAO accountPriorityRelationshipDAO;
    /**
     * 日期辅助组件
     */
    @Autowired
    private DateProvider dateProvider;
    /**
     * 测试新增账号和权限的关联关系
     * @throws Exception 抛出异常
     */
    @Test
    public void testSave() throws Exception {
        Long accountId = (Long) 1L;
        Long priorityId = (Long) 1L;
        AccountPriorityRelationshipDO accountPriorityRelationshipDO =
            createAccountPriorityRelationshipDO(accountId,priorityId);

        assertNotNull(accountPriorityRelationshipDO.getId());
        assertThat(accountPriorityRelationshipDO.getId(),greaterThan(0L));
    }
    /**
     * 测试根据权限id查询记录数
     * @throws Exception 抛出异常
     */
    @Test
    public void testCountByPriorityId() throws Exception {
        Long priorityId = (Long) 1L;

        Long accountId1 = (Long) 1L;
        createAccountPriorityRelationshipDO(accountId1, priorityId);

        Long accountId2 = (Long) 2L;
        createAccountPriorityRelationshipDO(accountId2, priorityId);

        Long resultCount = accountPriorityRelationshipDAO.countByPriorityId(priorityId);

        assertEquals(2L,resultCount.longValue());

    }

    /**
     * 创建账号和权限关系DO对象
     * @return  账号和权限关系DO对象
     * @throws Exception 抛出异常
     */
    private AccountPriorityRelationshipDO createAccountPriorityRelationshipDO(
            Long accountId,Long priorityId) throws Exception {
        AccountPriorityRelationshipDO accountPriorityRelationshipDO =
                new AccountPriorityRelationshipDO();
        accountPriorityRelationshipDO.setAccountId(accountId);
        accountPriorityRelationshipDO.setGmtCreate(dateProvider.getCurrentTime());
        accountPriorityRelationshipDO.setGmtModified(dateProvider.getCurrentTime());

        accountPriorityRelationshipDAO.save(accountPriorityRelationshipDO);

        return accountPriorityRelationshipDO;
    }
}
