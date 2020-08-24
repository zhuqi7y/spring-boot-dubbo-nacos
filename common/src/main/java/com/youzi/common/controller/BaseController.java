package com.youzi.common.controller;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.youzi.common.constant.JwtConstant;
import com.youzi.common.constant.SessionConstant;
import com.youzi.common.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

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

    /**
     * @description: 判断是否登录
     */
    protected boolean isLogin(String token) {
        try {
            if(StrUtil.isNotBlank(token)) {
                Integer userId = Convert.toInt(JWT.decode(token).getAudience().get(0));
                if(userId != null && userId != 0) {
                    DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256(JwtConstant.SECRET+userId)).build().verify(token);
                    if(decodedJWT.getExpiresAt().after(new Date())) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return false;
    }

    protected boolean isLogin() {
        String token = request.getHeader("token");
        return isLogin(token);
    }

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
