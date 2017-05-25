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
import com.sx.weixin.dao.ParkSpotMapper; 
import com.sx.weixin.dto.MonitorDto;
import com.sx.weixin.dto.ParkSpotDto;
import com.sx.weixin.model.MonitorModel;
import com.sx.weixin.model.ParkSpotModel;
import com.sx.weixin.model.ParkSpotModel;
import com.sx.weixin.model.VideoSpotModel;
import com.sx.weixin.rs.MonitorMapRs;
import com.sx.weixin.rs.MonitorSpotsRs;
import com.sx.weixin.rs.ParkSpotsRs;
import com.sx.weixin.rs.TMCDetailRs;
import com.sx.weixin.rs.MonitorMapRs;
import com.sx.weixin.service.IParkSpotService;
import com.sx.weixin.util.CommonUtil;

@Service("parkspotService")
public class ParkSpotServiceImpl extends BaseServiceImpl implements IParkSpotService {
	
	public static final Logger logger = LoggerFactory.getLogger(ParkSpotServiceImpl.class);
 
	@Autowired
	private ParkSpotMapper parkSpotMapper;

	/* (non-Javadoc)
	 * @see com.sx.weixin.service.IParkSpotService#queryParkSpots(float, float, float, float)
	 */
	@Override
	public ParkSpotsRs queryParkSpots(float bigLat, float smallLat,
			float bigLng, float smallLng) {
		// TODO Auto-generated method stub
		
		ParkSpotsRs parkSpotsRs=new ParkSpotsRs();
		List<ParkSpotModel> parkSpotModelList = parkSpotMapper.selectScopeSpots(  bigLat,   smallLat,
	    		 bigLng, smallLng);
		ParkSpotDto parkSpotDto;
	    List<ParkSpotDto>	parkSpotDtoList=new ArrayList<ParkSpotDto>();
	    for(ParkSpotModel parkSpotModel:parkSpotModelList){
	    	parkSpotDto=new ParkSpotDto();
	    	parkSpotDto.buildDto(parkSpotModel);
	    	parkSpotDtoList.add(parkSpotDto); 
	    }
	    parkSpotsRs.setParkSpotDtoList(parkSpotDtoList);
		// TODO Auto-generated method stub
		return parkSpotsRs;
		 
	}

	/* (non-Javadoc)
	 * @see com.sx.weixin.service.IParkSpotService#queryUntransSpots()
	 */
	
	
}