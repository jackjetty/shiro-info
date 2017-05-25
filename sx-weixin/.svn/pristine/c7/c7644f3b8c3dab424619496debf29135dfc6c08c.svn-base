package com.sx.weixin.dto; 
import com.sx.weixin.model.CarMoveModel;
import com.sx.weixin.util.CommonUtil;
import com.sx.weixin.util.DateUtil; 
public class CarMoveDto   extends BaseDto<CarMoveModel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2355325197996881111L;
	
	
	private String carmoveid;

    private String reportopenid;

    private String reporttime;

    private String reportphonenumber;

    private String cartype;

    private String carnumber;

    private String address;

    private String locationx;

    private String locationy;

    private String carmovestate;

    private String accepter;

    private String accepttime;

    private String remark;

    private String dealresult;
    
	
	

	 

	public String getCarmoveid() {
		return carmoveid;
	}

	public void setCarmoveid(String carmoveid) {
		this.carmoveid = carmoveid;
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

	public String getCartype() {
		return cartype;
	}

	public void setCartype(String cartype) {
		this.cartype = cartype;
	}

	public String getCarnumber() {
		return carnumber;
	}

	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
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

	public String getCarmovestate() {
		return carmovestate;
	}

	public void setCarmovestate(String carmovestate) {
		this.carmovestate = carmovestate;
	}

	public String getAccepter() {
		return accepter;
	}

	public void setAccepter(String accepter) {
		this.accepter = accepter;
	}

	public String getAccepttime() {
		return accepttime;
	}

	public void setAccepttime(String accepttime) {
		this.accepttime = accepttime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getDealresult() {
		return dealresult;
	}

	public void setDealresult(String dealresult) {
		this.dealresult = dealresult;
	}

	@Override
	public void buildDto(CarMoveModel carMoveModel) {
		// TODO Auto-generated method stub
		
		this.carmoveid=CommonUtil.trim(carMoveModel.getCarmoveid());
		this.reportopenid=CommonUtil.trim(carMoveModel.getReportopenid());
		this.reportphonenumber=CommonUtil.trim(carMoveModel.getReportphonenumber());
		 
		this.reporttime=DateUtil.getDateForm(carMoveModel.getReporttime()); 
		this.cartype=CommonUtil.trim(carMoveModel.getCartype());
		this.carnumber=CommonUtil.trim(carMoveModel.getCarnumber()); 
		this.address=CommonUtil.trim(carMoveModel.getAddress()); 
		this.locationx=CommonUtil.trim(carMoveModel.getLocationx()); 
		this.locationy=CommonUtil.trim(carMoveModel.getLocationy()); 
		this.carmovestate=CommonUtil.trim(carMoveModel.getCarmovestate()); 
		this.accepter=CommonUtil.trim(carMoveModel.getAccepter()); 
		this.accepttime=DateUtil.getDateForm(carMoveModel.getAccepttime()); 
		 
		this.dealresult=CommonUtil.trim(carMoveModel.getDealresult());
		 
		this.remark=CommonUtil.trim(carMoveModel.getRemark());   
	     
		
	}

	@Override
	public CarMoveModel vertModel() {
		// TODO Auto-generated method stub
		
		return null;
	}
	
   
	
	
}