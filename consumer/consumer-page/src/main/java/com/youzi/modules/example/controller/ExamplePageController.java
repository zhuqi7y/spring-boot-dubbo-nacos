package com.youzi.modules.example.controller;

import com.youzi.modules.base.controller.BaseSysPageController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: TODO
 * @author: zhuqi
 * @date: 2020年07月22日 11:40
 */
@Controller
@RequestMapping("/example")
public class ExamplePageController extends BaseSysPageController {

    @RequestMapping("/list")
    public String list() {
        return "example/list";
    }

    @RequestMapping("/add")
    public String add() {
        return "example/add";
    }

    @RequestMapping("/update")
    public String update() {
        return "example/update";
    }

}
