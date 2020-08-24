package com.youzi.modules.sys.controller;

import com.alibaba.fastjson.JSONObject;
import com.youzi.common.api.ApiResult;
import com.youzi.common.constant.DubboConstant;
import com.youzi.common.controller.api.BaseApiController;
import com.youzi.modules.sys.service.SysInfoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: TODO
 * @author: zhuqi
 * @date: 2020年08月20日 11:00
 */
@RestController
@RequestMapping("/sysInfo")
public class SysInfoController extends BaseApiController {

    @DubboReference(version = DubboConstant.VERSION, group = DubboConstant.GROUP)
    private SysInfoService sysInfoService;

    @RequestMapping("/init")
    public JSONObject init() {
        return sysInfoService.init();
    }

    @RequestMapping("/clear")
    public ApiResult clear() {
        return new ApiResult(1, "服务端清理缓存成功");
    }

}
