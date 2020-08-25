package com.youzi.modules.base.controller;

import cn.hutool.core.util.StrUtil;
import com.youzi.common.constant.ApiConstant;
import com.youzi.common.controller.BaseController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * @Description: TODO
 * @author: zhuqi
 * @date: 2020年08月25日 10:23
 */
public abstract class BaseSysPageController extends BaseController {

    @ModelAttribute
    public void setCommonModel(Model model) {
        if(StrUtil.equals(env, "dev")) {
            model.addAttribute("apiPath", ApiConstant.API_DEV_PATH);
        }
    }


}
