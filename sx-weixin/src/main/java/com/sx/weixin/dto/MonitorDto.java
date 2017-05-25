package com.sx.weixin.dto;
import com.sx.weixin.model.MonitorModel;
import com.sx.weixin.util.CommonUtil;
public class MonitorDto   extends BaseDto<MonitorModel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2751168693271545264L;
	private String monitorid;

    private String position;

    private String longitude;

    private String latitude;

    private String direction;

    private String monitortypename;
    
    private String remark;
    
    

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getMonitorid() {
		return monitorid;
	}

	public void setMonitorid(String monitorid) {
		this.monitorid = monitorid;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
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

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getMonitortypename() {
		return monitortypename;
	}

	public void setMonitortypename(String monitortypename) {
		this.monitortypename = monitortypename;
	}
    
	@Override
	public void buildDto(MonitorModel monitorModel) {
		// TODO Auto-generated method stub 
		this.monitorid=CommonUtil.trim(monitorModel.getMonitorid());
		this.position=CommonUtil.trim(monitorModel.getPosition());  
		this.longitude=CommonUtil.trim(monitorModel.getLongitude());  
		this.latitude=CommonUtil.trim(monitorModel.getLatitude());  
		this.direction=CommonUtil.trim(monitorModel.getDirection()); 
		this.monitortypename=CommonUtil.trim(monitorModel.getMonitortypename()); 
		this.remark=CommonUtil.trim(monitorModel.getRemark());  
		 
	}

	@Override
	public MonitorModel vertModel() {
		// TODO Auto-generated method stub
		
		return null;
	}
	
	
}