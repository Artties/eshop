package com.Jenna.eshop.cart.smoke;

import com.Jenna.eshop.cart.controller.ShoppingCartController;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;


import com.Jenna.eshop.cart.domain.AddShoppingCartItemQuery;
import com.Jenna.eshop.cart.service.ShoppingCartService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Map;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.alibaba.fastjson.JSONObject;

import javax.transaction.Transactional;

import static org.mockito.Mockito.*;

/**
 * 购物车模块的冒烟测试
 * @author Jenna C He
 * @date 2023/04/10 10:33
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebMvcTest(ShoppingCartController.class)

public class ShoppingCartSmokeTest {
    /**
     * mvc测试类
     */
    @Autowired
    private MockMvc mockMvc;
    /**
     * 购物车管理模块的service组件
     */
    @MockBean
    private ShoppingCartService shoppingCartService;

    /**
     * 测试添加购物车商品条目
     * @throws Exception 抛出异常
     */
    @Test
    public void testAddShoppingCartItem() throws Exception {
        /**
         * 准备参数
         */
        Long userAccountId = 1L;
        Long goodsSkuId = 1L;

        AddShoppingCartItemQuery query = new AddShoppingCartItemQuery();
        query.setUserAccountId(userAccountId);
        query.setGoodsSkuId(goodsSkuId);

        //调用http接口请求，以及比较返回结果
        mockMvc.perform(post("/cart/item/add")
                        .contentType("application/json")
                        .content(JSONObject.toJSONString(query)))
                .andExpect(content().string("true"));



    }
}
