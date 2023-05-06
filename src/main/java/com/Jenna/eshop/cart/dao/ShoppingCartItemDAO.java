package com.Jenna.eshop.cart.dao;

import com.Jenna.eshop.cart.domain.ShoppingCartItemDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 购物车条目管理模块的DAO组件接口
 * @author Jenna C He
 * @date 2023/3/14 16:11
 */
public interface ShoppingCartItemDAO {
    /**
     * 新增购物车条目
     * @param shoppingCartItemDO 购物车条目的DO对象
     */
    Long saveShoppingCartItem(ShoppingCartItemDO shoppingCartItemDO);

    /**
     * 根据商品sku id查询购物车中是否存在商品条目
     * @param shoppingCartId 购物车id
     * @param goodsSkuId 商品sku id
     * @return 商品条目
     */
    ShoppingCartItemDO getShoppingCartItemByGoodsSkuId(
            Long shoppingCartId, Long goodsSkuId);
    /**
     * 更新购物车条目
     * @param shoppingCartItemDO 购物车条目的DO对象
     */
    Boolean updateShoppingCartItem(ShoppingCartItemDO shoppingCartItemDO);
    /**
     * 查询购物车中的所有条目
     * @param shoppingCartId 购物车id
     * @return 商品条目
     * @throws Exception
     */
    List<ShoppingCartItemDO> listShoppingCartItemByCartId(
            Long shoppingCartId) throws Exception;

    /**
     * 删除购物车条目
     * @param id 购物车条目id
     * @throws Exception
     */
    void remove(Long id) throws Exception;

}
