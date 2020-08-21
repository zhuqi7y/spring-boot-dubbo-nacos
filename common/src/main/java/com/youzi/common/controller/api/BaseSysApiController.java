package com.youzi.common.controller.api;

import com.youzi.common.api.ApiEnum;
import com.youzi.common.constant.SessionConstant;
import com.youzi.common.exception.CustomException;
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
    public final void beforeAllRequestCheck() {
        if(getSysUserid() != null && getSysUserid() == 0) {
            throw new CustomException(ApiEnum.UNAUTHORIZED);
        }
    }

    public Integer getSysUserid() {
        return (Integer) session.getAttribute(SessionConstant.LOGIN_CODE);
    }

}
