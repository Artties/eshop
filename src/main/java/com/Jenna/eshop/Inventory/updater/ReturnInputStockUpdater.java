package com.Jenna.eshop.Inventory.updater;

import com.Jenna.eshop.Inventory.dao.GoodsStockDAO;
import com.Jenna.eshop.Inventory.domain.GoodsStockDO;
import com.Jenna.eshop.common.util.DateProvider;
import com.Jenna.eshop.wms.domain.ReturnGoodsInputOrderItemDTO;

import java.util.List;
import java.util.Map;

/**
 * 退货入库
 * @author Jenna C He
 * @date 2023/04/10 17:59
 */
public class ReturnInputStockUpdater extends AbstractStockUpdater {
    /**
     * 退货入库单条目DTO集合
     */
    private Map<Long, ReturnGoodsInputOrderItemDTO> returnGoodsInputOrderItemDTOMap;

    /**
     * 构造函数
     *
     * @param goodsStockDOs 商品库存DO对象
     * @param goodsStockDAO 商品库存管理模块的DAO组件
     * @param dateProvider  日期辅助组件
     * @param returnGoodsInputOrderItemDTOMap 退货入库单条目DTO集合
     */
    public ReturnInputStockUpdater(
            List<GoodsStockDO> goodsStockDOs,
            GoodsStockDAO goodsStockDAO,
            DateProvider dateProvider,
            Map<Long,ReturnGoodsInputOrderItemDTO> returnGoodsInputOrderItemDTOMap) {
        super(goodsStockDOs, goodsStockDAO, dateProvider);
        this.returnGoodsInputOrderItemDTOMap = returnGoodsInputOrderItemDTOMap;
    }

    /**
     * 更新商品的销售库存
     */
    @Override
    protected void updateSaleStockQuantity() throws Exception {
        for(GoodsStockDO goodsStockDO:goodsStockDOs){
            ReturnGoodsInputOrderItemDTO returnGoodsInputOrderItemDTO =
                    returnGoodsInputOrderItemDTOMap.get(goodsStockDO.getId());
            goodsStockDO.setSaledStockQuantity(goodsStockDO.getSaleStockQuantity()
                    + returnGoodsInputOrderItemDTO.getArrivalCount());
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
        for(GoodsStockDO goodsStockDO:goodsStockDOs){
            ReturnGoodsInputOrderItemDTO returnGoodsInputOrderItemDTO =
                    returnGoodsInputOrderItemDTOMap.get(goodsStockDO.getId());
            goodsStockDO.setSaledStockQuantity(goodsStockDO.getSaleStockQuantity()
                    - returnGoodsInputOrderItemDTO.getArrivalCount());
        }
    }
}
