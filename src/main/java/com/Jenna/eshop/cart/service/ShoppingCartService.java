package com.Jenna.eshop.cart.service;

import com.Jenna.eshop.cart.domain.ShoppingCartDTO;
import org.springframework.stereotype.Service;

/**
 *购物车管理模块的service接口
 * @author Jenna C He
 * @date 2023/3/14 18:42
 */
@Service
public interface ShoppingCartService {
    /**
     * 添加购物车商品条目
     * @param userAccountId 用户账号id
     * @param goodsSkuId 商品sku id
     * @return 处理结果
     */
    Boolean addShoppingCartItem(Long userAccountId, Long goodsSkuId);

    /**
     * 查看用户的购物车中的数据
     * @param userAccountId 用户账号id
     * @return 购物车DTO对象
     */
    ShoppingCartDTO getShoppingCartDTOByUserAccountId(Long userAccountId);
}
