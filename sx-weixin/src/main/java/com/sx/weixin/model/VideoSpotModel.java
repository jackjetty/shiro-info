package com.sx.weixin.model;

import java.util.Date;

public class VideoSpotModel {
    private String vsid;

    private String vsname;

    private Date lasttime;

    private String remark;

    public String getVsid() {
        return vsid;
    }

    public void setVsid(String vsid) {
        this.vsid = vsid == null ? null : vsid.trim();
    }

    public String getVsname() {
        return vsname;
    }

    public void setVsname(String vsname) {
        this.vsname = vsname == null ? null : vsname.trim();
    }

    public Date getLasttime() {
        return lasttime;
    }

    public void setLasttime(Date lasttime) {
        this.lasttime = lasttime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}