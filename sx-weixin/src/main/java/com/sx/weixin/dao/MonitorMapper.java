package com.sx.weixin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sx.weixin.model.MonitorModel;
import com.sx.weixin.model.ParkSpotModel;

public interface MonitorMapper {
    int deleteByPrimaryKey(Integer monitorid);

    int insert(MonitorModel record);

    int insertSelective(MonitorModel record);

    MonitorModel selectByPrimaryKey(Integer monitorid);

    int updateByPrimaryKeySelective(MonitorModel record);

    int updateByPrimaryKey(MonitorModel record);
    
    
    List<MonitorModel> selectScopeSpots(@Param(value="monitortype") String monitortype,
    		@Param(value="position") String position, @Param(value="biglat") float biglat, @Param(value="smalllat") float smalllat,
    		@Param(value="biglng") float biglng,
    		@Param(value="smalllng") float smalllng);
    
    
    List<MonitorModel>  selectUntransScopeSpots();
}