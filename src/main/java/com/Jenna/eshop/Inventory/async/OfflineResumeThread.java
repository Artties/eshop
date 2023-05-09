package com.Jenna.eshop.Inventory.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

/**
 * 离线数据恢复线程
 * @author Jenna C He
 * @date 2023/05/09 11:23
 */
public class OfflineResumeThread extends Thread {
    private static final Logger logger = LoggerFactory.getLogger(OfflineResumeThread.class);
    /**
     * 离线存储管理组件
     */
    private OfflineStorageManager offlineStorageManager;
    /**
     * 库存更新队列
     */
    private StockUpdateQueue stockUpdatequeue;

    /**
     * 构造函数
     * @param offlineStorageManager 离线存储管理组件
     */
    public OfflineResumeThread(OfflineStorageManager offlineStorageManager,
                               StockUpdateQueue stockUpdatequeue){
        this.offlineStorageManager = offlineStorageManager;
        this.stockUpdatequeue = stockUpdatequeue;
    }

    /**
     * 执行线程
     */
    @Override
    public void run() {
        //如果表中还有数据的话
        while (offlineStorageManager.hasNext()) {
            //每次就从mysql中查询50条数据，批量查询，批量处理，批量删除
            try {
                List<StockUpdateMessage> stockUpdateMessages =
                        offlineStorageManager.getNextBatch();

                //将这批数据写入内存队列中
                for (StockUpdateMessage message:stockUpdateMessages) {
                    stockUpdatequeue.put(message);
                }
                //批量删除这批数据
                offlineStorageManager.removeByBatch(stockUpdateMessages);
            } catch (Exception e) {
                logger.error("error",e);
            }
        }
        //此时mysql中的数据全部恢复完成，更新内存标识
        offlineStorageManager.setOffline(false);
    }
}
