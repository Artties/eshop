package com.Jenna.eshop.cart.dao;

import com.Jenna.eshop.cart.domain.ShoppingCartDO;
import com.Jenna.eshop.common.util.DateProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
/**
 * 购物车管理模块的DAO组件的单元测试类
 * @author Jenna C He
 * @date 2023/03/15/ 09:15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(true)
public class ShoppingCartDAOTest {

    /**
     * 购物车管理模块的DAO组件
     */
    @Autowired
    private ShoppingCartDAO shoppingCartDAO;
    /**
     * 日期辅助组件
     */
    @Autowired
    private DateProvider dateProvider;

    /**
     * 测试新增购物车
     * @throws Exception
     */
    @Test
    public void testSaveShoppingCart() throws Exception {
        Long userAccountId = 1L;
        ShoppingCartDO shoppingCartDO = createShoppingCart(userAccountId);
        Long shoppingCartId = shoppingCartDO.getId();

        assertNotNull(shoppingCartId);
        assertThat(shoppingCartId,greaterThan(0L));

    }

    /**
     * 测试根据用户账号id查询购物车
     * @throws Exception
     */
    @Test
    public void testGetShoppingCartByUserAccountId() throws Exception{
        Long userAccountId = 1L;
        ShoppingCartDO shoppingCartDO = createShoppingCart(userAccountId);
        //根据用户账号id查询购物车
        ShoppingCartDO resultShoppingCartDO = shoppingCartDAO
                .getShoppingCartByUserAccountId(userAccountId);
        //断言结果
        assertEquals(shoppingCartDO,resultShoppingCartDO);

    }

    /**
     * 创建一个购物车
     * @return 购物车id
     */
    private ShoppingCartDO createShoppingCart(Long userAccountId) throws Exception{
        //新增一个购物车
        Date currentTime = DateProvider.getCurrentTime();

        ShoppingCartDO shoppingCartDO = new ShoppingCartDO();
        shoppingCartDO.setUserAccountId(userAccountId);
        shoppingCartDO.setGmtCreate(currentTime);
        shoppingCartDO.setGmtModified(currentTime);

         shoppingCartDAO.saveShoppingCart(shoppingCartDO);
         return shoppingCartDO;
    }
}