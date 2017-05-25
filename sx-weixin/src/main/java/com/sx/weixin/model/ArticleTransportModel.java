package com.sx.weixin.model;

import java.util.Date;

public class ArticleTransportModel {
    private Integer atid;

    private String attitle;

    private String atauthor;

    private Date createdate;

    private Date updatedate;

    private Date issuedate;

    private Integer sortsn;

    private String piclocation;

    private String atsource;

    private Boolean atvalid;

    private String aturl;

    private String remark;

    private String htmcontent;

    public Integer getAtid() {
        return atid;
    }

    public void setAtid(Integer atid) {
        this.atid = atid;
    }

    public String getAttitle() {
        return attitle;
    }

    public void setAttitle(String attitle) {
        this.attitle = attitle == null ? null : attitle.trim();
    }

    public String getAtauthor() {
        return atauthor;
    }

    public void setAtauthor(String atauthor) {
        this.atauthor = atauthor == null ? null : atauthor.trim();
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

    public String getAtsource() {
        return atsource;
    }

    public void setAtsource(String atsource) {
        this.atsource = atsource == null ? null : atsource.trim();
    }

    public Boolean getAtvalid() {
        return atvalid;
    }

    public void setAtvalid(Boolean atvalid) {
        this.atvalid = atvalid;
    }

    public String getAturl() {
        return aturl;
    }

    public void setAturl(String aturl) {
        this.aturl = aturl == null ? null : aturl.trim();
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