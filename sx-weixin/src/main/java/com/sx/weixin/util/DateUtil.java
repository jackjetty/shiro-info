package com.sx.weixin.util; 
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public   class DateUtil{
    private static DateUtil dateUtil;  
	
	public static DateUtil getInstance(){  
        if(dateUtil == null){  
        	dateUtil = new DateUtil();  
        }  
        return dateUtil;  
    }  
	
	public static String   getDateForm() { 
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date()); 
    }
	public static String   getDateForm(Date date) { 
		date=date==null?new Date():date;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date); 
    }
	public static String   getDateForm(String format) { 
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date()); 
    }
	public static String getDateForm(Object obj, String format) {
		if (obj == null)
			return "";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format((Date) obj);
	}
	/**
	 * @author tinker
	 * @create 2014年9月17日
	 * @return 当前日期 例如 2014-09-17
	 */
	public static String getCurrentDateStrForm() {
		Calendar c = Calendar.getInstance();
		return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
	}
	
	/**
	 * @author tinker
	 * @create 2014年9月17日
	 * @return 6天前日期 例如 2014-09-11
	 */
	public static String getBeforeWeekDateStrForm() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_YEAR, -6);
		return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
	}
	
	
	public static Date stringToDate(String str) {  
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
        Date date = null;  
        try {  
            // Fri Feb 24 00:00:00 CST 2012  
            date = format.parse(str);   
        } catch (ParseException e) {  
        	date=new Date();
            e.printStackTrace();  
        }   
                                              
        return date;  
    }  
	
}