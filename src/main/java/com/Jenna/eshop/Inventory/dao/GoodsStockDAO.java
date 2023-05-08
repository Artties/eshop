package com.Jenna.eshop.Inventory.dao;

import com.Jenna.eshop.Inventory.domain.GoodsStockDO;


/**
 * 商品管理模块的DAO组件接口
 * @author Jenna C He
 * @date 2023/04/10 15:14
 */
public interface GoodsStockDAO {
    /**
     * 根据商品sku id查询商品库存
     * @param goodsSkuId 商品sku id
     * @return 商品库存
     */
    GoodsStockDO getGoodsStockBySkuId(Long goodsSkuId);
    /**
     * 新增商品库存
     * @param goodsStockDO 商品库存的DO对象
     */
    Boolean saveGoodsStock(GoodsStockDO goodsStockDO);
    /**
     * 更新数据库存
     * @param goodsStockDO
     */
    Boolean updateGoodsStock(GoodsStockDO goodsStockDO);
}
