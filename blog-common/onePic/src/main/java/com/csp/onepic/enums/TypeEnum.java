package com.csp.onepic.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Title:
 * Description:
 * Project: blog-common
 * Author: csp
 * Create Time:2023/1/17 14:51
 */
@Getter
public enum TypeEnum {

    ALL(0, "全部"),

    GAME(1, "游戏"),

    COMIC(2, "动漫"),

    SCENERY(3, "风景");

    private Integer type;
    private String desc;

    TypeEnum(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public static Map<Integer, TypeEnum> lookUp = new HashMap<>();

    static {
        for (TypeEnum value : TypeEnum.values()) {
            lookUp.put(value.getType(), value);
        }
    }

    public static TypeEnum find(Integer type) {
        return lookUp.get(type);
    }
}
