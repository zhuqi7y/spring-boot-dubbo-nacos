package com;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@NacosPropertySource(dataId = "${spring.application.name}", autoRefreshed = true)
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ConsumerThymleafApplication /*extends SpringBootServletInitializer*/ {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerThymleafApplication.class, args);
    }

    /*@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBootDubboNacosApplication.class);
    }*/

}
