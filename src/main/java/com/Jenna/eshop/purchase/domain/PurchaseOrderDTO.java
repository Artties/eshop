package com.Jenna.eshop.purchase.domain;

import java.util.*;

/**
 * 采购单DTO
 * @author Jenna C He
 * @date 2023/1/6 13:56
 */
public class PurchaseOrderDTO {
    /**
     * id
     */
    private Long id;
    /**
     * 供应商id
     */
    private Long supplierId;
    /**
     * 预期到货时间
     */
    private Date expectArrivalTime;
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
     * 采购单状态
     */
    private Integer purchaseOrderStatus;

    /**
     * 采购单的创建时间
     */
    private Date gmtCreate;
    /**
     * 采购单的修改时间
     */
    private Date gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Date getExpectArrivalTime() {
        return expectArrivalTime;
    }

    public void setExpectArrivalTime(Date expectArrivalTime) {
        this.expectArrivalTime = expectArrivalTime;
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

    public Integer getPurchaseOrderStatus() {
        return purchaseOrderStatus;
    }

    public void setPurchaseOrderStatus(Integer purchaseOrderStatus) {
        this.purchaseOrderStatus = purchaseOrderStatus;
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
