package com.sx.weixin.controller;
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

import com.sx.weixin.rs.TMCDetailRs;
import com.sx.weixin.rs.TMCGridRs;
import com.sx.weixin.service.ITMCService;

 
 

 
@Controller 
@RequestMapping(value="/tmc")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TMCController  extends BaseController   {
	public static final Logger logger = LoggerFactory.getLogger(TMCController.class);
	

	@Autowired
	private ITMCService tmcService;
	
	//@ResponseBody
	
	@RequestMapping(value="/grid",produces="text/html;charset=UTF-8",method = RequestMethod.GET) 
	public    String  gridPage(HttpServletRequest request,HttpServletResponse response,Model model)
	{  
		 
		 TMCGridRs tmcGridRs=tmcService.gridTMC();
		 model.addAttribute("tmcGridRs", tmcGridRs);  
		 return "tmc/grid.html";
	}
	
	@RequestMapping(value="/detail",produces="text/html;charset=UTF-8",method = RequestMethod.GET) 
	public    String  detailPage(HttpServletRequest request,HttpServletResponse response,Model model ,
			@RequestParam(value="vsid", required=false)  String vsId)
	{  
		 
		 TMCDetailRs tmcDetailRs=tmcService.detailTMC(vsId);
		 model.addAttribute("tmcDetailRs", tmcDetailRs);  
		 return "tmc/detail.html";
	}
	
	
	
	
}