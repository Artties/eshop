package com.Jenna.eshop.wms.domain;

import java.util.Date;
import java.util.List;

/**
 * 退货入库单商品上架条目DTO类
 * @author Jenna C He
 * @date 2023/04/11 10:11
 */
public class ReturnGoodsInputOrderPutOnItemDTO {
    /**
     * id
     */
    private Long id;
    /**
     * 退货入库单条目id
     */
    private Long returnGoodsInputOrderItemId;
    /**
     * 货位id
     */
    private Long goodsAllocationId;
    /**
     * 商品上架数量
     */
    private Long putOnShelvesCount;
    /**
     * 退货入库单商品商家条目的创建时间
     */
    private Date gmtCreate;
    /**
     * 退货入库单商品商家条目的修改时间
     */
    private Date gmtModified;
    /**
     * 退货入库单条目DTO集合
     */
    private List<ReturnGoodsInputOrderItemDTO> returnGoodsInputOrderItemDTOs;
    /**
     * 退货入库单商品上架条目DTO集合
     */
    private List<ReturnGoodsInputOrderPutOnItemDTO> returnGoodsInputOrderPutOnItemDTOs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReturnGoodsInputOrderItemId() {
        return returnGoodsInputOrderItemId;
    }

    public void setReturnGoodsInputOrderItemId(Long returnGoodsInputOrderItemId) {
        this.returnGoodsInputOrderItemId = returnGoodsInputOrderItemId;
    }

    public Long getGoodsAllocationId() {
        return goodsAllocationId;
    }

    public void setGoodsAllocationId(Long goodsAllocationId) {
        this.goodsAllocationId = goodsAllocationId;
    }

    public Long getPutOnShelvesCount() {
        return putOnShelvesCount;
    }

    public void setPutOnShelvesCount(Long putOnShelvesCount) {
        this.putOnShelvesCount = putOnShelvesCount;
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

    public List<ReturnGoodsInputOrderItemDTO> getReturnGoodsInputOrderItemDTOs() {
        return returnGoodsInputOrderItemDTOs;
    }

    public void setReturnGoodsInputOrderItemDTOs(List<ReturnGoodsInputOrderItemDTO> returnGoodsInputOrderItemDTOs) {
        this.returnGoodsInputOrderItemDTOs = returnGoodsInputOrderItemDTOs;
    }

    public List<ReturnGoodsInputOrderPutOnItemDTO> getReturnGoodsInputOrderPutOnItemDTOs() {
        return returnGoodsInputOrderPutOnItemDTOs;
    }

    public void setReturnGoodsInputOrderPutOnItemDTOs(List<ReturnGoodsInputOrderPutOnItemDTO> returnGoodsInputOrderPutOnItemDTOs) {
        this.returnGoodsInputOrderPutOnItemDTOs = returnGoodsInputOrderPutOnItemDTOs;
    }
}
