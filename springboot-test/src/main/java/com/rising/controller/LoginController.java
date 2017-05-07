/**
 * 
 */
package com.rising.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rising.model.UserModel;
import com.rising.service.UserService; 
import com.rising.util.Constant;


/**
 * @author pg
 * @日期 2017-5-6
 */
@Controller 
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class LoginController {
	public static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login",produces="text/html;charset=UTF-8",method = RequestMethod.GET) 
	public    String  loginPage(HttpServletRequest request,HttpServletResponse response,Model model)
	{  
		 
		/*
		logger.error("毕业生");
		logger.debug("This is a debug message");  
        logger.info("This is an info message");  
        logger.warn("This is a warn message");  
        logger.error("This is an error message");*/
		
		//super.confixWx(request, model);
		return "login";
	}
	
	
	//@Valid User user,BindingResult bindingResult,RedirectAttributes redirectAttributes
	
	@RequestMapping(value="/login",produces="text/html;charset=UTF-8",method = RequestMethod.POST) 
	public   String  login(HttpServletRequest request,HttpServletResponse response,Model model,
			RedirectAttributes redirectAttributes,
			@RequestParam(value="username", required=false) String userName,
			@RequestParam(value="password", required=false) String password)
	{  
		 
		HttpSession session=request.getSession();
		UserModel userModel=userService.checkUser(userName, password);
		UsernamePasswordToken token = new UsernamePasswordToken("张三", "123456");
        //获取当前的Subject  
        Subject currentUser = SecurityUtils.getSubject(); 
        try {  
            //在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查  
            //每个Realm都能在必要时对提交的AuthenticationTokens作出反应  
            //所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法  
            logger.info("对用户[" + userName + "]进行登录验证..验证开始");  
            currentUser.login(token);  
            logger.info("对用户[" + userName + "]进行登录验证..验证通过");  
        }catch(UnknownAccountException uae){  
            logger.info("对用户[" + userName + "]进行登录验证..验证未通过,未知账户");  
            redirectAttributes.addFlashAttribute("message", "未知账户");  
        }catch(IncorrectCredentialsException ice){  
        	
        	
        	
            logger.info("对用户[" + userName + "]进行登录验证..验证未通过,错误的凭证");  
            redirectAttributes.addFlashAttribute("message", "密码不正确");  
        }catch(LockedAccountException lae){  
            logger.info("对用户[" + userName + "]进行登录验证..验证未通过,账户已锁定");  
            redirectAttributes.addFlashAttribute("message", "账户已锁定");  
        }catch(ExcessiveAttemptsException eae){  
            logger.info("对用户[" + userName + "]进行登录验证..验证未通过,错误次数过多");  
            redirectAttributes.addFlashAttribute("message", "用户名或密码错误次数过多");  
        }catch(AuthenticationException ae){  
            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景  
            logger.info("对用户[" + userName + "]进行登录验证..验证未通过,堆栈轨迹如下");  
            ae.printStackTrace();  
            redirectAttributes.addFlashAttribute("message", "用户名或密码不正确");  
        }  
        //验证是否登录成功  
        if(currentUser.isAuthenticated()){  
            logger.info("用户[" + userName + "]登录认证通过(这里可以进行一些认证通过后的一些系统参数初始化操作)"); 
            session.setAttribute(Constant.SESSION_USER, userModel);
    		model.addAttribute("title", "HelloWorld"); 
            return "forward:/index.do";
    		//return "index";
        }else{  
            token.clear();  
            //return "redirect:/login.do";
            return "login";
        }  
		 
		
		//return "index";
	}
	
	//@ResponseBody 
	@RequestMapping(value="/logout") 
	public  String  logout(HttpServletRequest request,HttpServletResponse response,Model model,RedirectAttributes redirectAttributes)
	{  
		 
		HttpSession session=request.getSession();
		session.removeAttribute(Constant.SESSION_USER);
		
		SecurityUtils.getSubject().logout();  
	    redirectAttributes.addFlashAttribute("message", "您已安全退出");  
		return "login";
	}
	
	@RequestMapping("/403")
    public String unauthorizedRole(){
        logger.info("------没有权限-------");
        return "403";
    }
	

}
