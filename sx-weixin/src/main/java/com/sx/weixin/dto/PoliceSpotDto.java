package com.sx.weixin.dto;
import com.sx.weixin.model.PoliceSpotModel; 
import com.sx.weixin.model.VideoSpotModel;
import com.sx.weixin.util.CommonUtil;
import com.sx.weixin.util.DateUtil;
public class PoliceSpotDto   extends BaseDto<PoliceSpotModel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6646394566454156143L;
	
	private String psid;

    private String psname;

    private String pscontact;

    private String psaddress;

    private String pstype;

    private String longitude;

    private String latitude;

    private String remark;

	public String getPsid() {
		return psid;
	}

	public void setPsid(String psid) {
		this.psid = psid;
	}

	public String getPsname() {
		return psname;
	}

	public void setPsname(String psname) {
		this.psname = psname;
	}

	public String getPscontact() {
		return pscontact;
	}

	public void setPscontact(String pscontact) {
		this.pscontact = pscontact;
	}

	public String getPsaddress() {
		return psaddress;
	}

	public void setPsaddress(String psaddress) {
		this.psaddress = psaddress;
	}

	public String getPstype() {
		return pstype;
	}

	public void setPstype(String pstype) {
		this.pstype = pstype;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	@Override
	public void buildDto(PoliceSpotModel policeSpotModel) {
		// TODO Auto-generated method stub 
		this.psid=CommonUtil.trim(policeSpotModel.getPsid());
		this.psname=CommonUtil.trim(policeSpotModel.getPsname());  
		this.pscontact=CommonUtil.trim(policeSpotModel.getPscontact());  
		this.psaddress=CommonUtil.trim(policeSpotModel.getPsaddress()); 
		this.pstype=CommonUtil.trim(policeSpotModel.getPstype()); 
		this.longitude=CommonUtil.trim(policeSpotModel.getLongitude()); 
		this.latitude=CommonUtil.trim(policeSpotModel.getLatitude()); 
		
		this.remark=CommonUtil.trim(policeSpotModel.getRemark());  
		
		 
	}

	@Override
	public PoliceSpotModel vertModel() {
		// TODO Auto-generated method stub
		
		return null;
	}
    
	
	
}