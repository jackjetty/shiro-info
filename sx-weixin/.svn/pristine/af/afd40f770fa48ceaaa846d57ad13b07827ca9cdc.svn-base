package com.sx.weixin.service;
import org.rising.wei.bean.BaseBean;

import com.sx.weixin.rs.MonitorMapRs;
import com.sx.weixin.rs.MonitorSpotsRs;
import com.sx.weixin.rs.ParkSpotsRs;
 
  




public interface IMonitorService extends IBaseService{

	public  MonitorMapRs  mapMonitor();
	public  MonitorSpotsRs  queryMonitorSpots(String monitorType,String  position, float bigLat, float smallLat,float bigLng,float smallLng);
	
	
    public MonitorSpotsRs  queryUntransSpots(  );
	
	public boolean  queryTrans(Integer monitorid, String lat ,String lng );
	   
}