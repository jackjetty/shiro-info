package com.sx.weixin.service;
import org.rising.wei.bean.BaseBean;

 
import com.sx.weixin.rs.ArticleDelictDetailRs;
import com.sx.weixin.rs.ArticleDelictGridRs;
import com.sx.weixin.rs.ArticleDelictMoreRs;

public interface IArticleDelictService extends IBaseService{
 
	public  ArticleDelictGridRs  gridArticleDelict( );
	public  ArticleDelictDetailRs detailArticleDelict(   Integer adid );  
	public  ArticleDelictMoreRs  moreArticleDelict( Integer  pageno);
	 
}