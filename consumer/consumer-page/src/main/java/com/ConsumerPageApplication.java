package com;

import com.alibaba.boot.nacos.config.autoconfigure.NacosConfigAutoConfiguration;
import org.apache.dubbo.spring.boot.autoconfigure.DubboAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, DubboAutoConfiguration.class, NacosConfigAutoConfiguration.class})
public class ConsumerPageApplication /*extends SpringBootServletInitializer*/ {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerPageApplication.class, args);
    }

    /*@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBootDubboNacosApplication.class);
    }*/

    /**
     * @description: 通用错误页面
     */
    @RequestMapping("/401")
    public String error401Page() {
        return "401";
    }
    @RequestMapping("/404")
    public String error404Page() {
        return "404";
    }
    @RequestMapping("/500")
    public String error500Page() {
        return "500";
    }

}
