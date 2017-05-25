package com.sx.weixin.controller; 

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

import com.sx.weixin.dto.ArticleTransportDto;
import com.sx.weixin.rs.AnnalsInfoRs;
import com.sx.weixin.rs.AnnalsMoreRs;
import com.sx.weixin.rs.AnnalsRefreshRs;
import com.sx.weixin.rs.ArticleTransportDetailRs;
import com.sx.weixin.rs.ArticleTransportGridRs;
import com.sx.weixin.rs.ArticleTransportMoreRs;
import com.sx.weixin.rs.MonitorMapRs;
import com.sx.weixin.rs.MonitorSpotsRs;
import com.sx.weixin.rs.PoliceSpotsRs;
import com.sx.weixin.rs.TMCDetailRs;
import com.sx.weixin.service.IAnnalsService;
import com.sx.weixin.service.IArticleTransportService;
import com.sx.weixin.service.IMonitorService;
import com.sx.weixin.util.CommonUtil;
import com.sx.weixin.util.Constant;

@Controller 
@RequestMapping(value="/articletransport")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ArticleTransportController  extends BaseController   {
	public static final Logger logger = LoggerFactory.getLogger(ArticleTransportController.class);
	

	@Autowired
	private IArticleTransportService articletransportService;
	
	//
	
	@RequestMapping(value="/grid",produces="text/html;charset=UTF-8" ) 
	public    String  gridPage(HttpServletRequest request,HttpServletResponse response,Model model )
	{  
		  
		ArticleTransportGridRs articleTransportGridRs=articletransportService.gridArticleTransport(   );  
		model.addAttribute("articleTransportGridRs", articleTransportGridRs); 
		return "articletransport/grid.html";
		
		
	}
	
	
	
	
	@RequestMapping(value="/detail",produces="text/html;charset=UTF-8" ) 
	public    String  detailPage(HttpServletRequest request,HttpServletResponse response,Model model
			,@RequestParam(value="atid", required=false)  Integer atid)
	{  
		  
		ArticleTransportDetailRs articleTransportDetailRs=articletransportService.detailArticleTransport(    atid );  
		model.addAttribute("articleTransportDetailRs", articleTransportDetailRs);
		
		ArticleTransportDto  articleTransportDto=articleTransportDetailRs.getArticleTransportDto();
		if(articleTransportDto.getAtsource().equalsIgnoreCase(Constant.ARTICLE_SOURCE_URL)
				&& articleTransportDto.getAturl().length()>0){
			return "redirect:"+articleTransportDto.getAturl();
		} 
		return "articletransport/detail.html";
	}
	
	
	
	@RequestMapping(value="/more" ) 
	public    @ResponseBody  Object refresh(HttpServletRequest request,HttpServletResponse response,Model model , 
			@RequestParam(value="pageno", required=false)  Integer pageno
			 )
	{   
		
		
		 
		ArticleTransportMoreRs articleTransportMoreRs=articletransportService.moreArticleTransport(pageno);
		   
		 return  articleTransportMoreRs;
	}
	
	
	
	
}
	