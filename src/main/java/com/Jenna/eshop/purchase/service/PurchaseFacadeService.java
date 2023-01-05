package com.Jenna.eshop.purchase.service;

/**
 * 采购中心对外提供接口
 * @author Artties
 */
public interface PurchaseFacadeService {
    /**
     * 判断是否有关联商品sku的采购单
     * @param goodsSkuId 商品sku id
     * @return 是否有采购单关联了商品sku
     */
    Boolean existRelatedPurchaseOrder(Long goodsSkuId);

    /**
     * 通知采购中心，"创建采购入库单事件"发生了
     * 创建了采购入库单
     * @param purchaseOrderId 采购单id
     * @return 处理结果
     */
    Boolean informCreatePurchaseInputOrderEvent(Long purchaseOrderId);

    /**
     * 通知采购中心，"完成采购入库单事件"发生了
     * @param purchaseOrderId 采购单id
     * @return 处理结果
     */
    Boolean informFinishPurchaseInputOrderEvent(long purchaseOrderId);

    /**
     * 通知采购中心，"创建采购结算单事件"发生了
     * @param purchaseOrderId 采购单id
     * @return 处理结果
     */
    Boolean informCreatePurchaseSettlementOrderEvent(long purchaseOrderId);

    /**
     * 通知采购中心，"完成采购结算单事件"发生了
     * @param purchaseOrderId
     * @return
     */
    Boolean informFinishPurchaseSettlementOrderEvent(long purchaseOrderId);

}
