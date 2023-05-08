package com.Jenna.eshop.Inventory.async;

/**
 * 商品库存更新结果管理组件接口
 * @author Jenna C He
 * @date 2023/05/08 16:31
 */
public interface GoodsStockUpdateManager {

    /**
     * 设置对商品库存更新结果的观察
     * @param messageId 消息id
     */
     void observe(String messageId);


    /**
     * 获取商品库存更新结果的观察目标
     * @param messageId 商品库存更新消息id
     * @return 商品库存更新结果的观察目标
     */
    void inform(String messageId,Boolean result);

}
