package com.sx.weixin.service.impl;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sx.weixin.dao.VideoSpotMapper;
import com.sx.weixin.dto.VideoSpotDto;
import com.sx.weixin.model.VideoSpotModel;
import com.sx.weixin.rs.TMCDetailRs;
import com.sx.weixin.rs.TMCGridRs;
import com.sx.weixin.service.ITMCService;

@Service("tmcService")
public class TMCServiceImpl extends BaseServiceImpl implements ITMCService {
	
	public static final Logger logger = LoggerFactory.getLogger(TMCServiceImpl.class);
 
	@Autowired
	private VideoSpotMapper videoSpotMapper;
	
	@Value("${url.video.spot}") 
	protected String  URLVIDEOSPOT;
	
	

	/* (non-Javadoc)
	 * @see com.sx.weixin.service.ITMCService#gridTMC()
	 */
	@Override
	public TMCGridRs gridTMC() {
		// TODO Auto-generated method stub
		TMCGridRs tmcGridRs  =new TMCGridRs();  
	    List<VideoSpotModel> list = videoSpotMapper.getValidVideoSpotList(); 
	    List<VideoSpotDto> dtoList=new ArrayList<VideoSpotDto>();
	    VideoSpotDto videoSpotDto;
	    
	    for(VideoSpotModel videoSpotModel:list){
	    	videoSpotDto=new VideoSpotDto();
	    	videoSpotDto.buildDto(videoSpotModel);
	    	dtoList.add(videoSpotDto ); 
	    }
	    tmcGridRs.setDtolist(dtoList); 
		return tmcGridRs;
	}

	/* (non-Javadoc)
	 * @see com.sx.weixin.service.ITMCService#detailTMC(java.lang.String)
	 */
	@Override
	public TMCDetailRs detailTMC(String vsId) { 
		// TODO Auto-generated method stub
		Random random = new Random();  
		TMCDetailRs tmcDetailRs=new TMCDetailRs(); 
		String videoImgUrl=String.format(URLVIDEOSPOT, vsId);  
		tmcDetailRs.setVideoImgUrl(videoImgUrl); 
		tmcDetailRs.setVideoImgRand(String.valueOf(random.nextInt(1000))); 
		return tmcDetailRs;
	}
	
	
}


