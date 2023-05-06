package com.Jenna.eshop.cart.domain;

import com.Jenna.eshop.common.util.BeanCopierUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 购物车条目VO类
 * @author Jenna C He
 * @date 2023/3/14 11:17
 */
public class ShoppingCartItemVO {
    private static final Logger logger = LoggerFactory.getLogger(ShoppingCartItemVO.class);
    /**
     * id
     */
    private Long id;
    /**
     * 用户id
     */
    private Long userAccountId;
    /**
     * 购物车id
     */
    private Long shoppingCartId;
    /**
     * 商品sku id
     */
    private Long goodsSkuId;
    /**
     * 购买数量
     */
    private Long purchaseQuantity;
    /**
     * 购物车条目的创建时间
     */
    private Date gmtCreate;
    /**
     * 购物车条目的修改时间
     */
    private Date gmtModified;
    /**
     * 购物车条目集合
     */
    private List<ShoppingCartItemVO> shoppingCartItemVOs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(Long userAccountId) {
        this.userAccountId = userAccountId;
    }
    public Long getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(Long shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    public Long getGoodsSkuId() {
        return goodsSkuId;
    }

    public void setGoodsSkuId(Long goodsSkuId) {
        this.goodsSkuId = goodsSkuId;
    }

    public Long getPurchaseQuantity() {
        return purchaseQuantity;
    }

    public void setPurchaseQuantity(Long purchaseQuantity) {
        this.purchaseQuantity = purchaseQuantity;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public List<ShoppingCartItemVO> getShoppingCartItemVOs() {
        return shoppingCartItemVOs;
    }

    public void setShoppingCartItemVOs(List<ShoppingCartItemVO> shoppingCartItemVOs) {
        this.shoppingCartItemVOs = shoppingCartItemVOs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ShoppingCartItemVO)) {
            return false;
        }
        ShoppingCartItemVO that = (ShoppingCartItemVO) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getUserAccountId(), that.getUserAccountId()) && Objects.equals(getShoppingCartId(), that.getShoppingCartId()) && Objects.equals(getGoodsSkuId(), that.getGoodsSkuId()) && Objects.equals(getPurchaseQuantity(), that.getPurchaseQuantity()) && Objects.equals(getGmtCreate(), that.getGmtCreate()) && Objects.equals(getGmtModified(), that.getGmtModified());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserAccountId(), getShoppingCartId(), getGoodsSkuId(), getPurchaseQuantity(), getGmtCreate(), getGmtModified());
    }

    public <T> T clone(Class<T> clazz) {
        T target = null;
        try{
            target = clazz.newInstance();
            BeanCopierUtils.copyProperties(this, target);
        }catch (Exception e) {
            logger.error("error",e);
            return null;
        }
        return target;
    }
}
