package com.servlet;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.youzi.common.constant.SessionConstant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @Description: TODO
 * @author: zhuqi
 * @date: 2020年08月21日 15:59
 */
@WebServlet(name = "captchaServlet", urlPatterns = "/captcha")
public class CaptchaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LineCaptcha captcha = CaptchaUtil.createLineCaptcha(110, 40);
        captcha.createCode();
        req.getSession().setAttribute(SessionConstant.CAPTCHA, captcha.getCode());
        OutputStream out = resp.getOutputStream();
        captcha.write(out);
        out.flush();
        out.close();
    }

}
