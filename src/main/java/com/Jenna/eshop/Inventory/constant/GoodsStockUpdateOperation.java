package com.Jenna.eshop.Inventory.constant;

/**
 * 商品库存更新操作
 * @author Jenna C He
 * @date 2023/05/08 15:20
 */
public class GoodsStockUpdateOperation {
    /**
     * 提交订单
     */
    public static final Integer SUBMIT_ORDER =1;
    /**
     * 执行订单
     */
    public static final Integer PAY_ORDER =2;
    /**
     * 取消订单
     */
    public static final Integer CANCEL_ORDER =3;


    private GoodsStockUpdateOperation(){

    }
}
