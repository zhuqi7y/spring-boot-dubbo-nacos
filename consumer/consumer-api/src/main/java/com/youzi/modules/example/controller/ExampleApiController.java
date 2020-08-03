package com.youzi.modules.example.controller;

import cn.hutool.core.map.MapUtil;
import com.github.pagehelper.PageInfo;
import com.youzi.common.api.ApiResult;
import com.youzi.common.constant.DubboConstant;
import com.youzi.common.controller.api.BaseApiController;
import com.youzi.common.query.DeleteQuery;
import com.youzi.modules.example.entity.Example;
import com.youzi.modules.example.query.ExampleQuery;
import com.youzi.modules.example.service.ExampleService;
import com.youzi.modules.example.vo.ExampleVo;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * @Description: TODO
 * @author: zhuqi
 * @date: 2020年07月22日 11:40
 */
@RestController
@RequestMapping("/example/")
public class ExampleApiController extends BaseApiController {

    @DubboReference(version = DubboConstant.VERSION, group = DubboConstant.GROUP)
    private ExampleService exampleService;

    @PostMapping("add")
    public ApiResult add(@Validated Example example) {
        Long id = exampleService.addAndGetId(example);
        return id == null ? ApiResult.fail().msg("添加失败")
                : ApiResult.success().msg("添加成功").body(MapUtil.builder().put("id", id).build());
    }

    @PostMapping("update")
    public ApiResult update(@Validated Example example) {
        int row = exampleService.update(example);
        return row > 0 ? ApiResult.success().msg("更新成功") : ApiResult.fail().msg("更新失败");
    }

    @PostMapping("delete")
    public ApiResult delete(@Validated DeleteQuery deleteQuery) {
        int row = exampleService.delete(deleteQuery);
        return row > 0 ? ApiResult.success().msg("更新成功") : ApiResult.fail().msg("更新失败");
    }

    @RequestMapping("detail")
    public ApiResult detail(@NotNull Long id) {
        ExampleVo exampleVo = exampleService.selectById(id);
        return ApiResult.success().msg("获取详情成功").body(exampleVo);
    }

    @RequestMapping("list")
    public ApiResult list(ExampleQuery exampleQuery) {
        PageInfo<ExampleVo> pageInfo = exampleService.selectPage(exampleQuery);
        return ApiResult.success().msg("获取分页成功").page(pageInfo);
    }

}
