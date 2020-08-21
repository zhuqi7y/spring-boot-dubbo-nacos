package com.youzi.common.controller.page;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.io.IOException;

/**
 * @Description: TODO
 * @author: zhuqi
 * @date: 2020年08月18日 17:17
 */
public abstract class BaseSysPageController extends BasePageController {

    private Logger logger = LoggerFactory.getLogger(BaseSysPageController.class);

    @ModelAttribute
    public final void beforeAllRequestCheck() throws IOException {
        /*boolean isLogin = false;
        try {
            RestTemplate restTemplate = new RestTemplateBuilder().messageConverters(new FastJsonHttpMessageConverter()).build();
            //拿到header信息
            HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.setContentType(MediaType.APPLICATION_JSON);
            Enumeration<String> headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String key = headerNames.nextElement();
                String value = request.getHeader(key);
                requestHeaders.add(key, value);
            }
            HttpEntity requestEntity = new HttpEntity(null, requestHeaders);
            if(StrUtil.equals(env, "dev")) {
                JSONObject result = restTemplate.postForObject(ApiConstant.API_DEV_LOGIN_URL, requestEntity, JSONObject.class);
                isLogin = Optional.ofNullable(result).map(r -> r.getBooleanValue("body")).orElse(false);
                System.out.println(JSON.toJSONString(result, true));
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        if(!isLogin) {
            response.sendRedirect("/page/login");
        }*/
    }

}
