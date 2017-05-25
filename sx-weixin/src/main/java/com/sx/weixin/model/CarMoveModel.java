package com.sx.weixin.model;

import java.util.Date;

public class CarMoveModel {
    private String carmoveid;

    private String reportopenid;

    private Date reporttime;

    private String reportphonenumber;

    private String cartype;

    private String carnumber;

    private String address;

    private String locationx;

    private String locationy;

    private String carmovestate;

    private String accepter;

    private Date accepttime;

    private String remark;

    private String dealresult;

    public String getCarmoveid() {
        return carmoveid;
    }

    public void setCarmoveid(String carmoveid) {
        this.carmoveid = carmoveid == null ? null : carmoveid.trim();
    }

    public String getReportopenid() {
        return reportopenid;
    }

    public void setReportopenid(String reportopenid) {
        this.reportopenid = reportopenid == null ? null : reportopenid.trim();
    }

    public Date getReporttime() {
        return reporttime;
    }

    public void setReporttime(Date reporttime) {
        this.reporttime = reporttime;
    }

    public String getReportphonenumber() {
        return reportphonenumber;
    }

    public void setReportphonenumber(String reportphonenumber) {
        this.reportphonenumber = reportphonenumber == null ? null : reportphonenumber.trim();
    }

    public String getCartype() {
        return cartype;
    }

    public void setCartype(String cartype) {
        this.cartype = cartype == null ? null : cartype.trim();
    }

    public String getCarnumber() {
        return carnumber;
    }

    public void setCarnumber(String carnumber) {
        this.carnumber = carnumber == null ? null : carnumber.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getLocationx() {
        return locationx;
    }

    public void setLocationx(String locationx) {
        this.locationx = locationx == null ? null : locationx.trim();
    }

    public String getLocationy() {
        return locationy;
    }

    public void setLocationy(String locationy) {
        this.locationy = locationy == null ? null : locationy.trim();
    }

    public String getCarmovestate() {
        return carmovestate;
    }

    public void setCarmovestate(String carmovestate) {
        this.carmovestate = carmovestate == null ? null : carmovestate.trim();
    }

    public String getAccepter() {
        return accepter;
    }

    public void setAccepter(String accepter) {
        this.accepter = accepter == null ? null : accepter.trim();
    }

    public Date getAccepttime() {
        return accepttime;
    }

    public void setAccepttime(Date accepttime) {
        this.accepttime = accepttime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getDealresult() {
        return dealresult;
    }

    public void setDealresult(String dealresult) {
        this.dealresult = dealresult == null ? null : dealresult.trim();
    }
}