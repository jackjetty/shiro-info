/**
 * 
 */
package com.rising;

import org.springframework.boot.builder.SpringApplicationBuilder;  
 
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
  
  
/** 
 * import org.springframework.boot.web.support.SpringBootServletInitializer; 
 * Title: ServletInitializer 
 * Description: 相当于整个Web.xml 
 * Company: blog.csdn.net/lu1005287365/ 
 * @author  L lulu 
 * @version 1.0 
 */  

/*
public class ServletInitializer extends SpringBootServletInitializer {  
  
  
    @Override  
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {  
        return application.sources(Application.class);  
    }  
  
    
    

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**");
            }
        };
    }
  
}  */
