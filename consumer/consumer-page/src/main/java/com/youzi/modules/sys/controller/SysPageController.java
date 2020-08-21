package com.youzi.modules.sys.controller;

import com.youzi.common.controller.page.BaseSysPageController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: TODO
 * @author: zhuqi
 * @date: 2020年07月23日 9:30
 */
@Controller
@RequestMapping("/sys")
public class SysPageController extends BaseSysPageController {

    /**
     * @description: 首页
     */
    @RequestMapping("/index")
    public String index() {
        return "sys/index";
    }

    /**
     * @description: 欢迎页-1
     */
    @RequestMapping("/welcome1")
    public String welcome1() {
        return "sys/welcome-1";
    }

}
