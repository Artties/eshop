package com.Jenna.eshop.Inventory.async;

import org.springframework.stereotype.Component;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 商品库存更新队列实现类
 * @author Jenna C He
 * @date 2023/05/08 15:16
 */
@Component
public class StockUpdateQueueImpl implements StockUpdateQueue {
    private static final Integer QUEUE_MAX_SIZE = 1000;

    /**
     * 商品库存更新队列
     */
    private ArrayBlockingQueue<StockUpdateMessage> queue =
            new ArrayBlockingQueue<StockUpdateMessage>(1000);

    /**
     * 将一个消息放入队列
     * @param message 消息
     * @throws Exception 抛出异常
     */
    public void put(StockUpdateMessage message) throws Exception {
        //如果内存队列已经满了，此时触发离线存储
        if (QUEUE_MAX_SIZE.equals(queue.size())){

            return;
        }
        queue.put(message);
    }

    /**
     * 从队列中取出一个消息
     * @return
     * @throws Exception
     */
    public StockUpdateMessage get() throws Exception{
        return queue.take();
    }
}
