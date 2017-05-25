package com.sx.weixin.service.impl;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.sx.weixin.util.HttpUtil;
import com.sx.weixin.dao.FormalAccidentMapper;
import com.sx.weixin.dao.InfoPicMapper;
import com.sx.weixin.dao.PlaceAreaMapper;
import com.sx.weixin.model.FormalAccidentModel;
import com.sx.weixin.model.InfoPicModel;
import com.sx.weixin.model.PlaceAreaModel;
import com.sx.weixin.ot.PointOt;
import com.sx.weixin.rs.AccidentGainImageRs;
import com.sx.weixin.rs.AccidentGainTextRs;
import com.sx.weixin.rs.AccidentGatherRs;
import com.sx.weixin.service.IAccidentService;
import com.sx.weixin.store.AccidentStore;
import com.sx.weixin.store.info.LocationStoreInfo;
import com.sx.weixin.store.info.PictureStoreInfo;
import com.sx.weixin.thread.CopyThread;
import com.sx.weixin.util.AttributionUtil;
import com.sx.weixin.util.CommonUtil;
import com.sx.weixin.util.Constant;
import com.sx.weixin.util.DateUtil;
import com.sx.weixin.util.HttpWeiUtil;

@Service("accidentService")
public class AccidentServiceImpl extends BaseServiceImpl implements IAccidentService {
	
	public static final Logger logger = LoggerFactory.getLogger(AccidentServiceImpl.class);
 
	@Autowired
	private FormalAccidentMapper formalAccidentMapper;
	
	@Autowired
	private PlaceAreaMapper placeAreaMapper;
	
	
	@Autowired
	private InfoPicMapper infoPicMapper;
	
	@Value("${image.root}") 
	protected String  IMAGEROOT;
	
	 
	
	@Value("${unit.contact}") 
	protected String  UNITCONTACT;
	
	
	
	@Value("${accident.notice.url}") 
	private  String  ACCIDENTNOTICEURL;
	 

	/* (non-Javadoc)
	 * @see com.sx.weixin.service.IAccidentService#gatherAccident()
	 */
	@Override
	public AccidentGatherRs gatherAccident() {
		// TODO Auto-generated method stub
		AccidentGatherRs accidentGatherRs=new AccidentGatherRs();
		 
		
		
		Calendar cal = Calendar.getInstance(); 
		int hour=cal.get(Calendar.HOUR_OF_DAY);
		int minute=cal.get(Calendar.MINUTE);
		if(hour<6 ||hour>20){
			
			accidentGatherRs.setCode(10);
			accidentGatherRs.setInfo("微信事故受理时间为每天6时至20时分,现在是非受理时间，请拨110报警。"); 
			return accidentGatherRs;
		} 
		
		accidentGatherRs.setAccidentTime(DateUtil.getDateForm("yyyy-MM-dd HH:mm"));
		
		
		//yyyy-MM-dd HH:mm:ss
		
		
		return accidentGatherRs;
	}

	/* (non-Javadoc)
	 * @see com.sx.weixin.service.IAccidentService#gainText(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public AccidentGainTextRs gainText(AccidentStore accidentStore,String address,
			String reportPhoneNumber, String otherPhoneNumber,
			String locationX, String locationY) {
		// TODO Auto-generated method stub
		AccidentGainTextRs accidentGainTextRs=new AccidentGainTextRs();
		accidentStore.setOtherPhoneNumber(otherPhoneNumber);
		accidentStore.setReportPhoneNumber(reportPhoneNumber);
		LocationStoreInfo locationStoreInfo=new LocationStoreInfo();
		locationStoreInfo.setAddress(address);
		locationStoreInfo.setLocationX(locationX);
		locationStoreInfo.setLocationY(locationY);
		accidentStore.setLocationInfo(locationStoreInfo);
		
		
		return accidentGainTextRs;
	}

	/* (non-Javadoc)
	 * @see com.sx.weixin.service.IAccidentService#gainImage(com.sx.weixin.store.AccidentStore, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String[])
	 */
	@Transactional
	@Override
	public AccidentGainImageRs gainImage(AccidentStore accidentStore,
			String overviewPath, String centerPath, String detailPath,
			String paperPath, String[] morePath) {
		
		// TODO Auto-generated method stub
		AccidentGainImageRs accidentGainImageRs=new AccidentGainImageRs();
		LocationStoreInfo locationStoreInfo =accidentStore.getLocationInfo();
		if(locationStoreInfo==null){
			 accidentGainImageRs.setCode(3);
			 accidentGainImageRs.setInfo("session 失效,请重新上传！");
			 return accidentGainImageRs;
		}
		//计算位置
		float  destLatitude=Float.parseFloat(locationStoreInfo.getLocationX());
		float  destLongitude=Float.parseFloat(locationStoreInfo.getLocationY());
		PointOt destPoint=new PointOt();
		destPoint.setPointX(destLatitude);
		destPoint.setPointY(destLongitude) ;
		
		int[] arrPlaceId=new int[]{1,2,3,4,6};
		List<PlaceAreaModel> placeAreaModelList;
		List<PointOt> pointOtList;
		 
		String departmentId=null;
		for(int placeId:arrPlaceId){
			placeAreaModelList=placeAreaMapper.selectByPlaceId(placeId);
			pointOtList=new ArrayList<PointOt>();
			PointOt pointOt;
			for(PlaceAreaModel placeAreaModel: placeAreaModelList){
				if(!CommonUtil.isNumeric(CommonUtil.trim(placeAreaModel.getLatitude())))
	    			 continue;
	    		if(!CommonUtil.isNumeric(CommonUtil.trim(placeAreaModel.getLongitude())))
	   			     continue;
	    		pointOt=new PointOt();
	    		pointOt.setPointX(new Float(CommonUtil.trim(placeAreaModel.getLatitude())).floatValue());
	    		pointOt.setPointY(new Float(CommonUtil.trim(placeAreaModel.getLongitude())).floatValue());
	    		pointOtList.add(pointOt);
				
			} 
			
			if(AttributionUtil.InPolygon(pointOtList, destPoint)==0)  
	              continue;
			
			switch(placeId){
		     case 1:
		    	  departmentId= "DP002";
		    	  break;
		     case 2:
		    	  departmentId= "DP006"; 
		    	  break;
		     case 3:
		    	  departmentId= "DP005";
		    	  break;
		     case 4:
		    	  departmentId= "DP003"; 
		    	  break;
		     case 6:
		    	  departmentId= "DP004"; 
		    	  break;
			  }
			 break;    
		}
		locationStoreInfo.setDepartmentId(departmentId);
		
		 
		
		 
		//生成编号
		String nextAccidentId = Constant.PREFIX_ACCIDENT + DateUtil.getDateForm("yyMMdd");
		
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		int currentNum=0;
		String maxFormlAccidentId=formalAccidentMapper.maxFormlAccidentId(cal.getTime());
		if(maxFormlAccidentId!=null){
			currentNum = CommonUtil
					.getCurrentNum(maxFormlAccidentId, nextAccidentId);
		}
		currentNum++;
		String formalAccidentId  = String.format(Constant.PREFIX_ACCIDENT+"%ty%<tm%<td%04d", cal.getTime(), currentNum);
		
		
		//生成事故记录
		
		FormalAccidentModel formalAccidentModel=formalAccidentMapper.selectByPrimaryKey(formalAccidentId);
		if(formalAccidentModel==null){
			formalAccidentModel=new FormalAccidentModel();
			formalAccidentModel.setFormlaccidentid(formalAccidentId);
			formalAccidentMapper.insertSelective(formalAccidentModel);
		}
		formalAccidentModel.setAccidentstate("上报");
		formalAccidentModel.setAddress(locationStoreInfo.getAddress());
		formalAccidentModel.setLocationx(locationStoreInfo.getLocationX());
		formalAccidentModel.setLocationy(locationStoreInfo.getLocationY());
		formalAccidentModel.setDepartmentid(locationStoreInfo.getDepartmentId());
		formalAccidentModel.setReportertype("公众");
		formalAccidentModel.setReportopenid(accidentStore.getReportopenId());
		formalAccidentModel.setEmergencycall(false);
		formalAccidentModel.setReportphonenumber(accidentStore.getReportPhoneNumber());
		formalAccidentModel.setOtherphonenumber(accidentStore.getOtherPhoneNumber());
		cal = Calendar.getInstance(); 
		formalAccidentModel.setReporttime(cal.getTime());
		formalAccidentMapper.updateByPrimaryKeySelective(formalAccidentModel);
		
		//图片保存了
		int picIndex=0;
		InfoPicModel infoPicModel;
		PictureStoreInfo pictureStoreInfo;
		String picLocalStore="";
		
		List<PictureStoreInfo> pictureStoreInfoList=new ArrayList<PictureStoreInfo>();
		pictureStoreInfo=new PictureStoreInfo();
		pictureStoreInfo.setInfo("前方照");
		pictureStoreInfo.setType("前方");
		pictureStoreInfo.setName("前方照.jpg");
		pictureStoreInfo.setPath(overviewPath);
		pictureStoreInfoList.add(pictureStoreInfo);
		
		pictureStoreInfo=new PictureStoreInfo();
		pictureStoreInfo.setInfo("后方照");
		pictureStoreInfo.setType("后方");
		pictureStoreInfo.setName("后方照.jpg");
		pictureStoreInfo.setPath(centerPath);
		pictureStoreInfoList.add(pictureStoreInfo);
		
		
		pictureStoreInfo=new PictureStoreInfo();
		pictureStoreInfo.setInfo("中心照");
		pictureStoreInfo.setType("中心");
		pictureStoreInfo.setName("中心照.jpg");
		pictureStoreInfo.setPath(detailPath);
		pictureStoreInfoList.add(pictureStoreInfo);
		
		pictureStoreInfo=new PictureStoreInfo();
		pictureStoreInfo.setInfo("信息照");
		pictureStoreInfo.setType("信息");
		pictureStoreInfo.setName("信息照.jpg");
		pictureStoreInfo.setPath(paperPath);
		pictureStoreInfoList.add(pictureStoreInfo);
		
		
		if(morePath!=null &&morePath.length>0){
			for(String aMorePath:morePath){
				picIndex++;
				pictureStoreInfo=new PictureStoreInfo();
				pictureStoreInfo.setInfo("附图照");
				pictureStoreInfo.setType("附图");
				pictureStoreInfo.setName("附图照_"+picIndex+".jpg");
				pictureStoreInfo.setPath(aMorePath);
				pictureStoreInfoList.add(pictureStoreInfo);
				
				
			}
		}
		picIndex=0;
		for(PictureStoreInfo aPictureStoreInfo :pictureStoreInfoList){
			picLocalStore=Constant.PROCESS_ACCIDENT.toLowerCase()+"/";
			picLocalStore+=DateUtil.getDateForm()+"/"+formalAccidentId;
			picLocalStore+="/"+aPictureStoreInfo.getName();
			picIndex++;
			infoPicModel=new InfoPicModel();
			infoPicModel.setPicindex(picIndex);
			infoPicModel.setPicinfo(aPictureStoreInfo.getInfo());
			infoPicModel.setPictype(aPictureStoreInfo.getType());
			infoPicModel.setPiclocalstore(picLocalStore);
			infoPicModel.setProcessid(Constant.PROCESS_ACCIDENT);
			infoPicModel.setRecordno(formalAccidentId);
			infoPicMapper.insertSelective(infoPicModel);
			
			new CopyThread(IMAGEROOT+aPictureStoreInfo.getPath(),IMAGEROOT+picLocalStore).start(); 	
		}  
		accidentGainImageRs.setFormalAccidentId(formalAccidentId);
		accidentGainImageRs.setInfo("事故编号为："+formalAccidentId);
		
		StringBuffer resBuffer=new StringBuffer(""); 
		resBuffer.append("已接收事故上报,\n"); 
		resBuffer.append("事故编号：\n");
		resBuffer.append(formalAccidentId);
		resBuffer.append("您的信息正在审核中,请耐心等候，\n");
		resBuffer.append("我们将以微信方式向您回复,\n");
		resBuffer.append("如若5分钟未收到回复，请致电\n"); 
		resBuffer.append(UNITCONTACT+"查询。\n");
		try {
			HttpWeiUtil.getInstance(WEIAPPID, WEIAPPSECRET).sendCustMsg(formalAccidentModel.getReportopenid(), resBuffer.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 
		}
		
		
		//调用浏览器js 消息提醒
		Map<String,String> params=new HashMap<String,String>();
		HttpUtil httpUtil=new HttpUtil(); 
		params.put("formlaccidentid",formalAccidentModel.getFormlaccidentid());
		params.put("departmentid", formalAccidentModel.getDepartmentid() ); 
		String result=""; 
		try {
			result=httpUtil.post(ACCIDENTNOTICEURL,  params ); 
			JSONObject jsonObj = JSONObject.parseObject(result);
			Integer code = jsonObj.getInteger("code");
			if(code!=0){
				logger.error("调用浏览器js 消息提醒——{}",jsonObj.getString("info"));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("调用浏览器js 消息提醒——{}", e.getMessage());
		}
				
		
		return accidentGainImageRs;
	}
	
}