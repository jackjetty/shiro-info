package com.sx.weixin.interceptor; 

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject; 
import com.sx.weixin.util.CommonUtil;
import com.sx.weixin.util.Constant; 
import com.sx.weixin.util.HttpWeiUtil;

/**
 * 
 * <p>Title : WeiXinOAuth2Interceptor</p>
 * <p>Description : 微信Oauth2.0 统一拦截器 </p>
 * <p>Company : 杭州冉思科技有限公司</p>
 * @author : caoyang
 * @date : 2016年12月14日 下午6:29:37
 */
public class WeiXinOAuth2Interceptor implements HandlerInterceptor {
	
	
	

	private static final Logger logger = LoggerFactory.getLogger(WeiXinOAuth2Interceptor.class);
	
	
	@Value("${wei.appid}") 
	protected String  WEIAPPID;
	
	@Value("${wei.appsecret}") 
	protected String  WEIAPPSECRET; 
	
	@Value("${url.mi}") 
	protected String  URLMI;  
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		    //此处配置需要通过OAuth2.0获取openId的URI 
			String openId = (String)request.getSession().getAttribute(Constant.SESSION_OPEN_ID);
			String oAuthAccessToken;  
			if(StringUtils.isBlank(openId)){//session里边没有openID
				String code = request.getParameter("code"); 
				if(StringUtils.isNotBlank(code)){//是微信重定向过来的请求  
					try { 
						oAuthAccessToken=HttpWeiUtil.getInstance(WEIAPPID, WEIAPPSECRET).getOAuthAccessToken(code);
						if(StringUtils.isNotEmpty(oAuthAccessToken)){
							
							JSONObject obj = JSONObject.parseObject(oAuthAccessToken); 
							if(!CommonUtil.trim(obj.getString("openid")).equals("")){
								openId=CommonUtil.trim(obj.getString("openid"));
							} 
							if(StringUtils.isBlank(openId))
							      logger.error("openId{},{}",openId,oAuthAccessToken);
							request.getSession().setAttribute(Constant.SESSION_OPEN_ID, openId);
							return true;
						}else{
							response.sendRedirect(request.getContextPath()+"/error/auth_fail");
							return false;
						}
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						response.sendRedirect(request.getContextPath()+"/error/auth_fail");
						return false;
					}
				}else{
					
					String state = request.getParameter("state");//需要oauth2返回的参数 
					//logger.debug("state============="+state);
					state="0";
					//PropertiesConf.getInstance().get("marketing.path")
					 response.sendRedirect("https://open.weixin.qq.com/connect/oauth2/authorize?appId="+WEIAPPID
							+"&redirect_uri="+URLMI+request.getRequestURI().replace(request.getContextPath(), "")+"&response_type=code&scope=snsapi_base&state="+state+"#wechat_redirect");
					 return false;
				}

			}
			
		 
		
		return true;
		
	}
	
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
