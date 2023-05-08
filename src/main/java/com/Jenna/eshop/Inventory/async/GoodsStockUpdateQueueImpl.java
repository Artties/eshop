package com.Jenna.eshop.Inventory.async;

import org.springframework.stereotype.Component;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 商品库存更新队列实现类
 * @author Jenna C He
 * @date 2023/05/08 15:16
 */
@Component
public class GoodsStockUpdateQueueImpl implements GoodsStockUpdateQueue {
    /**
     * 商品库存更新队列
     */
    private ArrayBlockingQueue<GoodsStockUpdateMessage> queue =
            new ArrayBlockingQueue<GoodsStockUpdateMessage>(1000);

    /**
     * 将一个消息放入队列
     * @param message 消息
     * @throws Exception 抛出异常
     */
    public void put(GoodsStockUpdateMessage message) throws Exception {
        queue.put(message);
    }

    /**
     * 从队列中取出一个消息
     * @return
     * @throws Exception
     */
    public GoodsStockUpdateMessage get() throws Exception{
        return queue.take();
    }
}
