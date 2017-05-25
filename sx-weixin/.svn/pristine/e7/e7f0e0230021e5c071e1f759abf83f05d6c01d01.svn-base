package com.sx.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PMTest{
	public static void main(String[] args){
	 String currentStr="VideoImage.jsp?unid=16,(袍江)中兴大道三江路口";
			Pattern pattern;
			Matcher matcher;
			pattern=Pattern.compile("^(.*)(=)(.*)(,)(.+)$");
			int currentNum=0;
			matcher=pattern.matcher(currentStr);
			if(matcher.find()){
				//currentNum=Integer.parseInt(matcher.group(2));  
				System.out.println(matcher.group(3));
				System.out.println(matcher.group(5));
		    }
			 
		 
	}
}