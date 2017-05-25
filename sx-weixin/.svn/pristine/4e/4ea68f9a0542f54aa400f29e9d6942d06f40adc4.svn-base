package com.sx.weixin.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sx.weixin.rs.AccidentGainImageRs;
import com.sx.weixin.rs.AccidentGainTextRs;
import com.sx.weixin.rs.AccidentGatherRs;
import com.sx.weixin.rs.HitchGainRs;
import com.sx.weixin.rs.HitchGainRs;
import com.sx.weixin.rs.MonitorSpotsRs;
import com.sx.weixin.service.IAccidentService;
import com.sx.weixin.service.IHitchService;
import com.sx.weixin.service.IMonitorService;
import com.sx.weixin.store.AccidentStore;
import com.sx.weixin.util.Constant;
 

 
@Controller 
@RequestMapping(value="/hitch")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class HitchController  extends BaseController  {
	public static final Logger logger = LoggerFactory.getLogger(HitchController.class);
	
	@Autowired
	private IHitchService hitchService;
	
	
	@RequestMapping(value="/capture",produces="text/html;charset=UTF-8",method = RequestMethod.GET) 
	public    String  capturePage(HttpServletRequest request,HttpServletResponse response,Model model)
	{  
		 
		super.confixWx(request, model);
		return "hitch/capture.html";
	}
	
	
	@RequestMapping(value="/gain"  ) 
	public    @ResponseBody  Object gain(HttpServletRequest request,HttpServletResponse response,Model model ,
			@RequestParam(value="phonenumber", required=false)  String phonenumber,
			@RequestParam(value="address", required=false)  String address,
			@RequestParam(value="locationx", required=false)  String locationx,   
			@RequestParam(value="locationy", required=false)  String locationy, 
			@RequestParam(value="hitchdes", required=false)  String hitchdes,  
			@RequestParam(value="morepath", required=false)  String[] morepath 
			)
	{   
		 HttpSession httpSession=request.getSession();  
		 
		 
		 HitchGainRs hitchGainRs=new HitchGainRs();
		 if(httpSession.getAttribute(Constant.SESSION_OPEN_ID)==null){
			 hitchGainRs.setCode(3);
			 hitchGainRs.setInfo("session 失效,请重新上传！");
			 return hitchGainRs;
		 }
		 
		 String openid=(String)httpSession.getAttribute(Constant.SESSION_OPEN_ID);
		 
		 
		 hitchGainRs=hitchService.gain(openid,phonenumber,
				  address,locationx,locationy,   hitchdes, morepath);
		   
		// logger.error("{}",accidentStore.getReportPhoneNumber());
		 return  hitchGainRs;
	}
	
	
}