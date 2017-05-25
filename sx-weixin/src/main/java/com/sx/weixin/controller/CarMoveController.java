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
import com.sx.weixin.rs.CarMoveGainRs;
import com.sx.weixin.rs.MonitorSpotsRs;
import com.sx.weixin.service.IAccidentService;
import com.sx.weixin.service.ICarMoveService;
import com.sx.weixin.service.IMonitorService;
import com.sx.weixin.store.AccidentStore;
import com.sx.weixin.util.Constant;
 

 
@Controller 
@RequestMapping(value="/carmove")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CarMoveController  extends BaseController  {
	public static final Logger logger = LoggerFactory.getLogger(CarMoveController.class);
	
	@Autowired
	private ICarMoveService carMoveService;
	
	
	@RequestMapping(value="/capture",produces="text/html;charset=UTF-8",method = RequestMethod.GET) 
	public    String  capturePage(HttpServletRequest request,HttpServletResponse response,Model model)
	{  
		 
		super.confixWx(request, model);
		return "carmove/capture.html";
	}
	
	
	@RequestMapping(value="/gain"  ) 
	public    @ResponseBody  Object gain(HttpServletRequest request,HttpServletResponse response,Model model ,
			@RequestParam(value="cartype", required=false)  String cartype,
			@RequestParam(value="phonenumber", required=false)  String phonenumber,
			@RequestParam(value="carnumber", required=false)  String carnumber, 
			@RequestParam(value="locationx", required=false)  String locationx, 
			@RequestParam(value="locationy", required=false)  String locationy,  
			@RequestParam(value="morepath", required=false)  String[] morePath 
			)
	{   
		 HttpSession httpSession=request.getSession();  
		 
		 
		 CarMoveGainRs carMoveGainRs=new CarMoveGainRs();
		 if(httpSession.getAttribute(Constant.SESSION_OPEN_ID)==null){
			 carMoveGainRs.setCode(3);
			 carMoveGainRs.setInfo("session 失效,请重新上传！");
			 return carMoveGainRs;
		 }
		 
		 String openid=(String)httpSession.getAttribute(Constant.SESSION_OPEN_ID);
		 
		 
		  carMoveGainRs=carMoveService.gain(openid,cartype,phonenumber,
				 carnumber,locationx,locationy, morePath);
		   
		// logger.error("{}",accidentStore.getReportPhoneNumber());
		 return  carMoveGainRs;
	}
	
	
	
	
}