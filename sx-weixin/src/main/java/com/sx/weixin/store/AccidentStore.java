package com.sx.weixin.store; 
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List; 
import com.sx.weixin.store.info.LocationStoreInfo;
import com.sx.weixin.store.info.PictureStoreInfo; 
public class AccidentStore implements Serializable{

	 
	private static final long serialVersionUID = 230036801185949546L; 
	private String accidentId;
	private String reportopenId;
	private String reportPhoneNumber; 
	private LocationStoreInfo locationInfo;
	private String otherPhoneNumber;
	private ArrayList <PictureStoreInfo> pictureInfoList;
	 
	public String getAccidentId() {
		return accidentId;
	}
	public void setAccidentId(String accidentId) {
		this.accidentId = accidentId;
	}
	
	public String getReportopenId() {
		return reportopenId;
	}
	public void setReportopenId(String reportopenId) {
		this.reportopenId = reportopenId;
	}
	public String getReportPhoneNumber() {
		return reportPhoneNumber;
	}
	public void setReportPhoneNumber(String reportPhoneNumber) {
		this.reportPhoneNumber = reportPhoneNumber;
	}
	public LocationStoreInfo getLocationInfo() {
		return locationInfo;
	}
	public void setLocationInfo(LocationStoreInfo locationInfo) {
		this.locationInfo = locationInfo;
	}
	 
	public String getOtherPhoneNumber() {
		return otherPhoneNumber;
	}
	public void setOtherPhoneNumber(String otherPhoneNumber) {
		this.otherPhoneNumber = otherPhoneNumber;
	}
	public ArrayList<PictureStoreInfo> getPictureInfoList() {
		return pictureInfoList;
	}
	public void setPictureInfoList(ArrayList<PictureStoreInfo> pictureInfoList) {
		this.pictureInfoList = pictureInfoList;
	}
	 
	
	
	
}