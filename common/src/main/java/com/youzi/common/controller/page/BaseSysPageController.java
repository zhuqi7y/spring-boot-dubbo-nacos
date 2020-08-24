package com.youzi.common.controller.page;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.io.IOException;

/**
 * @Description: TODO
 * @author: zhuqi
 * @date: 2020年08月18日 17:17
 */
public abstract class BaseSysPageController extends BasePageController {

    private Logger logger = LoggerFactory.getLogger(BaseSysPageController.class);

    @ModelAttribute
    public final void beforeAllRequestCheck(Model model) throws IOException {
        /*String token = (String) session.getAttribute("token");
        if(!isLogin(token)) {
            response.sendRedirect("sys/login");
        }
        model.addAttribute("token", token);*/
    }

}
