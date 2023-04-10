package com.Jenna.eshop.wms.domain;

import java.util.*;
/**
 * 采购入库单DTO
 */
public class PurchaseInputOrderDTO {
    /**
     * id
     */
    private Long id;

    /**
     * 供应商id
     */
    private long supplierId;
    /**
     * 预期到达时间
     */
    private Date expectArrivalTime;

    /**
     * 事假到达时间
     */
    private Date arrivalTime;

    /**
     * 采购联系人
     */
    private String purchaseContactor;
    /**
     * 采购联系人电话号码
     */
    private String getPurchaseContactorPhoneNumber;
    /**
     * 采购联系人邮箱地址
     */
    private String getPurchaseContactorEmail;
    /**
     * 采购入库单备注
     */
    private String purchaseOrderComment;
    /**
     * 采购员
     */
    private String purchaser;

    /**
     * 采购入库单状态
     */
    private Integer purchaseInputOrderStatus;

    /**
     * 采购入库单的创建时间
     */
    private Date gmtCreate;
    /**
     * 采购入库单的修改时间
     */
    private Date gmtModified;
    /**
     * 采购入库单条目集合
     */
    private List<PurchaseInputOrderItemDTO> purchaseInputOrderItemDTOs;
    /**
     * 采购入库单商品上架条目集合
     */
    private List<PurchaseInputOrderPutOnItemDTO> purchaseInputPutOnItemDTOs;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(long supplierId) {
        this.supplierId = supplierId;
    }

    public Date getExpectArrivalTime() {
        return expectArrivalTime;
    }

    public void setExpectArrivalTime(Date expectArrivalTime) {
        this.expectArrivalTime = expectArrivalTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getPurchaseContactor() {
        return purchaseContactor;
    }

    public void setPurchaseContactor(String purchaseContactor) {
        this.purchaseContactor = purchaseContactor;
    }

    public String getGetPurchaseContactorPhoneNumber() {
        return getPurchaseContactorPhoneNumber;
    }

    public void setGetPurchaseContactorPhoneNumber(String getPurchaseContactorPhoneNumber) {
        this.getPurchaseContactorPhoneNumber = getPurchaseContactorPhoneNumber;
    }

    public String getGetPurchaseContactorEmail() {
        return getPurchaseContactorEmail;
    }

    public void setGetPurchaseContactorEmail(String getPurchaseContactorEmail) {
        this.getPurchaseContactorEmail = getPurchaseContactorEmail;
    }

    public String getPurchaseOrderComment() {
        return purchaseOrderComment;
    }

    public void setPurchaseOrderComment(String purchaseOrderComment) {
        this.purchaseOrderComment = purchaseOrderComment;
    }

    public String getPurchaser() {
        return purchaser;
    }

    public void setPurchaser(String purchaser) {
        this.purchaser = purchaser;
    }

    public Integer getPurchaseInputOrderStatus() {
        return purchaseInputOrderStatus;
    }

    public void setPurchaseInputOrderStatus(Integer purchaseInputOrderStatus) {
        this.purchaseInputOrderStatus = purchaseInputOrderStatus;
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

    public List<PurchaseInputOrderItemDTO> getPurchaseInputOrderItemDTOs() {
        return purchaseInputOrderItemDTOs;
    }

    public void setPurchaseInputOrderItemDTOs(List<PurchaseInputOrderItemDTO> purchaseInputOrderItemDTOs) {
        this.purchaseInputOrderItemDTOs = purchaseInputOrderItemDTOs;
    }

    public List<PurchaseInputOrderPutOnItemDTO> getPurchaseInputPutOnItemDTOs() {
        return purchaseInputPutOnItemDTOs;
    }

    public void setPurchaseInputPutOnItemDTOs(List<PurchaseInputOrderPutOnItemDTO> purchaseInputPutOnItemDTOs) {
        this.purchaseInputPutOnItemDTOs = purchaseInputPutOnItemDTOs;
    }
}
