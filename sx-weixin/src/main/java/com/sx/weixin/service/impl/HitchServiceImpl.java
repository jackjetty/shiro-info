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
 
import com.sx.weixin.dao.HitchMapper;
import com.sx.weixin.dao.FormalAccidentMapper;
import com.sx.weixin.dao.InfoPicMapper;
import com.sx.weixin.dao.PlaceAreaMapper;
import com.sx.weixin.model.CarMoveModel;
import com.sx.weixin.model.HitchModel;
import com.sx.weixin.model.FormalAccidentModel;
import com.sx.weixin.model.InfoPicModel;
import com.sx.weixin.model.PlaceAreaModel; 
  
import com.sx.weixin.rs.HitchGainRs;
import com.sx.weixin.service.IHitchService;
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

@Service("hitchService")
public class HitchServiceImpl extends BaseServiceImpl implements IHitchService {
	
	public static final Logger logger = LoggerFactory.getLogger(HitchServiceImpl.class);

	/* (non-Javadoc)
	 * @see com.sx.weixin.service.IHitchService#gain(java.lang.String, java.lang.String, java.lang.String[])
	 */
	@Value("${image.root}") 
	protected String  IMAGEROOT;
 
	
	@Value("${unit.contact}") 
	protected String  UNITCONTACT;
	
	
	@Autowired
	private HitchMapper hitchMapper;
	
	@Autowired
	private InfoPicMapper infoPicMapper;

	/* (non-Javadoc)
	 * @see com.sx.weixin.service.IHitchService#gain(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Transactional
	@Override
	public HitchGainRs gain(String openid, String phonenumber, String address,
			String locationx, String locationy,String hitchdes, String[] morepath) {
		// TODO Auto-generated method stub
		HitchGainRs hitchGainRs=new HitchGainRs(); 
		//生成编号
	    String nextHitchId = Constant.PREFIX_HITCH + DateUtil.getDateForm("yyMMdd");
	    Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		int currentNum=0;
		String maxHitchId=hitchMapper.maxHitchId (cal.getTime());
		if(maxHitchId!=null){
			currentNum = CommonUtil
					.getCurrentNum(maxHitchId, nextHitchId);
		}
		currentNum++;
		String hitchId  = String.format(Constant.PREFIX_HITCH+"%ty%<tm%<td%04d", cal.getTime(), currentNum);
		
		//生成移车记录 
		HitchModel hitchModel=hitchMapper.selectByPrimaryKey(hitchId);
		if(hitchModel==null){
			hitchModel=new HitchModel();
			hitchModel.setHitchid(hitchId); 
			hitchMapper.insertSelective(hitchModel);
		}
		hitchModel.setAddress(address);
		hitchModel.setHitchdes(hitchdes);
		hitchModel.setHitchstate("上报");
		hitchModel.setLocationx(locationx);
		hitchModel.setLocationy(locationy);
		hitchModel.setRemark("");
		hitchModel.setReportopenid(openid);
		hitchModel.setReportphonenumber(phonenumber);
		cal = Calendar.getInstance(); 
		hitchModel.setReporttime(cal.getTime());
		StringBuffer resBuffer=new StringBuffer(""); 
		resBuffer.append("您的上报的设备故障信息已收到，\n");
		resBuffer.append("受理编号是:\n");
		resBuffer.append(hitchId+"\n");
		resBuffer.append("绍兴交警感谢你的热心。\n");
		try {
			HttpWeiUtil.getInstance(WEIAPPID, WEIAPPSECRET).sendCustMsg(hitchModel.getReportopenid(), resBuffer.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 
		}
		hitchMapper.updateByPrimaryKeySelective(hitchModel);
		//图片保存了
		 int picIndex=0;
		 InfoPicModel infoPicModel;
		 PictureStoreInfo pictureStoreInfo;
		 String picLocalStore=""; 
		 List<PictureStoreInfo> pictureStoreInfoList=new ArrayList<PictureStoreInfo>();
		 if(morepath!=null &&morepath.length>0){
				for(String aMorePath:morepath){
					picIndex++;
					pictureStoreInfo=new PictureStoreInfo();
					pictureStoreInfo.setInfo("信息照");
					pictureStoreInfo.setType("信息");
					pictureStoreInfo.setName("信息照_"+picIndex+".jpg");
					pictureStoreInfo.setPath(aMorePath);
					pictureStoreInfoList.add(pictureStoreInfo); 
				}
		 }
		 
		 picIndex=0;
		 for(PictureStoreInfo aPictureStoreInfo :pictureStoreInfoList){
			picLocalStore=Constant.PROCESS_HITCH.toLowerCase()+"/"; 
			picLocalStore+=DateUtil.getDateForm()+"/"+hitchId;
			picLocalStore+="/"+aPictureStoreInfo.getName();
			picIndex++;
			infoPicModel=new InfoPicModel();
			infoPicModel.setPicindex(picIndex);
			infoPicModel.setPicinfo(aPictureStoreInfo.getInfo());
			infoPicModel.setPictype(aPictureStoreInfo.getType());
			infoPicModel.setPiclocalstore(picLocalStore);
			infoPicModel.setProcessid(Constant.PROCESS_HITCH);
			infoPicModel.setRecordno(hitchId);
			infoPicMapper.insertSelective(infoPicModel);
			
			new CopyThread(IMAGEROOT+aPictureStoreInfo.getPath(),IMAGEROOT+picLocalStore).start(); 	
		 }  
		 
		 hitchGainRs.setInfo("感谢您的支持！");
		 hitchGainRs.setHitchId(hitchId); 
		 return hitchGainRs;
	}
}