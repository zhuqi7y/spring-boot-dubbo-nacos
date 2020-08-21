package com.youzi.modules.sys.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.youzi.common.constant.DubboConstant;
import com.youzi.modules.sys.enums.SysInfoEnum;
import com.youzi.modules.sys.mapper.SysInfoMapper;
import com.youzi.modules.sys.service.SysInfoService;
import com.youzi.modules.sys.vo.SysInfoVo;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: TODO
 * @author: zhuqi
 * @date: 2020年08月20日 9:19
 */
@DubboService(version = DubboConstant.VERSION, group = DubboConstant.GROUP)
public class SysInfoServiceImpl implements SysInfoService {

    @Autowired
    private SysInfoMapper sysInfoMapper;

    /**
     * @Description: 获取导航菜单信息json
     * @author: zhuqi
     * @date: 2020/8/20 9:19
     * @Return: com.alibaba.fastjson.JSONObject
     */
    public JSONObject init() {
        JSONObject result = new JSONObject();
        result.put(SysInfoEnum.getNameByType(1), sysInfoMapper.selectOneByType(1));
        result.put(SysInfoEnum.getNameByType(2), sysInfoMapper.selectOneByType(2));
        result.put(SysInfoEnum.getNameByType(3), JSONArray.parseArray(JSON.toJSONString(getMenuList(0))));
        return result;
    }

    private List<SysInfoVo> getMenuList(Integer parent) {
        return parent == null ? new ArrayList<>() : sysInfoMapper.selectAllMenuByParent(parent).stream()
                .map(sysInfo -> new SysInfoVo(){{
                    setTitle(sysInfo.getTitle());
                    setHref(sysInfo.getHref());
                    setIcon(sysInfo.getIcon());
                    setImage(sysInfo.getImage());
                    setTarget(sysInfo.getTarget());
                    if(sysInfoMapper.existChildByParent(sysInfo.getId())) {
                        setChild(getMenuList(sysInfo.getId()));
                    }
                }}).collect(Collectors.toList());
    }

}
