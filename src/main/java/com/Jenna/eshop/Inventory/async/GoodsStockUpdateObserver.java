package com.Jenna.eshop.Inventory.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Observable;
import java.util.Observer;

/**
 * 商品库存更新结果观察者
 * @author Jenna C He
 * @date 2023/05/08 17:47
 */
@Component
public class GoodsStockUpdateObserver implements Observer {
    private static final Logger logger = LoggerFactory.getLogger(
            GoodsStockUpdateObserver.class);

    /**
     * 通知异步处理结果
     * @param o     the observable object.
     * @param arg   an argument passed to the <code>notifyObservers</code>
     *                 method.
     */
    @Override
    public void update(Observable o, Object arg) {
        GoodsStockUpdateResult goodsStockUpdateResult = (GoodsStockUpdateResult) arg;

        logger.info("商品库存更新消息[messageId=" + goodsStockUpdateResult.getMessageId() +"]" +
                "的异步处理结果为：" + goodsStockUpdateResult.getResult());
    }
}
