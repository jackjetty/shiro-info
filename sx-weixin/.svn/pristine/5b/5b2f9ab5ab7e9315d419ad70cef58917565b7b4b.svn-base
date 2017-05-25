package com.sx.test;

import java.util.Map;
import java.util.Random;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.http.client.params.ClientPNames;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
 
import com.sx.weixin.factory.HttpFactory;

 

public class AppTest{
	private static  HttpFactory http = HttpFactory.getInstance();
	public static void main(String[] args){
		Random random=new Random(); 
		StringBuffer txtBuffer=new StringBuffer("");
		 
		try {
			String url = "http://www.sxga.gov.cn:8833/lwpsp/outmain/appVideo.jsp?" +random.nextInt(100); 
			 GetMethod get = new GetMethod(url); 
			// HttpClient client=getHttpClient(session ); 
			HttpClient httpClient= new HttpClient(); 
			httpClient.getParams().setParameter(ClientPNames.ALLOW_CIRCULAR_REDIRECTS, true);  
			//client.getParams().setParameter(client.getParams().ALLOW_CIRCULAR_REDIRECTS, true); 
			 int status = httpClient.executeMethod(get); 
		     if (status != HttpStatus.SC_OK) {
		    	System.out.println("error");
		    	return;   
			 }  
		     
		     String html=get.getResponseBodyAsString();
		     //System.out.println(html);
	    	 Document doc = Jsoup.parse(html);
	    	 
	    	// html=doc.getElementsByClass("speedMain").html();
	    	// System.out.println(html);
	    	 
		     Elements ele=doc.select("div.speedMain li:not([style])");
		        for(Element e :ele)
		        {
		        	//e.attr("rel", "nofollow");
		        	//System.out.println(e.select("span").get(0).text());
		        	//System.out.println(e.html());
		                System.out.println(e.select("a").get(0).attr("href"));
		        } 
		        
		        
		      //VideoImage.jsp?unid=16,(袍江)中兴大道三江路口  
		        //System.out.println( doc.body().html());
		} catch (Exception e) {
		   e.printStackTrace();
		}
		System.out.println(txtBuffer.toString());
	}
}