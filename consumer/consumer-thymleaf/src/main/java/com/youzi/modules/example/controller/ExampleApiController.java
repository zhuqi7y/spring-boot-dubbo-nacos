package com.youzi.modules.example.controller;

import com.youzi.common.controller.api.BaseApiController;
import com.youzi.modules.example.service.ExampleService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * @Description: TODO
 * @author: zhuqi
 * @date: 2020年07月22日 11:40
 */
@RestController
@RequestMapping("/api/example/")
public class ExampleApiController extends BaseApiController {

    @DubboReference
    private ExampleService exampleService;

    @RequestMapping("detail")
    public void detail(@NotNull Long id) {
        exampleService.selectById(id);
    }

}
