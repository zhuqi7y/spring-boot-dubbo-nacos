package com.config;

import com.youzi.common.api.ApiResult;
import com.youzi.common.exception.CustomException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 全局统一异常处理返回json
 * @author: zhuqi
 * @date: 2020年08月12日 15:44
 */
@RestControllerAdvice
public class ConsumerApiExceptionHandle {

    private Logger logger = LoggerFactory.getLogger(ConsumerApiExceptionHandle.class);

    /**
     * @description: 自定义异常
     */
    @ExceptionHandler(CustomException.class)
    public ApiResult customErrorHandler(HttpServletRequest request, CustomException e) {
        return new ApiResult(e.getCode(), e.getMsg());
    }

    /**
     * @description: 传入参数类型不匹配
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ApiResult methodArgumentTypeMismatchHandler(HttpServletRequest request, MethodArgumentTypeMismatchException e) {
        logger.error("参数类型不匹配，异常url：" + request.getRequestURI(), e);
        return ApiResult.badRequest().msg("参数类型不匹配");
    }

    /**
     * @description: 缺少请求参数
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ApiResult missingServletRequestParameterHandler(HttpServletRequest request, MissingServletRequestParameterException e) {
        logger.error("缺少请求参数，异常url：" + request.getRequestURI(), e);
        return ApiResult.badRequest().msg("缺少请求参数");
    }

    /**
     * @description: bean校验@Validated针对Controller的@resquestBody接收，返回第一个错误信息
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResult validatedErrorHandler(HttpServletRequest request, MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        String message = bindingResult.getAllErrors().get(0).getDefaultMessage();
        //logger.info("MethodArgumentNotValidException:" + request.getRequestURI());
        return ApiResult.badRequest().msg(message);
    }

    /**
     * @description: bean校验@Validated针对Controller默认表单提交方式，返回第一个错误信息
     */
    @ExceptionHandler(BindException.class)
    public ApiResult validatedErrorHandler(HttpServletRequest request, BindException e) {
        BindingResult bindingResult = e.getBindingResult();
        String message = bindingResult.getAllErrors().get(0).getDefaultMessage();
        //logger.info("BindException:"+request.getRequestURI());
        return ApiResult.badRequest().msg(message);
    }

    /**
     * @description: 参数类型转换错误
     */
    @ExceptionHandler(HttpMessageConversionException.class)
    public ApiResult parameterTypeException(HttpServletRequest request, HttpMessageConversionException e){
        logger.error("参数类型转换错误，"+request.getRequestURI(), e);
        return ApiResult.badRequest().msg("参数类型转换错误");
    }

    /**
     * @description: controller层方法参数校验@Validated 自定义抛异常
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ApiResult constraintViolationErrorHandler(HttpServletRequest request, ConstraintViolationException e) {
        List<String> msgList = new ArrayList<>();
        for (ConstraintViolation<?> constraintViolation : e.getConstraintViolations()) {
            msgList.add(constraintViolation.getMessage());
        }
        //String messages = StringUtils.join(msgList.toArray(), ";");
        logger.info("ConstraintViolationException:"+request.getRequestURI());
        return ApiResult.badRequest().msg(msgList.get(0));
    }

    /**
     * @description: hibernate-validator
     */
    @ExceptionHandler(ValidationException.class)
    public ApiResult handleValidationException(HttpServletRequest request, ValidationException e) {
        logger.info("参数验证失败,ValidationException:"+request.getRequestURI());
        return ApiResult.badRequest().msg("参数验证失败");
    }

    /**
     * @description: 不存在的地址返回错误
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public ApiResult noHandlerFoundErrorHandler(HttpServletRequest request, NoHandlerFoundException e) {
        logger.info("错误的请求地址：" + request.getRequestURI());
        return ApiResult.notFound();
    }

    /**
     * @description: controller接收参数注解requestBody处理异常
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ApiResult messageNotReadableErrorHandler(HttpServletRequest request, HttpMessageNotReadableException e) {
        if(e.getMessage().contains("Required request body is missing")) {
            logger.error("RequestBody不能为空，异常url：" + request.getRequestURI(), e);
            return ApiResult.badRequest().msg("传入参数不能为空");
        } else {
            logger.error("参数解析失败，异常url：" + request.getRequestURI(), e);
            return ApiResult.badRequest().msg("参数解析失败");
        }
    }

    /**
     * @description: request请求方法不支持
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ApiResult methodNotSupportedErrorHandler(HttpServletRequest request, HttpRequestMethodNotSupportedException e) {
        logger.error("request请求方法不支持，异常url：" + request.getRequestURI(), e);
        return ApiResult.fail().msg("请求方法不支持");
    }

    /**
     * @description: Content-type类型不支持
     */
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ApiResult mediaTypeNotSupportedErrorHandler(HttpServletRequest request, HttpMediaTypeNotSupportedException e) {
        logger.error("Content-type类型不支持，异常url：" + request.getRequestURI(), e);
        return ApiResult.fail().msg("Content-type类型不支持");
    }

    /**
     * @description: 发生空指针异常
     */
    @ExceptionHandler(NullPointerException.class)
    public ApiResult nullPointerErrorHandler(HttpServletRequest request, NullPointerException e) {
        logger.error("发生空指针异常，异常url：" + request.getRequestURI(), e);
        return ApiResult.fail();
    }

    /**
     * @description: 数据库访问异常
     */
    @ExceptionHandler(SQLException.class)
    public ApiResult sqlErrorHandler(HttpServletRequest request, SQLException e) {
        logger.error("数据库访问异常，异常url：" + request.getRequestURI(), e);
        return ApiResult.fail();
    }

    /**
     * @description: 其他未处理的异常
     */
    @ExceptionHandler(Exception.class)
    public ApiResult exceptionHandler(HttpServletRequest request, Exception e) {
        logger.error("异常url：" + request.getRequestURI(), e);
        return ApiResult.fail();
    }

}
