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
import com.sx.weixin.rs.MapQueryAddressRs;
import com.sx.weixin.rs.MonitorSpotsRs;
import com.sx.weixin.service.IAccidentService;
import com.sx.weixin.service.IMapService;
import com.sx.weixin.service.IMonitorService;
import com.sx.weixin.store.AccidentStore;
import com.sx.weixin.util.Constant;
 

 
@Controller 
@RequestMapping(value="/map")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MapController  extends BaseController  {
	public static final Logger logger = LoggerFactory.getLogger(MapController.class);
	
	@Autowired
	private IMapService mapService;
	
	
	
	
	@RequestMapping(value="/query_address"  ) 
	public    @ResponseBody  Object queryAddress(HttpServletRequest request,HttpServletResponse response,Model model ,
			@RequestParam(value="lat", required=false)  String lat,
			@RequestParam(value="lng", required=false)  String lng 
			)
	{   
		  
		 MapQueryAddressRs  mapQueryAddressRs=mapService.queryAddress(lat,lng );
		   
		// logger.error("{}",accidentStore.getReportPhoneNumber());
		 return  mapQueryAddressRs;
	} 
	
	
	
}