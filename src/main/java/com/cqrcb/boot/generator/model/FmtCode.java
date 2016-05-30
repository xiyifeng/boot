package com.cqrcb.boot.generator.model;

public class FmtCode {
    /**
     * UUID
     */
    private String uuid;

    /**
     * 交易
     */
    private String trancode;

    /**
     * 顺序号码
     */
    private Integer msgseq;

    /**
     * 请求时间
     */
    private String requesttime;

    /**
     * 响应时间
     */
    private String responsetime;

    /**
     * 状�?
     */
    private String status;

    /**
     * 是否存在差异
     */
    private String diffcode;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTrancode() {
        return trancode;
    }

    public void setTrancode(String trancode) {
        this.trancode = trancode;
    }

    public Integer getMsgseq() {
        return msgseq;
    }

    public void setMsgseq(Integer msgseq) {
        this.msgseq = msgseq;
    }

    public String getRequesttime() {
        return requesttime;
    }

    public void setRequesttime(String requesttime) {
        this.requesttime = requesttime;
    }

    public String getResponsetime() {
        return responsetime;
    }

    public void setResponsetime(String responsetime) {
        this.responsetime = responsetime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDiffcode() {
        return diffcode;
    }

    public void setDiffcode(String diffcode) {
        this.diffcode = diffcode;
    }
}