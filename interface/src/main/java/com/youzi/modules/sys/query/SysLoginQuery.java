package com.youzi.modules.sys.query;

import javax.validation.constraints.NotBlank;

/**
 * @Description: 用户登录查询对象
 * @author: zhuqi
 * @date: 2020年07月22日 14:20
 */
public class SysLoginQuery {
    @NotBlank(message="登录名或手机号不能为空")
    private String loginName;
    @NotBlank(message="密码不能为空")
    private String password;
    @NotBlank(message="验证码不能为空")
    private String captcha;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
}
