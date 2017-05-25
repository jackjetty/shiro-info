package com.sx.weixin.util; 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL; 
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import com.sx.weixin.factory.HttpFactory;
 
public class HttpUtil{ 
	
	 
	 public  String get(String url)   {
	        StringBuffer bufferRes = new StringBuffer("");  
	        
	        InputStream in=null;
	        BufferedReader read=null;
	        HttpURLConnection http=null;
	        try{
	         
	        	URL urlGet = new URL(url);
	            http = (HttpURLConnection) urlGet.openConnection(); 
	            http.setConnectTimeout(25000);
	            // 读取超时 --服务器响应比较慢，增大时间
	            http.setReadTimeout(25000);
	            http.setRequestMethod("GET");
	            http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
	           
	            http.setDoOutput(true);
	            http.setDoInput(true);
	            http.connect();
	            
	            in = http.getInputStream();
	            read = new BufferedReader(new InputStreamReader(in, Constant.DEFAULT_CHARSET));
	            String valueString = null; 
	            while ((valueString = read.readLine()) != null){
	                bufferRes.append(valueString);
	            }
	            in.close();
	    		in=null;
	    		read.close();
	            read=null;
	            if (http != null) {
	                // 关闭连接  
	                http.disconnect();
	                http=null;
	            } 
	            return bufferRes.toString();
	        }catch(Exception ex){
	        	 ex.printStackTrace();
	        	  
	        }
	        finally{
	        	if(in!=null){
	        		try {
						in.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	        		in=null;
	        	}
	        	if(read!=null){
	        		try {
						read.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                read=null;
	        	}
	        	if (http != null) {
	                // 关闭连接  
	                http.disconnect();
	               
	                http=null;
	                
	            }
	        }
	        return bufferRes.toString();
	      
	        
	    }
	 
	 
	 public   String post(String url   ,Map<String,String > params) throws Exception{  
	        HttpClient client = null;  
	        PostMethod post = null;  
	        String result = "";  
	        int status = 200;  
	        try {  
	               client=HttpFactory.getInstance().getClient();                  
	               //PostMethod对象用于存放地址  
	             //总账户的测试方法  
	               post = new PostMethod(url);           
	               //NameValuePair数组对象用于传入参数  
	               post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=" + Constant.UTF_8);//在头文件中设置转码  
	              
	               
	               if(params!=null && params.size()>0){
	            	   
	            	   
	            	   List<NameValuePair> nameValuePairList=new ArrayList<NameValuePair>();
	            	   
	            	   NameValuePair[] nameValuePairArr = new NameValuePair[params.size()];
	            	   NameValuePair nameValuePair = null;
	            	   for (Map.Entry<String, String> entry : params.entrySet()) {  
	            		   
	            		   nameValuePair=new NameValuePair(entry.getKey() , entry.getValue());     
	            		   nameValuePairList.add(nameValuePair)  ;
	            		  
	            	   } 
	            	   nameValuePairList.toArray(nameValuePairArr); 
	            	   post.setRequestBody(nameValuePairArr);
	               } 
	               
	               
	                
	               //执行的状态  
	              status = client.executeMethod(post);    
	              if(status == HttpStatus.SC_OK){  
	                  result = post.getResponseBodyAsString();  
	              }  
	                 
	        } catch (Exception ex) {  
	            // TODO: handle exception  
	            throw new Exception("通过httpClient进行post提交异常：" + ex.getMessage() + " status = " + status);  
	        }  
	        finally{  
	            post.releaseConnection();   
	        }  
	        return result;  
	    }  
	 
	 
	 
	 
}