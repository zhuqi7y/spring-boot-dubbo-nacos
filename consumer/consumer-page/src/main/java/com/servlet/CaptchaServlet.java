package com.servlet;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;

/**
 * @Description: TODO
 * @author: zhuqi
 * @date: 2020年08月21日 15:59
 */
@WebServlet(name = "captchaServlet", urlPatterns = "/captcha")
public class CaptchaServlet extends HttpServlet {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LineCaptcha captcha = CaptchaUtil.createLineCaptcha(110, 40);
        captcha.createCode();
        String uuid = IdUtil.simpleUUID();
        stringRedisTemplate.opsForValue().set(uuid, captcha.getCode(), 3, TimeUnit.MINUTES);
        Cookie cookie = new Cookie("captcha", uuid);
        cookie.setPath("/");
        resp.addCookie(cookie);
        OutputStream out = resp.getOutputStream();
        captcha.write(out);
        out.flush();
        out.close();
    }

}
