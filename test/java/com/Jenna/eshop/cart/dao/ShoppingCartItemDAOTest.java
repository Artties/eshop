package com.Jenna.eshop.cart.dao;

import com.Jenna.eshop.cart.domain.ShoppingCartItemDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 购物车条目管理模块的DAO组件的单元测试类
 * @author Jenna C He
 * @date 2023/03/16 11:03
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(true)
public class ShoppingCartItemDAOTest {
    /**
     * 购物车条目管理模块的DAO组件
     */
    @Autowired
    private ShoppingCartItemDAO shoppingCartItemDAO;

    /**
     * 测试新增购物车条目
     * @throws Exception
     */
    @Test
    public void testSaveShoppingCartItem() throws Exception {
        Long shoppingCartId = 1L;
        Long goodsSkuId = 1L;
        Long purchaseQuantity = 1L;

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currentTime = formatter.parse(formatter.format(new Date()));

        ShoppingCartItemDO shoppingCartItemDO = new ShoppingCartItemDO();

        shoppingCartItemDO.setShoppingCartId(shoppingCartId);
        shoppingCartItemDO.setGoodsSkuId(goodsSkuId);
        shoppingCartItemDO.setPurchaseQuantity(purchaseQuantity);
        shoppingCartItemDO.setGmtCreate(currentTime);
        shoppingCartItemDO.setGmtModified(currentTime);

        Long shoppingCartItemId = shoppingCartItemDAO.saveShoppingCartItem(shoppingCartItemDO);

        assertNotNull(shoppingCartItemId);
        assertThat(shoppingCartItemId,greaterThan(0L));
    }

    /**
     * 测试根据商品sku id查询购物车中是否存在商品条目
     * @throws Exception
     */
    @Test
    public void testGetShoppingCartItemByGoodsSkuId() throws Exception{
        //构造一个购物车条目
    }


}
