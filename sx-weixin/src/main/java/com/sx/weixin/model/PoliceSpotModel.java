package com.sx.weixin.model;

public class PoliceSpotModel {
    private Integer psid;

    private String psname;

    private String pscontact;

    private String psaddress;

    private String pstype;

    private String longitude;

    private String latitude;

    private String remark;

    public Integer getPsid() {
        return psid;
    }

    public void setPsid(Integer psid) {
        this.psid = psid;
    }

    public String getPsname() {
        return psname;
    }

    public void setPsname(String psname) {
        this.psname = psname == null ? null : psname.trim();
    }

    public String getPscontact() {
        return pscontact;
    }

    public void setPscontact(String pscontact) {
        this.pscontact = pscontact == null ? null : pscontact.trim();
    }

    public String getPsaddress() {
        return psaddress;
    }

    public void setPsaddress(String psaddress) {
        this.psaddress = psaddress == null ? null : psaddress.trim();
    }

    public String getPstype() {
        return pstype;
    }

    public void setPstype(String pstype) {
        this.pstype = pstype == null ? null : pstype.trim();
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}