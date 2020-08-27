package com.youzi.common.api;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageInfo;

/**
 * @Description: 通用api返回json结果
 * @author: zhuqi
 * @date: 2020年07月22日 15:16
 */
public class ApiResult {
    private int code;
    private String msg;
    private Object body;

    public ApiResult() {}

    public ApiResult(IApiCode apiCode) {
        this.code = apiCode.getCode();
        this.msg = apiCode.getMsg();
        this.body = null;
    }

    public ApiResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public static ApiResult success() { return new ApiResult(ApiEnum.SUCCESS); }
    public static ApiResult fail() { return new ApiResult(ApiEnum.FAIL); }
    public static ApiResult badRequest() { return new ApiResult(ApiEnum.BAD_REQUEST); }
    public static ApiResult forbidden() { return new ApiResult(ApiEnum.FORBIDDEN); }
    public static ApiResult notFound() { return new ApiResult(ApiEnum.NOT_FOUND); }
    public static ApiResult unauthorized() { return new ApiResult(ApiEnum.UNAUTHORIZED); }

    public ApiResult msg(String msg) {
        if(StrUtil.isNotBlank(msg)) {
            this.msg = msg;
        }
        return this;
    }

    public ApiResult body(Object body) {
        this.body = body;
        return this;
    }

    public <T> ApiResult page(PageInfo<T> pageInfo) {
        ApiPage<T> apiPage = new ApiPage<>();
        apiPage.setPageNum(pageInfo.getPageNum());
        apiPage.setPageSize(pageInfo.getPageSize());
        apiPage.setPages(pageInfo.getPages());
        apiPage.setTotal(pageInfo.getTotal());
        apiPage.setList(pageInfo.getList());
        this.body = apiPage;
        return this;
    }
}
