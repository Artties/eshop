package com.Jenna.eshop.Inventory.domain;

import java.util.Date;

/**
 * 商品sku 库存DO类
 * @author Jenna C He
 * @date 2023/04/10 11:59
 */
public class GoodsStockDO {
    /**
     * id
     */
    private Long id;
    /**
     * 商品Sku id
     */
    private Long goodsSkuId;
    /**
     * 商品sku的销售库存
     */
    private Long SaleStockQuantity;
    /**
     * 商品sku的锁定库存
     */
    private Long lockedStockQuantity;
    /**
     * 商品sku的已销售库存
     */
    private Long saledStockQuantity;
    /**
     * 商品sku的库存状态
     */
    private Integer stockStatus;
    /**
     * 商品sku库存的创建时间
     */
    private Date gmtCreate;
    /**
     * 商品sku库存的修改时间
     */
    private Date gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGoodsSkuId() {
        return goodsSkuId;
    }

    public void setGoodsSkuId(Long goodsSkuId) {
        this.goodsSkuId = goodsSkuId;
    }

    public Long getSaleStockQuantity() {
        return SaleStockQuantity;
    }

    public void setSaleStockQuantity(Long saleStockQuantity) {
        SaleStockQuantity = saleStockQuantity;
    }

    public Long getLockedStockQuantity() {
        return lockedStockQuantity;
    }

    public void setLockedStockQuantity(Long lockedStockQuantity) {
        this.lockedStockQuantity = lockedStockQuantity;
    }

    public Long getSaledStockQuantity(long l) {
        return saledStockQuantity;
    }

    public void setSaledStockQuantity(Long saledStockQuantity) {
        this.saledStockQuantity = saledStockQuantity;
    }

    public Integer getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(Integer stockStatus) {
        this.stockStatus = stockStatus;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}
