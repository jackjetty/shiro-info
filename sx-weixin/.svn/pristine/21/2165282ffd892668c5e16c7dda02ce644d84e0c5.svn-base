package com.sx.weixin.dto;
import java.util.Date;

import com.sx.weixin.model.ArticleTransportModel; 
import com.sx.weixin.util.CommonUtil;
import com.sx.weixin.util.DateUtil; 
public class ArticleTransportDto   extends BaseDto<ArticleTransportModel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2355325197991111111L;
	
	private String atid;

    private String attitle;

    private String atauthor;

    private String createdate;

    private String updatedate;

    private String issuedate;

    private String sortsn;

    private String piclocation;
    
    private String imgurl;

    private String atsource;

    private Boolean atvalid;

    private String aturl;

    private String remark;

    private String htmcontent;
    
    
    

	 
	
	
	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public String getAtid() {
		return atid;
	}

	public void setAtid(String atid) {
		this.atid = atid;
	}

	public String getAttitle() {
		return attitle;
	}

	public void setAttitle(String attitle) {
		this.attitle = attitle;
	}

	public String getAtauthor() {
		return atauthor;
	}

	public void setAtauthor(String atauthor) {
		this.atauthor = atauthor;
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public String getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}

	public String getIssuedate() {
		return issuedate;
	}

	public void setIssuedate(String issuedate) {
		this.issuedate = issuedate;
	}

	public String getSortsn() {
		return sortsn;
	}

	public void setSortsn(String sortsn) {
		this.sortsn = sortsn;
	}

	public String getPiclocation() {
		return piclocation;
	}

	public void setPiclocation(String piclocation) {
		this.piclocation = piclocation;
	}

	public String getAtsource() {
		return atsource;
	}

	public void setAtsource(String atsource) {
		this.atsource = atsource;
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
		this.aturl = aturl;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getHtmcontent() {
		return htmcontent;
	}

	public void setHtmcontent(String htmcontent) {
		this.htmcontent = htmcontent;
	}

	@Override
	public void buildDto(ArticleTransportModel articleTransportModel) {
		// TODO Auto-generated method stub
		
		this.atid=CommonUtil.trim(articleTransportModel.getAtid());
		this.attitle=CommonUtil.trim(articleTransportModel.getAttitle());
		this.atauthor=CommonUtil.trim(articleTransportModel.getAtauthor()); 
		this.createdate=DateUtil.getDateForm(articleTransportModel.getCreatedate()); 
		this.updatedate=DateUtil.getDateForm(articleTransportModel.getUpdatedate()); 
		this.issuedate=DateUtil.getDateForm(articleTransportModel.getIssuedate()); 
		this.sortsn=CommonUtil.trim(articleTransportModel.getSortsn());
		this.piclocation=CommonUtil.trim(articleTransportModel.getPiclocation()); 
		this.atsource=CommonUtil.trim(articleTransportModel.getAtsource()); 
		this.atvalid=articleTransportModel.getAtvalid()==null?false:articleTransportModel.getAtvalid();
		this.aturl=CommonUtil.trim(articleTransportModel.getAturl()); 
		 
		 
		this.htmcontent=CommonUtil.trim(articleTransportModel.getHtmcontent()); 
		this.remark=CommonUtil.trim(articleTransportModel.getRemark());   
	     
		
	}

	@Override
	public ArticleTransportModel vertModel() {
		// TODO Auto-generated method stub
		
		return null;
	}
    
    
    
	
	
}