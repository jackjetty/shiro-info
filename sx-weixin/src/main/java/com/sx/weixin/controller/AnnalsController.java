package com.sx.weixin.controller;

import java.io.UnsupportedEncodingException;

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

import com.sx.weixin.rs.AnnalsInfoRs;
import com.sx.weixin.rs.AnnalsMoreRs;
import com.sx.weixin.rs.AnnalsRefreshRs;
import com.sx.weixin.rs.MonitorMapRs;
import com.sx.weixin.rs.MonitorSpotsRs;
import com.sx.weixin.rs.PoliceSpotsRs;
import com.sx.weixin.rs.TMCDetailRs;
import com.sx.weixin.service.IAnnalsService;
import com.sx.weixin.service.IMonitorService;
import com.sx.weixin.util.CommonUtil;

@Controller 
@RequestMapping(value="/annals")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class AnnalsController  extends BaseController   {
	public static final Logger logger = LoggerFactory.getLogger(AnnalsController.class);
	

	@Autowired
	private IAnnalsService annalsService;
	
	
	@RequestMapping(value="/refresh" ) 
	public    @ResponseBody  Object refresh(HttpServletRequest request,HttpServletResponse response,Model model ,
			  @RequestParam(value="bigLat", required=false)  String bigLat)
	{   
		AnnalsRefreshRs annalsRefreshRs=annalsService.refreshAnnals(  );
		   
		 return  annalsRefreshRs;
	}
	
	
	@RequestMapping(value="/info",produces="text/html;charset=UTF-8" ) 
	public    String  infoPage(HttpServletRequest request,HttpServletResponse response,Model model
			,@RequestParam(value="keyword", required=false)  String keyword)
	{  
		 
		//super.confixWx(request, model); 
		keyword=CommonUtil.trim(keyword); 
		AnnalsInfoRs annalsInfoRs=annalsService.infoAnnals(  keyword);  
		model.addAttribute("annalsInfoRs", annalsInfoRs); 
		return "annals/info.html";
	}
	
	@RequestMapping(value="/more" ) 
	public    @ResponseBody  Object refresh(HttpServletRequest request,HttpServletResponse response,Model model ,
			@RequestParam(value="keyword", required=false)  String keyword,
			@RequestParam(value="pageno", required=false)  Integer pageno
			 )
	{   
		
		
		/*if(!CommonUtil.trim(keyword).equals("")){
			try {
				keyword = java.net.URLDecoder.decode(keyword,"UTF-8");
				 
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		}*/
		AnnalsMoreRs annalsMoreRs=annalsService.moreAnnals( keyword, pageno);
		   
		 return  annalsMoreRs;
	}
	
	
	
	
	
	
}