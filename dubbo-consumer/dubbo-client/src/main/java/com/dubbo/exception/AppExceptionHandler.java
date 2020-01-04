package com.dubbo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dubbo.common.RestfulResult;

@ControllerAdvice
public class AppExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public RestfulResult handleException(Exception e){
        if(e instanceof RuntimeException) {
        	return RestfulResult.fail(((RuntimeException)e).getMessage());
        }
        return RestfulResult.fail(e.getMessage());
    }
}