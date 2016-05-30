package com.xyf.boot.domain.info;

import java.io.Serializable;

public class FmtDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	private String uuid;
	private String requestMsg;
	private String responseMsg;
	private String newResponseMsg;
	private String compResult;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getRequestMsg() {
		return requestMsg;
	}

	public void setRequestMsg(String requestMsg) {
		this.requestMsg = requestMsg;
	}

	public String getResponseMsg() {
		return responseMsg;
	}

	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}

	public String getNewResponseMsg() {
		return newResponseMsg;
	}

	public void setNewResponseMsg(String newResponseMsg) {
		this.newResponseMsg = newResponseMsg;
	}

	public String getCompResult() {
		return compResult;
	}

	public void setCompResult(String compResult) {
		this.compResult = compResult;
	}

}
