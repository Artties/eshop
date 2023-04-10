package com.Jenna.eshop.cart.controller;

import com.Jenna.eshop.cart.domain.AddShoppingCartItemQuery;
import com.Jenna.eshop.cart.service.ShoppingCartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 购物车管理模块的controller组件
 * @author Jenna C He
 * @date 2023/03/14/ 20:47
 */
@Controller
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
    public Boolean addShoppingCartItem(@RequestBody AddShoppingCartItemQuery query){
        try {
            return shoppingCartService.addShoppingCartItem(
                    query.getUserAccountId(), query.getGoodsSkuId());
        }catch (Exception e) {
            logger.error("error",e);
            return false;
        }
    }
}
