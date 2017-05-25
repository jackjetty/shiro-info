package com.sx.weixin.util; 
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.Map.Entry;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.rising.wei.bean.Attachment;

 
 

/**
 * https 请求 微信为https的请求
 * @author L.cm
 * @date 2013-10-9 下午2:40:19
 */
public class HttpKit {
	 
    
    private static final Logger LOGGER = Logger.getLogger(HttpKit.class);
    
    
   

    /**
     * 发送Get请求
     * @param url
     * @return
     * @throws NoSuchProviderException 
     * @throws NoSuchAlgorithmException 
     * @throws IOException 
     * @throws KeyManagementException 
     */
    public   String get(String url)   {
        StringBuffer bufferRes = new StringBuffer(""); 
        TrustManager[] tm = { new MyX509TrustManager() };  
        
        InputStream in=null;
        BufferedReader read=null;
        HttpsURLConnection http=null;
        try{
        	SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");  
            sslContext.init(null, tm, new java.security.SecureRandom());   
            SSLSocketFactory ssf = sslContext.getSocketFactory();
        	URL urlGet = new URL(url);
            http = (HttpsURLConnection) urlGet.openConnection(); 
            http.setConnectTimeout(25000);
            // 读取超时 --服务器响应比较慢，增大时间
            http.setReadTimeout(25000);
            http.setRequestMethod("GET");
            http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            http.setSSLSocketFactory(ssf);
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
    
    /**
     * 发送Get请求
     * @param url
     * @return
     * @throws NoSuchProviderException 
     * @throws NoSuchAlgorithmException 
     * @throws IOException 
     * @throws KeyManagementException 
     */
    public   String get(String url,Boolean https)   {
    	if(https != null && https){
    		return get(url);
    	}else{
    		StringBuffer bufferRes = new StringBuffer(""); 
    		InputStream in=null;
            BufferedReader read=null;
            HttpURLConnection http=null;
            try{
            	URL urlGet = new URL(url);
                http = (HttpURLConnection) urlGet.openConnection();
             // 连接超时
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
                bufferRes = new StringBuffer();
                while ((valueString = read.readLine()) != null){
                    bufferRes.append(valueString);
                }
                read.close();
                in.close();
                 
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
    }

    /**
     *  发送Get请求
     * @param url
     * @param params
     * @return
     * @throws IOException 
     * @throws NoSuchProviderException 
     * @throws NoSuchAlgorithmException 
     * @throws KeyManagementException 
     */
    public   String get(String url, Map<String, String> params) throws KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException, IOException {
        return get(initParams(url, params));
    }

    /**
     *  发送Post请求
     * @param url
     * @param params
     * @return
     * @throws IOException 
     * @throws NoSuchProviderException 
     * @throws NoSuchAlgorithmException 
     * @throws KeyManagementException 
     */
    public   String post(String url, String params)   {
        	StringBuffer bufferRes = new StringBuffer("");
        	HttpsURLConnection http=null;
        	OutputStream out=null;
        	InputStream in=null;
        	BufferedReader read=null;
        	try{
        		TrustManager[] tm = { new MyX509TrustManager() };
                SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
                sslContext.init(null, tm, new java.security.SecureRandom());
                // 从上述SSLContext对象中得到SSLSocketFactory对象  
                SSLSocketFactory ssf = sslContext.getSocketFactory();

                URL urlGet = new URL(url);
                http = (HttpsURLConnection) urlGet.openConnection();
                // 连接超时
                http.setConnectTimeout(25000);
                // 读取超时 --服务器响应比较慢，增大时间
                http.setReadTimeout(25000);
                http.setRequestMethod("POST");
                http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
                http.setSSLSocketFactory(ssf);
                http.setDoOutput(true);
                http.setDoInput(true);
                http.connect();

                out = http.getOutputStream();
                out.write(params.getBytes("UTF-8"));
                out.flush();
                out.close();

                in = http.getInputStream();
                read = new BufferedReader(new InputStreamReader(in, Constant.DEFAULT_CHARSET));
                String valueString = null;
                bufferRes = new StringBuffer();
                while ((valueString = read.readLine()) != null){
                    bufferRes.append(valueString);
                }
                read.close();
                in.close();
                if (http != null) {
                    // 关闭连接
                    http.disconnect();
                }
                return bufferRes.toString();
        	}catch(Exception ex){
        		System.out.println("连接失败！！");
        		ex.printStackTrace();
        	}
        	finally{
        		if(out!=null){
            		try {
    					out.close();
    				} catch (IOException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
            		out=null;
            	}
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
    
    /**
     * 上传媒体文件
     * @param url
     * @param params
     * @param file
     * @return
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws NoSuchProviderException
     * @throws KeyManagementException
     */
    public   String upload(String url,File file) throws IOException, NoSuchAlgorithmException, NoSuchProviderException, KeyManagementException {
            String BOUNDARY = "----WebKitFormBoundaryiDGnV9zdZA1eM1yL"; // 定义数据分隔线  
            StringBuffer bufferRes = null;
            URL urlGet = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) urlGet.openConnection();
            conn.setDoOutput(true);  
            conn.setDoInput(true);  
            conn.setUseCaches(false);  
            conn.setRequestMethod("POST");  
            conn.setRequestProperty("connection", "Keep-Alive");  
            conn.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1700.107 Safari/537.36");  
            conn.setRequestProperty("Charsert", "UTF-8");   
            conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);  
              
            OutputStream out = new DataOutputStream(conn.getOutputStream());  
            byte[] end_data = ("\r\n--" + BOUNDARY + "--\r\n").getBytes();// 定义最后数据分隔线  
            StringBuilder sb = new StringBuilder();    
            sb.append("--");    
            sb.append(BOUNDARY);    
            sb.append("\r\n");    
            sb.append("Content-Disposition: form-data;name=\"media\";filename=\""+ file.getName() + "\"\r\n");    
            sb.append("Content-Type:application/octet-stream\r\n\r\n");    
            byte[] data = sb.toString().getBytes();  
            out.write(data);  
            DataInputStream fs = new DataInputStream(new FileInputStream(file));  
            int bytes = 0;  
            byte[] bufferOut = new byte[1024];  
            while ((bytes = fs.read(bufferOut)) != -1) {  
                out.write(bufferOut, 0, bytes);  
            }  
            out.write("\r\n".getBytes()); //多个文件时，二个文件之间加入这个  
            fs.close();  
            out.write(end_data);  
            out.flush();    
            out.close();   
              
            // 定义BufferedReader输入流来读取URL的响应  
            InputStream in = conn.getInputStream();
            BufferedReader read = new BufferedReader(new InputStreamReader(in, Constant.DEFAULT_CHARSET));
            String valueString = null;
            bufferRes = new StringBuffer();
            while ((valueString = read.readLine()) != null){
                bufferRes.append(valueString);
            }
            in.close();
            if (conn != null) {
                // 关闭连接
            	conn.disconnect();
            }
            return bufferRes.toString();
    }
    public   void downloadNet(String urlStr,File localFile)    {
        // 下载网络文件
        int bytesum = 0;
        int byteread = 0;
//
        HttpURLConnection conn=null;
        InputStream inStream =null;
        FileOutputStream fs=null;
        try {
        	URL url = new URL(urlStr);
              conn = (HttpURLConnection) url.openConnection();
              inStream = conn.getInputStream();
              fs = new FileOutputStream(localFile); 
            byte[] buffer = new byte[1204];
            int length;
            while ((byteread = inStream.read(buffer)) != -1) {
                bytesum += byteread; 
                fs.write(buffer, 0, byteread);
            }
            inStream.close();
            fs.close();
            if (conn != null) {
                // 关闭连接
            	conn.disconnect();
            	
            }
            inStream=null;
            fs=null;
            conn=null;
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
        	if(inStream!=null){
        		try {
					inStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		inStream=null;
        	}
        	if(fs!=null){
        		try {
					fs.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		fs=null;
        	}
        	
            
            if (conn != null) {
                // 关闭连接
            	conn.disconnect();
            	
            }
            
            
            conn=null;
        }
    }
    /**
     * 下载资源
     * @param url
     * @return
     * @throws IOException
     */
    public   Attachment download(String url) throws IOException{
    	Attachment att = new Attachment();
    	 URL urlGet = new URL(url);
         HttpURLConnection conn = (HttpURLConnection) urlGet.openConnection();
         conn.setDoOutput(true);  
         conn.setDoInput(true);  
         conn.setUseCaches(false);  
         conn.setRequestMethod("GET");  
         conn.connect(); 
         if(conn.getContentType().equalsIgnoreCase("text/plain")){
        	// 定义BufferedReader输入流来读取URL的响应  
             InputStream in = conn.getInputStream();
             BufferedReader read = new BufferedReader(new InputStreamReader(in, Constant.DEFAULT_CHARSET));
             String valueString = null;
             StringBuffer bufferRes = new StringBuffer();
             while ((valueString = read.readLine()) != null){
                 bufferRes.append(valueString);
             }
             in.close();
             att.setError(bufferRes.toString());
         }else{
        	 BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());  
             String ds = conn.getHeaderField("Content-Disposition");
             String fullName = ds.substring(ds.indexOf("filename=\"")+10,ds.length()-1);
             String relName = fullName.substring(0, fullName.lastIndexOf("."));
             String suffix = fullName.substring(relName.length()+1);
             
             att.setFullName(fullName);
             att.setFileName(relName);
             att.setSuffix(suffix);
             att.setContentLength(conn.getHeaderField("Content-Length"));
             att.setContentType(conn.getHeaderField("Content-Type"));
             
             att.setFileStream(bis);
         }
         return att;
    }

    /**
     *
     * @param url
     * @param params
     * @return
     */
    private   String initParams(String url, Map<String, String> params){
        if (null == params || params.isEmpty()) {
            return url;
        }
        StringBuilder sb = new StringBuilder(url);
        if (url.indexOf("?") == -1) {
            sb.append("?");
        } else {
            sb.append("&");
        }
        boolean first = true;
        for (Entry<String, String> entry : params.entrySet()) {
            if (first) {
                first = false;
            } else {
                sb.append("&");
            }
            String key = entry.getKey();
            String value = entry.getValue();
            sb.append(key).append("=");
            if (StringUtils.isNotEmpty(value)) {
                try {
                    sb.append(URLEncoder.encode(value, Constant.DEFAULT_CHARSET));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    LOGGER.error(url,e);
                }
            }
        }
        return sb.toString();
    }
    
    
    public   String sendPost(String urlStr, String xmlString) {
    	
    	
   	 byte[] xmlData = xmlString.getBytes();   
   	 String requestString="";
   	 DataOutputStream printout = null;    
   	 BufferedReader  reader=null;  
   	 try{   
   	   
   	        //获得到位置服务的链接   
   	   
   	        URL url = new URL(urlStr);   
   	   
   	        URLConnection urlCon = url.openConnection();   
   	   
   	        urlCon.setDoOutput(true);   
   	   
   	        urlCon.setDoInput(true);   
   	   
   	        urlCon.setUseCaches(false);   
   	   
   	        //将xml数据发送到位置服务   
   	   
   	        urlCon.setRequestProperty("Content-Type", "text/xml");   
   	   
   	        urlCon.setRequestProperty("Content-length",String.valueOf(xmlData.length));   
   	   
   	        printout = new DataOutputStream(urlCon.getOutputStream());   
   	   
   	        printout.write(xmlData);   
   	   
   	        printout.flush();   
   	   
   	        printout.close(); 
   	        
   	        
   	        // 取得输入流，并使用Reader读取
   	        reader = new BufferedReader(new InputStreamReader(urlCon.getInputStream(), "UTF-8"));
   	        
   	        String lines;
   	        StringBuffer linebuff = new StringBuffer("");
   	        while ((lines = reader.readLine()) != null) {
   	         linebuff.append(lines);
   	        }
   	        requestString=linebuff.toString();
   	           
   	         
   	  
   	          
   	   
   	 }   
   	   
   	 catch(Exception e){   
   	   
   	        e.printStackTrace();   
   	   
   	 }   
   	   
   	 finally {   
   	   
   	        try {   
   	        	
   	        	   reader.close();    
   	        	   printout.close();  
   	        	   reader=null;
   	        	   printout=null;
   	   
   	        }   
   	   
   	        catch (Exception ex) {   
   	   
   	        }  
        }
   	    return requestString;
    }
    
    public static void main(String[] args)throws Exception {
    	/*String fname = "dsasdas.mp4";
    	String s = fname.substring(0, fname.lastIndexOf("."));
    	String f = fname.substring(s.length()+1);
		System.out.println(f);*/
    	
    		//http://115.206.124.78/webchat/image/accidentFormPic.png
    	
    	
    	String str=new HttpKit().sendPost("http://hd.jdapi.cn/WeChat/WxApi/WeiDServiceApi?signature=JDKJ", "<xml><ToUserName><![CDATA[gh_4396bbd05f4a]]></ToUserName><FromUserName><![CDATA[oGPgHuAeUWKdSZ-oIYVco34KAYPc]]></FromUserName><CreateTime>1413270789</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[88888888]]></Content><MsgId>6069951819348165738</MsgId><MediaId><![CDATA[xpf6btuYPPN0jlv4GfsIGtWD2EDCAoF-iL_693u1dD_c6KH-tHBKmJhQksLRErAO]]></MediaId></xml>") ;
    	System.out.println(str);
	}
    
    
    public   String httpPost(String urlAddress,String paramsTemp){
        URL url = null;
        HttpURLConnection con  =null;
        BufferedReader in = null;
        StringBuffer result = new StringBuffer();
        try {
            url = new URL(urlAddress);
            con  = (HttpURLConnection) url.openConnection();
            con.setUseCaches(false);
            con.setDoOutput(true);
            con.setRequestMethod("POST"); 
             
            byte[] b = paramsTemp.getBytes();
            con.getOutputStream().write(b, 0, b.length);
            con.getOutputStream().flush();
            con.getOutputStream().close();
            in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            while (true) {
              String line = in.readLine();
              if (line == null) {
                break;
              }
              else {
                  result.append(line);
              }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if(in!=null){
                    in.close();
                }
                if(con!=null){
                    con.disconnect();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result.toString();
    }
  
}
     
 


/**
 * 证书管理
 */
class MyX509TrustManager implements X509TrustManager {

    public X509Certificate[] getAcceptedIssuers() {
        return null;  
    }

    @Override
    public void checkClientTrusted(X509Certificate[] chain, String authType)
            throws CertificateException {
    }

    @Override
    public void checkServerTrusted(X509Certificate[] chain, String authType)
            throws CertificateException {
    }
}