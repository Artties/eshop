package com.Jenna.eshop.Inventory.async;

/**
 * 商品库存更新消息队列接口
 * @author Jenna C He
 * @date 2023/05/08 15:15
 */

public interface StockUpdateQueue {
    /**
     * 将一个消息放入队列
     * @param message 消息
     * @throws Exception 抛出异常
     */
     public void put(StockUpdateMessage message) throws Exception ;

    /**
     * 从队列中取出一个消息
     * @return
     * @throws Exception
     */
     public StockUpdateMessage get() throws Exception;
}
