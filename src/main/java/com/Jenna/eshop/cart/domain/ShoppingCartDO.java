package com.Jenna.eshop.cart.domain;

import java.util.Date;
import java.util.Objects;

/**
 * 购物车DO类
 * @author Jenna C He
 * @date 2023/3/14 11:14
 */
public class ShoppingCartDO {
    /**
     * id
     */
    private Long id;
    /**
     * 用户账号id
     */
    private Long userAccountId;
    /**
     * 购物车的创建时间
     */
    private Date gmtCreate;
    /**
     * 购物车的修改时间
     */
    private Date gmtModified;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShoppingCartDO)) return false;
        ShoppingCartDO that = (ShoppingCartDO) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getUserAccountId(), that.getUserAccountId()) && Objects.equals(getGmtCreate(), that.getGmtCreate()) && Objects.equals(getGmtModified(), that.getGmtModified());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserAccountId(), getGmtCreate(), getGmtModified());
    }
}
