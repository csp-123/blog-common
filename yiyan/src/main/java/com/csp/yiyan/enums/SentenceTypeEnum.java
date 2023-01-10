package com.csp.yiyan.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: 语句分类
 * Description:
 * Project: yiyan
 * Author: csp
 * Create Time:2023/1/10 14:22
 */
@Getter
public enum SentenceTypeEnum {

    /**
     * 1， 古文诗词
     */
    POETRY(1, "古文诗词");

    private Integer code;

    private String desc;

    SentenceTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static Map<Integer, SentenceTypeEnum> lookUp = new HashMap<>();

    static {
        for (SentenceTypeEnum value : SentenceTypeEnum.values()) {
            lookUp.put(value.getCode(), value);
        }
    }

    public static SentenceTypeEnum find(Integer type) {
        return lookUp.get(type);
    }



}
