package com.sx.weixin.service.impl;

import org.springframework.beans.factory.annotation.Value;

import com.sx.weixin.service.IBaseService; 

public class BaseServiceImpl implements IBaseService {
	@Value("${wei.appid}") 
	protected String  WEIAPPID;
	
	@Value("${wei.appsecret}") 
	protected String  WEIAPPSECRET; 
}