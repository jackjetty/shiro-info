package com.sx.weixin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sx.weixin.model.ParkSpotModel;
import com.sx.weixin.model.PoliceSpotModel;

public interface ParkSpotMapper {
    int deleteByPrimaryKey(Integer psid);

    int insert(ParkSpotModel record);

    int insertSelective(ParkSpotModel record);

    ParkSpotModel selectByPrimaryKey(Integer psid);

    int updateByPrimaryKeySelective(ParkSpotModel record);

    int updateByPrimaryKey(ParkSpotModel record);
    
    
    List<ParkSpotModel> selectScopeSpots(  @Param(value="biglat") float biglat, @Param(value="smalllat") float smalllat,
    		@Param(value="biglng") float biglng,
    		@Param(value="smalllng") float smalllng);
    
    
    List<ParkSpotModel>  selectUntransScopeSpots();
}