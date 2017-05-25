package com.sx.weixin.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.sx.weixin.model.CarMoveModel;

public interface CarMoveMapper {
    int deleteByPrimaryKey(String carmoveid);

    int insert(CarMoveModel record);

    int insertSelective(CarMoveModel record);

    CarMoveModel selectByPrimaryKey(String carmoveid);

    int updateByPrimaryKeySelective(CarMoveModel record);

    int updateByPrimaryKey(CarMoveModel record);
    
    
    String maxCarMoveId(@Param(value="reporttime")  Date reporttime);
    
    
    Integer queryLateCount(@Param(value="cartype")  String cartype,
    		   @Param(value="carnumber")  String carnumber,@Param(value="reporttime")  Date reporttime);
}