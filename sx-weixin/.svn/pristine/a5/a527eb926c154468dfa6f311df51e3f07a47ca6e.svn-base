package com.sx.weixin.service;
import org.rising.wei.bean.BaseBean;

import com.sx.weixin.rs.AccidentGainImageRs;
import com.sx.weixin.rs.AccidentGainTextRs;
import com.sx.weixin.rs.AccidentGatherRs; 
import com.sx.weixin.store.AccidentStore;




public interface IAccidentService extends IBaseService{

	public AccidentGatherRs gatherAccident(  ) ; 
	
	
	public AccidentGainTextRs  gainText(AccidentStore accidentStore,String address,String reportPhoneNumber,String otherPhoneNumber,String locationX,String locationY);
	
	
	public AccidentGainImageRs  gainImage(AccidentStore accidentStore,
			 String overviewPath, String centerPath,String  detailPath,String  paperPath,String[] morePath);
}