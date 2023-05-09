package com.Jenna.eshop.Inventory.async;

import org.springframework.stereotype.Component;

/**
 * 离线存储管理组件
 * @author Jenna C He
 * @date 2023/05/09 09:21
 */
@Component
public class OfflineStorageManagerImpl implements OfflineStorageManager{
    /**
     * 离线存储库存更新消息
     * @param message 库存更新消息
     * @throws Exception 抛出异常
     */
    public void store(StockUpdateMessage message) throws Exception{

    }
}
