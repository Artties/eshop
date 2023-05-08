package com.Jenna.eshop.Inventory.async;

import java.util.Observable;

/**
 * 商品库存更新结果观察目标
 * @author Jenna C He
 * @date 2023/05/08 16:49
 */
public class GoodsStockUpdateObservable extends Observable{
    /**
     * 消息id
     */
    private String messageId;

    /**
     * 构造函数
     * @param messageId 消息id
     */

    public GoodsStockUpdateObservable(String messageId){
        this.messageId = messageId;
    }

    /**
     * 设置商品库存更新结果
     * @param result 商品库存更新结果
     */
    public void setResult(Boolean result){
        GoodsStockUpdateResult goodsStockUpdateResult = new GoodsStockUpdateResult();
        goodsStockUpdateResult.setMessageId(messageId);
        goodsStockUpdateResult.setMessageId(messageId);


        this.setChanged();
        this.notifyObservers(goodsStockUpdateResult);
    }

    public String getMessageId() {
        return messageId;
    }
}
