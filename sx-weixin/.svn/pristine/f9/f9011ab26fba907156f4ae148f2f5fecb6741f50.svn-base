package com.sx.weixin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sx.weixin.model.PlaceAreaModel;

public interface PlaceAreaMapper {
    int deleteByPrimaryKey(Integer infoid);

    int insert(PlaceAreaModel record);

    int insertSelective(PlaceAreaModel record);

    PlaceAreaModel selectByPrimaryKey(Integer infoid);

    int updateByPrimaryKeySelective(PlaceAreaModel record);

    int updateByPrimaryKey(PlaceAreaModel record);
    
    
    List <PlaceAreaModel> selectByPlaceId(@Param(value="placeid") Integer placeid);
    
    
    
}