package com.Jenna.eshop.Inventory.command;

import com.Jenna.eshop.Inventory.dao.GoodsStockDAO;
import com.Jenna.eshop.Inventory.domain.GoodsStockDO;
import com.Jenna.eshop.common.util.DateProvider;
import com.Jenna.eshop.wms.domain.PurchaseInputOrderDTO;
import com.Jenna.eshop.wms.domain.PurchaseInputOrderItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 采购入库库存更新命令的工厂
 * @author Jenna C He
 * @date 2023/04/11 11:53
 */
@Component
public class PurchaseInputStockUpdateCommandFactory <T>
        extends AbstractGoodsStockUpdateCommandFactory <T>{

    /**
     * 构造函数
     *
     * @param goodsStockDAO 商品库存管理模块的DAO组件
     * @param dateProvider  日期辅助组件
     */
    @Autowired
    public PurchaseInputStockUpdateCommandFactory(
            GoodsStockDAO goodsStockDAO,
            DateProvider dateProvider) {
        super(goodsStockDAO, dateProvider);
    }

    /**
     * 获取商品sku id集合
     *
     * @param parameter 泛型参数
     * @return 商品sku id集合
     * @throws Exception 抛出异常
     */
    @Override
    protected List<Long> getGoodsSkuIds(T parameter) throws Exception {
        PurchaseInputOrderDTO purchaseInputOrderDTO = (PurchaseInputOrderDTO) parameter;
        List<PurchaseInputOrderItemDTO> purchaseInputOrderItemDTOs =
                purchaseInputOrderDTO.getPurchaseInputOrderItemDTOs();
        if(purchaseInputOrderItemDTOs == null || purchaseInputOrderItemDTOs.size() == 0){
            return new ArrayList<>();
        }
        List<Long> goodsSkuIds = new ArrayList<Long>(purchaseInputOrderItemDTOs.size());

        for (PurchaseInputOrderItemDTO purchaseInputOrderItemDTO : purchaseInputOrderItemDTOs) {
            goodsSkuIds.add(purchaseInputOrderItemDTO.getGoodsSkuId());

}

        return goodsSkuIds;
    }

    /**
     * 创建库存更新命令
     *
     * @param goodsStockDOs 商品库存DO对象集合
     * @param parameter
     * @return 库存更新命令
     * @throws Exception 抛出异常
     */
    @Override
    protected GoodsStockUpdateCommand create(List<GoodsStockDO> goodsStockDOs, T parameter) throws Exception {
        return null;
    }


}
