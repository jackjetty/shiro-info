package com.sx.weixin.dto;
import com.sx.weixin.model.ParkSpotModel; 
import com.sx.weixin.model.PoliceSpotModel;
import com.sx.weixin.model.VideoSpotModel;
import com.sx.weixin.util.CommonUtil;
import com.sx.weixin.util.DateUtil;
public class ParkSpotDto   extends BaseDto<ParkSpotModel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2149660092353604664L;
	
	private String psid;

    private String psname;

    private String departmentid;

    private String psaddress;

    private String pstype;

    private String longitude;

    private String latitude;

    private String remark;
    
    
    @Override
	public void buildDto(ParkSpotModel parkSpotModel) {
		// TODO Auto-generated method stub 
		this.psid=CommonUtil.trim(parkSpotModel.getPsid());
		this.psname=CommonUtil.trim(parkSpotModel.getPsname());  
		this.departmentid=CommonUtil.trim(parkSpotModel.getDepartmentid());  
		this.psaddress=CommonUtil.trim(parkSpotModel.getPsaddress()); 
		this.pstype=CommonUtil.trim(parkSpotModel.getPstype()); 
		this.longitude=CommonUtil.trim(parkSpotModel.getLongitude()); 
		this.latitude=CommonUtil.trim(parkSpotModel.getLatitude());  
		this.remark=CommonUtil.trim(parkSpotModel.getRemark());  
		
		 
	}

	@Override
	public ParkSpotModel vertModel() {
		// TODO Auto-generated method stub
		
		return null;
	}

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

	public String getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(String departmentid) {
		this.departmentid = departmentid;
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
    
    
    
	
}