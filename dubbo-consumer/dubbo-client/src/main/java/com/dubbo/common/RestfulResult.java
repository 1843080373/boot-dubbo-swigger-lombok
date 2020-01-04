package com.dubbo.common;

public class RestfulResult {

	private Integer code;
	
	private Object  data;
	
	private String message;

	
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public RestfulResult() {
		super();
	}

	

	public RestfulResult(Integer code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public RestfulResult(Integer code, Object data, String message) {
		super();
		this.code = code;
		this.data = data;
		this.message = message;
	}

	public static RestfulResult fail(String message) {
		return new RestfulResult(500,message);
	}
	
	public static RestfulResult succeed(Object data) {
		return new RestfulResult(200,data,"操作成功");
	}

	public static RestfulResult succeed() {
		return new RestfulResult(200,"操作成功");
	}
}
