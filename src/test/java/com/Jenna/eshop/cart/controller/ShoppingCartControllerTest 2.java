package com.Jenna.eshop.cart.controller;

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

/**
 * 购物车管理模块的controller组件的单元测试类
 * @author Jenna C He
 * @date 2023/04/07 19:11
 */
@RunWith(SpringRunner.class)
@WebMvcTest(ShoppingCartController.class)
public class ShoppingCartControllerTest {
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

        //模拟一下service组件的行为
        when(shoppingCartService.addShoppingCartItem(
                userAccountId,goodsSkuId)).thenReturn(true);
        //调用http接口请求，以及比较返回结果
        mockMvc.perform(post("/cart/item/add")
                .contentType("application/json")
                .content(JSONObject.toJSONString(query)))
                .andExpect(content().string("true"));



    }

}
