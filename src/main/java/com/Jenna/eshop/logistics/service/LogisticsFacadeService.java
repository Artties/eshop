package com.Jenna.eshop.logistics.service;

import com.Jenna.eshop.goods.domain.GoodsSkuDTO;
/**
 * 物流中心对外提供接口
 * @author Jenna C He
 */
public interface LogisticsFacadeService {
    /**
     * 计算sku商品运费
     * @param GoodsSkuDTO 商品sku DTO
     * @return 商品sku运费
     */
    Double calculateFreight(GoodsSkuDTO GoodsSkuDTO);

}
