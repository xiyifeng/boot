/**
* 
* FmtCode.java
* Copyright(c) 2015-2020 
* All Rights reserved. 
* -----------------------------------
* 2016-05-30creadted 
* @Auther xiyifeng
*/
package com.cqrcb.boot.domain;

import com.cqrcb.boot.domain.page.PageBase;

public class FmtCode extends PageBase {
    /**
     * UUID
     */
    private String uuid;

    /**
     * 交易
     */
    private String tranCode;

    /**
     * 顺序号码
     */
    private Integer msgSeq;

    /**
     * 请求时间
     */
    private String requestTime;

    /**
     * 响应时间
     */
    private String responseTime;

    /**
     * 状�?
     */
    private String status;

    /**
     * 是否存在差异
     */
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