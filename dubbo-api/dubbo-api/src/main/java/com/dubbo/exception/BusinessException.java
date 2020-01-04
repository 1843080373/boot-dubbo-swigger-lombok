package com.dubbo.exception;

public class BusinessException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BusinessException() {
		super();
	}
	/**
     * 自定义错误类型
     * @param msg 自定义的错误提示
     */
    public BusinessException(String msg){
        super(msg);
    }
}
