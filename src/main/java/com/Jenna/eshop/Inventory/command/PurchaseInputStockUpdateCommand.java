package com.Jenna.eshop.Inventory.command;

import com.Jenna.eshop.Inventory.dao.GoodsStockDAO;
import com.Jenna.eshop.Inventory.domain.GoodsStockDO;
import com.Jenna.eshop.common.util.DateProvider;

/**
 * 采购入库库存更新命令
 * @author Jenna C He
 * @date 2023/04/10 16:28
 */
public class PurchaseInputStockUpdateCommand extends AbstractGoodsStockUpdateCommand{


    /**
     * 构造函数
     *
     * @param goodsStockDO  商品库存DO对象
     * @param goodsStockDAO 商品库存管理模块的DAO组件
     * @param dateProvider  日期辅助组件
     */
    public PurchaseInputStockUpdateCommand(GoodsStockDO goodsStockDO,
                                           GoodsStockDAO goodsStockDAO,
                                           DateProvider dateProvider) {
        super(goodsStockDO, goodsStockDAO, dateProvider);
    }

    /**
     * 更新商品的销售库存
     */
    @Override
    protected void updateSaleStockQuantity() throws Exception {

    }

    /**
     * 更新商品的锁定库存
     */
    @Override
    protected void updateLockedStockQuantity() throws Exception {

    }

    /**
     * 更新商品的已销售库存
     */
    @Override
    protected void updateSaledStockQuantity() throws Exception {

    }

    /**
     * 更新商品的库存状态
     */
    @Override
    protected void updateStockStatus() throws Exception {

    }
}
