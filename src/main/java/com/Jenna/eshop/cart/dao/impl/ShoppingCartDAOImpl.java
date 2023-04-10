package com.Jenna.eshop.cart.dao.impl;

import com.Jenna.eshop.cart.dao.ShoppingCartDAO;
import com.Jenna.eshop.cart.domain.ShoppingCartDO;
import com.Jenna.eshop.cart.mapper.ShoppingCartMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * 购物车管理模块的DAO组件
 * @author Jenna C He
 * @date 2023/3/14 15:47
 */
@Repository
@Service
public class ShoppingCartDAOImpl implements ShoppingCartDAO {

    /**
     * 购物车管理模块的mapper组件
     */
    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    /**
     * 根据用户账号id查询购物车
     * @param userAccountId 用户账号id
     * @return 购物车
     */
    @Override
    public ShoppingCartDO getShoppingCartByUserAccountId(Long userAccountId) {
        return shoppingCartMapper.getShoppingCartByUserAccountId(userAccountId);
    }

    /**
     * 新增购物车
     * @param shoppingCartDO 购物车DO对象
     */
    @Override
    public Long saveShoppingCart(ShoppingCartDO shoppingCartDO) {
        shoppingCartMapper.saveShoppingCart(shoppingCartDO);
        return shoppingCartDO.getId();
    }

}

