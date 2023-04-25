package com.Jenna.eshop.common.util;

/**
 * @author Jenna C He
 * @date 2023/04/25 11:47
 */
public class CloneDirection {

    /**
     * 正向克隆：从VO->DTO，DTO->DO
     */
    public static final Integer FORWARD = 1;
    /**
     * 反向克隆：从DO->DTO，DTO->VO
     */
    public static final Integer OPPOSITE = 2;

    private CloneDirection() {

    }
}
