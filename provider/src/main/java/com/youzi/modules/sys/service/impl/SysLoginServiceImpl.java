package com.youzi.modules.sys.service.impl;

import com.youzi.modules.sys.entity.SysUser;
import com.youzi.modules.sys.mapper.SysLoginMapper;
import com.youzi.modules.sys.service.SysLoginService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: TODO
 * @author: zhuqi
 * @date: 2020年07月23日 9:26
 */
@DubboService(version = "${dubbo.provider.version}", group = "${dubbo.provider.group}")
public class SysLoginServiceImpl implements SysLoginService {

    @Autowired
    private SysLoginMapper sysLoginMapper;

    /**
     * @Description: 检查用户名或者手机号是否存在
     * @author: zhuqi
     * @date: 2020/7/22 14:31
     * @param loginName:
     * @Return: boolean
     */
    public boolean isLoginNameOrPhoneExisted(String loginName) {
        return sysLoginMapper.isLoginNameOrPhoneExisted(loginName);
    }

    /**
     * @Description: 根据用户名或手机号获取对象
     * @author: zhuqi
     * @date: 2020/7/22 14:33
     * @param loginName:
     * @Return: com.youzi.modules.sys.entity.SysUser
     */
    public SysUser selectByLoginName(String loginName) {
        return sysLoginMapper.selectByLoginName(loginName);
    }

}
