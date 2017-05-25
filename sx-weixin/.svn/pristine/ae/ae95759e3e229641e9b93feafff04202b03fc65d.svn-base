package com.sx.weixin.service.impl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper; 
import com.github.pagehelper.PageInfo; 
import com.sx.weixin.dao.AnnalsMapper;
import com.sx.weixin.dao.MonitorMapper;
import com.sx.weixin.dao.PoliceSpotMapper; 
import com.sx.weixin.dto.AnnalsDto;
import com.sx.weixin.dto.MonitorDto;
import com.sx.weixin.dto.PoliceSpotDto;
import com.sx.weixin.model.AnnalsModel;
import com.sx.weixin.model.MonitorModel;
import com.sx.weixin.model.PoliceSpotModel;
import com.sx.weixin.model.VideoSpotModel;
import com.sx.weixin.rs.AnnalsInfoRs;
import com.sx.weixin.rs.AnnalsMoreRs;
import com.sx.weixin.rs.AnnalsRefreshRs;
import com.sx.weixin.rs.MonitorMapRs;
import com.sx.weixin.rs.MonitorSpotsRs;
import com.sx.weixin.rs.PoliceSpotsRs;
import com.sx.weixin.rs.TMCDetailRs;
import com.sx.weixin.rs.MonitorMapRs;
import com.sx.weixin.service.IAnnalsService;
import com.sx.weixin.util.Constant;
import com.sx.weixin.util.HttpWeiUtil;

@Service("annalsService")
public class AnnalsServiceImpl extends BaseServiceImpl implements IAnnalsService {
	
	public static final Logger logger = LoggerFactory.getLogger(AnnalsServiceImpl.class);
 
	@Autowired
	private AnnalsMapper annalsMapper;
	
	
	@Value("${redirect.image.url}") 
	protected String  REDIRECTIMAGEURL; 
	
	

	/* (non-Javadoc)
	 * @see com.sx.weixin.service.IAnnalsService#refreshAnnals(float, float, float, float)
	 */
	@Transactional
	@Override
	public AnnalsRefreshRs refreshAnnals() {
		// TODO Auto-generated method stub
		AnnalsRefreshRs annalsRefreshRs=new AnnalsRefreshRs();
		HttpWeiUtil httpWeiUtil=  HttpWeiUtil.getInstance(WEIAPPID,WEIAPPSECRET);
		String result="";
		
		try {
			result=httpWeiUtil.batchMaterial(0, 20);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject jsonObj = JSONObject.parseObject(result);
		Integer itemCount = jsonObj.getInteger("item_count");
		//System.out.println( "sodfjskdfj"+itemCount);
	 
		JSONArray itemJsonArr=jsonObj.getJSONArray("item");
		
		int createTime;
		int updateTime;
		String mediaId;
		JSONObject itemJsonObj;
		JSONArray newsItemJsonArr;
		
		List <AnnalsModel> annalsModelList=new ArrayList<AnnalsModel>();
		for(int itemId=0;itemId<itemJsonArr.size();itemId++){
			itemJsonObj=itemJsonArr.getJSONObject(itemId);
			 System.out.println(itemJsonObj.toJSONString());
			mediaId=itemJsonObj.getString("media_id");
			updateTime=itemJsonObj.getInteger("update_time");
			createTime=itemJsonObj.getJSONObject("content").getInteger("create_time");
			newsItemJsonArr=itemJsonObj.getJSONObject("content").getJSONArray("news_item");
			
			// calNewsItem(  mediaId ,  createTime,  updateTime,  newsItemJsonArr,  annalsModelList);
			
			
		}
		System.out.println(annalsModelList.size());
	 
		for(AnnalsModel annalsModel:annalsModelList){
			 
			 if(annalsMapper.selectByPrimaryKey(annalsModel.getAnid()) ==null){
				 annalsMapper.insertSelective(annalsModel);
			 }
			
		}  
		/*
		AnnalsModel annalsModel=annalsModelList.get(0);
		
		System.out.println(annalsModel.getAntitle());
		System.out.println(annalsModel.getAnurl());
		System.out.println(annalsModel.getMediaid());
		System.out.println(annalsModel.getAncreatetime());
		System.out.println(annalsModel.getAnupdatetime()); */
		/*
		if(annalsMapper.selectByPrimaryKey(annalsModel.getAntitle()) ==null){
			 annalsMapper.insertSelective(annalsModel);
		 }*/
		
		
		 
		
		return annalsRefreshRs;
	}
	
	
	private void calNewsItem(String mediaId ,int createTime,int updateTime,JSONArray newsItemJsonArr,List <AnnalsModel> annalsModelList){
		AnnalsModel annalsModel;
		JSONObject newsItemJsonObj;
		String newsItemUrl;
		//约束是同个图文消息里 图片不可能存在相同的
		for(int newsItemId=0;newsItemId<newsItemJsonArr.size();newsItemId++){
			newsItemJsonObj=newsItemJsonArr.getJSONObject(newsItemId);
			newsItemUrl=newsItemJsonObj.getString("url");
			annalsModel=new AnnalsModel();
			annalsModel.setAnid(mediaId+newsItemJsonObj.getString("thumb_media_id"));
			annalsModel.setAncreatetime(createTime);
			annalsModel.setAntitle(newsItemJsonObj.getString("title"));
			annalsModel.setThumburl(newsItemJsonObj.getString("thumb_url")); 
			annalsModel.setAnupdatetime(updateTime);
			annalsModel.setAnurl(newsItemUrl);
			annalsModel.setMediaid(mediaId);
			annalsModel.setThumbmediaid(newsItemJsonObj.getString("thumb_media_id"));
			annalsModel.setAnvalid(true);
			annalsModelList.add(annalsModel);
		}
		
		
		
	}


	/* (non-Javadoc)
	 * @see com.sx.weixin.service.IAnnalsService#infoAnnals()
	 */
	@Override
	public AnnalsInfoRs infoAnnals(String keyword) {
		
		
		// TODO Auto-generated method stub
		AnnalsInfoRs annalsInfoRs=new AnnalsInfoRs();
		
	    PageHelper.startPage(1, Constant.TEXTPAGESIZE); 
	    
	    List<AnnalsModel> list = annalsMapper.getValidAnnalsList(  keyword);
	    
	    
	    List<AnnalsDto> dtoList=new ArrayList<AnnalsDto>();
	    AnnalsDto annalsDto;
	    for(AnnalsModel annalsModel:list){
	    	annalsDto=new AnnalsDto();
	    	annalsDto.buildDto(annalsModel); 
	    	annalsDto.setThumburl(REDIRECTIMAGEURL+annalsDto.getThumburl()); 
	    	dtoList.add(annalsDto ); 
	    }
	    //用PageInfo对结果进行包装
	    PageInfo<AnnalsModel> pageinfo = new PageInfo<AnnalsModel>(list);
	    
	    annalsInfoRs.setDtolist(dtoList);
	    annalsInfoRs.setPageinfo(pageinfo); 
		return annalsInfoRs;
	}


	/* (non-Javadoc)
	 * @see com.sx.weixin.service.IAnnalsService#moreAnnals(java.lang.String, java.lang.Integer)
	 */
	@Override
	public AnnalsMoreRs moreAnnals(String keyword, Integer pageno) {
		// TODO Auto-generated method stub
		
		
		AnnalsMoreRs annalsMoreRs=new AnnalsMoreRs();
		 
		pageno = pageno == null?2:pageno;
		pageno=pageno<2?2:pageno; 
        PageHelper.startPage(pageno, Constant.TEXTPAGESIZE); 
	    
	    List<AnnalsModel> list = annalsMapper.getValidAnnalsList(  keyword);
	    
	    
	    List<AnnalsDto> dtoList=new ArrayList<AnnalsDto>();
	    AnnalsDto annalsDto;
	    for(AnnalsModel annalsModel:list){
	    	annalsDto=new AnnalsDto();
	    	annalsDto.buildDto(annalsModel); 
	    	annalsDto.setThumburl(REDIRECTIMAGEURL+annalsDto.getThumburl()); 
	    	dtoList.add(annalsDto ); 
	    }
	    //用PageInfo对结果进行包装
	    PageInfo<AnnalsModel> pageinfo = new PageInfo<AnnalsModel>(list);
	    
	    annalsMoreRs.setDtolist(dtoList);
	    annalsMoreRs.setPageinfo(pageinfo); 
		
		return annalsMoreRs;
	}
}

