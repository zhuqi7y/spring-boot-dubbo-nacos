package com.youzi.modules.sys.controller;

import com.youzi.common.api.ApiResult;
import com.youzi.common.constant.DubboConstant;
import com.youzi.common.controller.api.BaseSysApiController;
import com.youzi.modules.sys.entity.SysUser;
import com.youzi.modules.sys.query.SysLoginQuery;
import com.youzi.modules.sys.service.SysLoginService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: TODO
 * @author: zhuqi
 * @date: 2020年07月23日 9:30
 */
@RestController
@RequestMapping("/api/sys/")
public class SysLoginController extends BaseSysApiController {

    @DubboReference(version = DubboConstant.VERSION, group = DubboConstant.GROUP)
    private SysLoginService sysLoginService;

    /**
    * @Description: 账号或手机号，密码，验证码登录
    * @author: zhuqi
    * @date: 2020/7/23 9:44
    * @param sysLoginQuery:
    * @Return: com.youzi.common.api.ApiResult<com.youzi.modules.sys.vo.SysLoginVo>
    */
    @RequestMapping("login")
    public ApiResult login(@Validated SysLoginQuery sysLoginQuery) {
        String loginName = sysLoginQuery.getLoginName();
        if(sysLoginService.isLoginNameOrPhoneExisted(loginName)) {
            SysUser sysUser = sysLoginService.selectByLoginName(loginName);
            session.setAttribute("sysUser", sysUser);
            return ApiResult.success().body(sysUser);
        }
        return ApiResult.fail();
    }

}
