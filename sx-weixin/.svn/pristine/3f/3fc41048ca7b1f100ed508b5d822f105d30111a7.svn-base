package com.sx.weixin.util; 
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public  class CommonUtil{
    private static CommonUtil commonUtil;  
	
	public static CommonUtil getInstance(){  
        if(commonUtil == null){  
        	commonUtil = new CommonUtil();  
        }  
        return commonUtil;  
    }  
	public static String trim(Object obj) {
		if (obj == null) {
			return "";
		}
		return trim(obj.toString());
	}

	 
	public static String trim(String str) {
        if (str == null) {
            return "";
        }
        try {
            str = java.net.URLDecoder.decode(str, "UTF-8");
        } catch (Exception ex) {
        } 
        return str.trim();
    } 
	public static boolean  isInteger(String str){
		 
		Pattern pattern;
		Matcher matcher; 
		pattern=Pattern.compile("^(\\+|-){0,1}\\d+$");
		matcher=pattern.matcher(str); 
	    return matcher.matches();
	} 
	
	 public static boolean isNumeric(String Stemp) {
	        Stemp = Stemp.trim();
	        String reg = ("(-|\\+)?\\d+(\\.\\d+)?");
	        Pattern pattern = Pattern.compile(reg, Pattern.UNICODE_CASE);
	        Matcher matcher;
	        matcher = pattern.matcher(Stemp);
	        return matcher.matches();
	    }
	public static int  getCurrentNum(String currentStr,String prefixStr){
		Pattern pattern;
		Matcher matcher;
		pattern=Pattern.compile("^"+prefixStr+"(0*)(\\d+)$");
		int currentNum=0;
		matcher=pattern.matcher(currentStr);
		if(matcher.find()){
			currentNum=Integer.parseInt(matcher.group(2));   
	    }
		return currentNum; 
	}
	
	
	 public static String getImageName() {  
	        UUID uuid = UUID.randomUUID();  
	        String str = uuid.toString();  
	        // 去掉"-"符号  
	        return str.substring(0, 8) ;  
	 }  
	
}