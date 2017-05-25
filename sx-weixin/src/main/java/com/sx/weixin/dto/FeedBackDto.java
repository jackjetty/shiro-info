package com.sx.weixin.dto;
import java.util.Date;

import com.sx.weixin.model.AnnalsModel;
import com.sx.weixin.model.FeedBackModel; 
import com.sx.weixin.util.CommonUtil;
import com.sx.weixin.util.DateUtil;
public class FeedBackDto   extends BaseDto<FeedBackModel> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3736376735722369333L;
	
	private String feedbackid;

	private String feedtime;

    private String feedopenid;

    private String recordtype; 

    private String feedbackstate;

    private String feedtext;
    
    
    private String contact;

    private String remark;
    
    
    @Override
	public void buildDto(FeedBackModel feedBackModel) {
		// TODO Auto-generated method stub  
		this.feedbackid=CommonUtil.trim(feedBackModel.getFeedopenid());
		this.feedtime=DateUtil.getDateForm(feedBackModel.getFeedtime()); 
		this.feedopenid=CommonUtil.trim(feedBackModel.getFeedopenid());
		this.recordtype=CommonUtil.trim(feedBackModel.getRecordtype());  
		this.feedbackstate=CommonUtil.trim(feedBackModel.getFeedbackstate());  
		this.feedtext=CommonUtil.trim(feedBackModel.getFeedtext());  
		this.contact=CommonUtil.trim(feedBackModel.getContact()); 
		this.remark=CommonUtil.trim(feedBackModel.getRemark()); 
		
		
		
	}

	@Override
	public FeedBackModel vertModel() {
		// TODO Auto-generated method stub
		
		return null;
	}

	public String getFeedbackid() {
		return feedbackid;
	}

	public void setFeedbackid(String feedbackid) {
		this.feedbackid = feedbackid;
	}

	public String getFeedtime() {
		return feedtime;
	}

	public void setFeedtime(String feedtime) {
		this.feedtime = feedtime;
	}

	public String getFeedopenid() {
		return feedopenid;
	}

	public void setFeedopenid(String feedopenid) {
		this.feedopenid = feedopenid;
	}

	public String getRecordtype() {
		return recordtype;
	}

	public void setRecordtype(String recordtype) {
		this.recordtype = recordtype;
	}

	public String getFeedbackstate() {
		return feedbackstate;
	}

	public void setFeedbackstate(String feedbackstate) {
		this.feedbackstate = feedbackstate;
	}

	public String getFeedtext() {
		return feedtext;
	}

	public void setFeedtext(String feedtext) {
		this.feedtext = feedtext;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}