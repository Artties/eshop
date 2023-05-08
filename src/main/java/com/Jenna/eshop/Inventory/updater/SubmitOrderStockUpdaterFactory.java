package com.Jenna.eshop.Inventory.updater;

import com.Jenna.eshop.Inventory.dao.GoodsStockDAO;
import com.Jenna.eshop.Inventory.domain.GoodsStockDO;
import com.Jenna.eshop.common.util.DateProvider;
import com.Jenna.eshop.order.domain.OrderInfoDTO;
import com.Jenna.eshop.order.domain.OrderItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 提交订单库存更新组件工厂
 * @author Jenna C He
 * @date 2023/05/06 16:55
 */
@Component
public class SubmitOrderStockUpdaterFactory<T>
        extends AbstractGoodsStockUpdaterFactory<T> {
    /**
     * 构造函数
     *
     * @param goodsStockDAO 商品库存管理模块的DAO组件
     * @param dateProvider  日期辅助组件
     */
    @Autowired
    public SubmitOrderStockUpdaterFactory(
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
        OrderInfoDTO orderInfoDTO = (OrderInfoDTO) parameter;

        List<Long> goodsSkuIds = new ArrayList<Long>();

        List<OrderItemDTO> orderItemDTOs = OrderInfoDTO.getOrderItems();
        for(OrderItemDTO orderItemDTO : orderItemDTOs) {
            goodsSkuIds.add(orderItemDTO.getGoodsSkuId());
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
    protected GoodsStockUpdater create(List<GoodsStockDO> goodsStockDOs,
                                       T parameter) throws Exception {
        OrderInfoDTO orderInfoDTO = (OrderInfoDTO) parameter;
        Map<Long, OrderItemDTO> orderItemDTOMap = new HashMap<Long, OrderItemDTO>();
        for(OrderItemDTO orderItemDTO : OrderInfoDTO.getOrderItems()) {
            orderItemDTOMap.put(orderItemDTO.getGoodsSkuId(), orderItemDTO);
        }

        return new SubmitOrderStockUpdater(goodsStockDOs, goodsStockDAO,
                dateProvider, orderItemDTOMap);
    }

    /**
     * 获取要更新库存的商品sku id集合
     *
     * @param parameter 泛型参数
     * @return 商品sku id集合
     * @throws Exception 抛出异常
     */
    @Override
    protected List<Long> getGoodsSkuIds(OrderInfoDTO parameter) throws Exception {
        List<Long> goodsSkuIds = new ArrayList<Long>();

        List<OrderItemDTO> orderItemDTOs = OrderInfoDTO.getOrderItems();
        for (OrderItemDTO orderItemDTO : orderItemDTOs){
            goodsSkuIds.add(orderItemDTO.getGoodsSkuId());
        }

        return goodsSkuIds;
    }

    /**
     * 创建商品库存更新组件
     *
     * @param goodsStockDOs 商品库存DO对象集合
     * @param parameter 订单DTO对象
     * @return 商品库存更新组件
     * @throws Exception 抛出异常
     */
    @Override
    protected GoodsStockUpdater create(List<GoodsStockDO> goodsStockDOs,
                                       OrderInfoDTO parameter) throws Exception {
        Map<Long,OrderItemDTO> orderItemDTOMap = new HashMap<>();

        for (OrderItemDTO orderItemDTO : OrderInfoDTO.getOrderItems()) {
            orderItemDTOMap.put(orderItemDTO.getGoodsSkuId(),orderItemDTO);
        }

        return new SubmitOrderStockUpdater(goodsStockDOs,goodsStockDAO,
                dateProvider,orderItemDTOMap);
    }
}
