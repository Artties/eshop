package com.Jenna.eshop.Inventory.updater;

import com.Jenna.eshop.Inventory.dao.GoodsStockDAO;
import com.Jenna.eshop.Inventory.domain.GoodsStockDO;
import com.Jenna.eshop.common.util.DateProvider;
import com.Jenna.eshop.wms.domain.PurchaseInputOrderItemDTO;

import java.util.List;
import java.util.Map;

/**
 * 采购入库库存更新命令
 * @author Jenna C He
 * @date 2023/04/10 16:28
 */
public class PurchaseInputStockUpdater extends AbstractGoodsStockUpdater {

    /**
     * 采购入库单条目DTO集合
     */
    private Map<Long, PurchaseInputOrderItemDTO> purchaseInputOrderItemDTOMap;

    /**
     * 构造函数
     *
     * @param goodsStockDOs 商品库存DO对象
     * @param goodsStockDAO 商品库存管理模块的DAO组件
     * @param dateProvider  日期辅助组件
     */
    public PurchaseInputStockUpdater(
            List<GoodsStockDO> goodsStockDOs,
            GoodsStockDAO goodsStockDAO,
            DateProvider dateProvider,
            Map<Long, PurchaseInputOrderItemDTO> purchaseInputOrderItemDTO) {
        super(goodsStockDOs, goodsStockDAO, dateProvider);
        this.purchaseInputOrderItemDTOMap = purchaseInputOrderItemDTOMap;
    }

    /**
     * 更新商品的销售库存
     */
    @Override
    protected void updateSaleStockQuantity() throws Exception {
        for(GoodsStockDO goodsStockDO:goodsStockDOs){
            PurchaseInputOrderItemDTO purchaseInputOrderItemDTO =
                    purchaseInputOrderItemDTOMap.get(goodsStockDO.getId());
            goodsStockDO.setSaledStockQuantity(goodsStockDO.getSaleStockQuantity()
                    + purchaseInputOrderItemDTO.getArrivalCount());
        }
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

}
