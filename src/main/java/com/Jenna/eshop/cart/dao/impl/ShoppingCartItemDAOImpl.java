package com.Jenna.eshop.cart.dao.impl;

import com.Jenna.eshop.cart.dao.ShoppingCartItemDAO;
import com.Jenna.eshop.cart.domain.ShoppingCartItemDO;
import com.Jenna.eshop.cart.mapper.ShoppingCartItemMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * 购物车管理模块的DAO组件
 * @author Jenna C He
 * @date 2023/3/14 16:17
 */
@Repository
@Service
public class ShoppingCartItemDAOImpl implements ShoppingCartItemDAO {
    private static final Logger logger = LoggerFactory.getLogger(ShoppingCartItemDAOImpl.class);
    /**
     * 购物车条目管理模块的mapper组件
     */
    @Autowired
    private ShoppingCartItemMapper shoppingItemMapper;
    /**
     * 新增购物车条目
     *
     * @param shoppingCartItemDO 购物车条目的DO对象
     */
    @Override
    public Long saveShoppingCartItem(ShoppingCartItemDO shoppingCartItemDO) {

        try {
             shoppingItemMapper.saveShoppingCartItem(shoppingCartItemDO);
        } catch (Exception e) {
            logger.error("error",e);
            return null;
        }
        return shoppingCartItemDO.getId();
    }

    /**
     * 根据商品sku id查询购物车中是否存在商品条目
     *
     * @param shoppingCartId 购物车id
     * @param goodsSkuId     商品sku id
     * @return 商品条目
     */
    @Override
    public ShoppingCartItemDO getShoppingCartItemByGoodsSkuId(
            Long shoppingCartId, Long goodsSkuId) {

        try {
            return shoppingItemMapper.getShoppingCartItemByGoodsSkuId(shoppingCartId, goodsSkuId);
        } catch (Exception e) {
            logger.error("error",e);
        }
        return null;
    }

    /**
     * 更新购物车条目
     *
     * @param shoppingCartItemDO 购物车条目的DO对象
     */
    @Override
    public Boolean updateShoppingCartItem(ShoppingCartItemDO shoppingCartItemDO) {
        try {
            shoppingItemMapper.updateShoppingCartItem(shoppingCartItemDO);
        } catch (Exception e) {
            logger.error("error",e);
            return false;
        }
        return true;
    }
}