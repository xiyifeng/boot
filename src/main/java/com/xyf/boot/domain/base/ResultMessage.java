package com.xyf.boot.domain.base;

import java.io.Serializable;

public class ResultMessage implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final String SUCCESS = "1";
	public static final String FAIL = "0";
	/**
	 * 状态 ( 1-成功 0-失败)
	 */
	private String status;
	/**
	 * 消息
	 */
	private String message;

	public ResultMessage() {
		super();
		status = SUCCESS;
		message = "交易成功";
	}

	public ResultMessage(String status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 设置错误消息
	 * 
	 * @param errorMessage
	 *            消息
	 */
	public void setErrorMessage(String errorMessage) {
		this.message = errorMessage;
		this.status = FAIL;
	}

}
