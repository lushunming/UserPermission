package com.lu.dto;

import java.io.Serializable;

public class ResultDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8026654920811799895L;
	public ResultDto(String msg, boolean success, Integer code) {
		super();
		this.msg = msg;
		this.success = success;
		this.code = code;
	}


	/** 返回的消息 */
	private String msg;
	/** 操作是否成功 */
	private boolean success;
	/** 代表操作结果的code */
	private Integer code;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

}
