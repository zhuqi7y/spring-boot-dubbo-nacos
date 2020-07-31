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

    public ApiResult() {}

    public ApiResult(int code, String msg, T body) {
        this.code = code;
        this.msg = msg;
        this.body = body;
    }

    public ApiResult(IApiCode apiCode) {
        this.code = apiCode.getCode();
        this.msg = apiCode.getMsg();
        this.body = null;
    }

    public ApiResult(IApiCode apiCode, String msg) {
        this.code = apiCode.getCode();
        this.msg = StrUtil.blankToDefault(msg, apiCode.getMsg());
        this.body = null;
    }

    public ApiResult(IApiCode apiCode, T body) {
        this.code = apiCode.getCode();
        this.msg = apiCode.getMsg();
        this.body = body;
    }

    public ApiResult(IApiCode apiCode, String msg, T body) {
        this.code = apiCode.getCode();
        this.msg = StrUtil.blankToDefault(msg, apiCode.getMsg());
        this.body = body;
    }

    public static <T> ApiResult<T> success() {
        return new ApiResult(ApiCode.SUCCESS);
    }

    public static <T> ApiResult<T> success(String msg) {
        return new ApiResult(ApiCode.SUCCESS, msg);
    }

    public static <T> ApiResult<T> successBody(T body) {
        return new ApiResult(ApiCode.SUCCESS, body);
    }

    public static <T> ApiResult<T> successBody(String msg, Object body) {
        return new ApiResult(ApiCode.SUCCESS, msg, body);
    }

    public static <T> ApiResult<T> fail() {
        return new ApiResult(ApiCode.FAIL);
    }

    public static <T> ApiResult<T> fail(String msg) {
        return new ApiResult(ApiCode.FAIL, msg);
    }

    public static <T> ApiResult<T> badRequest() {
        return new ApiResult(ApiCode.BAD_REQUEST);
    }

    public static <T> ApiResult<T> badRequest(String msg) {
        return new ApiResult(ApiCode.BAD_REQUEST, msg);
    }

    public static <T> ApiResult<T> forbidden() {
        return new ApiResult(ApiCode.FORBIDDEN);
    }

    public static <T> ApiResult<T> forbidden(String msg) {
        return new ApiResult(ApiCode.FORBIDDEN, msg);
    }

    public static <T> ApiResult<T> notFound() {
        return new ApiResult(ApiCode.NOT_FOUND);
    }

    public static <T> ApiResult<T> notFound(String msg) {
        return new ApiResult(ApiCode.NOT_FOUND, msg);
    }

}
