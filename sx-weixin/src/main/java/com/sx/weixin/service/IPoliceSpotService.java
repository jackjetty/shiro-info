package com.sx.weixin.service;
import org.rising.wei.bean.BaseBean;
 
import com.sx.weixin.rs.PoliceSpotsRs;
 
  




public interface IPoliceSpotService extends IBaseService{
 
	public  PoliceSpotsRs  queryPoliceSpots(float bigLat, float smallLat,float bigLng,float smallLng);
	
	
	   
}