package com.sx.weixin.dto;
import com.sx.weixin.model.InfoPicModel; 
import com.sx.weixin.model.PlaceAreaModel;
import com.sx.weixin.util.CommonUtil;
import com.sx.weixin.util.DateUtil;
public class InfoPicDto   extends BaseDto<InfoPicModel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2080806757247301833L;
	private String processid;

    private String recordno;

    private String picindex;
    
	private String pictype;

    private String picinfo;

    private String picurl;

    private String piclocalstore;
    
    
    
    
    
    public String getProcessid() {
		return processid;
	}

	public void setProcessid(String processid) {
		this.processid = processid;
	}

	public String getRecordno() {
		return recordno;
	}

	public void setRecordno(String recordno) {
		this.recordno = recordno;
	}

	public String getPicindex() {
		return picindex;
	}

	public void setPicindex(String picindex) {
		this.picindex = picindex;
	}

	public String getPictype() {
		return pictype;
	}

	public void setPictype(String pictype) {
		this.pictype = pictype;
	}

	public String getPicinfo() {
		return picinfo;
	}

	public void setPicinfo(String picinfo) {
		this.picinfo = picinfo;
	}

	public String getPicurl() {
		return picurl;
	}

	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}

	public String getPiclocalstore() {
		return piclocalstore;
	}

	public void setPiclocalstore(String piclocalstore) {
		this.piclocalstore = piclocalstore;
	}

	@Override
	public void buildDto(InfoPicModel infoPicModel) {
		// TODO Auto-generated method stub 
		this.processid=CommonUtil.trim(infoPicModel.getProcessid());
		this.recordno=CommonUtil.trim(infoPicModel.getRecordno());  
		this.picindex=CommonUtil.trim(infoPicModel.getPicindex());  
		this.pictype=CommonUtil.trim(infoPicModel.getPictype());  
		this.picinfo=CommonUtil.trim(infoPicModel.getPicinfo());  
		this.picurl=CommonUtil.trim(infoPicModel.getPicurl());  
		this.piclocalstore=CommonUtil.trim(infoPicModel.getPiclocalstore());  
	}

	@Override
	public InfoPicModel vertModel() {
		// TODO Auto-generated method stub
		
		return null;
	}
	
}