/**
 * 
 */
package com.rising.controller;

import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;  
import org.springframework.stereotype.Controller;  
import org.springframework.ui.ModelMap;  
import org.springframework.web.bind.annotation.RequestMapping;  
  
  
@Controller  
public class HomeController {  
      
    //配置日志  
    private static final Logger log = LoggerFactory.getLogger(HomeController.class);  
      
    @RequestMapping("/index") 
    public String index(ModelMap map){  
       // log.info("============Controller=================");  
        map.put("title", "HelloWorld");  
        return "index";  
    }  
      
} 
