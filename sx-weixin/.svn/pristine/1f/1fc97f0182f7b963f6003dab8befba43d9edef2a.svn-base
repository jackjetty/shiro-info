package com.sx.weixin.dto;
import java.util.Date;
 
import com.sx.weixin.model.FormalAccidentModel;
import com.sx.weixin.util.CommonUtil;
import com.sx.weixin.util.DateUtil; 
public class FormalAccidentDto   extends BaseDto<FormalAccidentModel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2355325199996881111L;
	private String formlaccidentid;

    private String reportopenid;

    private String reporttime;

    private String reportphonenumber;
    
    private String otherphonenumber;

    private String reportertype;

    private String address;

    private String locationx;

    private String locationy;

    private String accidentstate;

    private String accepttime;

    private String accepter;

    private String remark;

    private String departmentid;

    private boolean emergencycall;

	public String getFormlaccidentid() {
		return formlaccidentid;
	}

	public void setFormlaccidentid(String formlaccidentid) {
		this.formlaccidentid = formlaccidentid;
	}

	public String getReportopenid() {
		return reportopenid;
	}

	public void setReportopenid(String reportopenid) {
		this.reportopenid = reportopenid;
	}
	
	
	

	 

	public String getOtherphonenumber() {
		return otherphonenumber;
	}

	public void setOtherphonenumber(String otherphonenumber) {
		this.otherphonenumber = otherphonenumber;
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

	public String getReportertype() {
		return reportertype;
	}

	public void setReportertype(String reportertype) {
		this.reportertype = reportertype;
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

	public String getAccidentstate() {
		return accidentstate;
	}

	public void setAccidentstate(String accidentstate) {
		this.accidentstate = accidentstate;
	}

	public String getAccepttime() {
		return accepttime;
	}

	public void setAccepttime(String accepttime) {
		this.accepttime = accepttime;
	}

	public String getAccepter() {
		return accepter;
	}

	public void setAccepter(String accepter) {
		this.accepter = accepter;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(String departmentid) {
		this.departmentid = departmentid;
	}

	public boolean isEmergencycall() {
		return emergencycall;
	}

	public void setEmergencycall(boolean emergencycall) {
		this.emergencycall = emergencycall;
	}
	@Override
	public void buildDto(FormalAccidentModel formalAccidentModel) {
		
		this.formlaccidentid=CommonUtil.trim(formalAccidentModel.getFormlaccidentid());
		this.reportopenid=CommonUtil.trim(formalAccidentModel.getReportopenid());
		this.reportphonenumber=CommonUtil.trim(formalAccidentModel.getReportphonenumber());
		this.otherphonenumber=CommonUtil.trim(formalAccidentModel.getOtherphonenumber());
		this.reporttime=DateUtil.getDateForm(formalAccidentModel.getReporttime());
		this.reportertype=CommonUtil.trim(formalAccidentModel.getReportertype());
		this.address=CommonUtil.trim(formalAccidentModel.getAddress());
		this.locationx=CommonUtil.trim(formalAccidentModel.getLocationx());
		this.locationy=CommonUtil.trim(formalAccidentModel.getLocationy());
		this.accidentstate=CommonUtil.trim(formalAccidentModel.getAccidentstate());
		this.accepttime=DateUtil.getDateForm(formalAccidentModel.getAccepttime());
		this.accepter=CommonUtil.trim(formalAccidentModel.getAccepter());
		this.remark=CommonUtil.trim(formalAccidentModel.getRemark());
		this.departmentid=CommonUtil.trim(formalAccidentModel.getDepartmentid()); 
		this.emergencycall=formalAccidentModel.getEmergencycall()==null?false:formalAccidentModel.getEmergencycall(); 
	}

	@Override
	public FormalAccidentModel vertModel() {
		// TODO Auto-generated method stub
		
		return null;
	}
    
}