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
 
import com.sx.weixin.rs.ParkSpotsRs; 
import com.sx.weixin.service.IParkSpotService;

 
 

 
@Controller 
@RequestMapping(value="/parkspot")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ParkSpotController  extends BaseController   {
	public static final Logger logger = LoggerFactory.getLogger(ParkSpotController.class);
	

	@Autowired
	private IParkSpotService parkspotService;
	
	//
	
	@RequestMapping(value="/map",produces="text/html;charset=UTF-8",method = RequestMethod.GET) 
	public    String  mapPage(HttpServletRequest request,HttpServletResponse response,Model model)
	{  
		 
		super.confixWx(request, model);
		 return "parkspot/map.html";
	}
	
	
	
	
	
	@RequestMapping(value="/spots" ) 
	public    @ResponseBody  Object monitorSpots(HttpServletRequest request,HttpServletResponse response,Model model ,
			 
			@RequestParam(value="bigLat", required=false)  float bigLat,
			@RequestParam(value="smallLat", required=false)  float smallLat,
			@RequestParam(value="bigLng", required=false)  float bigLng,
			@RequestParam(value="smallLng", required=false)  float smallLng
			)
	{   
		 ParkSpotsRs parkSpotsRs=parkspotService.queryParkSpots( bigLat, smallLat, bigLng, smallLng);
		   
		 return  parkSpotsRs;
	}
	
	
	
	
	
	
	
}