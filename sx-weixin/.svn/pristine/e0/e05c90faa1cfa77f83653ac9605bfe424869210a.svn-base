package com.sx.weixin.controller;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sx.weixin.dto.ArticleDelictDto;
import com.sx.weixin.rs.AnnalsInfoRs;
import com.sx.weixin.rs.AnnalsMoreRs;
import com.sx.weixin.rs.AnnalsRefreshRs;
import com.sx.weixin.rs.ArticleDelictDetailRs;
import com.sx.weixin.rs.ArticleDelictGridRs;
import com.sx.weixin.rs.ArticleDelictMoreRs;
import com.sx.weixin.rs.MonitorMapRs;
import com.sx.weixin.rs.MonitorSpotsRs;
import com.sx.weixin.rs.PoliceSpotsRs;
import com.sx.weixin.rs.TMCDetailRs;
import com.sx.weixin.service.IAnnalsService;
import com.sx.weixin.service.IArticleDelictService;
import com.sx.weixin.service.IMonitorService;
import com.sx.weixin.util.CommonUtil;
import com.sx.weixin.util.Constant;

@Controller 
@RequestMapping(value="/articledelict")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ArticleDelictController  extends BaseController   {
	public static final Logger logger = LoggerFactory.getLogger(ArticleDelictController.class);
	

	@Autowired
	private IArticleDelictService articledelictService;
	
	//
	
	@RequestMapping(value="/grid",produces="text/html;charset=UTF-8" ) 
	public    String  gridPage(HttpServletRequest request,HttpServletResponse response,Model model )
	{  
		  
		ArticleDelictGridRs articleDelictGridRs=articledelictService.gridArticleDelict(   );  
		model.addAttribute("articleDelictGridRs", articleDelictGridRs); 
		return "articledelict/grid.html";
		
		
	}
	
	
	
	
	@RequestMapping(value="/detail",produces="text/html;charset=UTF-8" ) 
	public    String  detailPage(HttpServletRequest request,HttpServletResponse response,Model model
			,@RequestParam(value="adid", required=false)  Integer adid)
	{  
		  
		ArticleDelictDetailRs articleDelictDetailRs=articledelictService.detailArticleDelict(    adid );  
		model.addAttribute("articleDelictDetailRs", articleDelictDetailRs);
		
		ArticleDelictDto  articleDelictDto=articleDelictDetailRs.getArticleDelictDto();
		if(articleDelictDto.getAdsource().equalsIgnoreCase(Constant.ARTICLE_SOURCE_URL)
				&& articleDelictDto.getAdurl().length()>0){
			return "redirect:"+articleDelictDto.getAdurl();
		} 
		return "articledelict/detail.html";
	}
	
	
	
	@RequestMapping(value="/more" ) 
	public    @ResponseBody  Object refresh(HttpServletRequest request,HttpServletResponse response,Model model , 
			@RequestParam(value="pageno", required=false)  Integer pageno
			 )
	{   
		
		
		 
		ArticleDelictMoreRs articleDelictMoreRs=articledelictService.moreArticleDelict(pageno);
		   
		 return  articleDelictMoreRs;
	}
	
	
	
	
}
	