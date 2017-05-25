package com.sx.weixin.controller; 
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
 
 
@Controller
@RequestMapping("/weUi")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class WeUiController  extends BaseController{
	public static final Logger logger = LoggerFactory.getLogger(WeUiController.class); 
	
	@RequestMapping(value = "/") 
	public String testPage(HttpSession session, HttpServletRequest request,
			HttpServletResponse response,Model model, 
			@RequestParam(value="userName", required=false) String userName ) { 
		logger.info("好吧我就是测试日志输出了啊 {}","这是什么情况info");
		logger.error("好吧我就是测试日志输出了啊 {}","这是什么情况error");
		//weiUserService.testRoll();
 
		 // return "redirect:/questionDetail/questionDetailPage?qsId=QS16060110001";
 
		 //return "redirect:/questionDetail/questionDetailPage?qsId=QS16060110001";
 
		 // forward
		/*try {
			response.sendRedirect("http://www.baidu.com");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//
		return null;*/
		//return "redirect:http://www.baidu.com";
		//return "redirect:/weUi/search";
		return "weui/index.html";
	}
	
	
	@RequestMapping(value = "/search") 
	public String search(HttpSession session, HttpServletRequest request, Model model, 
			@RequestParam(value="userName", required=false) String userName ) { 
		model.addAttribute("tt", "123");
		 
		model.addAttribute("tt", "123454");
		Map<String,Object> modelMap=model.asMap();
		for (String key : modelMap.keySet()) {
			   System.out.println("key= "+ key + " and value= " + modelMap.get(key));
		}
		
		return "weui/search.html";
	}
	
	 
	
}