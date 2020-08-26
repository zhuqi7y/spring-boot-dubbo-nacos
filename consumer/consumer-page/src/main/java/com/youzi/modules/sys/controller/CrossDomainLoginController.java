package com.youzi.modules.sys.controller;

import cn.hutool.core.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: TODO
 * @author: zhuqi
 * @date: 2020年08月25日 14:46
 */
@RestController
@RequestMapping("/cross")
public class CrossDomainLoginController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;

    @RequestMapping("/page1")
    public void page1(String token) {
        if(StrUtil.isNotBlank(token)) {
            Cookie cookie = new Cookie("token", token);
            cookie.setDomain("page1.com");
            cookie.setPath("/");
            response.addCookie(cookie);
        }
    }

    @RequestMapping("/page2")
    public void page2(String token) {
        if(StrUtil.isNotBlank(token)) {
            Cookie cookie = new Cookie("token", token);
            cookie.setDomain("page2.com");
            cookie.setPath("/");
            response.addCookie(cookie);
        }
    }

    @RequestMapping("/page3")
    public void page3(String token) {
        if(StrUtil.isNotBlank(token)) {
            Cookie cookie = new Cookie("token", token);
            cookie.setDomain("page3.com");
            cookie.setPath("/");
            response.addCookie(cookie);
        }
    }

}
