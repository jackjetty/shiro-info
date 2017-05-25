package com.sx.weixin.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 

 
@Controller 
@RequestMapping(value="/home")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class HomeController   extends BaseController  {
	public static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
 
	//@ResponseBody
	
	@RequestMapping(value="/mi",produces="text/html;charset=UTF-8",method = RequestMethod.GET) 
	public    String  miPage(HttpServletRequest request,HttpServletResponse response,Model model)
	{  
		  
		 return "home/mi.html";
	}
	
	@RequestMapping(value="/mq",produces="text/html;charset=UTF-8",method = RequestMethod.GET) 
	public    String  mqPage(HttpServletRequest request,HttpServletResponse response,Model model)
	{  
		  
		 return "home/mq.html";
	}
	
	@RequestMapping(value="/ms",produces="text/html;charset=UTF-8",method = RequestMethod.GET) 
	public    String  msPage(HttpServletRequest request,HttpServletResponse response,Model model)
	{  
		  
		 return "home/ms.html";
	}
	
}