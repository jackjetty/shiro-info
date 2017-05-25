package com.sx.weixin.service;
import org.rising.wei.bean.BaseBean;
 
import com.sx.weixin.rs.TMCDetailRs;
import com.sx.weixin.rs.TMCGridRs;




public interface ITMCService extends IBaseService{

	public TMCGridRs gridTMC(  ) ; 
	
	
	public TMCDetailRs  detailTMC(String vsId);
}
