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
import com.sx.weixin.dao.FormalAccidentMapper;
import com.sx.weixin.dao.InfoPicMapper;
import com.sx.weixin.dao.PlaceAreaMapper;
import com.sx.weixin.model.CarMoveModel;
import com.sx.weixin.model.FormalAccidentModel;
import com.sx.weixin.model.InfoPicModel;
import com.sx.weixin.model.PlaceAreaModel; 
  
import com.sx.weixin.rs.CarMoveGainRs;
import com.sx.weixin.service.ICarMoveService;
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

@Service("carmoveService")
public class CarMoveServiceImpl extends BaseServiceImpl implements ICarMoveService {
	
	public static final Logger logger = LoggerFactory.getLogger(CarMoveServiceImpl.class);

	/* (non-Javadoc)
	 * @see com.sx.weixin.service.ICarMoveService#gain(java.lang.String, java.lang.String, java.lang.String[])
	 */
	@Value("${image.root}") 
	protected String  IMAGEROOT;
	
	 
	
	@Value("${unit.contact}") 
	protected String  UNITCONTACT;
	
	
	@Autowired
	private CarMoveMapper carMoveMapper;
	
	@Autowired
	private InfoPicMapper infoPicMapper;
	
	@Transactional
	@Override
	public CarMoveGainRs gain(String openid,String cartype,String phonenumber, String carnumber,
			String  locationx,String  locationy,
			String[] morePath) {
		// TODO Auto-generated method stub
		CarMoveGainRs carMoveGainRs=new CarMoveGainRs();
		carnumber=carnumber.toUpperCase();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR_OF_DAY, -5);
		carnumber="浙D"+carnumber;
		Integer lateCount=carMoveMapper.queryLateCount(cartype,carnumber,cal.getTime());
		if(lateCount!=null && lateCount>0){
			carMoveGainRs.setCode(1);
			carMoveGainRs.setInfo("车牌号为:"+cartype+"已经受理请耐心等候!");
			return carMoveGainRs;
		}
		
		
		
		
		
		
		
		//生成编号
		String nextCarMoveId = Constant.PREFIX_CARMOVE + DateUtil.getDateForm("yyMMdd");
		cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		int currentNum=0;
		String maxCarMoveId=carMoveMapper.maxCarMoveId (cal.getTime());
		if(maxCarMoveId!=null){
			currentNum = CommonUtil
					.getCurrentNum(maxCarMoveId, nextCarMoveId);
		}
		currentNum++;
		String carMoveId  = String.format(Constant.PREFIX_CARMOVE+"%ty%<tm%<td%04d", cal.getTime(), currentNum);
		
		//生成移车记录 
		CarMoveModel carMoveModel=carMoveMapper.selectByPrimaryKey(carMoveId);
		if(carMoveModel==null){
			carMoveModel=new CarMoveModel();
			carMoveModel.setCarmoveid(carMoveId) ;
			carMoveMapper.insertSelective(carMoveModel);
		}
		carMoveModel.setCarmovestate("上报");
		carMoveModel.setCartype(cartype);
		carMoveModel.setCarnumber(carnumber);
		carMoveModel.setLocationx(locationx);
		carMoveModel.setLocationy(locationy);
		carMoveModel.setAddress(new HttpMapUtil().mapAddress(locationx,locationy));
		carMoveModel.setReportopenid(openid);
		carMoveModel.setReportphonenumber(phonenumber);
		cal = Calendar.getInstance(); 
		carMoveModel.setReporttime(cal.getTime());
		ClientWSDD clientWSDD=new ClientWSDD();
		ErrCodeBean errCodeBean=clientWSDD.sendCarMoveMessage(CommonUtil.trim(carMoveModel.getCartype()),
				                                               CommonUtil.trim(carMoveModel.getCarnumber()) ,
				                                               CommonUtil.trim(carMoveModel.getAddress()),  
				                                               CommonUtil.trim(carMoveModel.getReportphonenumber()));
		 
		 
		StringBuffer resBuffer=new StringBuffer(""); 
		resBuffer.append("您的信息已收到，\n");
		resBuffer.append("受理编号是:\n");
		resBuffer.append(carMoveId+"\n");
		
		  
		 if(errCodeBean.getErrcode().equalsIgnoreCase("0")){
			 carMoveModel.setCarmovestate("已通知");
			 resBuffer.append("我们已短信通知车主请耐心等候。\n");  
		 }
		 else{
			 carMoveModel.setCarmovestate("未通知");
			 resBuffer.append("短信发送失败，可拨"+this.UNITCONTACT+"人工联系。\n");
			 logger.error("短信通知失败!编号是"+carMoveId+" "+errCodeBean.getErrmsg());
		 } 
		 
		 carMoveMapper.updateByPrimaryKeySelective(carMoveModel);
		 
		//图片保存了
		 int picIndex=0;
		 InfoPicModel infoPicModel;
		 PictureStoreInfo pictureStoreInfo;
		 String picLocalStore=""; 
		 List<PictureStoreInfo> pictureStoreInfoList=new ArrayList<PictureStoreInfo>();
		 
		 if(morePath!=null &&morePath.length>0){
				for(String aMorePath:morePath){
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
			picLocalStore=Constant.PROCESS_CARMOVE.toLowerCase()+"/"; 
			picLocalStore+=DateUtil.getDateForm()+"/"+carMoveId;
			picLocalStore+="/"+aPictureStoreInfo.getName();
			picIndex++;
			infoPicModel=new InfoPicModel();
			infoPicModel.setPicindex(picIndex);
			infoPicModel.setPicinfo(aPictureStoreInfo.getInfo());
			infoPicModel.setPictype(aPictureStoreInfo.getType());
			infoPicModel.setPiclocalstore(picLocalStore);
			infoPicModel.setProcessid(Constant.PROCESS_CARMOVE);
			infoPicModel.setRecordno(carMoveId);
			infoPicMapper.insertSelective(infoPicModel);
			
			new CopyThread(IMAGEROOT+aPictureStoreInfo.getPath(),IMAGEROOT+picLocalStore).start(); 	
		 }  
		 
		 
		 
		     
			 
		try {
			HttpWeiUtil.getInstance(WEIAPPID, WEIAPPSECRET).sendCustMsg(carMoveModel.getReportopenid(), resBuffer.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 
		}
		 carMoveGainRs.setCarMoveId(carMoveId);
		 carMoveGainRs.setInfo("我们已短信通知车主请耐心等候。");
		 return carMoveGainRs;
		 
		 
	}
	
	
}