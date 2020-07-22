package com.youzi.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
}
