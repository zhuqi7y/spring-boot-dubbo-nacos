package com.youzi.common.exception;

import cn.hutool.core.util.StrUtil;
import com.youzi.common.api.ApiEnum;
import com.youzi.common.api.ApiResult;
import com.youzi.common.api.IApiCode;

/**
 * @Description: TODO
 * @author: zhuqi
 * @date: 2020年08月20日 15:05
 */
public class CustomException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private int code;
    private String msg;

    public CustomException(IApiCode apiCode) {
        this.code = apiCode.getCode();
        this.msg = apiCode.getMsg();
    }

    public CustomException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static void back(IApiCode apiCode) {
        throw new CustomException(apiCode);
    }

    public static void back(int code, String msg) {
        throw new CustomException(code, msg);
    }

    public static void back(ApiResult apiResult) {
        throw new CustomException(apiResult.getCode(), apiResult.getMsg());
    }

    public static void badRequest(String msg) {
        throw new CustomException(ApiEnum.BAD_REQUEST.getCode(), StrUtil.blankToDefault(msg, ApiEnum.BAD_REQUEST.getMsg()));
    }

    public static void unauthorized() {
        back(ApiResult.unauthorized());
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
}
