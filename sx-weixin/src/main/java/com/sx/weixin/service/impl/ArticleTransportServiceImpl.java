package com.sx.weixin.service.impl;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sx.weixin.dao.ArticleTransportMapper;
import com.sx.weixin.dto.AnnalsDto;
import com.sx.weixin.dto.ArticleTransportDto;
import com.sx.weixin.model.AnnalsModel;
import com.sx.weixin.model.ArticleTransportModel;
import com.sx.weixin.rs.AnnalsMoreRs;
import com.sx.weixin.rs.ArticleTransportDetailRs;
import com.sx.weixin.rs.ArticleTransportGridRs;
import com.sx.weixin.rs.ArticleTransportMoreRs;
import com.sx.weixin.service.IArticleTransportService;
import com.sx.weixin.util.Constant;

@Service("articletransportService")
public class ArticleTransportServiceImpl extends BaseServiceImpl implements IArticleTransportService {
	
	public static final Logger logger = LoggerFactory.getLogger(ArticleTransportServiceImpl.class);
 
	@Autowired
	private ArticleTransportMapper articleTransportMapper;
	
	
	@Value("${image.url}") 
	protected String  IMAGEURL; 

	/* (non-Javadoc)
	 * @see com.sx.weixin.service.IArticleTransportService#gridArticleTransport()
	 */
	@Override
	public ArticleTransportGridRs gridArticleTransport() {
		// TODO Auto-generated method stub
		ArticleTransportGridRs articleTransportGridRs=new ArticleTransportGridRs();
		
        PageHelper.startPage(1, Constant.TEXTPAGESIZE); 
	    
	    List<ArticleTransportModel> list = articleTransportMapper.getValidArticleTransportList(   );
	    
	    
	    List<ArticleTransportDto> dtoList=new ArrayList<ArticleTransportDto>();
	    ArticleTransportDto articleTransportDto;
	    for(ArticleTransportModel articleTransportModel:list){
	    	articleTransportDto=new ArticleTransportDto();
	    	articleTransportDto.buildDto(articleTransportModel);  
	    	if(articleTransportDto.getPiclocation().equalsIgnoreCase(""))
	    		articleTransportDto.setImgurl("");
	    	else
	    		articleTransportDto.setImgurl(IMAGEURL+articleTransportDto.getPiclocation());
	    	
	    	dtoList.add(articleTransportDto ); 
	    }
	    //用PageInfo对结果进行包装
	    PageInfo<ArticleTransportModel> pageinfo = new PageInfo<ArticleTransportModel>(list);
	    
	    articleTransportGridRs.setDtolist(dtoList);
	    articleTransportGridRs.setPageinfo(pageinfo); 
		return articleTransportGridRs; 
	}

	/* (non-Javadoc)
	 * @see com.sx.weixin.service.IArticleTransportService#detailArticleTransport(java.lang.Integer)
	 */
	@Override
	public ArticleTransportDetailRs detailArticleTransport(Integer atid) {
		// TODO Auto-generated method stub
		ArticleTransportDetailRs articleTransportDetailRs=new ArticleTransportDetailRs();
		if(atid==null){
			articleTransportDetailRs.setCode(1);
			articleTransportDetailRs.setInfo("参数不正确！");
			return articleTransportDetailRs;
		}
		ArticleTransportModel articleTransportModel=articleTransportMapper.selectByPrimaryKey(atid);
		if(articleTransportModel==null){
			articleTransportDetailRs.setCode(2);
			articleTransportDetailRs.setInfo("记录不存在！");
			return articleTransportDetailRs;
		}
		ArticleTransportDto articleTransportDto=new ArticleTransportDto();
		articleTransportDto.buildDto(articleTransportModel);  
		articleTransportDetailRs.setArticleTransportDto(articleTransportDto);
		
		return articleTransportDetailRs;
	}

	/* (non-Javadoc)
	 * @see com.sx.weixin.service.IArticleTransportService#moreArticleTransport(java.lang.Integer)
	 */
	@Override
	public ArticleTransportMoreRs moreArticleTransport(Integer pageno) {
		// TODO Auto-generated method stub
		
		ArticleTransportMoreRs articleTransportMoreRs=new ArticleTransportMoreRs();
		 
		pageno = pageno == null?2:pageno;
		pageno=pageno<2?2:pageno; 
        PageHelper.startPage(pageno, Constant.TEXTPAGESIZE); 
        
        
        List<ArticleTransportModel> list = articleTransportMapper.getValidArticleTransportList(   ); 
	    List<ArticleTransportDto> dtoList=new ArrayList<ArticleTransportDto>();
	    ArticleTransportDto  articleTransportDto;
	    for(ArticleTransportModel articleTransportModel:list){
	    	articleTransportDto=new ArticleTransportDto();
	    	articleTransportDto.buildDto(articleTransportModel); 
	    	if(articleTransportDto.getPiclocation().equalsIgnoreCase(""))
	    		articleTransportDto.setImgurl("");
	    	else
	    		articleTransportDto.setImgurl(IMAGEURL+articleTransportDto.getPiclocation());
	    	dtoList.add(articleTransportDto ); 
	    }
	    //用PageInfo对结果进行包装
	    PageInfo<ArticleTransportModel> pageinfo = new PageInfo<ArticleTransportModel>(list);
	    
	    articleTransportMoreRs.setDtolist(dtoList);
	    articleTransportMoreRs.setPageinfo(pageinfo); 
		
		return articleTransportMoreRs; 
	}

	 
	
}