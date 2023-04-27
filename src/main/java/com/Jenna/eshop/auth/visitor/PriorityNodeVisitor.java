package com.Jenna.eshop.auth.visitor;

import com.Jenna.eshop.auth.composite.PriorityNode;

/**
 * 访问树节点的访问者接口
 */
public interface PriorityNodeVisitor {
    /**
     * 访问权限树节点
     * @param node 权限树节点
     */
    void visit(PriorityNode node);
}
