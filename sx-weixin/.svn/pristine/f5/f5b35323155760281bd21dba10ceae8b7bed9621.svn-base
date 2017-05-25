package com.sx.weixin.dao;

import java.util.List;

import com.sx.weixin.model.VideoSpotModel;

public interface VideoSpotMapper {
    int deleteByPrimaryKey(String vsid);

    int insert(VideoSpotModel record);

    int insertSelective(VideoSpotModel record);

    VideoSpotModel selectByPrimaryKey(String vsid);

    int updateByPrimaryKeySelective(VideoSpotModel record);

    int updateByPrimaryKey(VideoSpotModel record);
    
    List<VideoSpotModel> getValidVideoSpotList();
}