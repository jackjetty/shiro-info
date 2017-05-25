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
import com.sx.weixin.rs.MonitorSpotsRs;
import com.sx.weixin.service.IAccidentService;
import com.sx.weixin.service.IMonitorService;
import com.sx.weixin.store.AccidentStore;
import com.sx.weixin.util.Constant;
 

 
@Controller 
@RequestMapping(value="/accident")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class AccidentController  extends BaseController  {
	public static final Logger logger = LoggerFactory.getLogger(AccidentController.class);
	
	@Autowired
	private IAccidentService accidentService;
	//@ResponseBody
	
	@RequestMapping(value="/guide",produces="text/html;charset=UTF-8",method = RequestMethod.GET) 
	public    String  guidePage(HttpServletRequest request,HttpServletResponse response,Model model)
	{  
		  
		 return "accident/guide.html";
	}
	@RequestMapping(value="/brief",produces="text/html;charset=UTF-8",method = RequestMethod.GET) 
	public    String  briefPage(HttpServletRequest request,HttpServletResponse response,Model model)
	{  
		  
		 return "accident/brief.html";
	}
	
	@RequestMapping(value="/overtime",produces="text/html;charset=UTF-8",method = RequestMethod.GET) 
	public    String  overtimePage(HttpServletRequest request,HttpServletResponse response,Model model)
	{  
		  
		 return "accident/overtime.html";
	}
	
	
	
	@RequestMapping(value="/gather",produces="text/html;charset=UTF-8",method = RequestMethod.GET) 
	public    String  gatherPage(HttpServletRequest request,HttpServletResponse response,Model model)
	{  
		   
		AccidentGatherRs accidentGatherRs=accidentService.gatherAccident();
		
		if(accidentGatherRs.getCode()==10){
			return "redirect:/accident/overtime";
		} 
		
		model.addAttribute("accidentGatherRs", accidentGatherRs);
		super.confixWx(request, model);
		
		return "accident/gather.html";
	}
	
	@RequestMapping(value="/capture",produces="text/html;charset=UTF-8",method = RequestMethod.GET) 
	public    String  capturePage(HttpServletRequest request,HttpServletResponse response,Model model)
	{  
		 
		super.confixWx(request, model);
		return "accident/capture.html";
	}
	
	
	@RequestMapping(value="/gain_text"  ) 
	public    @ResponseBody  Object gainText(HttpServletRequest request,HttpServletResponse response,Model model ,
			@RequestParam(value="address", required=false)  String address,
			@RequestParam(value="reportPhoneNumber", required=false)  String reportPhoneNumber,
			@RequestParam(value="otherPhoneNumber", required=false)  String otherPhoneNumber,
			@RequestParam(value="locationX", required=false)  String locationX,
			@RequestParam(value="locationY", required=false)  String locationY 
			)
	{   
		 HttpSession httpSession=request.getSession(); 
		 AccidentStore accidentStore=new AccidentStore();
		 httpSession.setAttribute(Constant.SESSION_ACCIDENT_STORE, accidentStore);
		 accidentStore.setReportopenId((String)httpSession.getAttribute(Constant.SESSION_OPEN_ID));
		 
		 AccidentGainTextRs accidentGainTextRs=accidentService.gainText(accidentStore,address, reportPhoneNumber, otherPhoneNumber, locationX, locationY);
		   
		// logger.error("{}",accidentStore.getReportPhoneNumber());
		 return  accidentGainTextRs;
	}
	
	@RequestMapping(value="/gain_image"  ) 
	public    @ResponseBody  Object gainImage(HttpServletRequest request,HttpServletResponse response,Model model ,
			@RequestParam(value="overviewpath", required=false)  String overviewPath,
			@RequestParam(value="centerpath", required=false)  String centerPath,
			@RequestParam(value="detailpath", required=false)  String detailPath,
			@RequestParam(value="paperpath", required=false)  String paperPath,
			@RequestParam(value="morepath", required=false)  String[] morePath 
			)
	{   
		 HttpSession httpSession=request.getSession(); 
		 AccidentGainImageRs accidentGainImageRs=new AccidentGainImageRs();
		 if(httpSession.getAttribute(Constant.SESSION_ACCIDENT_STORE)==null){
			 accidentGainImageRs.setCode(3);
			 accidentGainImageRs.setInfo("session 失效,请重新上传！");
			 return accidentGainImageRs;
		 }
		 
		 
		 AccidentStore accidentStore=  (AccidentStore) httpSession.getAttribute(Constant.SESSION_ACCIDENT_STORE);
		 
		 accidentGainImageRs=accidentService.gainImage(accidentStore,
				 overviewPath, centerPath, detailPath, paperPath, morePath);
		   
		// logger.error("{}",accidentStore.getReportPhoneNumber());
		 return  accidentGainImageRs;
	}
	
	
	
	
	
	
	@RequestMapping(value="/claims",produces="text/html;charset=UTF-8",method = RequestMethod.GET) 
	public    String  claimsPage(HttpServletRequest request,HttpServletResponse response,Model model)
	{  
		  
		 return "accident/claims.html";
	}
	
	@RequestMapping(value="/responsibility",produces="text/html;charset=UTF-8",method = RequestMethod.GET) 
	public    String  responsibilityPage(HttpServletRequest request,HttpServletResponse response,Model model)
	{  
		  
		 return "accident/responsibility.html";
	}
	
	@RequestMapping(value="/scope",produces="text/html;charset=UTF-8",method = RequestMethod.GET) 
	public    String  scopePage(HttpServletRequest request,HttpServletResponse response,Model model)
	{  
		  
		 return "accident/scope.html";
	}
	
	
	
	
	
}