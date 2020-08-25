package com.youzi.modules.base.controller;

import com.youzi.common.api.ApiEnum;
import com.youzi.common.exception.CustomException;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * @Description: TODO
 * @author: zhuqi
 * @date: 2020年08月25日 9:26
 */
public abstract class BaseSysApiController extends BaseApiController {

    /**
     * @Description: 所有请求之前判断是否登录
     * @author: zhuqi
     * @date: 2020/7/22 15:51
     * @Return: void
     */
    @ModelAttribute
    public final void beforeAllRequestCheck(HttpServletRequest request) {
        String token = Optional.ofNullable(request).map(r -> r.getHeader("token")).orElse("");
        if(!isLogin(token)) {
            throw new CustomException(ApiEnum.UNAUTHORIZED);
        }
    }

}
