package com.Jenna.eshop.membership.service.impl;

import com.Jenna.eshop.membership.service.MembershipFacadeService;
import org.springframework.stereotype.Service;

/**
 * 会员中心对外接口service组件
 * @author Jenna C He
 * @date 2023/3/8 12:21
 */
@Service
public class MembershipFacadeServiceImpl implements MembershipFacadeService {

    /**
     * 通知会员中心，"用户今日第一次登录"事件发生了
     *
     * @param userAccountId 用户账号ID
     * @return 处理结果
     */
    @Override
    public Boolean informFirstLoginDailyEvent(Long userAccountId) {
        return true;
    }

    /**
     * 通知会员中心，"支付订单事件"发生了
     *
     * @param userAccountId    用户账号ID
     * @param totalOrderAmount 订单总金额
     * @return 处理结果
     */
    @Override
    public Boolean informPayOrderEvent(Long userAccountId, Long totalOrderAmount) {
        return true;
    }

    /**
     * 通知会员中心，"完成退货"事件发生了
     *
     * @param userAccountId    用户账号ID
     * @param totalOrderAmount 订单总金额
     * @return 处理结果
     */
    @Override
    public Boolean informFinishReturnGoodsEvent(Long userAccountId, Long totalOrderAmount) {
        return true;
    }

    /**
     * 通知会员中心，"发表评论"事件发生了
     *
     * @param userAccountId 用户账号ID
     * @param showPictures  是否晒图
     * @return 处理结果
     */
    @Override
    public Boolean informPublishCommentEvent(Long userAccountId, Boolean showPictures) {
        return true;
    }

    /**
     * 通知会员中心，"删除评论"事件发生了
     *
     * @param userAccountId 用户账号ID
     * @param showPictures  是否晒图
     * @return 处理结果
     */
    @Override
    public Boolean informRemoveCommentEvent(Long userAccountId, Boolean showPictures) {
        return true;
    }
}
