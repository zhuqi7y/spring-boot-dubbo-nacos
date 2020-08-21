package com.youzi.modules.sys.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.youzi.common.api.ApiResult;
import com.youzi.common.constant.DubboConstant;
import com.youzi.common.constant.SessionConstant;
import com.youzi.common.controller.api.BaseApiController;
import com.youzi.modules.sys.entity.SysUser;
import com.youzi.modules.sys.query.SysLoginQuery;
import com.youzi.modules.sys.service.SysLoginService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: TODO
 * @author: zhuqi
 * @date: 2020年07月23日 9:30
 */
@RestController
@RequestMapping("/sysLogin")
public class SysLoginController extends BaseApiController {

    @DubboReference(version = DubboConstant.VERSION, group = DubboConstant.GROUP)
    private SysLoginService sysLoginService;

    /**
    * @Description: 账号或手机号，密码，验证码登录
    * @author: zhuqi
    * @date: 2020/7/23 9:44
    * @param sysLoginQuery:
    * @Return: com.youzi.common.api.ApiResult<com.youzi.modules.sys.vo.SysLoginVo>
    */
    @PostMapping("/login")
    public ApiResult login(@Validated SysLoginQuery sysLoginQuery) {
        validCaptcha(sysLoginQuery.getCaptcha()); //校验验证码
        String loginName = sysLoginQuery.getLoginName();
        if(!sysLoginService.isLoginNameOrPhoneExisted(loginName)) {
            return ApiResult.badRequest().msg("登录名或手机号不存在");
        }
        SysUser sysUser = sysLoginService.selectByLoginName(loginName);
        if(!StrUtil.equals(SecureUtil.md5(sysLoginQuery.getPassword()), sysUser.getPassword())) {
            return ApiResult.badRequest().msg("登录名或手机号或密码错误");
        }
        session.setAttribute(SessionConstant.LOGIN_CODE, sysUser.getId());
        return ApiResult.success().msg("登录成功").body(null);
    }

    /**
    * @Description: 退出登录
    * @author: zhuqi
    * @date: 2020/8/20 16:58
    * @Return: com.youzi.common.api.ApiResult
    */
    @RequestMapping("/loginoff")
    public ApiResult loginoff() {
        session.removeAttribute(SessionConstant.LOGIN_CODE);
        return ApiResult.success().msg("退出登录成功");
    }

    /**
    * @Description: 判断是否登录
    * @author: zhuqi
    * @date: 2020/8/21 11:32
    * @Return: com.youzi.common.api.ApiResult
    */
    @RequestMapping("/isLogin")
    public ApiResult isLogin() {
        Integer userid = (Integer) session.getAttribute(SessionConstant.LOGIN_CODE);
        return ApiResult.success().body(userid != null && userid != 0);
    }

}
