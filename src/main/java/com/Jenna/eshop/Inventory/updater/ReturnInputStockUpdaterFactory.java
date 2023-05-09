package com.Jenna.eshop.Inventory.updater;

import com.Jenna.eshop.Inventory.dao.GoodsStockDAO;
import com.Jenna.eshop.Inventory.domain.GoodsStockDO;
import com.Jenna.eshop.common.util.DateProvider;
import com.Jenna.eshop.order.domain.OrderInfoDTO;
import com.Jenna.eshop.wms.domain.ReturnGoodsInputOrderDTO;
import com.Jenna.eshop.wms.domain.ReturnGoodsInputOrderItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 退货入库库存更新命令的工厂
 * @author Jenna C He
 * @date 2023/04/11 11:53
 */
@Component
public class ReturnInputStockUpdaterFactory<T>
        extends AbstractStockUpdaterFactory<T> {

    /**
     * 构造函数
     *
     * @param goodsStockDAO 商品库存管理模块的DAO组件
     * @param dateProvider  日期辅助组件
     */
    @Autowired
    public ReturnInputStockUpdaterFactory(
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
        ReturnGoodsInputOrderDTO returnGoodsInputOrderDTO = (ReturnGoodsInputOrderDTO) parameter;
        List<ReturnGoodsInputOrderItemDTO> returnGoodsInputOrderItemDTOs =
                returnGoodsInputOrderDTO.getReturnGoodsInputOrderItemDTOs();

        if(returnGoodsInputOrderItemDTOs == null || returnGoodsInputOrderItemDTOs.size() == 0){
            return new ArrayList<Long>();
        }

        List<Long> goodsSkuIds = new ArrayList<Long>(returnGoodsInputOrderItemDTOs.size());

        for (ReturnGoodsInputOrderItemDTO returnGoodsInputOrderItemDTO : returnGoodsInputOrderItemDTOs) {
            goodsSkuIds.add(ReturnGoodsInputOrderItemDTO.getGoodsSkuId());

}

        return goodsSkuIds;
    }

    /**
     * 创建库存更新命令
     *
     * @param goodsStockDOs 商品库存DO对象集合
     * @param parameter 泛型参数
     * @return 库存更新命令
     * @throws Exception 抛出异常
     */
    @Override
    protected StockUpdater create(
            List<GoodsStockDO> goodsStockDOs,
            T parameter) throws Exception {
        //解析采购入库单，获取一个采购入库单条目Map
        ReturnGoodsInputOrderDTO returnGoodsInputOrderDTO = (ReturnGoodsInputOrderDTO) parameter;
        List<ReturnGoodsInputOrderItemDTO> returnGoodsInputOrderItemDTOs =
                returnGoodsInputOrderDTO.getReturnGoodsInputOrderItemDTOs();

        Map<Long, ReturnGoodsInputOrderItemDTO> returnGoodsInputOrderItemMap =
                new HashMap<>();

        if(returnGoodsInputOrderItemDTOs != null && returnGoodsInputOrderItemDTOs.size() > 0){
            for(ReturnGoodsInputOrderItemDTO returnGoodsInputOrderItemDTO:returnGoodsInputOrderItemDTOs){
                returnGoodsInputOrderItemMap.put(ReturnGoodsInputOrderItemDTO.getGoodsSkuId(),
                        returnGoodsInputOrderItemDTO);
            }

        }
        //创建库存更新命令
        return new ReturnInputStockUpdater(goodsStockDOs,goodsStockDAO,
                dateProvider,returnGoodsInputOrderItemMap);
    }

    /**
     * @param parameter
     * @return
     * @throws Exception
     */
    @Override
    protected List<Long> getGoodsSkuIds(OrderInfoDTO parameter) throws Exception {
        return null;
    }

    /**
     * @param goodsStockDOs
     * @param parameter
     * @return
     * @throws Exception
     */
    @Override
    protected StockUpdater create(List<GoodsStockDO> goodsStockDOs, OrderInfoDTO parameter) throws Exception {
        return null;
    }


}
