package com.youzi.common.controller.api;

import cn.hutool.core.convert.Convert;
import com.auth0.jwt.JWT;
import com.youzi.common.api.ApiEnum;
import com.youzi.common.exception.CustomException;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

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
    public final void beforeAllRequestCheck(HttpServletRequest request) {
        String token = Optional.ofNullable(request).map(r -> r.getHeader("token")).orElse("");
        if(!isLogin(token)) {
            throw new CustomException(ApiEnum.UNAUTHORIZED);
        }
    }

    public Integer getSysUserid() {
        String token = request.getHeader("token");
        return Convert.toInt(JWT.decode(token).getAudience().get(0), 0);
    }

}
