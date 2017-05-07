/**
 * 
 */
package com.rising.controller;

import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rising.model.UserModel;
import com.rising.service.UserService;

/**
 * @author pg
 * @日期 2017-5-7
 */

@Controller 
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@RequestMapping("/redis")
public class RedisController {
	public static final Logger logger = LoggerFactory.getLogger(RedisController.class);
	
	
	@Autowired
    private StringRedisTemplate stringRedisTemplate;
    
	@Autowired
	private RedisTemplate redisTemplate;
	
	@Autowired
	private UserService userService;
	
	@RequiresAuthentication 
	@RequestMapping(value="/simple",method = RequestMethod.GET) 
	public @ResponseBody   String  simple(HttpServletRequest request,HttpServletResponse response,Model model)
	{  
		stringRedisTemplate.opsForValue().set("aaa", "111");
		
		return "simple";
	}
	
	/*
	@RequiresAuthentication  
	表示当前Subject已经通过login进行了身份验证；即Subject. isAuthenticated()返回true。 

	@RequiresUser  
	表示当前Subject已经身份验证或者通过记住我登录的。

	@RequiresGuest  
	表示当前Subject没有身份验证或通过记住我登录过，即是游客身份。
	  
	@RequiresRoles(value={“admin”, “user”}, logical= Logical.AND)  
	表示当前Subject需要角色admin和user。

	@RequiresPermissions (value={“user:a”, “user:b”}, logical= Logical.OR)  
	表示当前Subject需要权限user:a或user:b。*/ 
	
	@RequestMapping(value="/complate",method = RequestMethod.GET) 
	public @ResponseBody   String  complate(HttpServletRequest request,HttpServletResponse response,Model model) throws InterruptedException
	{  
		UserModel userModel=userService.checkUser("li", "huang");
		ValueOperations<String, UserModel> operations=redisTemplate.opsForValue();
       // operations.set("com.neox", user);
        operations.set("com.neo.f", userModel,3,TimeUnit.SECONDS);
        Thread.sleep(1000);
        boolean exists=redisTemplate.hasKey("com.neo.f");
        
      //operations.get("com.neo.f").getUserName()
        return new Boolean(exists).toString();
		
	}
	
	
	
	@RequestMapping(value="/check_simple",method = RequestMethod.GET) 
	public @ResponseBody   String  checkSimple(HttpServletRequest request,HttpServletResponse response,Model model)
	{  
		
		return stringRedisTemplate.opsForValue().get("aaa");
	}
	
	
	
}
