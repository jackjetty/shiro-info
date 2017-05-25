package com.sx.weixin.service.impl;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
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
import com.sx.weixin.rs.MapQueryAddressRs;
import com.sx.weixin.service.ICarMoveService;
import com.sx.weixin.service.IMapService;
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

@Service("mapService")
public class MapServiceImpl extends BaseServiceImpl implements IMapService {
	
	public static final Logger logger = LoggerFactory.getLogger(MapServiceImpl.class);

	/* (non-Javadoc)
	 * @see com.sx.weixin.service.IMapService#queryAddress(java.lang.String, java.lang.String)
	 */
	@Override
	public MapQueryAddressRs queryAddress(String lat, String lng) {
		// TODO Auto-generated method stub
		
		MapQueryAddressRs mapQueryAddressRs=new MapQueryAddressRs();
		if(StringUtils.isBlank(lat)||StringUtils.isBlank(lng)){
			mapQueryAddressRs.setCode(1);
			mapQueryAddressRs.setInfo("数据不完整");
			mapQueryAddressRs.setAddress("");
		}
		mapQueryAddressRs.setAddress(new HttpMapUtil().mapAddress(lat,lng));
		
		
		return mapQueryAddressRs;
	}
	
	
} 