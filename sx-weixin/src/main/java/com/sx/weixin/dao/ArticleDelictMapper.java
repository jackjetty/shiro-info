package com.sx.weixin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sx.weixin.model.AnnalsModel;
import com.sx.weixin.model.ArticleDelictModel;

public interface ArticleDelictMapper {
    int deleteByPrimaryKey(Integer adid);

    int insert(ArticleDelictModel record);

    int insertSelective(ArticleDelictModel record);

    ArticleDelictModel selectByPrimaryKey(Integer adid);

    int updateByPrimaryKeySelective(ArticleDelictModel record);

    int updateByPrimaryKeyWithBLOBs(ArticleDelictModel record);

    int updateByPrimaryKey(ArticleDelictModel record);
    
    
    List<ArticleDelictModel> getValidArticleDelictList( );
    
    
    
}