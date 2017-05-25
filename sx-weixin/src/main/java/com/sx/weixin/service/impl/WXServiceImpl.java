package com.sx.weixin.service.impl;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;

import org.rising.wei.bean.BaseBean;
import org.rising.wei.bean.UserBean;
import org.rising.wei.bean.req.ScanEventReqBean;
import org.rising.wei.bean.req.ScribeEventReqBean;
import org.rising.wei.bean.req.UnScribeEventReqBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

   
import com.sx.weixin.dao.CustResMapper;
import com.sx.weixin.dao.WeiUserMapper;
import com.sx.weixin.model.CustResModel;
import com.sx.weixin.model.WeiUserModel;
import com.sx.weixin.rs.DownloadMediaRs;
import com.sx.weixin.rs.WXReplyRs;
import com.sx.weixin.service.IWXService;
import com.sx.weixin.util.CommonUtil;
import com.sx.weixin.util.DateUtil;
import com.sx.weixin.util.FileUtil;
import com.sx.weixin.util.HttpWeiUtil;
import com.sx.weixin.util.WeiUtil;

@Service("wxService")
public class WXServiceImpl extends BaseServiceImpl implements IWXService {
	
	public static final Logger logger = LoggerFactory.getLogger(WXServiceImpl.class);
 
	@Autowired
	private WeiUserMapper weiUserMapper;
	
	
	
	
	@Value("${unit.name}") 
	protected String  UNITNAME; 
	
	@Value("${image.root}") 
	protected String  IMAGEROOT; 
	
	@Value("${image.url}") 
	protected String  IMAGEURL; 
	
	
	@Autowired
	private CustResMapper custResMapper;
	 

	/* (non-Javadoc)
	 * @see com.sx.weixin.service.IWXService#communicateWX(org.rising.wei.bean.BaseBean)
	 */
	@Transactional
	@Override
	public BaseBean communicateWX(BaseBean inMsg) {
		BaseBean outMsg=null;
		String openId=inMsg.getFromUserName().trim();  
		 
		if(inMsg instanceof UnScribeEventReqBean){ 
			
			WeiUserModel weiUserModel=weiUserMapper.selectByPrimaryKey(openId);
			 
			if(weiUserModel==null){
				weiUserModel=new WeiUserModel();
				weiUserModel.setOpenid(openId);
				weiUserMapper.insertSelective(weiUserModel);
			}  
			int sceneId=weiUserModel.getSceneid()==null?0:weiUserModel.getSceneid() ;
			weiUserModel.setSceneid(sceneId);
			weiUserModel.setSubscribe(0);
			
			weiUserMapper.updateByPrimaryKeySelective(weiUserModel); 
			 
			return WeiUtil.getTextMessage(inMsg, ""); 
		}
		if(inMsg instanceof ScribeEventReqBean){ 
			ScribeEventReqBean scribeEventReqBean=(ScribeEventReqBean)inMsg;
			
			
			//关注的时候操作写入数据库
			 
			WeiUserModel weiUserModel=weiUserMapper.selectByPrimaryKey(openId);
			 
			if(weiUserModel==null){
				weiUserModel=new WeiUserModel();
				weiUserModel.setOpenid(openId);
				weiUserMapper.insertSelective(weiUserModel) ;
			}  
			 
			if(CommonUtil.trim(weiUserModel.getSubscribeTime()).equalsIgnoreCase("")){
				UserBean userBean=null; 
				try {
					userBean=HttpWeiUtil.getInstance(WEIAPPID, WEIAPPSECRET).getUserBean(openId);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(userBean!=null&&(userBean.getSubscribe()==1)){ 
					 
					weiUserModel.setCity(userBean.getCity());
					weiUserModel.setCountry(userBean.getCountry());
					weiUserModel.setHeadimgurl(userBean.getHeadimgurl());
					weiUserModel.setLanguage(userBean.getLanguage());
					weiUserModel.setNickname(userBean.getNickname());
					weiUserModel.setProvince(userBean.getProvince());
					weiUserModel.setSex(userBean.getSex());
					weiUserModel.setSubscribe(userBean.getSubscribe()); 
					if(userBean.getSubscribe_time()!=null)
						weiUserModel.setSubscribeTime(Long.toString(userBean.getSubscribe_time()));  
					 
				}   
				
			}  
			String strSceneId=scribeEventReqBean.getEventKey().replace("qrscene_", "");
			strSceneId=CommonUtil.trim(strSceneId);
			int sceneId;
			if(weiUserModel.getSceneid()==null ){
				weiUserModel.setSceneid(0); 
			}
			if(weiUserModel.getSceneid()==0&& CommonUtil.isInteger(strSceneId) ){
				sceneId=new Integer(strSceneId).intValue();
				weiUserModel.setSceneid(sceneId); 
			}
			weiUserModel.setSubscribe(1);
			
			
			weiUserMapper.updateByPrimaryKeySelective(weiUserModel); 
			StringBuffer textBuffer=new StringBuffer("");
			textBuffer.append("您好！\n");
			textBuffer.append("欢迎进入"+UNITNAME+"微信平台,\n");
			textBuffer.append("我们为您提供轻微事故快速处理等服务，您的满意是我们最大的追求！");   
			return WeiUtil.getTextMessage(inMsg, textBuffer.toString()); 
			
		}
		//扫码
		if(inMsg instanceof ScanEventReqBean){ 
			ScanEventReqBean scanEventReqBean=(ScanEventReqBean)inMsg;
			
			WeiUserModel weiUserModel=weiUserMapper.selectByPrimaryKey(openId);
			if(weiUserModel==null){
				weiUserModel=new WeiUserModel();
				weiUserModel.setOpenid(openId);
				weiUserMapper.insertSelective(weiUserModel) ;
			}
			String strSceneId=CommonUtil.trim(scanEventReqBean.getEventKey());
			
			int sceneId ;
			if(weiUserModel.getSceneid()==null ){
				weiUserModel.setSceneid(0); 
			}
			
			if(weiUserModel.getSceneid()==0&& CommonUtil.isInteger(strSceneId) ){
				sceneId=new Integer(strSceneId).intValue();
				weiUserModel.setSceneid(sceneId); 
				 
			}
			weiUserMapper.updateByPrimaryKeySelective(weiUserModel); 
			
			return WeiUtil.getTextMessage(inMsg, "");
		}
		//其他
		
		WeiUserModel weiUserModel=weiUserMapper.selectByPrimaryKey(openId);
		if(weiUserModel==null){
			weiUserModel=new WeiUserModel();
			weiUserModel.setOpenid(openId);
			weiUserMapper.insertSelective(weiUserModel) ;
		}
	 
		if(CommonUtil.trim(weiUserModel.getSubscribeTime()).equalsIgnoreCase("")){
			UserBean userBean=null; 
			try {
				userBean=HttpWeiUtil.getInstance(WEIAPPID, WEIAPPSECRET).getUserBean(openId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(userBean!=null&&(userBean.getSubscribe()==1)){ 
				 
				weiUserModel.setCity(userBean.getCity());
				weiUserModel.setCountry(userBean.getCountry());
				weiUserModel.setHeadimgurl(userBean.getHeadimgurl());
				weiUserModel.setLanguage(userBean.getLanguage());
				weiUserModel.setNickname(userBean.getNickname());
				weiUserModel.setProvince(userBean.getProvince());
				weiUserModel.setSex(userBean.getSex());
				weiUserModel.setSubscribe(userBean.getSubscribe()); 
				if(userBean.getSubscribe_time()!=null)
					weiUserModel.setSubscribeTime(Long.toString(userBean.getSubscribe_time()));   
				weiUserMapper.updateByPrimaryKeySelective(weiUserModel); 
			}   
			
		} 
		 
		return WeiUtil.getTextMessage(inMsg, "");
	}


	/* (non-Javadoc)
	 * @see com.sx.weixin.service.IWXService#downloadMedia(java.lang.String)
	 */
	@Override
	public DownloadMediaRs downloadMedia(String mediaId) {
		// TODO Auto-generated method stub
		
		
		DownloadMediaRs downloadMediaRs=new DownloadMediaRs();
		String accessToken;
		try {
			accessToken = HttpWeiUtil.getInstance(WEIAPPID, WEIAPPSECRET ).getAccessToken(false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("WeActiveService  downloadMedia 出错{}", e);
			downloadMediaRs.setCode(1);
			downloadMediaRs.setInfo("获取accessToken 出错");
			return downloadMediaRs;
			 
		}
		String filePath="";
		String requestUrl = String.format(HttpWeiUtil.DOWN_MEDIA_URL, accessToken,mediaId)  ;
		
		HttpURLConnection conn=null;
		BufferedInputStream bis=null ;
		FileOutputStream fos=null; 
		 try {
		      URL url = new URL(requestUrl);
		      conn = (HttpURLConnection) url.openConnection();
		      conn.setDoInput(true);
		      conn.setRequestMethod("GET");

		      String dataStr = DateUtil.getDateForm();
			  File toFile = new File(IMAGEROOT + "/" + dataStr);
			  if (!toFile.exists()) {
					toFile.mkdirs();
			   }
		      // 根据内容类型获取扩展名
		      String fileExt = FileUtil .getFileexpandedName(conn.getHeaderField("Content-Type"));
		      // 将mediaId作为文件名
		      String newName = CommonUtil.getImageName()  + fileExt; 
		      bis = new BufferedInputStream(conn.getInputStream());
		      fos = new FileOutputStream(new File(toFile + "/" + newName));
		      
		      
		      filePath="/"+dataStr+"/"+newName;
		      byte[] buf = new byte[8096];
		      int size = 0;
		      while ((size = bis.read(buf)) != -1)
		        fos.write(buf, 0, size);
		      
		     
		    } catch (Exception e) {
		    	logger.error("WeActiveService  downloadMedia 出错{}", e);
		    	downloadMediaRs.setCode(2);
				downloadMediaRs.setInfo("文件下载 出错");
				
		    }finally{
		    	if(fos!=null){
		    		try {
						fos.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    		fos=null;
		    	}
		    	    
		    	if(bis!=null){
		    		 try {
						bis.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    		 bis=null;
		    	}
			    if(conn!=null){
			    	conn.disconnect();
			    	conn=null;
			    } 
		    	
		    }
		 
		    if(downloadMediaRs.getCode()!=0){
		    	return downloadMediaRs;
		    }
		 
			downloadMediaRs.setMediaUrl(IMAGEURL+filePath);
			//logger.error("图片：{}", IMAGEURL+filePath);
			downloadMediaRs.setMediaPath(filePath);
			return downloadMediaRs;
		 
	}


	/* (non-Javadoc)
	 * @see com.sx.weixin.service.IWXService#reply(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Transactional
	@Override
	public WXReplyRs reply(String processId, String recordNo,
			String replyContent, String openId, String userId) {
		// TODO Auto-generated method stub
		processId=CommonUtil.trim(processId);
		recordNo=CommonUtil.trim(recordNo);
		replyContent=CommonUtil.trim(replyContent);
		openId=CommonUtil.trim(openId);
		processId=CommonUtil.trim(processId);
		WXReplyRs wxReplyRs=new WXReplyRs();
		if(processId.equals("")){
			wxReplyRs.setCode(1);
			wxReplyRs.setInfo("传递的参数processid不完整！");
			return wxReplyRs;
		}
		if(recordNo.equals("")){
			wxReplyRs.setCode(1);
			wxReplyRs.setInfo("传递的参数recordno不完整！");
			return wxReplyRs;
		}
		if(replyContent.equals("")){
			wxReplyRs.setCode(1);
			wxReplyRs.setInfo("传递的参数replycontent不完整！");
			return wxReplyRs;
		}
		if(openId.equals("")){
			wxReplyRs.setCode(1);
			wxReplyRs.setInfo("传递的参数openid不完整！");
			return wxReplyRs;
		}
		
		
		try {
			HttpWeiUtil.getInstance(WEIAPPID, WEIAPPSECRET).sendCustMsg(openId, replyContent);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			wxReplyRs.setCode(2);
			wxReplyRs.setInfo("发送回复消息失败！"+e.getMessage());
			return wxReplyRs;
			 
		}
		Calendar cal = Calendar.getInstance();
		CustResModel custResModel=new CustResModel();
		custResModel.setCustrescontent(replyContent);
		custResModel.setCustresponser(userId);
		
		custResModel.setCustrestime(cal.getTime());
	 
		custResModel.setOpenid(openId);
		custResModel.setProcessid(processId);
		custResModel.setRecordno(recordNo);
		custResMapper.insertSelective(custResModel);
		wxReplyRs.setInfo("操作成功！");
		
		return wxReplyRs;
	}
}