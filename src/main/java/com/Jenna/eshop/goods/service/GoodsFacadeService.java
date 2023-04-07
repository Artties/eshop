package com.Jenna.eshop.goods.service;

import com.Jenna.eshop.goods.domain.GoodsSkuDTO;

/**
 *
 * 采购中心对外提供接口
 */
public interface GoodsFacadeService {
    GoodsSkuDTO getGoodsSkuById(Long goodsSkuId);

}
