package com.Jenna.eshop.cart.dao;

import com.Jenna.eshop.cart.domain.ShoppingCartDO;
import org.apache.ibatis.annotations.Param;

/**
 * 购物车管理模块的DAO组件接口
 * @author Jenna C He
 * @date 2023/3/14 15:42
 */
public interface ShoppingCartDAO {
    /**
     * 根据用户账号id查询购物车
     * @param userAccountId 用户账号id
     * @return 购物车
     */
    ShoppingCartDO getShoppingCartByUserAccountId(Long userAccountId);
    /**
     * 新增购物车
     * @param shoppingCartDO 购物车DO对象
     */
    Long saveShoppingCart(ShoppingCartDO shoppingCartDO);
}
