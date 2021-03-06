package com.sx.weixin.service.impl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sx.weixin.dao.MonitorMapper;
import com.sx.weixin.dao.VideoSpotMapper;
import com.sx.weixin.dto.MonitorDto;
import com.sx.weixin.dto.MonitorDto;
import com.sx.weixin.dto.VideoSpotDto;
import com.sx.weixin.model.MonitorModel;
import com.sx.weixin.model.MonitorModel;
import com.sx.weixin.model.VideoSpotModel;
import com.sx.weixin.rs.MonitorMapRs;
import com.sx.weixin.rs.MonitorSpotsRs; 
import com.sx.weixin.rs.TMCDetailRs;
import com.sx.weixin.rs.MonitorMapRs;
import com.sx.weixin.service.IMonitorService;
import com.sx.weixin.util.CommonUtil;

@Service("monitorService")
public class MonitorServiceImpl extends BaseServiceImpl implements IMonitorService {
	
	public static final Logger logger = LoggerFactory.getLogger(TMCServiceImpl.class);
 
	@Autowired
	private MonitorMapper monitorMapper;

	/* (non-Javadoc)
	 * @see com.sx.weixin.service.IMonitorService#mapMonitor()
	 */
	@Override
	public MonitorMapRs mapMonitor() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.sx.weixin.service.IMonitorService#queryMonitorSpots(java.lang.String, java.lang.String, float, float, float, float)
	 */
	@Override
	public MonitorSpotsRs queryMonitorSpots(String monitorType,
			String position, float bigLat, float smallLat, float bigLng,
			float smallLng) {
		
		
		MonitorSpotsRs monitorSpotsRs=new MonitorSpotsRs();
		List<MonitorModel> monitorModelList = monitorMapper.selectScopeSpots(  monitorType,
	    		 position,  bigLat,   smallLat,
	    		 bigLng, smallLng);
		MonitorDto monitorDto;
	    List<MonitorDto>	monitorDtoList=new ArrayList<MonitorDto>();
	    for(MonitorModel monitorModel:monitorModelList){
	    	monitorDto=new MonitorDto();
	    	monitorDto.buildDto(monitorModel);
	    	monitorDtoList.add(monitorDto); 
	    }
	    monitorSpotsRs.setMonitorDtoList(monitorDtoList); 
		// TODO Auto-generated method stub
		return monitorSpotsRs;
	}
	
	
	@Override
	public MonitorSpotsRs queryUntransSpots() {
		// TODO Auto-generated method stub
		MonitorSpotsRs monitorsRs=new MonitorSpotsRs();
		List<MonitorModel> monitorModelList = monitorMapper.selectUntransScopeSpots(   );
		MonitorDto monitorDto;
	    List<MonitorDto>	monitorDtoList=new ArrayList<MonitorDto>();
	    for(MonitorModel monitorModel:monitorModelList){
	    	monitorDto=new MonitorDto();
	    	monitorDto.buildDto(monitorModel);
	    	monitorDtoList.add(monitorDto); 
	    }
	    monitorsRs.setMonitorDtoList(monitorDtoList);
		// TODO Auto-generated method stub
		return monitorsRs; 
	}
	
	
	@Override
	public boolean queryTrans(Integer monitorid, String lat, String lng) {
		// TODO Auto-generated method stub
		MonitorModel monitorModel= monitorMapper.selectByPrimaryKey(monitorid);
		if(monitorModel==null){
			logger.error("monitor编号为{}不存在！", monitorid);
			return false;
		}
		String remark=CommonUtil.trim(monitorModel.getRemark());
		
	    if(!remark.equalsIgnoreCase("0")){
	    	logger.error("monitor编号为{}remark已经非零为{}！", monitorid,remark);
			return false;
	    }
	    monitorModel.setLatitude(lat);
	    monitorModel.setLongitude(lng);
	    monitorModel.setRemark("1");
	    monitorMapper.updateByPrimaryKeySelective(monitorModel);
		
		
		return true;
	}
	
}