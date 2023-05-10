package com.Jenna.eshop.commondity.service;

import com.Jenna.eshop.goods.domain.GoodsSkuDTO;

/**
 * 商品中心对外提供的接口
 * @author Jenna C He
 * @date 2023/05/05 09:06
 */
public interface CommodityFacadeService {
    /**
     * 根据商品id查询商品sku
     * @param goodsSkuId 商品sku id
     * @return 商品sku DTO
     */
    GoodsSkuDTO getGoodsSkuById(Long goodsSkuId);
}
