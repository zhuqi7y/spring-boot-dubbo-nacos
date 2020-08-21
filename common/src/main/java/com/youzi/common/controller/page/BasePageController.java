package com.youzi.common.controller.page;

import cn.hutool.core.util.StrUtil;
import com.youzi.common.constant.ApiConstant;
import com.youzi.common.controller.BaseController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * @Description: 通用page超类BasePageController
 * @author: zhuqi
 * @date: 2020年07月22日 14:57
 */
public abstract class BasePageController extends BaseController {

    @ModelAttribute
    public void setCommonModel(Model model) {
        if(StrUtil.equals(env, "dev")) {
            model.addAttribute("apiPath", ApiConstant.API_DEV_PATH);
        }
    }

}
