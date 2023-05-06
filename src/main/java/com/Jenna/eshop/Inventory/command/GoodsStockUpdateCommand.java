package com.Jenna.eshop.Inventory.command;

/**
 * 商品库存更新命令的接口
 * @author Jenna C He
 * @date 2023/04/10 15:41
 */
public interface GoodsStockUpdateCommand {
    /**
     * 更新商品库存
     * @return 处理结果
     */
    Boolean updateGoodsStock();

}
