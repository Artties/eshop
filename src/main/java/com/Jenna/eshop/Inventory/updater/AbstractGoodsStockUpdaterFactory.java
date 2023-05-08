package com.Jenna.eshop.Inventory.updater;

import com.Jenna.eshop.Inventory.constant.StockStatus;
import com.Jenna.eshop.Inventory.dao.GoodsStockDAO;
import com.Jenna.eshop.Inventory.domain.GoodsStockDO;
import com.Jenna.eshop.common.util.DateProvider;
import com.Jenna.eshop.order.domain.OrderInfoDTO;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;


import java.util.ArrayList;
import java.util.List;

/**
 * 库存更新命令工厂的父类
 * @author Jenna C He
 * @date 2023/04/11 11:20
 */
public abstract class AbstractGoodsStockUpdaterFactory<T>
        implements GoodsStockUpdaterFactory<T> {

    private static final Logger logger =  LoggerFactory.getLogger(AbstractGoodsStockUpdaterFactory.class);

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
     * @param goodsStockDAO 商品库存管理模块的DAO组件
     * @param dateProvider 日期辅助组件
     */
    public AbstractGoodsStockUpdaterFactory(
            GoodsStockDAO goodsStockDAO,
            DateProvider dateProvider
            ) {
        this.goodsStockDAO = goodsStockDAO;
        this.dateProvider = dateProvider;
    }

    /**
     * 创建一个库存更新命令
     *
     * @param parameter 参数对象
     * @return 库存更新命令
     */
    public GoodsStockUpdater create(OrderInfoDTO parameter) {
        try {
            List<Long> goodsSkuIds = getGoodsSkuIds((T) parameter);
            List<GoodsStockDO> goodsStockDOs = createGoodsStockDOs(goodsSkuIds);
            return create(goodsStockDOs, (T) parameter);
        }catch (Exception e) {
            logger.error("error",e);

        }
        return null;
    }

    /**
     * 获取商品sku id集合
     * @param parameter 泛型参数
     * @return 商品sku id集合
     * @throws Exception 抛出异常
     */
    protected abstract List<Long> getGoodsSkuIds(T parameter) throws Exception;

    /**
     * 创建商品库存DO对象集合
     * @param goodsSkuIds 商品sku id集合
     * @return 商品库存DO对象集合
     */

    private List<GoodsStockDO> createGoodsStockDOs(List<Long> goodsSkuIds) throws Exception {
        List<GoodsStockDO> goodsStockDOs = new ArrayList<GoodsStockDO>(goodsSkuIds.size());
        for(Long goodsSkuId:goodsSkuIds){
            GoodsStockDO goodsStockDO = goodsStockDAO.getGoodsStockBySkuId(goodsSkuId);
            if (goodsStockDO == null) {
                goodsStockDO = new GoodsStockDO();
                goodsStockDO.setGoodsSkuId(goodsSkuId);
                goodsStockDO.setSaledStockQuantity(0L);
                goodsStockDO.setLockedStockQuantity(0L);
                goodsStockDO.getSaledStockQuantity();
                goodsStockDO.setStockStatus(StockStatus.NOT_IN_STOCK);
                goodsStockDO.setGmtCreate(dateProvider.getCurrentTime());
                goodsStockDO.setGmtModified(dateProvider.getCurrentTime());

                goodsStockDAO.saveGoodsStock(goodsStockDO);

            }
            goodsStockDOs.add(goodsStockDO);
        }
        return goodsStockDOs;
    }

    protected abstract GoodsStockUpdater create(
            List<GoodsStockDO> goodsStockDOs,
            T parameter) throws Exception;
}
