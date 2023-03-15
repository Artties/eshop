package com.Jenna.eshop.cart.dao;

import com.Jenna.eshop.cart.domain.ShoppingCartDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
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
@RunWith(SpringClassRunner.class)
@SpringBootTest
@Transactional
@Rollback(true)

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class ShoppingCartDAOTest {
    /**
     * 购物车管理模块的DAO组件
     */
    @Autowired
    private ShoppingCartDAO shoppingCartDAO;

    /**
     * 测试新增购物车
     * @throws Exception
     */
    @Test
    public void testSaveShoppingCart() throws Exception {

        Long userAccountId = 1L;
        Date currentTime = new Date();
        ShoppingCartDO shoppingCartDO = new ShoppingCartDO();
        shoppingCartDO.setUserAccountId(userAccountId);
        shoppingCartDO.setGmtCreate(new Date());
        shoppingCartDO.setGmtModified(new Date());

        Long shoppingCartId= shoppingCartDAO.saveShoppingCart(shoppingCartDO);

        assertNotNull(shoppingCartId);
        assertThat(shoppingCartId,greaterThan(0L));

    }

    /**
     * 测试根据用户账号id查询购物车
     * @throws Exception
     */
    public void testGetShoppingCartByUserAccountId() throws Exception{
        //构造一个已有的购物车数据
        Long userAccountId = 1L;
        Date currentTime = new Date();
        ShoppingCartDO shoppingCartDO = new ShoppingCartDO();
        shoppingCartDO.setUserAccountId(userAccountId);
        shoppingCartDO.setGmtCreate(new Date());
        shoppingCartDO.setGmtModified(new Date());

        Long shoppingCartId= shoppingCartDAO.saveShoppingCart(shoppingCartDO);

        //根据用户账号id查询购物车
        ShoppingCartDO resultShoppingCartDO = shoppingCartDAO
                .getShoppingCartByUserAccountId(userAccountId);
        //断言结果
        assertSame(shoppingCartDO,resultShoppingCartDO);

    }
}