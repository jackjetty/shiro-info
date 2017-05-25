package com.sx.weixin.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.sx.weixin.model.HitchModel;

public interface HitchMapper {
    int deleteByPrimaryKey(String hitchid);

    int insert(HitchModel record);

    int insertSelective(HitchModel record);

    HitchModel selectByPrimaryKey(String hitchid);

    int updateByPrimaryKeySelective(HitchModel record);

    int updateByPrimaryKey(HitchModel record);
    
    String maxHitchId (@Param(value="reporttime")  Date reporttime);
    
     
}