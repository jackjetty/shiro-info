package com.sx.weixin.service.impl;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.rising.wei.bean.ErrCodeBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.sx.weixin.dao.CarMoveMapper;
import com.sx.weixin.dao.FeedBackMapper;
import com.sx.weixin.dao.FormalAccidentMapper;
import com.sx.weixin.dao.InfoPicMapper;
import com.sx.weixin.dao.PlaceAreaMapper;
import com.sx.weixin.model.CarMoveModel;
import com.sx.weixin.model.FeedBackModel;
import com.sx.weixin.model.FormalAccidentModel;
import com.sx.weixin.model.InfoPicModel;
import com.sx.weixin.model.PlaceAreaModel; 
  
import com.sx.weixin.rs.CarMoveGainRs;
import com.sx.weixin.rs.FeedBackGainRs;
import com.sx.weixin.service.IFeedBackService;
import com.sx.weixin.store.AccidentStore;
import com.sx.weixin.store.info.LocationStoreInfo;
import com.sx.weixin.store.info.PictureStoreInfo;
import com.sx.weixin.thread.CopyThread;
import com.sx.weixin.util.AttributionUtil;
import com.sx.weixin.util.CommonUtil;
import com.sx.weixin.util.Constant;
import com.sx.weixin.util.DateUtil;
import com.sx.weixin.util.HttpMapUtil;
import com.sx.weixin.util.HttpWeiUtil;
import com.sx.weixin.wsdd.ClientWSDD;

@Service("feedbackService")
public class FeedBackServiceImpl extends BaseServiceImpl implements IFeedBackService {
	
	public static final Logger logger = LoggerFactory.getLogger(FeedBackServiceImpl.class);

	/* (non-Javadoc)
	 * @see com.sx.weixin.service.ICarMoveService#gain(java.lang.String, java.lang.String, java.lang.String[])
	 */
	 
	
	
	@Autowired
	private FeedBackMapper feedBackMapper;
	
	 
	
	 


	/* (non-Javadoc)
	 * @see com.sx.weixin.service.IFeedBackService#gain(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Transactional
	@Override
	public FeedBackGainRs gain(String openid, String contact, String feedtext) {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance();
		FeedBackGainRs feedBackGainRs=new FeedBackGainRs();
		feedtext=CommonUtil.trim(feedtext);
		contact=CommonUtil.trim(contact);
		if(feedtext.equals("")){
			feedBackGainRs.setCode(2);
			feedBackGainRs.setInfo("请填入意见建议！");
			return feedBackGainRs;
		}
		FeedBackModel feedBackModel=new FeedBackModel();
		feedBackModel.setContact(contact);
		feedBackModel.setFeedbackstate("未回复");
		feedBackModel.setRecordtype("REPLY");
		feedBackModel.setFeedopenid(openid);
		feedBackModel.setFeedtext(feedtext);
		
		
		feedBackModel.setFeedtime(cal.getTime());
		feedBackModel.setRemark("");
		feedBackMapper.insertSelective(feedBackModel);
		feedBackGainRs.setInfo("感谢您的意见与建议！共建绍兴美好交通！");
		return feedBackGainRs;
	}
	
	
}