package com.youzi.common.api;

/**
 * @Description: 通用api返回json结果
 * @author: zhuqi
 * @date: 2020年07月22日 15:16
 */
public class ApiResult<T> {
    private int code;
    private String msg;
    private T data;



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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
