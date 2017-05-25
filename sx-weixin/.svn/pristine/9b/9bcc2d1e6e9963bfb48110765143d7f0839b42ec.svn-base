package com.sx.weixin.controller;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.rising.wei.bean.BaseBean;
import org.rising.wei.bean.req.ClickEventReqBean;
import org.rising.wei.bean.req.ImageReqBean;
import org.rising.wei.bean.req.LinkReqBean;
import org.rising.wei.bean.req.LocationReqBean;
import org.rising.wei.bean.req.ScanEventReqBean;
import org.rising.wei.bean.req.ScribeEventReqBean;
import org.rising.wei.bean.req.TextReqBean;
import org.rising.wei.bean.req.UnScribeEventReqBean;
import org.rising.wei.bean.req.VideoReqBean;
import org.rising.wei.bean.req.VoiceReqBean;
import org.rising.wei.bean.res.NewsResBean;
import org.rising.wei.bean.res.TextResBean;
import org.rising.wei.bean.res.object.ItemResObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
  
import com.sx.weixin.rs.DownloadMediaRs;
import com.sx.weixin.rs.WXReplyRs;
import com.sx.weixin.service.IWXService;
import com.sx.weixin.util.CommonUtil;
import com.sx.weixin.util.Constant;
import com.sx.weixin.util.DecriptUtil;
import com.sx.weixin.util.XmlUtil;
import com.thoughtworks.xstream.XStream;
 
 
@Controller 
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class WXController  extends BaseController  {
	public static final Logger logger = LoggerFactory.getLogger(WXController.class);
	
	
	
	@Value("${wei.token}") 
	protected String  WEITOKEN; 
	
	@Autowired
	private IWXService wxService;
	
	 
	@RequestMapping(value="/weixin" ,method = RequestMethod.POST)
	public    void  communicate(HttpServletRequest request,HttpServletResponse response,Model model )
	{ 
		BaseBean inMsg;
		BaseBean outMsg=null;   
		StringBuffer sb = new StringBuffer();
		String inMsgXml="";
		String line;
		Map<String, String> map = null;   
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			} 
			inMsgXml=sb.toString();
			map = XmlUtil.xml2Map(inMsgXml); 
		} catch (Exception e) {
			writeToResponse(  response, "");  
			return;
		} 
		
		String openId=map.get("xml.FromUserName");
		inMsg=new BaseBean(); 
		inMsg.setCreateTime(map.get("xml.CreateTime")); 
		inMsg.setFromUserName(openId);
		inMsg.setMsgType(map.get("xml.MsgType"));
		inMsg.setToUserName(map.get("xml.ToUserName"));  
		XStream xstream=XmlUtil.init(true); 
		if(inMsg.getMsgType().equalsIgnoreCase(Constant.MESSAGE_TYPE_IMAGE)){  
			xstream.processAnnotations(ImageReqBean.class); 
			xstream.alias("xml", ImageReqBean.class);  
			inMsg= (ImageReqBean) xstream.fromXML(inMsgXml); 
		}
		if(inMsg.getMsgType().equalsIgnoreCase(Constant.MESSAGE_TYPE_LINK)){ 
			xstream.processAnnotations(LinkReqBean.class);
			xstream.alias("xml", LinkReqBean.class); 
			inMsg= (LinkReqBean) xstream.fromXML(inMsgXml);  
		}
		
		if(inMsg.getMsgType().equalsIgnoreCase(Constant.MESSAGE_TYPE_LOCATION)){  
			xstream.processAnnotations(LocationReqBean.class);
			xstream.alias("xml", LocationReqBean.class); 
			inMsg= (LocationReqBean) xstream.fromXML(inMsgXml); 
		}
		if(inMsg.getMsgType().equalsIgnoreCase(Constant.MESSAGE_TYPE_TEXT)){
			xstream.processAnnotations(TextReqBean.class);  
			xstream.alias("xml", TextReqBean.class);  
			inMsg= (TextReqBean) xstream.fromXML(inMsgXml);
		  
		}
		
		if(inMsg.getMsgType().equalsIgnoreCase(Constant.MESSAGE_TYPE_VIDEO)){  
			xstream.processAnnotations(VideoReqBean.class);
			xstream.alias("xml", VideoReqBean.class); 
			inMsg= (VideoReqBean) xstream.fromXML(inMsgXml);
			 
		}
		if(inMsg.getMsgType().equalsIgnoreCase(Constant.MESSAGE_TYPE_VOICE)){  
			xstream.processAnnotations(VoiceReqBean.class);
			xstream.alias("xml", VoiceReqBean.class); 
			inMsg= (VoiceReqBean) xstream.fromXML(inMsgXml); 
		}   
		if(inMsg.getMsgType().equalsIgnoreCase(Constant.MESSAGE_TYPE_EVENT)){
			String event=map.get("xml.Event")==null?"":map.get("xml.Event").trim();
			if(event.equalsIgnoreCase(Constant.EVENT_TYPE_SUBSCRIBE)){ 
				xstream.processAnnotations(ScribeEventReqBean.class);
				xstream.alias("xml", ScribeEventReqBean.class);  
				inMsg= (ScribeEventReqBean) xstream.fromXML(inMsgXml);
			} 
			
			if(event.equalsIgnoreCase(Constant.EVENT_TYPE_UNSUBSCRIBE)){ 
				
				xstream.processAnnotations(UnScribeEventReqBean.class);
				xstream.alias("xml", UnScribeEventReqBean.class);  
				inMsg= (UnScribeEventReqBean) xstream.fromXML(inMsgXml);   
			} 
			
			
			if(event.equalsIgnoreCase(Constant.EVENT_TYPE_SCAN)){  
				xstream.processAnnotations(ScanEventReqBean.class);
				xstream.alias("xml", ScanEventReqBean.class);
				inMsg= (ScanEventReqBean) xstream.fromXML(inMsgXml); 
			}
            if(event.equalsIgnoreCase("LOCATION")){ 
            	//writeToResponse(  response, ""); 
            	//return;
			} 
            
            if(event.equalsIgnoreCase(Constant.EVENT_TYPE_CLICK)){ 
            	xstream.processAnnotations(ClickEventReqBean.class);
            	xstream.alias("xml", ClickEventReqBean.class);
            	inMsg= (ClickEventReqBean) xstream.fromXML(inMsgXml); 
				
			}
			
		} 
		
		outMsg=wxService.communicateWX(inMsg);
		if(outMsg instanceof TextResBean){ 
			TextResBean aTextResBean=(TextResBean)outMsg;
			if(aTextResBean.getContent().equals("")){
				writeToResponse(  response, ""); 
				return;
			} 
			xstream.alias("xml", TextResBean.class);  
		}
		if(outMsg instanceof NewsResBean){
			xstream.alias("xml", NewsResBean.class); 
			xstream.alias("item", ItemResObject.class); 
		}   
		String xml = xstream.toXML(outMsg);   
		writeToResponse(  response, xml); 
	}
	
	 
	
	@RequestMapping(value="/weixin",method = RequestMethod.GET)
	public    void  handShake(HttpServletRequest request,HttpServletResponse response,Model model 
			,@RequestParam(value="signature", required=true)  String signature  
			,@RequestParam(value="timestamp", required=true)  String timestamp
			,@RequestParam(value="nonce", required=true)  String nonce
			,@RequestParam(value="echostr", required=true)  String echostr)
	{   
		signature=CommonUtil.trim(signature);
		timestamp=CommonUtil.trim(timestamp); 
		nonce=CommonUtil.trim(nonce);
		echostr=CommonUtil.trim(echostr);
		String[] ArrTmp = { WEITOKEN, timestamp, nonce };
		Arrays.sort(ArrTmp);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < ArrTmp.length; i++) {
			sb.append(ArrTmp[i]);
		}
		String pwd = DecriptUtil.Encrypt(sb.toString());  
		
		if(pwd.equals(signature)){
			if(!"".equals(echostr) && echostr != null){
				
				writeToResponse(  response, echostr); 
			}
		}   
	}
	
	
	@RequestMapping(value = "/download_media" )
	@ResponseBody
	public DownloadMediaRs downloadMedia(HttpSession session, HttpServletRequest request,
			HttpServletResponse response, Model model, 
			@RequestParam(value="mediaId", required=false) String mediaId ) {
		
		return wxService.downloadMedia(mediaId);
	}
	
	
	@RequestMapping(value="/wx_reply" ,method = RequestMethod.POST)
	public    @ResponseBody Object  reply(HttpServletRequest request,HttpServletResponse response,Model model
			,@RequestParam(value="processid", required=true) String processId
			,@RequestParam(value="recordno", required=true) String recordNo
			,@RequestParam(value="replycontent", required=true) String replyContent
			,@RequestParam(value="openid", required=true) String openId
			,@RequestParam(value="userid", required=false) String userId)
	{ 
		
		
		WXReplyRs wxReplyRs=wxService.reply(processId,recordNo,replyContent,openId,userId);
			
		return wxReplyRs; 
		
	}
	 
	
	
}
	