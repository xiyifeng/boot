package com.xyf.boot.domain;

import com.xyf.boot.domain.base.PageBase;

public class FmtCode extends PageBase {
    private String uuid;

    private String tranCode;

    private Integer msgSeq;

    private String requestTime;

    private String responseTime;

    private String status;

    private String diffCode;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getTranCode() {
        return tranCode;
    }

    public void setTranCode(String tranCode) {
        this.tranCode = tranCode == null ? null : tranCode.trim();
    }

    public Integer getMsgSeq() {
        return msgSeq;
    }

    public void setMsgSeq(Integer msgSeq) {
        this.msgSeq = msgSeq;
    }

    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime == null ? null : requestTime.trim();
    }

    public String getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(String responseTime) {
        this.responseTime = responseTime == null ? null : responseTime.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getDiffCode() {
        return diffCode;
    }

    public void setDiffCode(String diffCode) {
        this.diffCode = diffCode == null ? null : diffCode.trim();
    }
}