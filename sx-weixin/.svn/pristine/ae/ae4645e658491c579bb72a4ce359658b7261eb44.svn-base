package com.sx.weixin.thread; 

import java.io.File;
import java.io.IOException;
 
import com.sx.weixin.util.CommonUtil;
import com.sx.weixin.util.HttpKit;
 

 
public class FileThread extends Thread{
    private String picUrl;
    private String filePath; 
    public FileThread(String picUrl,String filePath){
    	super(); 
    	this.picUrl=picUrl;
    	this.filePath=filePath;
    } 
    public void run() {
    	
    	
    	File file=new File(filePath); 
		File dirFile= file.getParentFile(); 
		if(!dirFile.exists()){
			dirFile.mkdirs();
		} 
		new  HttpKit().downloadNet(picUrl,new File(filePath));
		 
		 
    }      
} 