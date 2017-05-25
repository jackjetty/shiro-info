package com.sx.weixin;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
 
public class Test1 {
     
    public static void main(String[] args) {
        Date date = new Date();
        int k = 1;
         
        // JDK 1.5 or higher
        String number = String.format("%ty%<tm%<td%04d", date, k);
        System.out.println(number);
        System.out.printf("年的后两位数字（不足两位前面补0）：%ty%n",date);  
        // JDK 1.4 or lower
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        DecimalFormat df = new DecimalFormat("000");
        String d = sdf.format(date);
        String n = df.format(k);
        System.out.println(d + n);
        
        
        System.out.println(new Integer("0002").intValue());
    }
}