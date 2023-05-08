package com.Jenna.eshop.Inventory.async;

import com.Jenna.eshop.order.domain.OrderInfoDTO;

/**
 * 商品库存更新消息
 * @author Jenna C He
 * @date 2023/05/08 15:19
 */
public class GoodsStockUpdateMessage {
    /**
     * 商品库存更新操作
     */
    private Integer operation;
    /**
     * 核心参数数据
     */
    private Object parameter;

    public Integer getOperation() {
        return operation;
    }

    public void setOperation(Integer operation) {
        this.operation = operation;
    }

    public Object getParameter() {
        return parameter;
    }

    public void setParameter(Object parameter) {
        this.parameter = parameter;
    }
}
