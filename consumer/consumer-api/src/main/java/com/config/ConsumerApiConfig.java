package com.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: TODO
 * @author: zhuqi
 * @date: 2020年07月31日 16:04
 */
@Configuration
public class ConsumerApiConfig implements WebMvcConfigurer {

    /**
     * @Description: fastjson配置序列化属性
     */
    public static final SerializerFeature[] serializerFeatures = {
            //SerializerFeature.SortField, //按字段名称排序后输出，默认为false
            SerializerFeature.WriteEnumUsingToString, //用枚举toString()值输出
            SerializerFeature.WriteMapNullValue, //是否输出值为null的字段,默认为false
            SerializerFeature.WriteNullNumberAsZero, //数值字段如果为null,输出为0,而非null
            SerializerFeature.WriteNullListAsEmpty, //List字段如果为null,输出为[],而非null
            SerializerFeature.WriteNullStringAsEmpty, //字符类型字段如果为null,输出为"",而非null
            SerializerFeature.WriteNullBooleanAsFalse, //Boolean字段如果为null,输出为false,而非null
            SerializerFeature.DisableCircularReferenceDetect, //循环引用
            SerializerFeature.PrettyFormat //格式化输出
            //SerializerFeature.WriteDateUseDateFormat
    };

    /**
     * 配置消息转换器
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(serializerFeatures);
        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
        fastJsonConfig.setCharset(StandardCharsets.UTF_8);
        fastConverter.setFastJsonConfig(fastJsonConfig);
        fastConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON));
        converters.add(0, fastConverter);
    }

}
