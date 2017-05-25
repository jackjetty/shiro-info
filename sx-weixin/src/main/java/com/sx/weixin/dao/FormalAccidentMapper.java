package com.sx.weixin.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.sx.weixin.model.FormalAccidentModel;

public interface FormalAccidentMapper {
    int deleteByPrimaryKey(String formlaccidentid);

    int insert(FormalAccidentModel record);

    int insertSelective(FormalAccidentModel record);

    FormalAccidentModel selectByPrimaryKey(String formlaccidentid);

    int updateByPrimaryKeySelective(FormalAccidentModel record);

    int updateByPrimaryKey(FormalAccidentModel record);
    
    
    String maxFormlAccidentId(@Param(value="reporttime")  Date reporttime);
}