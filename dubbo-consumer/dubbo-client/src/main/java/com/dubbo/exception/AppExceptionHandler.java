package com.dubbo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dubbo.common.RestfulResult;

@ControllerAdvice
public class AppExceptionHandler {

	@ResponseBody
	@ExceptionHandler(IllegalArgumentException.class)	
	public RestfulResult RpcException(IllegalArgumentException ex) {
		return RestfulResult.fail(ex.getMessage());
	}

	@ResponseBody
	@ExceptionHandler(BusinessException.class)
	public RestfulResult BusinessException(BusinessException e) {
		return RestfulResult.fail(e.getMessage());
	}

	@ResponseBody
	@ExceptionHandler(Exception.class)
	public RestfulResult Exception(Exception e) {
		return RestfulResult.fail("服務器開小差了...");
	}
}