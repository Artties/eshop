package com.Jenna.eshop.Inventory.updater;

import com.Jenna.eshop.order.domain.OrderInfoDTO;

/**
 * 库存更新命令创建工厂接口
 * @author Jenna C He
 * @date 2023/04/11 11:18
 */
public interface GoodsStockUpdaterFactory<T> {
    /**
     * 创建一个库存更新命令
     * @param parameter 参数对象
     * @return 库存更新命令
     */
    GoodsStockUpdater create(OrderInfoDTO parameter);
}
