package com.Jenna.eshop.Inventory.command;

import com.Jenna.eshop.Inventory.dao.GoodsStockDAO;
import com.Jenna.eshop.Inventory.domain.GoodsStockDO;
import com.Jenna.eshop.common.util.DateProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 商品库存更新命令的抽象基类
 * @author Jenna C He
 * @date 2023/04/10 15:44
 */
public abstract class AbstractGoodsStockUpdateCommand implements GoodsStockUpdateCommand {
    private static final Logger logger = LoggerFactory.getLogger(
            AbstractGoodsStockUpdateCommand.class);
    /**
     * 商品库存DO对象
     */
    protected GoodsStockDO goodsStockDO;
    /**
     * 商品库存管理模块的DAO组件
     */
    protected GoodsStockDAO goodsStockDAO;
    /**
     * 日期辅助组件
     */
    protected DateProvider dateProvider;

    /**
     * 构造函数
     * @param goodsStockDO 商品库存DO对象
     * @param goodsStockDAO 商品库存管理模块的DAO组件
     * @param dateProvider 日期辅助组件
     */
    public AbstractGoodsStockUpdateCommand(
            GoodsStockDO goodsStockDO,
            GoodsStockDAO goodsStockDAO,
            DateProvider dateProvider) {
        this.goodsStockDO = goodsStockDO;
        this.goodsStockDAO = goodsStockDAO;
        this.dateProvider = dateProvider;
    }

    /**
     * 更新商品库存
     *
     * @return 处理结果
     */
    @Override
    public Boolean updateGoodsStock() {
        try{
            //更新商品销售库存
            updateSaleStockQuantity();
            updateLockedStockQuantity();
            updateSaledStockQuantity();
            updateStockStatus();
            updateGmtModified();
            executeUpdateGoodsStock();


        }catch (Exception e) {
            logger.error("error",e);
        }
        return true;
    }

    /**
     * 更新商品的销售库存
     */

    protected abstract void updateSaleStockQuantity() throws Exception;

    /**
     * 更新商品的锁定库存
     */
    protected abstract void updateLockedStockQuantity() throws Exception;
    /**
     * 更新商品的已销售库存
     */
    protected abstract void updateSaledStockQuantity() throws Exception;

    /**
     * 更新商品的库存状态
     */
    protected abstract void updateStockStatus() throws Exception;

    /**
     * 更新商品库存的修改时间
     * @throws Exception 抛出异常
     */
    private void updateGmtModified() throws Exception {
        goodsStockDO.setGmtModified(dateProvider.getCurrentTime());

    }

    /**
     * 实际执行更新商品库存的操作
     * @throws Exception 抛出异常
     */
    private void executeUpdateGoodsStock() throws Exception {
        goodsStockDAO.updateGoodsStock(goodsStockDO);
    }
}
