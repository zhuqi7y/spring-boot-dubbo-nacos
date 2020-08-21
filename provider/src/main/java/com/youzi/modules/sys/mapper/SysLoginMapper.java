package com.youzi.modules.sys.mapper;

import com.youzi.modules.sys.entity.SysUser;

/**
 * @Description: TODO
 * @author: zhuqi
 * @date: 2020年07月22日 17:17
 */
public interface SysLoginMapper {

    /**
     * @Description: 检查用户名或者手机号是否存在
     * @author: zhuqi
     * @date: 2020/7/22 14:31
     * @param loginName:
     * @Return: boolean
     */
    Boolean isLoginNameOrPhoneExisted(String loginName);

    /**
     * @Description: 根据用户名或手机号获取对象
     * @author: zhuqi
     * @date: 2020/7/22 14:33
     * @param loginName:
     * @Return: com.youzi.modules.sys.entity.SysUser
     */
    SysUser selectByLoginName(String loginName);

}
