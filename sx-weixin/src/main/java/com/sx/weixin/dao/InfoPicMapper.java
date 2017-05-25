package com.sx.weixin.dao;

import com.sx.weixin.model.InfoPicModel;
import com.sx.weixin.model.InfoPicModelKey;

public interface InfoPicMapper {
    int deleteByPrimaryKey(InfoPicModelKey key);

    int insert(InfoPicModel record);

    int insertSelective(InfoPicModel record);

    InfoPicModel selectByPrimaryKey(InfoPicModelKey key);

    int updateByPrimaryKeySelective(InfoPicModel record);

    int updateByPrimaryKey(InfoPicModel record);
}