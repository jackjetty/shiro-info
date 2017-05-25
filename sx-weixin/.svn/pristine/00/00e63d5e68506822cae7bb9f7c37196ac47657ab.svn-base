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

import com.sx.weixin.rs.FeedBackGainRs;
import com.sx.weixin.service.IFeedBackService;
import com.sx.weixin.util.Constant;
 

 
@Controller 
@RequestMapping(value="/feedback")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class FeedBackController  extends BaseController  {
	public static final Logger logger = LoggerFactory.getLogger(FeedBackController.class);
	
	@Autowired
	private IFeedBackService feedBackService;
	
	
	@RequestMapping(value="/report",produces="text/html;charset=UTF-8",method = RequestMethod.GET) 
	public    String  reportPage(HttpServletRequest request,HttpServletResponse response,Model model)
	{  
		 
		//super.confixWx(request, model);
		return "feedback/report.html";
	}
	
	
	@RequestMapping(value="/gain"  ) 
	public    @ResponseBody  Object gain(HttpServletRequest request,HttpServletResponse response,Model model ,
			@RequestParam(value="contact", required=false)  String contact,
			@RequestParam(value="feedtext", required=false)  String feedtext 
			)
	{   
		 HttpSession httpSession=request.getSession();  
		 
		 
		 FeedBackGainRs feedBackGainRs=new FeedBackGainRs();
		 if(httpSession.getAttribute(Constant.SESSION_OPEN_ID)==null){
			 feedBackGainRs.setCode(3);
			 feedBackGainRs.setInfo("session 失效,请重新上传！");
			 return feedBackGainRs;
		 } 
		 String openid=(String)httpSession.getAttribute(Constant.SESSION_OPEN_ID); 
		 feedBackGainRs=feedBackService.gain(openid,contact,feedtext );
		   
		// logger.error("{}",accidentStore.getReportPhoneNumber());
		 return  feedBackGainRs;
	}
}