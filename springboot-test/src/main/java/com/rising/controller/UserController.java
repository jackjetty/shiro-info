/**
 * 
 */
package com.rising.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rising.service.UserService;

/**
 * @author pg
 * @日期 2017-5-6
 */
@Controller 
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UserController {
    public static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/user",produces="text/html;charset=UTF-8",method = RequestMethod.GET) 
	public    String  userPage(HttpServletRequest request,HttpServletResponse response,Model model)
	{  
		Subject currentUser = SecurityUtils.getSubject();  
		if (currentUser.hasRole("administrator")) {  
		    //show the admin button  
		} else {  
		    //don't show the button?  Grey it out? 
			
			return "login";
		}  
		
		return "user";
	}
	
}
