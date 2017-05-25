package com.sx.weixin.model;

import java.util.Date;

public class ArticleDelictModel {
    private Integer adid;

    private String adtitle;

    private String adauthor;

    private Date createdate;

    private Date updatedate;

    private Date issuedate;

    private Integer sortsn;

    private String piclocation;

    private String adsource;

    private Boolean advalid;

    private String adurl;

    private String remark;

    private String htmcontent;

    public Integer getAdid() {
        return adid;
    }

    public void setAdid(Integer adid) {
        this.adid = adid;
    }

    public String getAdtitle() {
        return adtitle;
    }

    public void setAdtitle(String adtitle) {
        this.adtitle = adtitle == null ? null : adtitle.trim();
    }

    public String getAdauthor() {
        return adauthor;
    }

    public void setAdauthor(String adauthor) {
        this.adauthor = adauthor == null ? null : adauthor.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public Date getIssuedate() {
        return issuedate;
    }

    public void setIssuedate(Date issuedate) {
        this.issuedate = issuedate;
    }

    public Integer getSortsn() {
        return sortsn;
    }

    public void setSortsn(Integer sortsn) {
        this.sortsn = sortsn;
    }

    public String getPiclocation() {
        return piclocation;
    }

    public void setPiclocation(String piclocation) {
        this.piclocation = piclocation == null ? null : piclocation.trim();
    }

    public String getAdsource() {
        return adsource;
    }

    public void setAdsource(String adsource) {
        this.adsource = adsource == null ? null : adsource.trim();
    }

    public Boolean getAdvalid() {
        return advalid;
    }

    public void setAdvalid(Boolean advalid) {
        this.advalid = advalid;
    }

    public String getAdurl() {
        return adurl;
    }

    public void setAdurl(String adurl) {
        this.adurl = adurl == null ? null : adurl.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getHtmcontent() {
        return htmcontent;
    }

    public void setHtmcontent(String htmcontent) {
        this.htmcontent = htmcontent == null ? null : htmcontent.trim();
    }
}