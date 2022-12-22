package com.Jenna.eshop.goods.service;

import com.Jenna.eshop.goods.dto.GoodsSkuDTO;

/**
 * 根据id查询商品sku
 * @param goodsSkuId 商品sku id
 * @return 商品sku DTO
 *
 * 采购中心对外提供接口
 */
public interface GoodsFacadeService {
    GoodsSkuDTO getGoodsSkuById(Long goodsSkuId);

}
