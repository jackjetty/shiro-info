package com.sx.weixin.model;

import java.util.Date;

public class HitchModel {
    private String hitchid;

    private String reportopenid;

    private Date reporttime;

    private String reportphonenumber;

    private String address;

    private String locationx;

    private String locationy;

    private String hitchstate;

    private Date handletime;

    private String handler;

    private String hitchdes;

    private String remark;

    public String getHitchid() {
        return hitchid;
    }

    public void setHitchid(String hitchid) {
        this.hitchid = hitchid == null ? null : hitchid.trim();
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

    public String getHitchstate() {
        return hitchstate;
    }

    public void setHitchstate(String hitchstate) {
        this.hitchstate = hitchstate == null ? null : hitchstate.trim();
    }

    public Date getHandletime() {
        return handletime;
    }

    public void setHandletime(Date handletime) {
        this.handletime = handletime;
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler == null ? null : handler.trim();
    }

    public String getHitchdes() {
        return hitchdes;
    }

    public void setHitchdes(String hitchdes) {
        this.hitchdes = hitchdes == null ? null : hitchdes.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}