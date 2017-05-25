package com.sx.weixin.util; 
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.rising.wei.bean.AccessTokenBean;
import org.rising.wei.bean.UserBean;

 

import com.alibaba.fastjson.JSONObject; 
 
 
public class HttpWeiUtil { 
	private static final String TOKEN_URI="https://api.weixin.qq.com/cgi-bin/token";
	private static final String USER_INFO_URI = "https://api.weixin.qq.com/cgi-bin/user/info";
	private static final String USER_GET_URI = "https://api.weixin.qq.com/cgi-bin/user/get"; 
	private static final String MESSAGE_URL = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=";
	private static final String TICKET_URL="https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=";
	private static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token";
	private static final String JS_TICKET_URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket";
	public  static final String DOWN_MEDIA_URL="http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=%s&media_id=%s";
	private static final String BATCH_MATERIAL_URL = "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=";
	
	
	private static HttpWeiUtil httpWeiUtil;   
	private String appid; 
	private String secret;
	 
	
	 
    private HttpWeiUtil(String appid,String secret){  
          this.appid=appid;
          this.secret=secret;
    }   
    public static HttpWeiUtil getInstance(String appid,String secret){  
        if(httpWeiUtil == null){  
        	httpWeiUtil = new HttpWeiUtil(appid,secret);  
        }  
        return httpWeiUtil;  
    }  
   
    public String sendCustMsg( String openId, String text) throws Exception {
        Map<String,Object> json = new HashMap<String,Object>();
        Map<String,Object> textObj = new HashMap<String,Object>();
        textObj.put("content", text);
        json.put("touser", openId);
        json.put("msgtype", "text");
        json.put("text", textObj);
        String post = JSONObject.toJSONString(json);
    	String reslut = new HttpKit().post(MESSAGE_URL.concat(getAccessToken(false)), post);
    	 
        return reslut;
    }
    
    
    public String batchMaterial( int offset, int count) throws Exception {
        Map<String,Object> json = new HashMap<String,Object>(); 
        json.put("type", "news");
        json.put("offset", offset);
        json.put("count",  count); 
        String post = JSONObject.toJSONString(json);
    	String reslut = new HttpKit().post(BATCH_MATERIAL_URL.concat(getAccessToken(false)), post);
    	 
        return reslut;
    }
    
    
    
    
    public String getLimitTicket(int  sceneId ) throws Exception{
    	 Map<String,Object> json = new HashMap<String,Object>();
    	 Map<String,Object> scene= new HashMap<String,Object>();
    	 scene.put("scene_id", sceneId);
    	 Map<String,Object> action_info= new HashMap<String,Object>();
    	 action_info.put("scene", scene);
    	 json.put("action_name", "QR_LIMIT_SCENE");
    	 json.put("action_info", action_info);
    	 String post = JSONObject.toJSONString(json);
     	 String jsonStr = new HttpKit().post(TICKET_URL.concat(getAccessToken(false)), post);
     	if(StringUtils.isNotEmpty(jsonStr)){ 
			JSONObject obj = JSONObject.parseObject(jsonStr);
			if(obj.get("errcode") != null){
				throw new Exception(obj.getString("errmsg"));
			}  
			return obj.get("ticket").toString(); 
		}
    	return null;  
    }
    
    public String getAccessToken(boolean force) throws Exception{ 
    	boolean sign=true;
    	if(force)
       	   sign=false;
    	String accessToken=PropertyUtil.getKeyValue(Constant.ACCESSTOKEN);
    	String accessTokenCreatTime=PropertyUtil.getKeyValue(Constant.ACCESSTOKENCREATTIME);
    	accessToken=CommonUtil.trim(accessToken);
    	accessTokenCreatTime=CommonUtil.trim(accessTokenCreatTime);
    	if(accessToken.equalsIgnoreCase("")){
    	 
    		sign=false;
    	}
    	Long currentTime=System.currentTimeMillis();
    	Long creatTime=0L;
    	Long midTime;
    	if(CommonUtil.isInteger(accessTokenCreatTime)){
    		creatTime =  Long.parseLong(accessTokenCreatTime);
    	}
    	
    	
    	//7200
    	
    	midTime=currentTime-creatTime;
    	midTime=midTime/1000;
    	if(sign&&(midTime>60*50)){
     
    		sign=false;
    	}
    	Map<String, String> params = new HashMap<String, String>();
    	if(sign){ 
    		params.put("access_token", accessToken);
    		params.put("openid", "");
    		String  jsonStr = new HttpKit().get(USER_INFO_URI, params);
    		JSONObject obj = JSONObject.parseObject(jsonStr);
			if( obj.get("errcode") != null ){
				if(!(obj.get("errcode").toString().equals("40001"))){
					return accessToken;
				}
			}
    		
    	}
    		
    	 
		params = new HashMap<String, String>();
		params.put("grant_type", "client_credential");  
        params.put("appid", appid);
        params.put("secret", secret ); 
        String  jsonStr = new HttpKit().get(TOKEN_URI, params); 
		if(StringUtils.isNotEmpty(jsonStr)){
			// = JSON.parseObject(json,);
			JSONObject obj = JSONObject.parseObject(jsonStr);
			if(obj.get("errcode") != null){
				throw new Exception(obj.getString("errmsg"));
			}
			AccessTokenBean accessTokenBean  = JSONObject.toJavaObject(obj, AccessTokenBean.class);
			accessToken=accessTokenBean.getAccess_token();
			accessTokenCreatTime=new Long(System.currentTimeMillis()).toString();
			PropertyUtil.updateProperties(Constant.ACCESSTOKEN, accessToken);  
			PropertyUtil.updateProperties(Constant.ACCESSTOKENCREATTIME, accessTokenCreatTime);  
			return accessToken; 
		}
		PropertyUtil.updateProperties(Constant.ACCESSTOKEN, "");  
		PropertyUtil.updateProperties(Constant.ACCESSTOKENCREATTIME, "0");  
		return ""; 
	}
    
    
    public UserBean getUserBean(String openid) throws Exception {
    	String accessToken=getAccessToken(false);
    	if(accessToken==null)
    		 return null;
		Map<String, String> params = new HashMap<String, String>();
	 
		params.put("access_token", accessToken);
		params.put("openid", openid);
		String  jsonStr = new HttpKit().get(USER_INFO_URI, params);
		if(StringUtils.isNotEmpty(jsonStr)){
			JSONObject obj = JSONObject.parseObject(jsonStr);
			if(obj.get("errcode") != null){
				if( obj.get("errcode").toString().equals("40001")
						||obj.get("errcode").toString().equals("42001")){
					getAccessToken(true );
					//避免程序死循环
					//return getUserBean(  openid); 
				}
				throw new Exception(obj.getString("errmsg"));
			}
			UserBean userBean = JSONObject.toJavaObject(obj, UserBean.class);
			return userBean;
		}
		return null;
	}
	/**
	 * @param code
	 * @return
	 */
	public String getOAuthAccessToken(String code) {
		// TODO Auto-generated method stub
		String url = ACCESS_TOKEN_URL;
		url += "?appid=" + appid;
		url += "&secret=" + secret;
		url += "&code=" + code;
		url += "&grant_type=authorization_code";

		String reslut = "";
	    reslut = new HttpKit().get(url);
		 

		return reslut;
	}
	
	
	public String getJsTicket() {

		boolean sign = true;

		String jsTicket = PropertyUtil.getKeyValue(Constant.JSTICKET);
		String jsTicketCreatTime = PropertyUtil
				.getKeyValue(Constant.JSTICKETCREATTIME);

		jsTicket = CommonUtil.trim(jsTicket);
		jsTicketCreatTime = CommonUtil.trim(jsTicketCreatTime);
		if (jsTicket.equalsIgnoreCase("")) {

			sign = false;
		}
		Long currentTime = System.currentTimeMillis();
		Long creatTime = 0L;
		Long midTime;
		if (CommonUtil.isInteger(jsTicketCreatTime)) {
			creatTime = Long.parseLong(jsTicketCreatTime);
		}
		// 7200

		midTime = currentTime - creatTime;
		midTime = midTime / 1000;
		if (sign && (midTime > 60 * 60)) {

			sign = false;
		}
		
		if (sign) {
			return jsTicket;
		}
		try {
			String url = JS_TICKET_URL;
			url += "?access_token=" + getAccessToken(false);
			url += "&type=jsapi";
			String reslut = "";
			reslut = new HttpKit().get(url);
			JSONObject obj = JSONObject.parseObject(reslut);
			if (obj.get("ticket") != null) {
				jsTicket = obj.getString("ticket");
				jsTicketCreatTime = new Long(System.currentTimeMillis())
						.toString();
				PropertyUtil.updateProperties(Constant.JSTICKET, jsTicket);
				PropertyUtil.updateProperties(Constant.JSTICKETCREATTIME,
						jsTicketCreatTime);
				//System.out.println("jsTicket:"+jsTicket);
				return jsTicket;
			}
		} catch (Exception ex) {

		}

		PropertyUtil.updateProperties(Constant.JSTICKET, "");
		PropertyUtil.updateProperties(Constant.JSTICKETCREATTIME, "0");
		return "";

	}
}