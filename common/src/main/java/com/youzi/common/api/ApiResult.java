package com.youzi.common.api;

import cn.hutool.core.util.StrUtil;

/**
 * @Description: 通用api返回json结果
 * @author: zhuqi
 * @date: 2020年07月22日 15:16
 */
public class ApiResult<T> {
    private int code;
    private String msg;
    private T body;

    public ApiResult(int code, String msg, T body) {
        this.code = code;
        this.msg = msg;
        this.body = body;
    }

    public static ApiResult success() {
        return new ApiResult(ApiCodeEnum.SUCCESS.getCode(), ApiCodeEnum.SUCCESS.getMsg(), null);
    }

    public static ApiResult success(String msg) {
        return new ApiResult(ApiCodeEnum.SUCCESS.getCode(), StrUtil.blankToDefault(msg, ApiCodeEnum.SUCCESS.getMsg()), null);
    }

    public static ApiResult successBody(Object body) {
        return new ApiResult(ApiCodeEnum.SUCCESS.getCode(), ApiCodeEnum.SUCCESS.getMsg(), body);
    }

    public static ApiResult successBody(String msg, Object body) {
        return new ApiResult(ApiCodeEnum.SUCCESS.getCode(), StrUtil.blankToDefault(msg, ApiCodeEnum.SUCCESS.getMsg()), body);
    }

    public static ApiResult fail() {
        return new ApiResult(ApiCodeEnum.FAIL.getCode(), ApiCodeEnum.FAIL.getMsg(), null);
    }

    public static ApiResult fail(String msg) {
        return new ApiResult(ApiCodeEnum.FAIL.getCode(), StrUtil.blankToDefault(msg, ApiCodeEnum.FAIL.getMsg()), null);
    }

}
