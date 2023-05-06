package com.Jenna.eshop.cart.service.impl;

import com.Jenna.eshop.Inventory.service.InventoryFacadeService;
import com.Jenna.eshop.cart.dao.ShoppingCartDAO;

import com.Jenna.eshop.cart.dao.ShoppingCartItemDAO;
import com.Jenna.eshop.cart.domain.ShoppingCartDO;
import com.Jenna.eshop.cart.domain.ShoppingCartDTO;
import com.Jenna.eshop.cart.domain.ShoppingCartItemDO;
import com.Jenna.eshop.cart.domain.ShoppingCartItemDTO;
import com.Jenna.eshop.cart.service.ShoppingCartService;
import com.Jenna.eshop.common.util.DateProvider;
import com.Jenna.eshop.commondity.service.CommodityFacadeService;
import com.Jenna.eshop.goods.domain.GoodsSkuDTO;
import com.Jenna.eshop.promotion.domain.PromotionActivityDTO;
import com.Jenna.eshop.promotion.service.PromotionFacadeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 购物车管理模块的service组件
 * @author Jenna C He
 * @date 2023/3/14 19:07
 */
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private static final Logger logger = LoggerFactory.getLogger(ShoppingCartServiceImpl.class);
    /**
     * 购物车管理模块的DAO组件
     */
    @Autowired
    private ShoppingCartDAO shoppingCartDAO;
    /**
     * 购物车条目管理模块的DAO组件
     */
    @Autowired
    private ShoppingCartItemDAO shoppingCartItemDAO;
    /**
     * 日期辅助组件
     */
    @Autowired
    private DateProvider dateProvider;
    /**
     * 商品中心对外service组件
     */
    @Autowired
    private CommodityFacadeService commodityFacadeService;
    /**
     * 库存中心对外接口service组件
     */
    @Autowired
    private InventoryFacadeService inventoryFacadeService;
    /**
     * 促销中心对外接口service组件
     */
    @Autowired
    private PromotionFacadeService promotionFacadeService;
    /**
     * 添加购物车商品条目
     *
     * @param userAccountId 用户账号id
     * @param goodsSkuId    商品sku id
     * @return 处理结果
     */
    @Override
    public Boolean addShoppingCartItem(Long userAccountId, Long goodsSkuId)  {
        try {

            Date currentTime = dateProvider.getCurrentTime();
            


            //先查询一些用户的购物车
            ShoppingCartDO shoppingCartDO = shoppingCartDAO
                    .getShoppingCartByUserAccountId(userAccountId);

            //如果购物车不存在则新增一个购物车
            if(shoppingCartDO == null) {
                shoppingCartDO = new ShoppingCartDO();
                shoppingCartDO.setUserAccountId(userAccountId);
                shoppingCartDO.setGmtCreate(new Date());
                shoppingCartDO.setGmtModified(new Date());

                shoppingCartDAO.saveShoppingCart(shoppingCartDO);
            }

            //查询一下购物车中是否存在这个商品sku对应的条目
            ShoppingCartItemDO shoppingCartItemDO = shoppingCartItemDAO
                    .getShoppingCartItemByGoodsSkuId(shoppingCartDO.getId(), goodsSkuId);

            //如果没有这个商品条目则新增一个商品条目，则新增一个商品条目
            if (shoppingCartItemDO == null) {
                shoppingCartItemDO = new ShoppingCartItemDO();
                shoppingCartItemDO.setShoppingCartId(shoppingCartDO.getId());
                shoppingCartItemDO.setGoodsSkuId(goodsSkuId);
                shoppingCartItemDO.setPurchaseQuantity(1L);
                shoppingCartItemDO.setGmtCreate(currentTime);
                shoppingCartItemDO.setGmtModified(currentTime);

                shoppingCartItemDAO.saveShoppingCartItem(shoppingCartItemDO);
                //如果购物车中已经存在这个商品条目了，则对已有的商品条目购买数量累加1
            }else {
                shoppingCartItemDO.setPurchaseQuantity(
                        shoppingCartItemDO.getPurchaseQuantity() + 1L);
                shoppingCartItemDO.setGmtModified(currentTime);
                shoppingCartItemDAO.updateShoppingCartItem(shoppingCartItemDO);

            }
        } catch (Exception e) {
           logger.error("error",e);
           return false;
        }

        return true;
    }

    /**
     * 查看用户的购物车中的数据
     *
     * @param userAccountId 用户账号id
     * @return 购物车DTO对象
     */
    @Override
    public ShoppingCartDTO getShoppingCartDTOByUserAccountId(Long userAccountId) {
        try{
            //根据用户账号id
            ShoppingCartDO shoppingCartDO = shoppingCartDAO
                    .getShoppingCartByUserAccountId(userAccountId);
            if (shoppingCartDO == null){
                return new ShoppingCartDTO();
            }

            ShoppingCartDTO shoppingCartDTO = shoppingCartDO.clone(ShoppingCartDTO.class);

            //查询购物车中的条目数据
            List<ShoppingCartItemDO> shoppingCartItemDOs = shoppingCartItemDAO
                    .listShoppingCartItemByCartId(shoppingCartDTO.getId());

            if (shoppingCartItemDOs == null || shoppingCartItemDOs.size() == 0) {
                return shoppingCartDTO;
            }

            List<ShoppingCartItemDTO> shoppingCartItemDTOs = new ArrayList<ShoppingCartItemDTO>();
            shoppingCartDTO.setShoppingCartItemDTOs(shoppingCartItemDTOs);

            for (ShoppingCartItemDO shoppingCartItemDO : shoppingCartItemDOs) {
                ShoppingCartItemDTO shoppingCartItemDTO = shoppingCartItemDO.clone(
                        ShoppingCartItemDTO.class);
                //给每个购物车条目填充数据
                GoodsSkuDTO goodsSkuDTO = commodityFacadeService.getGoodsSkuById(
                        shoppingCartItemDTO.getGoodsSkuId());
                shoppingCartItemDTO.setGoodsId(goodsSkuDTO.getGoodsId());
                shoppingCartItemDTO.setGoodsHeight(goodsSkuDTO.getGoodsHeight());
                shoppingCartItemDTO.setGoodsLength(goodsSkuDTO.getGoodsLength());
                shoppingCartItemDTO.setGoodsName(goodsSkuDTO.getGoodsName());
                shoppingCartItemDTO.setGoodsSkuCode(goodsSkuDTO.getGoodsSkuCode());
                shoppingCartItemDTO.setGoodsWidth(goodsSkuDTO.getGoodsWidth());
                shoppingCartItemDTO.setGrossWeight(goodsSkuDTO.getGrossWeight());
                shoppingCartItemDTO.setSalePrice(goodsSkuDTO.getSalePrice());
                shoppingCartItemDTO.setSaleProperties(goodsSkuDTO.getSaleProperties());

                //给购物车条目填充库存数据
                Long saleStockQuantity = inventoryFacadeService.getSaleStockQuantity(
                        shoppingCartItemDTO.getGoodsSkuId());
                shoppingCartItemDTO.setSaleStockQuantity(saleStockQuantity);

                //给购物车条目填充促销数据
                List<PromotionActivityDTO> promotionActivityDTOs = promotionFacadeService
                        .listPromotionActivitiesByGoodsId(shoppingCartItemDTO.getGoodsId());
                shoppingCartItemDTO.setPromotionActivityDTOs(promotionActivityDTOs);

                //添加购物车条目DTO对象到集合中
                shoppingCartItemDTOs.add(shoppingCartItemDTO);
            }
            return shoppingCartDTO;
        }catch (Exception e) {
            logger.error("error",e);
            return new ShoppingCartDTO();
        }
    }
}
