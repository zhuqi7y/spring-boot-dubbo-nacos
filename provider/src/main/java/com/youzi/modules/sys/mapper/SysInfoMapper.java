package com.youzi.modules.sys.mapper;

import com.youzi.modules.sys.entity.SysInfo;
import com.youzi.modules.sys.vo.SysInfoVo;

import java.util.List;

/**
 * @Description: TODO
 * @author: zhuqi
 * @date: 2020年08月20日 9:20
 */
public interface SysInfoMapper {

    /**
    * @Description: TODO
    * @author: zhuqi
    * @date: 2020/8/20 10:30
    * @Return: com.youzi.modules.sys.entity.SysInfo
    */
    SysInfoVo selectOneByType(Integer type);

    /**
    * @Description: TODO
    * @author: zhuqi
    * @date: 2020/8/20 10:41
    * @param parent:
    * @Return: java.util.List<com.youzi.modules.sys.entity.SysInfo>
    */
    List<SysInfo> selectAllMenuByParent(Integer parent);

    /**
    * @Description: TODO
    * @author: zhuqi
    * @date: 2020/8/20 10:45
    * @param parent:
    * @Return: java.lang.Boolean
    */
    Boolean existChildByParent(Integer parent);

}
