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
import com.sx.weixin.dao.ArticleDelictMapper;
import com.sx.weixin.dto.AnnalsDto;
import com.sx.weixin.dto.ArticleDelictDto;
import com.sx.weixin.model.AnnalsModel;
import com.sx.weixin.model.ArticleDelictModel;
import com.sx.weixin.rs.AnnalsMoreRs;
import com.sx.weixin.rs.ArticleDelictDetailRs;
import com.sx.weixin.rs.ArticleDelictGridRs;
import com.sx.weixin.rs.ArticleDelictMoreRs;
import com.sx.weixin.service.IArticleDelictService;
import com.sx.weixin.util.Constant;

@Service("articledelictService")
public class ArticleDelictServiceImpl extends BaseServiceImpl implements IArticleDelictService {
	
	public static final Logger logger = LoggerFactory.getLogger(ArticleDelictServiceImpl.class);
 
	@Autowired
	private ArticleDelictMapper articleDelictMapper;
	
	
	@Value("${image.url}") 
	protected String  IMAGEURL; 

	/* (non-Javadoc)
	 * @see com.sx.weixin.service.IArticleDelictService#gridArticleDelict()
	 */
	@Override
	public ArticleDelictGridRs gridArticleDelict() {
		// TODO Auto-generated method stub
		ArticleDelictGridRs articleDelictGridRs=new ArticleDelictGridRs();
		
        PageHelper.startPage(1, Constant.TEXTPAGESIZE); 
	    
	    List<ArticleDelictModel> list = articleDelictMapper.getValidArticleDelictList(   );
	    
	    
	    List<ArticleDelictDto> dtoList=new ArrayList<ArticleDelictDto>();
	    ArticleDelictDto articleDelictDto;
	    for(ArticleDelictModel articleDelictModel:list){
	    	articleDelictDto=new ArticleDelictDto();
	    	articleDelictDto.buildDto(articleDelictModel);  
	    	if(articleDelictDto.getPiclocation().equalsIgnoreCase(""))
	    		articleDelictDto.setImgurl("");
	    	else
	    		articleDelictDto.setImgurl(IMAGEURL+articleDelictDto.getPiclocation());
	    	
	    	dtoList.add(articleDelictDto ); 
	    }
	    //用PageInfo对结果进行包装
	    PageInfo<ArticleDelictModel> pageinfo = new PageInfo<ArticleDelictModel>(list);
	    
	    articleDelictGridRs.setDtolist(dtoList);
	    articleDelictGridRs.setPageinfo(pageinfo); 
		return articleDelictGridRs; 
	}

	/* (non-Javadoc)
	 * @see com.sx.weixin.service.IArticleDelictService#detailArticleDelict(java.lang.Integer)
	 */
	@Override
	public ArticleDelictDetailRs detailArticleDelict(Integer adid) {
		// TODO Auto-generated method stub
		ArticleDelictDetailRs articleDelictDetailRs=new ArticleDelictDetailRs();
		if(adid==null){
			articleDelictDetailRs.setCode(1);
			articleDelictDetailRs.setInfo("参数不正确！");
			return articleDelictDetailRs;
		}
		ArticleDelictModel articleDelictModel=articleDelictMapper.selectByPrimaryKey(adid);
		if(articleDelictModel==null){
			articleDelictDetailRs.setCode(2);
			articleDelictDetailRs.setInfo("记录不存在！");
			return articleDelictDetailRs;
		}
		ArticleDelictDto articleDelictDto=new ArticleDelictDto();
		articleDelictDto.buildDto(articleDelictModel);  
		articleDelictDetailRs.setArticleDelictDto(articleDelictDto);
		
		return articleDelictDetailRs;
	}

	/* (non-Javadoc)
	 * @see com.sx.weixin.service.IArticleDelictService#moreArticleDelict(java.lang.Integer)
	 */
	@Override
	public ArticleDelictMoreRs moreArticleDelict(Integer pageno) {
		// TODO Auto-generated method stub
		
		ArticleDelictMoreRs articleDelictMoreRs=new ArticleDelictMoreRs();
		 
		pageno = pageno == null?2:pageno;
		pageno=pageno<2?2:pageno; 
        PageHelper.startPage(pageno, Constant.TEXTPAGESIZE); 
        
        
        List<ArticleDelictModel> list = articleDelictMapper.getValidArticleDelictList(   ); 
	    List<ArticleDelictDto> dtoList=new ArrayList<ArticleDelictDto>();
	    ArticleDelictDto  articleDelictDto;
	    for(ArticleDelictModel articleDelictModel:list){
	    	articleDelictDto=new ArticleDelictDto();
	    	articleDelictDto.buildDto(articleDelictModel); 
	    	if(articleDelictDto.getPiclocation().equalsIgnoreCase(""))
	    		articleDelictDto.setImgurl("");
	    	else
	    		articleDelictDto.setImgurl(IMAGEURL+articleDelictDto.getPiclocation());
	    	dtoList.add(articleDelictDto ); 
	    }
	    //用PageInfo对结果进行包装
	    PageInfo<ArticleDelictModel> pageinfo = new PageInfo<ArticleDelictModel>(list);
	    
	    articleDelictMoreRs.setDtolist(dtoList);
	    articleDelictMoreRs.setPageinfo(pageinfo); 
		
		return articleDelictMoreRs; 
	}

	 
	
}