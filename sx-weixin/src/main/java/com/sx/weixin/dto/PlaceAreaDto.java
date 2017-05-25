package com.sx.weixin.dto;
import com.sx.weixin.model.PlaceAreaModel; 
import com.sx.weixin.util.CommonUtil;
import com.sx.weixin.util.DateUtil;
public class PlaceAreaDto   extends BaseDto<PlaceAreaModel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5910214428093246250L;
	
	private String infoid;

    private String placeid;

    private String latitude;

    private String longitude;
    
    
	
	
	public String getInfoid() {
		return infoid;
	}

	public void setInfoid(String infoid) {
		this.infoid = infoid;
	}

	public String getPlaceid() {
		return placeid;
	}

	public void setPlaceid(String placeid) {
		this.placeid = placeid;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Override
	public void buildDto(PlaceAreaModel placeAreaModel) {
		// TODO Auto-generated method stub 
		this.infoid=CommonUtil.trim(placeAreaModel.getInfoid());
		this.placeid=CommonUtil.trim(placeAreaModel.getPlaceid());  
		this.latitude=DateUtil.getDateForm(placeAreaModel.getLatitude());  
		this.longitude=CommonUtil.trim(placeAreaModel.getLongitude());  
		
		
		 
	}

	@Override
	public PlaceAreaModel vertModel() {
		// TODO Auto-generated method stub
		
		return null;
	}
	
	
}