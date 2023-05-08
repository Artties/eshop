package com.Jenna.eshop.Inventory.async;

/**
 * 商品库存更新结果
 * @author Jenna C He
 * @date 2023/05/08 18:12
 */
public class GoodsStockUpdateResult {
    /**
     * 消息id
     */
    private String messageId;
    /**
     * 商品库存更新结果
     */
    private Boolean result;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }
}
