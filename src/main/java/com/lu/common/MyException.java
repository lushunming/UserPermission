package com.lu.common;

/**
 * 自定义运行时异常类，为spring的事务准备的
 * 
 * @author lusm
 * @date 2016年3月26日
 *
 */
public class MyException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3994660471092050484L;

	/**
	 * 
	 * @param message
	 *            异常消息
	 */
	public MyException(String message) {
		super(message);
	}

	/**
	 * 
	 * @param message
	 * @param cause
	 */
	public MyException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * 
	 * @param cause
	 */
	public MyException(Throwable cause) {
		super(cause);
	}

	/**
	 * 
	 * @param message
	 *            消息
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	protected MyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
