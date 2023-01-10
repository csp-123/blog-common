package com.csp.yiyan.enums;

import lombok.Getter;

/**
 * Title: 通用状态
 * Description:
 * Project: yiyan
 * Author: csp
 * Create Time:2023/1/10 13:46
 */
@Getter
public enum CommonStatusEnum {

    /**
     * 是
     */
    YES(1, "是"),

    /**
     * 否
     */
    NO(0, "否");

    /**
     * 状态码
     */
    private Byte code;

    /**
     * 描述
     */
    private String desc;

    CommonStatusEnum(Byte code, String desc) {
        this.code = code;
        this.desc = desc;
    }


}
