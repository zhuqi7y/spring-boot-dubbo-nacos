package com.youzi.modules.base.controller;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.youzi.common.constant.DubboConstant;
import com.youzi.common.constant.RedisConstant;
import com.youzi.common.controller.BaseController;
import com.youzi.common.exception.CustomException;
import com.youzi.modules.sys.service.SysUserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @Description: TODO
 * @author: zhuqi
 * @date: 2020年08月25日 9:26
 */
public abstract class BaseApiController extends BaseController {

    @DubboReference(version = DubboConstant.VERSION, group = DubboConstant.GROUP)
    private SysUserService sysUserService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * @description: 判断是否登录
     */
    protected boolean isLogin(String token) {
        try {
            if(StrUtil.isNotBlank(token)) {
                Integer userId = Convert.toInt(JWT.decode(token).getAudience().get(0));
                if(userId != null && userId != 0 && sysUserService.existById(userId)) {
                    String password = sysUserService.selectById(userId).getPassword();
                    JWT.require(Algorithm.HMAC256(password)).build().verify(token);
                    String key = RedisConstant.TOKEN_KEY + userId.toString();
                    //校验redis里的token
                    if(stringRedisTemplate.hasKey(key)) {
                        String value = stringRedisTemplate.opsForValue().get(key);
                        if(StrUtil.equals(value, token)) {
                            stringRedisTemplate.expire(key, 1, TimeUnit.DAYS);
                            return true;
                        }
                    }
                }
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return false;
    }

    private String getToken() {
        return request.getHeader("token");
    }

    protected boolean isLogin() {
        return isLogin(getToken());
    }

    protected Integer getSysUserid() {
        try {
            if(StrUtil.isNotBlank(getToken())) {
                return Convert.toInt(JWT.decode(getToken()).getAudience().get(0), 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    protected void validCaptcha(String captcha) {
        if(StrUtil.isBlank(captcha)) {
            CustomException.badRequest("验证码不能为空");
        }
        String captchaUuid = request.getHeader("captcha");
        if(StrUtil.isBlank(captchaUuid) || !stringRedisTemplate.hasKey(captchaUuid)) {
            CustomException.badRequest("验证码过期");
        }
        if(!StrUtil.equals(stringRedisTemplate.opsForValue().get(captchaUuid), captcha)) {
            CustomException.badRequest("验证码错误");
        }
    }

}
