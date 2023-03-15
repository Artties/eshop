package com.Jenna.eshop.cart.dao;

import com.Jenna.eshop.cart.domain.ShoppingCartDO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.*;

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

public class ShoppingCartDAOTest {
    /**
     * 购物车管理模块的DAO组件
     */
    @Autowired
    private ShoppingCartDAO shoppingCartDAO;

    @Test
    public void getShoppingCartByUserAccountId() {
    }

    @Test
    public void saveShoppingCart() {
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
}