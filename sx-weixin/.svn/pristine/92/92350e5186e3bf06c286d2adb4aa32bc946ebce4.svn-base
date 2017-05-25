package com.sx.weixin.thread; 

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.sx.weixin.util.CommonUtil;
 

 

public class CopyThread extends Thread{
    private String fromPath;
    private String toPath;
    public CopyThread(String fromPath,String toPath){
    	super();
    	this.fromPath=fromPath;
    	this.toPath=toPath;
    }
    public void run() {
    	
    	File fromFile=new File(fromPath);
    	if(!fromFile.exists()) return;
    	File toFile=new File(toPath);
    	File toParentFile=toFile.getParentFile() ;
		if(!toParentFile.exists()){
			toParentFile.mkdirs();
		} 
		InputStream in=null;
		OutputStream out=null;
        try {   
            in = new FileInputStream(fromPath);   
            out = new FileOutputStream(toPath);    
            byte[] buff = new byte[1024];   
            int len = 0;   
            while ((len = in.read(buff)) != -1) {   
                 out.write(buff, 0, len);   
             }   
            in.close();
            out.close(); 
   		    in=null;
   		    out=null;  
         } catch (FileNotFoundException e) {   
             e.printStackTrace();   
         } catch (IOException e) {   
             e.printStackTrace();   
         } finally{
        	 if(in!=null){
        		 try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
        		 in=null;
        	 }
        	 if(out!=null){
        		 try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
                 
                 out=null; 
        	 }
         }
        
    }      
} 