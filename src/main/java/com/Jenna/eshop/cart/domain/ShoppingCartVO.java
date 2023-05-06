package com.Jenna.eshop.cart.domain;

import java.util.Date;
import java.util.List;

/**
 * 购物车VO类
 * @author Jenna C He
 * @date 2023/05/05 16:45
 */
public class ShoppingCartVO {
    /**
     * id
     */
    private Long id;
    /**
     * 用户账户id
     */
    private Long userAccountId;
    /**
     * 购物车创建时间
     */
    private Date gmtCreate;
    /**
     * 购物车修改时间
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
}
