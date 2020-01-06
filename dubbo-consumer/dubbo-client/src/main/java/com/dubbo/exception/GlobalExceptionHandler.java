package com.dubbo.exception;


import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dubbo.common.RestfulResult;

/**
 * 自定义的统一异常处理器
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	private static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Object resolveException(HttpServletRequest request, HttpServletResponse response, Exception exception) {

		String errTip = null;

		/*--- 自定义业务异常 ---*/
		if (exception instanceof BusinessException) {
			BusinessException businessException = (BusinessException) exception;
			errTip = businessException.getMessage();
			log.error("自定义业务异常 = {}", errTip);
			return RestfulResult.fail(errTip);
		}
		/*--- 请求参数相关的异常 ---*/
		else if (exception instanceof IllegalArgumentException) {
			errTip = exception.getMessage();
			log.error("非法参数异常 = {}", errTip, exception);
			return RestfulResult.fail(errTip);
		} else if (exception instanceof BindException) {
			// 普通对象参数校验
			BindingResult result = (BindingResult) exception;
			errTip = result.getAllErrors().get(0).getDefaultMessage();
			log.error("参数绑定异常 = {}", errTip);
			return RestfulResult.fail(errTip);
		} else if (exception instanceof MethodArgumentNotValidException) {
			// 复杂对象参数嵌套校验
			MethodArgumentNotValidException ex = (MethodArgumentNotValidException) exception;
			errTip = ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();
			log.error("参数绑定异常 = {}", errTip);
			return RestfulResult.fail(errTip);
		} else if (exception instanceof ConstraintViolationException) {
			// 简单参数直接校验
			ConstraintViolationException ex = (ConstraintViolationException) exception;
			errTip = ex.getConstraintViolations().iterator().next().getMessage();
			log.error("参数绑定异常 = {}", errTip);
			return RestfulResult.fail(errTip);
		} if (exception instanceof SQLIntegrityConstraintViolationException) {
			if (exception.getMessage().contains("Duplicate")) {
				errTip = "指定的数据已存在，请核对相关数据后再进行相关操作";
			} else {
				errTip = "数据库完整性约束异常，请核对相关数据后再进行相关操作";
			}
			log.error("违反数据库完整性约束异常 = {}", exception);
			return RestfulResult.fail(errTip);
		} else {
			errTip = "亲,服务器开小差了...";
			log.error("未知异常 = {}", exception);
			return RestfulResult.fail(errTip);
		}
	}

}
