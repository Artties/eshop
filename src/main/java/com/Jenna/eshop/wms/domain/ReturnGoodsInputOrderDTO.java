package com.Jenna.eshop.wms.domain;

import java.util.Date;

/**
 * 退货入库单DTO
 * @author Jenna C He
 */
public class ReturnGoodsInputOrderDTO {
    /**
     * id
     */
    private Long id;
    /**
     *用户账号ID
     */
    private Long userAccountId;

    /**
     * 订单ID
     */
    private Long orderId;
    /**
     * 订单编号
     */
    private String orderNo;
    /**
     * 退货入库单的状态
     */
    private Integer returnGoodsInputOrderStatus;

    /**
     * 收货人
     */
    private String consignee;

    /**
     * 收货地址
     */
    private String deliveryAddress;

    /**
     * 收货人手机号码
     */
    private String consigneeCellPhoneNumber;

    /**
     * 运费
     */
    private Double freight;

    /**
     * 支付方式
     */
    private Integer payType;

    /**
     * 订单总金额
     */
    private Double totalAmount;
    /**
     * 折扣金额
     */
    private Double discountAmount;
    /**
     * 优惠券抵扣金额
     */
    private Double couponAmount;

    /**
     * 应付金额
     */
    private Double payableAmount;

    /**
     * 发票抬头
     */
    private String invoiceTitle;

    /**
     * 纳税人识别号
     */
    private String taxPayerId;

    /**
     * 订单备注
     */
    private String orderComment;

    /**
     * 退货原因
     */
    private String returnGoodsReason;
    /**
     * 退货备注
     */
    private String returnGoodsComment;

    /**
     * 退货实际到货时间
     */
    private Date arrivalTime;

    /**
     * 退货出库单的创建时间
     */
    private Date gmtCreate;

    /**
     * 退货出库单的修改时间
     */
    private Date gmtModified;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(Long userAccountId) {
        this.userAccountId = userAccountId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getReturnGoodsInputOrderStatus() {
        return returnGoodsInputOrderStatus;
    }

    public void setReturnGoodsInputOrderStatus(Integer returnGoodsInputOrderStatus) {
        this.returnGoodsInputOrderStatus = returnGoodsInputOrderStatus;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getConsigneeCellPhoneNumber() {
        return consigneeCellPhoneNumber;
    }

    public void setConsigneeCellPhoneNumber(String consigneeCellPhoneNumber) {
        this.consigneeCellPhoneNumber = consigneeCellPhoneNumber;
    }

    public Double getFreight() {
        return freight;
    }

    public void setFreight(Double freight) {
        this.freight = freight;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Double getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(Double couponAmount) {
        this.couponAmount = couponAmount;
    }

    public Double getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(Double payableAmount) {
        this.payableAmount = payableAmount;
    }

    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle;
    }

    public String getTaxPayerId() {
        return taxPayerId;
    }

    public void setTaxPayerId(String taxPayerId) {
        this.taxPayerId = taxPayerId;
    }

    public String getOrderComment() {
        return orderComment;
    }

    public void setOrderComment(String orderComment) {
        this.orderComment = orderComment;
    }

    public String getReturnGoodsReason() {
        return returnGoodsReason;
    }

    public void setReturnGoodsReason(String returnGoodsReason) {
        this.returnGoodsReason = returnGoodsReason;
    }

    public String getReturnGoodsComment() {
        return returnGoodsComment;
    }

    public void setReturnGoodsComment(String returnGoodsComment) {
        this.returnGoodsComment = returnGoodsComment;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
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
