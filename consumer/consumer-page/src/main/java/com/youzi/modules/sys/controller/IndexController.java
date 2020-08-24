package com.youzi.modules.sys.controller;

import com.youzi.common.controller.page.BasePageController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: TODO
 * @author: zhuqi
 * @date: 2020年08月21日 16:19
 */
@Controller
public class IndexController extends BasePageController {

    /**
     * @description: 主页
     */
    @RequestMapping("/")
    public String index() {
        return "sys/index";
    }

    /**
     * @description: 通用错误页面
     */
    @RequestMapping("/401")
    public String error401Page() {
        return "401";
    }
    @RequestMapping("/404")
    public String error404Page() {
        return "404";
    }
    @RequestMapping("/500")
    public String error500Page() {
        return "500";
    }

}
