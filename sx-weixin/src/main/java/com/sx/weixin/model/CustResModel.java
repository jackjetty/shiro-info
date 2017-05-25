package com.sx.weixin.model;

import java.util.Date;

public class CustResModel {
    private Integer custresid;

    private String processid;

    private String recordno;

    private Date custrestime;

    private String openid;

    private String custresponser;

    private String custrestype;

    private String custrescontent;

    public Integer getCustresid() {
        return custresid;
    }

    public void setCustresid(Integer custresid) {
        this.custresid = custresid;
    }

    public String getProcessid() {
        return processid;
    }

    public void setProcessid(String processid) {
        this.processid = processid == null ? null : processid.trim();
    }

    public String getRecordno() {
        return recordno;
    }

    public void setRecordno(String recordno) {
        this.recordno = recordno == null ? null : recordno.trim();
    }

    public Date getCustrestime() {
        return custrestime;
    }

    public void setCustrestime(Date custrestime) {
        this.custrestime = custrestime;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getCustresponser() {
        return custresponser;
    }

    public void setCustresponser(String custresponser) {
        this.custresponser = custresponser == null ? null : custresponser.trim();
    }

    public String getCustrestype() {
        return custrestype;
    }

    public void setCustrestype(String custrestype) {
        this.custrestype = custrestype == null ? null : custrestype.trim();
    }

    public String getCustrescontent() {
        return custrescontent;
    }

    public void setCustrescontent(String custrescontent) {
        this.custrescontent = custrescontent == null ? null : custrescontent.trim();
    }
}