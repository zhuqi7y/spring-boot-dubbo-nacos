package com.youzi.common.controller;

import cn.hutool.core.util.StrUtil;
import com.youzi.common.constant.SessionConstant;
import com.youzi.common.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Description: 通用超类BaseController
 * @author: zhuqi
 * @date: 2020年07月22日 14:58
 */
public abstract class BaseController {
    @Autowired
    public HttpServletRequest request;
    @Autowired
    public HttpServletResponse response;
    @Autowired
    public HttpSession session;
    @Autowired
    public ApplicationContext applicationContext;

    @Value("${spring.profiles.active}")
    public String env;

    protected void validCaptcha(String captcha) {
        if(StrUtil.isBlank(captcha)) {
            CustomException.badRequest("验证码不能为空");
        }
        String captchaSes = (String) session.getAttribute(SessionConstant.CAPTCHA);
        if(StrUtil.isBlank(captchaSes)) {
            CustomException.badRequest("验证码过期");
        }
        if(!captcha.toLowerCase().equals(captchaSes.toLowerCase())) {
            session.removeAttribute(SessionConstant.CAPTCHA);
            CustomException.badRequest("验证码错误");
        }
        session.removeAttribute(SessionConstant.CAPTCHA);
    }

}
