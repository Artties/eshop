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
    private static final Logger logger = LoggerFactory.getLogger(ShoppingCartDAOImpl.class);
    /**
     * 购物车管理模块的Mapper组件
     */
    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    /**
     * 根据用户账号id查询购物车
     *
     * @param userAccountId 用户账号id
     * @return 购物车
     */
    @Override
    public ShoppingCartDO getShoppingCartByUserAccountId(Long userAccountId) {

        try {
            return shoppingCartMapper.getShoppingCartByUserAccountId(userAccountId);
        } catch (Exception e) {
            logger.error("error",e);
        }
        return null;
    }

    /**
     * 新增购物车
     * @param shoppingCartDO 购物车DO对象
     * @return 返回id
     */
    @Override
    public Long saveShoppingCart(ShoppingCartDO shoppingCartDO) {

        try {
            shoppingCartMapper.saveShoppingCart(shoppingCartDO);
        } catch (Exception e) {
            logger.error("error",e);
            return null;
        }
        return shoppingCartDO.getId();
    }
}
