package com.youzi.modules.sys.controller;

import com.youzi.common.controller.page.BasePageController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: TODO
 * @author: zhuqi
 * @date: 2020年07月23日 9:30
 */
@Controller
@RequestMapping("/sys")
public class SysPageController extends BasePageController {

    /**
     * @description: 首页
     */
    @RequestMapping("/index")
    public String index() {
        return "sys/index";
    }

    /**
     * @description: 登录页
     */
    @RequestMapping("/login")
    public String login() {
        return "sys/login";
    }

    @RequestMapping("/login1")
    public String login1() {
        return "sys/login-1";
    }
    @RequestMapping("/login2")
    public String login2() {
        return "sys/login-2";
    }
    @RequestMapping("/login3")
    public String login3() {
        return "sys/login-3";
    }

    /**
     * @description: 欢迎页
     */
    @RequestMapping("/welcome")
    public String welcome() {
        return "sys/welcome-2";
    }

}
