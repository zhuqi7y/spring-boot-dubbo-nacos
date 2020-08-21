package com.youzi.common.api;

/**
 * @Description: TODO
 * @author: zhuqi
 * @date: 2020年07月22日 15:20
 */
public enum ApiEnum implements IApiCode {

    SUCCESS(200,"成功"),
    BAD_REQUEST(400, "请求参数有误"),
    UNAUTHORIZED(401, "未进行身份验证或验证已过期"),
    FORBIDDEN(403,"访问受限，授权过期"),
    NOT_FOUND(404,"接口地址错误"),
    FAIL(500,"失败");

    private Integer code;
    private String msg;

    ApiEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
