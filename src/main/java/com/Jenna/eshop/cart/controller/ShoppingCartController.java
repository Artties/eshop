package com.Jenna.eshop.cart.controller;

import com.Jenna.eshop.cart.service.ShoppingCartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 购物车管理模块的controller组件
 * @author Jenna C He
 * @date 2023/03/14/ 20:47
 */
public class ShoppingCartController {
    private static final Logger logger = LoggerFactory.getLogger(ShoppingCartController.class);
    /**
     * 购物车管理模块的service组件
     */
    @Autowired
    private ShoppingCartService shoppingCartService;

    /**
     * 添加购物车商品条目
     * @param userAccountId 用户账号id
     * @param goodsId 商品sku id
     * @return 处理结果
     */
    @PostMapping("item/add")
    public Boolean addShoppingCartItem(Long userAccountId,Long goodsId){
        try {
            return shoppingCartService.addShoppingCartItem(userAccountId, goodsId);
        }catch (Exception e) {
            logger.error("error",e);
            return false;
        }
    }
}
