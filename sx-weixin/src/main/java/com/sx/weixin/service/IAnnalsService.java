package com.sx.weixin.service;
import org.rising.wei.bean.BaseBean;

import com.sx.weixin.rs.AnnalsInfoRs;
import com.sx.weixin.rs.AnnalsMoreRs;
import com.sx.weixin.rs.AnnalsRefreshRs; 

public interface IAnnalsService extends IBaseService{
 
	public  AnnalsRefreshRs  refreshAnnals( );
	
	public  AnnalsInfoRs  infoAnnals( String keyword);
	
	public  AnnalsMoreRs  moreAnnals( String keyword, Integer pageno);
	   
}