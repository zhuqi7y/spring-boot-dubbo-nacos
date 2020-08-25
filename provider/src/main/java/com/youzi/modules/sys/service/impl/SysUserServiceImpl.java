package com.youzi.modules.sys.service.impl;

import com.youzi.common.constant.DubboConstant;
import com.youzi.modules.sys.entity.SysUser;
import com.youzi.modules.sys.mapper.SysUserMapper;
import com.youzi.modules.sys.service.SysUserService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: TODO
 * @author: zhuqi
 * @date: 2020年08月25日 9:29
 */
@DubboService(version = DubboConstant.VERSION, group = DubboConstant.GROUP)
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     * @Description: 判断id是否存在
     * @author: zhuqi
     * @date: 2020/8/25 9:37
     * @param id:
     * @Return: boolean
     */
    public boolean existById(Integer id) {
        return sysUserMapper.existById(id);
    }

    /**
     * @Description: 根据id获取SysUser
     * @author: zhuqi
     * @date: 2020/8/25 9:37
     * @param id:
     * @Return: com.youzi.modules.sys.entity.SysUser
     */
    public SysUser selectById(Integer id) {
        return sysUserMapper.selectById(id);
    }

}
