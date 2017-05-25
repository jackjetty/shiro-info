package com.sx.weixin.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;

import com.sun.istack.internal.logging.Logger;
import com.sx.weixin.util.Constant;
import com.sx.weixin.util.DecriptUtil;
import com.sx.weixin.util.HttpWeiUtil; 
import com.sx.weixin.util.PropertyUtil;
public class BaseController {
	
	@Value("${wei.appid}") 
	protected String  APPID;
	
	@Value("${wei.appsecret}") 
	protected String  APPSECRET;
	
	
	
	@Value("${server.ip}") 
	protected String  SERVERIP;
	
	@Value("${server.domain}") 
	protected String  SERVERDOMAIN;
	
	
	
	protected void writeToResponse(HttpServletResponse response, String str) {

		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().write(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
    protected void confixWx(HttpServletRequest request, Model model){
		
		HttpSession session=request.getSession();
		String url=request.getRequestURL().toString();
		if(!StringUtils.isEmpty(request.getQueryString()))
			 url+= "?"+request.getQueryString();
		 
		
		//url=url.replace(Constant.NGINXPORT, "");
		String WxDebug="false";
		String WxAppId=APPID;
		String WxNoncestr=Constant.WXNONCESTR;
		String WxTimestamp=new Long(System.currentTimeMillis()/1000).toString();
		String WxUrl=url.replace(SERVERIP, SERVERDOMAIN); 
		model.addAttribute("WxDebug", WxDebug);
		model.addAttribute("WxAppId", WxAppId);
		model.addAttribute("WxTimestamp", WxTimestamp);
		model.addAttribute("WxNoncestr", WxNoncestr);
		//强制了啊
		//PropertyUtil.updateProperties(Constant.JSTICKET, "");
		//PropertyUtil.updateProperties(Constant.JSTICKETCREATTIME, "0");
		String unDecriptText="jsapi_ticket=" +HttpWeiUtil.getInstance(APPID, APPSECRET ).getJsTicket()+
				"&noncestr=" +WxNoncestr+
				"&timestamp=" +WxTimestamp+
				"&url="+WxUrl; 
		
		
		//System.out.println("unDecriptText:"+unDecriptText);
		String WxSignature=DecriptUtil.SHA1(unDecriptText);
		model.addAttribute("WxSignature", WxSignature);
		
    }
	
	

}