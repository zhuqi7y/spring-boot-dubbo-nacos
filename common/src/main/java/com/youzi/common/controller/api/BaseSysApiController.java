package com.youzi.common.controller.api;

import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * @Description: TODO
 * @author: zhuqi
 * @date: 2020年07月22日 15:46
 */
public abstract class BaseSysApiController extends BaseApiController {

    /**
    * @Description: 所有请求之前判断是否登录
    * @author: zhuqi
    * @date: 2020/7/22 15:51
    * @Return: void
    */
    @ModelAttribute
    public final void checkSysUserLogin() {
    }
}
