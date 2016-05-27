package com.cqrcb.boot.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import com.cqrcb.boot.domain.page.PageBase;

/**
 * 报文暂存表
 * 
 * @author Administrator
 * 
 */
public class FmtCode extends PageBase implements Serializable {
	private static final long serialVersionUID = -5101919464351554453L;
	private String uuid;
	private String tranCode;
	private int msgSeq;
	private String requestTime;
	private String responseTime;
	private String requestMsg;
	private String newResponseMsg;
	private String responseMsg;
	private String status;
	private String diffCode;
	private String compResult;

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

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getTranCode() {
		return tranCode;
	}

	public void setTranCode(String tranCode) {
		this.tranCode = tranCode;
	}

	public int getMsgSeq() {
		return msgSeq;
	}

	public void setMsgSeq(int msgSeq) {
		this.msgSeq = msgSeq;
	}

	public String getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(String requestTime) {
		this.requestTime = requestTime;
	}

	public String getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(String responseTime) {
		this.responseTime = responseTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDiffCode() {
		return diffCode;
	}

	public void setDiffCode(String diffCode) {
		this.diffCode = diffCode;
	}

	public FmtCode(String uuid, String tranCode, int msgSeq,
			String requestTime, String responseTime, String status,
			String diffCode) {
		super();
		this.uuid = uuid;
		this.tranCode = tranCode;
		this.msgSeq = msgSeq;
		this.requestTime = requestTime;
		this.responseTime = responseTime;
		this.status = status;
		this.diffCode = diffCode;
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

	public FmtCode() {
		super();
	}

	/**
	 * 测试用，随机生成
	 */
	public void randomInit() {
		Random random = new Random();
		this.uuid = UUID.randomUUID().toString();
		this.tranCode = "1000" + random.nextInt(10);
		this.msgSeq = 1000 + random.nextInt();
		this.requestTime = new Date().getTime() + "";
		this.responseTime = requestTime;
		this.status = "1";
		this.diffCode = "2";
	}

	@Override
	public String toString() {
		return "FmtCode [uuid=" + uuid + ", tranCode=" + tranCode + ", msgSeq="
				+ msgSeq + ", requestTime=" + requestTime + ", responseTime="
				+ responseTime + ", requestMsg=" + requestMsg
				+ ", newResponseMsg=" + newResponseMsg + ", responseMsg="
				+ responseMsg + ", status=" + status + ", diffCode=" + diffCode
				+ ", compResult=" + compResult + "]" + super.toString();
	}

}
