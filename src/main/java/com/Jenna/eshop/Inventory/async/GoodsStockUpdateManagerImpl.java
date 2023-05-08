package com.Jenna.eshop.Inventory.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 商品库存更新结果管理组件实现接口
 * @author Jenna C He
 * @date 2023/05/08 16:32
 */
@Component
public class GoodsStockUpdateManagerImpl
        implements GoodsStockUpdateManager {
    /**
     * 商品库存更新结果map
     */
    private Map<String, GoodsStockUpdateObservable> observableMap=
            new ConcurrentHashMap<String, GoodsStockUpdateObservable>();
    /**
     * 商品库存更新结果观察者
     */
    @Autowired
    private GoodsStockUpdateObserver observer;

    /**
     * 设置对商品库存更新结果的观察
     * @param messageId 消息id
     */
    public void observe(String messageId){
        GoodsStockUpdateObservable observable = new GoodsStockUpdateObservable(messageId);
        observable.addObserver(observer);
        observableMap.put(messageId,observable);
    }

    /**
     * 获取商品库存更新结果的观察目标
     * @param messageId 商品库存更新消息id
     * @return 商品库存更新结果的观察目标
     */
    public void inform(String messageId,Boolean result){
        GoodsStockUpdateObservable observable = observableMap.get(messageId);
        observable.setResult(result);
        observableMap.remove(messageId);
    }
}
