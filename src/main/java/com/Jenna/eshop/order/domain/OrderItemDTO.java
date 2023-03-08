package com.Jenna.eshop.order.domain;

import java.util.Date;
import java.util.List;


/**
 * 订单条目的DTO类
 * @author Jenna C He
 * @date 2023/1/6 13:55
 */
public class OrderItemDTO {
    /**
     * id
     */
    private Long id;
    /**
     * 订单id
     */
    private Long orderInfoId;
    /**
     * 商品sku id
     */
    private Long goodsSkuId;
    /**
     * 商品sku 编号
     */
    private String goodsSkuCode;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品sku的销售属性
     */
    private String saleProperties;
    /**
     * 商品的毛重
     */
    private Double goodsGrossWeight;
    /**
     * 商品sku购买数量
     */
    private Long purchaseQuantity;
    /**
     * 商品sku购买价格
     */
    private Double purchasePrice;
    /**
     * 使用的促销活动id
     */
    private Long promotionActivityId;
    /**
     * 商品长度
     */
    private Double goodsLength;
    /**
     * 商品宽度
     */
    private Double goodsWidth;
    /**
     * 商品高度
     */
    private Double goodsHeight;

    /**
     * 订单条目的创建时间
     */
    private Date gmtCreate;

    /**
     * 订单条目的修改时间
     */
    private Date gmtModified;
    /**
     * 订单包含的订单条目
     */
    private List<OrderItemDTO> orderItems;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getorderInfoId() {
        return orderInfoId;
    }

    public void setorderInfoId(Long orderInfoId) {
        this.orderInfoId = orderInfoId;
    }

    public Long getGoodsSkuId() {
        return goodsSkuId;
    }

    public void setGoodsSkuId(Long goodsSkuId) {
        this.goodsSkuId = goodsSkuId;
    }

    public String getGoodsSkuCode() {
        return goodsSkuCode;
    }

    public void setGoodsSkuCode(String goodsSkuCode) {
        this.goodsSkuCode = goodsSkuCode;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getSaleProperties() {
        return saleProperties;
    }

    public void setSaleProperties(String saleProperties) {
        this.saleProperties = saleProperties;
    }

    public Double getGoodsGrossWeight() {
        return goodsGrossWeight;
    }

    public void setGoodsGrossWeight(Double goodsGrossWeight) {
        this.goodsGrossWeight = goodsGrossWeight;
    }

    public Long getPurchaseQuantity() {
        return purchaseQuantity;
    }

    public void setPurchaseQuantity(Long purchaseQuantity) {
        this.purchaseQuantity = purchaseQuantity;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Long getPromotionActivityId() {
        return promotionActivityId;
    }

    public void setPromotionActivityId(Long promotionActivityId) {
        this.promotionActivityId = promotionActivityId;
    }

    public Double getGoodsLength() {
        return goodsLength;
    }

    public void setGoodsLength(Double goodsLength) {
        this.goodsLength = goodsLength;
    }

    public Double getGoodsWidth() {
        return goodsWidth;
    }

    public void setGoodsWidth(Double goodsWidth) {
        this.goodsWidth = goodsWidth;
    }

    public Double getGoodsHeight() {
        return goodsHeight;
    }

    public void setGoodsHeight(Double goodsHeight) {
        this.goodsHeight = goodsHeight;
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

    public List<OrderItemDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDTO> orderItems) {
        this.orderItems = orderItems;
    }
}