package com.sx.weixin.dao;

import com.sx.weixin.model.FeedBackModel;

public interface FeedBackMapper {
    int deleteByPrimaryKey(Integer feedbackid);

    int insert(FeedBackModel record);

    int insertSelective(FeedBackModel record);

    FeedBackModel selectByPrimaryKey(Integer feedbackid);

    int updateByPrimaryKeySelective(FeedBackModel record);

    int updateByPrimaryKeyWithBLOBs(FeedBackModel record);

    int updateByPrimaryKey(FeedBackModel record);
}