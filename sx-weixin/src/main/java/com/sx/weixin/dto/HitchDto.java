package com.sx.weixin.dto;
import java.util.Date;

import com.sx.weixin.model.FormalAccidentModel;
import com.sx.weixin.model.HitchModel;
import com.sx.weixin.util.CommonUtil;
import com.sx.weixin.util.DateUtil; 
public class HitchDto   extends BaseDto<HitchModel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2355325199999881111L;
	
	
	private String hitchid;

    private String reportopenid;

    private String reporttime;

    private String reportphonenumber;

    private String address;

    private String locationx;

    private String locationy;

    private String hitchstate;

    private String handletime;

    private String handler;

    private String hitchdes;

    private String remark;

	public String getHitchid() {
		return hitchid;
	}

	public void setHitchid(String hitchid) {
		this.hitchid = hitchid;
	}

	public String getReportopenid() {
		return reportopenid;
	}

	public void setReportopenid(String reportopenid) {
		this.reportopenid = reportopenid;
	}

	public String getReporttime() {
		return reporttime;
	}

	public void setReporttime(String reporttime) {
		this.reporttime = reporttime;
	}

	public String getReportphonenumber() {
		return reportphonenumber;
	}

	public void setReportphonenumber(String reportphonenumber) {
		this.reportphonenumber = reportphonenumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLocationx() {
		return locationx;
	}

	public void setLocationx(String locationx) {
		this.locationx = locationx;
	}

	public String getLocationy() {
		return locationy;
	}

	public void setLocationy(String locationy) {
		this.locationy = locationy;
	}

	public String getHitchstate() {
		return hitchstate;
	}

	public void setHitchstate(String hitchstate) {
		this.hitchstate = hitchstate;
	}

	public String getHandletime() {
		return handletime;
	}

	public void setHandletime(String handletime) {
		this.handletime = handletime;
	}

	public String getHandler() {
		return handler;
	}

	public void setHandler(String handler) {
		this.handler = handler;
	}

	public String getHitchdes() {
		return hitchdes;
	}

	public void setHitchdes(String hitchdes) {
		this.hitchdes = hitchdes;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	@Override
	public void buildDto(HitchModel hitchModel) {
		
		this.hitchid=CommonUtil.trim(hitchModel.getHitchid());
		this.reportopenid=CommonUtil.trim(hitchModel.getReportopenid());
		this.reporttime=DateUtil.getDateForm(hitchModel.getReporttime());
		this.reportphonenumber=CommonUtil.trim(hitchModel.getReportphonenumber()); 
		this.address=CommonUtil.trim(hitchModel.getAddress());
		this.locationx=CommonUtil.trim(hitchModel.getLocationx());
		this.locationy=CommonUtil.trim(hitchModel.getLocationy());
		this.hitchstate=CommonUtil.trim(hitchModel.getHitchstate());
		this.handletime=DateUtil.getDateForm(hitchModel.getHandletime());
		this.handler=CommonUtil.trim(hitchModel.getHandler());
		this.hitchdes=CommonUtil.trim(hitchModel.getHitchdes()); 
		this.remark=CommonUtil.trim(hitchModel.getRemark());
		 
	}

	@Override
	public HitchModel vertModel() {
		// TODO Auto-generated method stub
		
		return null;
	}
    
	
}