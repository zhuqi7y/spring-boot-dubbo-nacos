package com.youzi.modules.sys.enums;

import cn.hutool.core.util.EnumUtil;

import java.util.Objects;

/**
 * @Description: TODO
 * @author: zhuqi
 * @date: 2020年08月20日 9:27
 */
public enum SysInfoEnum {

    homeInfo(1, "homeInfo"),
    logoInfo(2, "logoInfo"),
    menuInfo(3, "menuInfo");

    private Integer type;
    private String name;

    public static String getNameByType(Integer type) {
        return EnumUtil.getEnumMap(SysInfoEnum.class).values().stream()
                .filter(o -> Objects.equals(o.getType(), type))
                .findFirst().map(SysInfoEnum::getName).orElse("");
    }

    SysInfoEnum(Integer type, String name) {
        this.type = type;
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
