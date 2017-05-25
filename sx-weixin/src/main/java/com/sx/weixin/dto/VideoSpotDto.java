package com.sx.weixin.dto;
import com.sx.weixin.model.VideoSpotModel;
import com.sx.weixin.util.CommonUtil;
import com.sx.weixin.util.DateUtil;
public class VideoSpotDto   extends BaseDto<VideoSpotModel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2355325199996881111L;
	private String vsid;

    private String vsname;

    private String lasttime;

    private String remark;

	public String getVsid() {
		return vsid;
	}

	public void setVsid(String vsid) {
		this.vsid = vsid;
	}

	public String getVsname() {
		return vsname;
	}

	public void setVsname(String vsname) {
		this.vsname = vsname;
	}

	public String getLasttime() {
		return lasttime;
	}

	public void setLasttime(String lasttime) {
		this.lasttime = lasttime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
    
	@Override
	public void buildDto(VideoSpotModel videoSpotModel) {
		// TODO Auto-generated method stub 
		this.vsid=CommonUtil.trim(videoSpotModel.getVsid());
		this.vsname=CommonUtil.trim(videoSpotModel.getVsname());  
		this.lasttime=DateUtil.getDateForm(videoSpotModel.getLasttime());  
		this.remark=CommonUtil.trim(videoSpotModel.getRemark());  
	}

	@Override
	public VideoSpotModel vertModel() {
		// TODO Auto-generated method stub
		
		return null;
	}
	
    
}