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
@RequestMapping(value="/error")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ErrorController   extends BaseController  {
	public static final Logger logger = LoggerFactory.getLogger(ErrorController.class);
	
 
	//@ResponseBody
	
	@RequestMapping(value="/auth_fail",produces="text/html;charset=UTF-8",method = RequestMethod.GET) 
	public    String  authFailPage(HttpServletRequest request,HttpServletResponse response,Model model)
	{  
		  
		 return "error/auth_fail.html";
	}
	@RequestMapping(value="/build_ing",produces="text/html;charset=UTF-8",method = RequestMethod.GET) 
	public    String  buildIngPage(HttpServletRequest request,HttpServletResponse response,Model model)
	{  
		  
		 return "error/build_ing.html";
	}
	
	
}