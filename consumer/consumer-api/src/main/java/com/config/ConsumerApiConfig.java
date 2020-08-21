package com.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.youzi.common.constant.ApiConstant;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 设置默认使用fastjson消息转换器
 * @author: zhuqi
 * @date: 2020年07月31日 16:04
 */
@Configuration
public class ConsumerApiConfig {

    /**
     * @description: 跨域过滤器
     * @author zhuqi
     * @date 2020-08-21
     */
	@Bean
    public FilterRegistrationBean<CorsFilter> corsFilterRegistrationBean() {
    	CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.setAllowedOrigins(Arrays.asList(ApiConstant.PAGE_DEV_ORIGIN));
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        // 设置跨域缓存时间为30分钟
        config.setMaxAge(1800L);
        // 注册CORS过滤器
        UrlBasedCorsConfigurationSource configurationSource = new UrlBasedCorsConfigurationSource();
        configurationSource.registerCorsConfiguration("/**", config);
        CorsFilter corsFilter = new CorsFilter(configurationSource);
        FilterRegistrationBean<CorsFilter> CorsBean = new FilterRegistrationBean<>(corsFilter);
        CorsBean.setOrder(0);//设置过滤器优先级最高
        return CorsBean;
    }

    /**
     * @description: 配置默认fastjson转换器
     * @author zhuqi
     * @date 2020-08-21
     */
    @Bean
    public HttpMessageConverters customConverters() {
        List<HttpMessageConverter<?>> converters = new ArrayList<>();
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.WriteEnumUsingToString, //用枚举toString()值输出
                SerializerFeature.WriteMapNullValue, //是否输出值为null的字段,默认为false
                SerializerFeature.WriteNullNumberAsZero, //数值字段如果为null,输出为0,而非null
                SerializerFeature.WriteNullListAsEmpty, //List字段如果为null,输出为[],而非null
                SerializerFeature.WriteNullStringAsEmpty, //字符类型字段如果为null,输出为"",而非null
                SerializerFeature.WriteNullBooleanAsFalse, //Boolean字段如果为null,输出为false,而非null
                SerializerFeature.DisableCircularReferenceDetect, //循环引用
                SerializerFeature.PrettyFormat, //格式化输出
                SerializerFeature.WriteDateUseDateFormat //格式化日期(默认是毫秒值)
        );
        //fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
        fastJsonConfig.setCharset(StandardCharsets.UTF_8);
        fastConverter.setFastJsonConfig(fastJsonConfig);
        fastConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON));
        converters.add(fastConverter);
        return new HttpMessageConverters(true, converters);
    }

}
