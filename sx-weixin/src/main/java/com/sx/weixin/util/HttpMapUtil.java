package com.sx.weixin.util;

import org.jsoup.helper.StringUtil;

import com.alibaba.fastjson.JSONObject;

public class HttpMapUtil{
	
	
	private static final String COORDINATE_ADDRESS_URL="http://apis.map.qq.com/ws/geocoder/v1/?location=%s,%s&key=%s&get_poi=1";
	private static final String MAP_KEY = "XGVBZ-S3A3X-QUT4C-ZDFU6-TNW7F-S5FXO";
	 
	//http://apis.map.qq.com/ws/geocoder/v1/?location=39.984154,116.307490&key=OB4BZ-D4W3U-B7VVO-4PJWW-6TKDJ-WPB77&get_poi=1
	
	public  String  mapAddress(String lat ,String lng ){
		
		if(StringUtil.isBlank(lat))
			 return "";
		if(StringUtil.isBlank(lng))
			 return "";
		String url= String.format(COORDINATE_ADDRESS_URL,lat,lng,MAP_KEY )  ;
		
		String result=new HttpUtil().get(url);
		//System.out.println(result);
		if(StringUtil.isBlank(result))
			 return "";
		
		JSONObject jsonObj = JSONObject.parseObject(result);
		Integer status = jsonObj.getInteger("status");
		if(status==null && status!=0)
			return "";
		return CommonUtil.trim(jsonObj.getJSONObject("result").getString("address")).replace("浙江省", "");
		
		 
	}
	public static void main(String[] args){
		System.out.println( new HttpMapUtil().mapAddress("39.984154","116.307490"));
	}
}