package com.sx.weixin.dto;
import java.util.Date;

import com.sx.weixin.model.ArticleDelictModel;
import com.sx.weixin.model.CarMoveModel;
import com.sx.weixin.util.CommonUtil;
import com.sx.weixin.util.DateUtil; 
public class ArticleDelictDto   extends BaseDto<ArticleDelictModel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2355325197991181111L;
	
	private String adid;

    private String adtitle;

    private String adauthor;

    private String createdate;

    private String updatedate;

    private String issuedate;

    private String sortsn;

    private String piclocation;
    
    private String imgurl;

    private String adsource;

    private Boolean advalid;

    private String adurl;

    private String remark;

    private String htmcontent;
    
    
    

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public String getAdid() {
		return adid;
	}

	public void setAdid(String adid) {
		this.adid = adid;
	}

	public String getAdtitle() {
		return adtitle;
	}

	public void setAdtitle(String adtitle) {
		this.adtitle = adtitle;
	}

	public String getAdauthor() {
		return adauthor;
	}

	public void setAdauthor(String adauthor) {
		this.adauthor = adauthor;
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

	public String getAdsource() {
		return adsource;
	}

	public void setAdsource(String adsource) {
		this.adsource = adsource;
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
		this.adurl = adurl;
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
	public void buildDto(ArticleDelictModel articleDelictModel) {
		// TODO Auto-generated method stub
		
		this.adid=CommonUtil.trim(articleDelictModel.getAdid());
		this.adtitle=CommonUtil.trim(articleDelictModel.getAdtitle());
		this.adauthor=CommonUtil.trim(articleDelictModel.getAdauthor());
		 
		this.createdate=DateUtil.getDateForm(articleDelictModel.getCreatedate()); 
		this.updatedate=DateUtil.getDateForm(articleDelictModel.getUpdatedate()); 
		this.issuedate=DateUtil.getDateForm(articleDelictModel.getIssuedate()); 
		this.sortsn=CommonUtil.trim(articleDelictModel.getSortsn());
		this.piclocation=CommonUtil.trim(articleDelictModel.getPiclocation()); 
		this.adsource=CommonUtil.trim(articleDelictModel.getAdsource()); 
		this.advalid=articleDelictModel.getAdvalid()==null?false:articleDelictModel.getAdvalid();
		this.adurl=CommonUtil.trim(articleDelictModel.getAdurl()); 
		 
		 
		this.htmcontent=CommonUtil.trim(articleDelictModel.getHtmcontent());
		 
		this.remark=CommonUtil.trim(articleDelictModel.getRemark());  
		
		
		 
 
	     
		
	}

	@Override
	public ArticleDelictModel vertModel() {
		// TODO Auto-generated method stub
		
		return null;
	}
    
    
    
	
	
}