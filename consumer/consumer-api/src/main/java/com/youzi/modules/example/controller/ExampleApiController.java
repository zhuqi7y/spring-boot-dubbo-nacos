package com.youzi.modules.example.controller;

import cn.hutool.core.map.MapUtil;
import com.github.pagehelper.PageInfo;
import com.youzi.common.api.ApiResult;
import com.youzi.common.constant.DubboConstant;
import com.youzi.common.query.DeleteQuery;
import com.youzi.common.query.DetailQuery;
import com.youzi.modules.base.controller.BaseSysApiController;
import com.youzi.modules.example.entity.Example;
import com.youzi.modules.example.query.ExampleQuery;
import com.youzi.modules.example.service.ExampleService;
import com.youzi.modules.example.vo.ExampleVo;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: TODO
 * @author: zhuqi
 * @date: 2020年07月22日 11:40
 */
@RestController
@RequestMapping("/example")
public class ExampleApiController extends BaseSysApiController {

    @DubboReference(version = DubboConstant.VERSION, group = DubboConstant.GROUP)
    private ExampleService exampleService;

    @PostMapping("/add")
    public ApiResult add(@Validated @RequestBody Example example) {
        Integer id = exampleService.addAndGetId(example);
        return id == null ? ApiResult.fail().msg("添加失败")
                : ApiResult.success().msg("添加成功").body(MapUtil.builder().put("id", id).build());
    }

    @PostMapping("/update")
    public ApiResult update(@Validated @RequestBody Example example) {
        if(example.getId() == null || example.getId() == 0) {
            return ApiResult.badRequest().msg("id不能为空");
        }
        int row = exampleService.update(example);
        return row > 0 ? ApiResult.success().msg("更新成功") : ApiResult.fail().msg("更新失败");
    }

    @PostMapping("/delete")
    public ApiResult delete(@Validated @RequestBody DeleteQuery deleteQuery) {
        deleteQuery.setDeleteSysUserid(getSysUserid());
        int row = exampleService.delete(deleteQuery);
        return row > 0 ? ApiResult.success().msg("删除成功") : ApiResult.fail().msg("删除失败");
    }

    @RequestMapping("/detail")
    public ApiResult detail(@Validated @RequestBody DetailQuery detailQuery) {
        if(!exampleService.existById(detailQuery.getId())) {
            return ApiResult.badRequest().msg("记录不存在");
        }
        ExampleVo exampleVo = exampleService.selectById(detailQuery.getId());
        return ApiResult.success().msg("获取详情成功").body(exampleVo);
    }

    @RequestMapping("/list")
    public ApiResult list(@RequestBody ExampleQuery exampleQuery) {
        PageInfo<ExampleVo> pageInfo = exampleService.selectPage(exampleQuery);
        return ApiResult.success().msg("获取分页成功").page(pageInfo);
    }

}
