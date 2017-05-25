package com.sx.weixin.service;

import org.rising.wei.bean.BaseBean;
 
import com.sx.weixin.rs.DownloadMediaRs;
import com.sx.weixin.rs.WXReplyRs;
 

 

public interface IWXService extends IBaseService{

	public BaseBean communicateWX(BaseBean inMsg ) ; 
	
	public DownloadMediaRs downloadMedia(String mediaId);
	
	
	public WXReplyRs  reply(String processId,String recordNo,String replyContent,String openId,String userId);
}

