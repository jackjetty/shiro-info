package com.sx.weixin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sx.weixin.model.AnnalsModel;

public interface AnnalsMapper {
    int deleteByPrimaryKey(String anid);

    int insert(AnnalsModel record);

    int insertSelective(AnnalsModel record);

    AnnalsModel selectByPrimaryKey(String anid);

    int updateByPrimaryKeySelective(AnnalsModel record);

    int updateByPrimaryKey(AnnalsModel record);
    
    
    List<AnnalsModel> getValidAnnalsList(@Param(value="keyword") String keyword);
}