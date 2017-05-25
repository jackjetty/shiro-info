package com.sx.weixin.model;

public class InfoPicModel extends InfoPicModelKey {
    private String pictype;

    private String picinfo;

    private String picurl;

    private String piclocalstore;

    public String getPictype() {
        return pictype;
    }

    public void setPictype(String pictype) {
        this.pictype = pictype == null ? null : pictype.trim();
    }

    public String getPicinfo() {
        return picinfo;
    }

    public void setPicinfo(String picinfo) {
        this.picinfo = picinfo == null ? null : picinfo.trim();
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl == null ? null : picurl.trim();
    }

    public String getPiclocalstore() {
        return piclocalstore;
    }

    public void setPiclocalstore(String piclocalstore) {
        this.piclocalstore = piclocalstore == null ? null : piclocalstore.trim();
    }
}