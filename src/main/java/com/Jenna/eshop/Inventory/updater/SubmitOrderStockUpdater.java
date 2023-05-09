package com.Jenna.eshop.Inventory.updater;

import com.Jenna.eshop.Inventory.dao.GoodsStockDAO;
import com.Jenna.eshop.Inventory.domain.GoodsStockDO;
import com.Jenna.eshop.common.util.DateProvider;
import com.Jenna.eshop.order.domain.OrderItemDTO;

import java.util.List;
import java.util.Map;

/**
 * 提交订单库存更新组件
 * @author Jenna C He
 * @date 2023/05/06 11:27
 */
public class SubmitOrderStockUpdater extends AbstractStockUpdater {
    /**
     * 订单条目DTO对象集合
     */
    private Map<Long, OrderItemDTO> orderItemDTOMap;

    /**
     * 构造函数
     *
     * @param goodsStockDOs 商品库存DO对象
     * @param goodsStockDAO 商品库存管理模块的DAO组件
     * @param dateProvider  日期辅助组件
     */
    public SubmitOrderStockUpdater(
            List<GoodsStockDO> goodsStockDOs,
            GoodsStockDAO goodsStockDAO,
            DateProvider dateProvider,
            Map<Long, OrderItemDTO> orderItemDTOMap) {
        super(goodsStockDOs, goodsStockDAO, dateProvider);
        this.orderItemDTOMap = orderItemDTOMap;
    }

    /**
     * 更新商品的销售库存
     */
    @Override
    protected void updateSaleStockQuantity() throws Exception {
        for (GoodsStockDO goodsStockDO : goodsStockDOs) {
            OrderItemDTO orderItemDTO = orderItemDTOMap.get(goodsStockDO.getId());
            goodsStockDO.setSaledStockQuantity(goodsStockDO.getSaledStockQuantity()
                    - orderItemDTO.getPurchaseQuantity());
        }
    }

    /**
     * 更新商品的锁定库存
     */
    @Override
    protected void updateLockedStockQuantity() throws Exception {
        for (GoodsStockDO goodsStockDO : goodsStockDOs) {
            OrderItemDTO orderItemDTO = orderItemDTOMap.get(goodsStockDO.getId());
            goodsStockDO.setLockedStockQuantity(goodsStockDO.getLockedStockQuantity()
                    + orderItemDTO.getPurchaseQuantity());
        }
    }

    /**
     * 更新商品的已销售库存
     */
    @Override
    protected void updateSaledStockQuantity() throws Exception {

    }
}
