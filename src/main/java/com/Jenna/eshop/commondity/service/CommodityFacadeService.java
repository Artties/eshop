package com.Jenna.eshop.commondity.service;

import com.Jenna.eshop.goods.domain.GoodsSkuDTO;

public interface CommodityFacadeService {
    /**
     * 商品中心对外接口
     */
    GoodsSkuDTO getGoodsSkuById(Long goodsSkuId);
}
