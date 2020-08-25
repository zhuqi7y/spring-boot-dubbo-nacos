package com.youzi.modules.sys.service;

import com.youzi.modules.sys.entity.SysUser;

/**
 * @Description: TODO
 * @author: zhuqi
 * @date: 2020年07月22日 14:20
 */
public interface SysUserService {

    /**
    * @Description: 判断id是否存在
    * @author: zhuqi
    * @date: 2020/8/25 9:37
    * @param id:
    * @Return: boolean
    */
    boolean existById(Integer id);

    /**
    * @Description: 根据id获取SysUser
    * @author: zhuqi
    * @date: 2020/8/25 9:37
    * @param id:
    * @Return: com.youzi.modules.sys.entity.SysUser
    */
    SysUser selectById(Integer id);

}
