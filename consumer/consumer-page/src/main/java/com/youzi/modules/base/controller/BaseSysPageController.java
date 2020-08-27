package com.youzi.modules.base.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.youzi.common.controller.BaseController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * @Description: TODO
 * @author: zhuqi
 * @date: 2020年08月25日 10:23
 */
public abstract class BaseSysPageController extends BaseController {

    @NacosValue(value = "${api.path}", autoRefreshed = true)
    private String apiPath;

    @ModelAttribute
    public void setCommonModel(Model model) {
        model.addAttribute("apiPath", apiPath);
    }

}
