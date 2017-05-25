package com.sx.weixin.controller;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import com.sx.weixin.rs.MonitorMapRs;
import com.sx.weixin.rs.MonitorSpotsRs;
import com.sx.weixin.rs.MonitorSpotsRs;
import com.sx.weixin.rs.TMCDetailRs;
import com.sx.weixin.service.IMonitorService;

 
 

 
@Controller 
@RequestMapping(value="/monitor")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MonitorController  extends BaseController   {
	public static final Logger logger = LoggerFactory.getLogger(MonitorController.class);
	

	@Autowired
	private IMonitorService monitorService;
	 
	
	@RequestMapping(value="/map",produces="text/html;charset=UTF-8",method = RequestMethod.GET) 
	public    String  mapPage(HttpServletRequest request,HttpServletResponse response,Model model)
	{  
		 super.confixWx(request, model);
		 MonitorMapRs monitorMapRs=monitorService.mapMonitor();
		 model.addAttribute("monitorMapRs", monitorMapRs);  
		 
		 return "monitor/map.html";
	}
	
	
	
	@RequestMapping(value="/monitorspots"  ) 
	public    @ResponseBody  Object monitorSpots(HttpServletRequest request,HttpServletResponse response,Model model ,
			@RequestParam(value="monitorType", required=false)  String monitorType,
			@RequestParam(value="position", required=false)  String position,
			@RequestParam(value="bigLat", required=false)  float bigLat,
			@RequestParam(value="smallLat", required=false)  float smallLat,
			@RequestParam(value="bigLng", required=false)  float bigLng,
			@RequestParam(value="smallLng", required=false)  float smallLng
			)
	{   
		 MonitorSpotsRs monitorSpotsRs=monitorService.queryMonitorSpots(monitorType, position, bigLat, smallLat, bigLng, smallLng);
		   
		 return  monitorSpotsRs;
	}
	
	
	@RequestMapping(value="/test",produces="text/html;charset=UTF-8",method = RequestMethod.GET) 
	public    String  testPage(HttpServletRequest request,HttpServletResponse response,Model model)
	{  
		 
		 
		 return "monitor/test.html";
	}
	@RequestMapping(value="/untransspots" ) 
	public    @ResponseBody  Object untransSpots(HttpServletRequest request,HttpServletResponse response,Model model  )
	{   
		 MonitorSpotsRs parkSpotsRs=monitorService.queryUntransSpots(  );
		   
		 return  parkSpotsRs;
	}
	
	
	@RequestMapping(value="/trans" ) 
	public    @ResponseBody  Object transSpots(HttpServletRequest request,HttpServletResponse response,Model model
			,@RequestParam(value="monitorid", required=false)  Integer monitorid
			,@RequestParam(value="lat", required=false)  String lat 
			,@RequestParam(value="lng", required=false)  String lng)
	{   
		 Map result=new HashMap();
		 
		 boolean sign=monitorService.queryTrans( monitorid, lat ,lng );
		 result.put("code", 1);
		 if(sign){
			 result.put("code", 0);
		 }
		   
		 return  result;
	}
}