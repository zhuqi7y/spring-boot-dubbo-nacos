package com.youzi.modules.sys.controller;

import com.youzi.common.controller.api.BaseSysApiController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: TODO
 * @author: zhuqi
 * @date: 2020年07月23日 9:30
 */
@Controller
@RequestMapping("/sys/")
public class SysPageController extends BaseSysApiController {

    @RequestMapping("login")
    public String login() {
        return "sys/login";
    }

}
