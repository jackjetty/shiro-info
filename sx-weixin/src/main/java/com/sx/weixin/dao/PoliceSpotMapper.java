package com.sx.weixin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sx.weixin.model.MonitorModel;
import com.sx.weixin.model.PoliceSpotModel; 

public interface PoliceSpotMapper {
     

	int deleteByPrimaryKey(Integer psid);

    int insert(PoliceSpotModel record);

    int insertSelective(PoliceSpotModel record);

    PoliceSpotModel selectByPrimaryKey(Integer psid);

    int updateByPrimaryKeySelective(PoliceSpotModel record);

    int updateByPrimaryKey(PoliceSpotModel record);
    
    
    List<PoliceSpotModel> selectScopeSpots(  @Param(value="biglat") float biglat, @Param(value="smalllat") float smalllat,
    		@Param(value="biglng") float biglng,
    		@Param(value="smalllng") float smalllng);
}