package com.Jenna.eshop.cart.service;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;

import com.Jenna.eshop.cart.dao.ShoppingCartDAO;
import com.Jenna.eshop.cart.dao.ShoppingCartItemDAO;
import com.Jenna.eshop.cart.domain.ShoppingCartDO;
import com.Jenna.eshop.cart.domain.ShoppingCartItemDO;
import com.Jenna.eshop.common.util.DateProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 购物车管理模块的service组件的单元测试类
 * @author Jenna C He
 * @date 2023/04/01 17:04
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShoppingCartServiceTest {
    /**
     * 购物车管理模块的service组件
     */
    @Autowired
    private ShoppingCartService shoppingCartService;
    /**
     * 做单元测试要隔离
     *购物车管理模块的DAO组件
     */
    @MockBean
    private ShoppingCartDAO shoppingCartDAO;
    /**
     * 购物车条目管理模块的DAO组件
     */
    @MockBean
    private ShoppingCartItemDAO shoppingCartItemDAO;
    

    /**
     * 测试添加购物车商品条目
     * @throws Exception 抛出异常
     */
    @Test
    public void testAddShoppingCartItem() throws Exception {
        //准备一些参数
        Long userAccountId = 1L;
        Long goodsSkuId = 1L;

        ShoppingCartDO shoppingCartDO = createShoppingCartDO(userAccountId);
        ShoppingCartItemDO shoppingCartItemDO = createShoppingCartItemDO(
                shoppingCartDO.getId(),goodsSkuId);



        //模仿一下两个DAO的行为

        when(shoppingCartDAO.getShoppingCartByUserAccountId(userAccountId))
                .thenReturn(shoppingCartDO);

        when(shoppingCartItemDAO.getShoppingCartItemByGoodsSkuId(
                shoppingCartDO.getId(),goodsSkuId)).thenReturn(shoppingCartItemDO);

        when(shoppingCartItemDAO.updateShoppingCartItem(shoppingCartItemDO));


        //执行service方法
    }

    /**
     * 创建一个购物车DO对象
     * @param userAccountId 用户账号id
     * @return 购物车DO对象
     * @throws Exception 抛出异常
     */
    private ShoppingCartDO createShoppingCartDO(Long userAccountId) throws Exception {
        Long id = 1L;

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currentTime = formatter.parse(formatter.format(new Date()));



        ShoppingCartDO shoppingCartDO = new ShoppingCartDO();
        shoppingCartDO.setId(id);
        shoppingCartDO.setUserAccountId(userAccountId);
        shoppingCartDO.setGmtCreate(currentTime);
        shoppingCartDO.setGmtModified(currentTime);

        return shoppingCartDO;

    }

    /**
     * 创建一个购物车条目对象
     * @param shoppingCartId 购物车id
     * @param goodsSkuId 商品sku id
     * @return 购物车条目DO对象
     * @throws Exception 抛出异常
     */
    private ShoppingCartItemDO createShoppingCartItemDO(
            Long shoppingCartId,Long goodsSkuId) throws Exception{
        Long id = 1L;
        Long purchaseQuantity = 1L;

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currentTime = formatter.parse(formatter.format(new Date()));

        ShoppingCartItemDO shoppingCartItemDO = new ShoppingCartItemDO();
        shoppingCartItemDO.setId(id);
        shoppingCartItemDO.setShoppingCartId(shoppingCartId);
        shoppingCartItemDO.setGoodsSkuId(goodsSkuId);
        shoppingCartItemDO.setPurchaseQuantity(purchaseQuantity);
        shoppingCartItemDO.setGmtCreate(currentTime);
        shoppingCartItemDO.setGmtModified(currentTime);

        return shoppingCartItemDO;


    }
}
