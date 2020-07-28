package com.youzi.modules.sys.controller;

import com.youzi.common.controller.api.BaseSysApiController;
import com.youzi.modules.sys.entity.SysUser;
import com.youzi.modules.sys.query.SysLoginQuery;
import com.youzi.modules.sys.service.SysLoginService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: TODO
 * @author: zhuqi
 * @date: 2020年07月23日 9:30
 */
@Controller
@RequestMapping("/sys/")
public class SysLoginController extends BaseSysApiController {

    @DubboReference
    private SysLoginService sysLoginService;

    @RequestMapping("login")
    public String login() {
        return "sys/login";
    }

    /**
    * @Description: 账号或手机号，密码，验证码登录
    * @author: zhuqi
    * @date: 2020/7/23 9:44
    * @param sysLoginQuery:
    * @Return: com.youzi.common.api.ApiResult<com.youzi.modules.sys.vo.SysLoginVo>
    */
    @RequestMapping("doLogin")
    public String doLogin(@Validated SysLoginQuery sysLoginQuery) {
        String loginName = sysLoginQuery.getLoginName();
        if(sysLoginService.isLoginNameOrPhoneExisted(loginName)) {
            SysUser sysUser = sysLoginService.selectByLoginName(loginName);
            session.setAttribute("sysUser", sysUser);
            return "sys/index";
        }
        return "fail";
    }

}
