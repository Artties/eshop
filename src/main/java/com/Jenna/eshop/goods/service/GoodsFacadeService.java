package com.Jenna.eshop.goods.service;

import com.Jenna.eshop.goods.domain.GoodsSkuDTO;

/**
 * 采购中心对外提供接口
 * @author Jenna C He
 */

public interface GoodsFacadeService {
    /**
     * 根据id查询商品sku
     * @param goodsSkuId 商品sku id
     * @return 处理结果
     */
    GoodsSkuDTO getGoodsSkuById(Long goodsSkuId);

}
