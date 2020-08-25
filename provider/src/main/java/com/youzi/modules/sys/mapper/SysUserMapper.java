package com.youzi.modules.sys.mapper;

import com.youzi.modules.sys.entity.SysUser;

/**
 * @Description: TODO
 * @author: zhuqi
 * @date: 2020年08月25日 9:31
 */
public interface SysUserMapper {

    Boolean existById(Integer id);

    SysUser selectById(Integer id);

}
