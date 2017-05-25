package com.sx.weixin.dto;
import com.sx.weixin.model.AnnalsModel;
import com.sx.weixin.model.PoliceSpotModel;
import com.sx.weixin.util.CommonUtil;
import com.sx.weixin.util.DateUtil;
public class AnnalsDto   extends BaseDto<AnnalsModel> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3736376735722369362L;
	
	private String anid;

	private String antitle;

    private String mediaid;

    private String anurl;
    
    private String thumburl;

    private String anupdatetime;
    
    private String ancreatetime;
    
    private String thumbmediaid;

    private Boolean anvalid;

    private String remark;
    
    

	public String getThumbmediaid() {
		return thumbmediaid;
	}

	public void setThumbmediaid(String thumbmediaid) {
		this.thumbmediaid = thumbmediaid;
	}

	public Boolean getAnvalid() {
		return anvalid;
	}

	public void setAnvalid(Boolean anvalid) {
		this.anvalid = anvalid;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAnid() {
		return anid;
	}

	public void setAnid(String anid) {
		this.anid = anid;
	}

	public String getAntitle() {
		return antitle;
	}

	public void setAntitle(String antitle) {
		this.antitle = antitle;
	}

	public String getMediaid() {
		return mediaid;
	}

	public void setMediaid(String mediaid) {
		this.mediaid = mediaid;
	}

	public String getAnurl() {
		return anurl;
	}

	public void setAnurl(String anurl) {
		this.anurl = anurl;
	}

	public String getAnupdatetime() {
		return anupdatetime;
	}

	public void setAnupdatetime(String anupdatetime) {
		this.anupdatetime = anupdatetime;
	}
    
    
	
	public String getAncreatetime() {
		return ancreatetime;
	}

	public void setAncreatetime(String ancreatetime) {
		this.ancreatetime = ancreatetime;
	}
	
	

	 
	public String getThumburl() {
		return thumburl;
	}

	public void setThumburl(String thumburl) {
		this.thumburl = thumburl;
	}

	@Override
	public void buildDto(AnnalsModel annalsModel) {
		// TODO Auto-generated method stub  
		this.anid=CommonUtil.trim(annalsModel.getAnid());
		this.antitle=CommonUtil.trim(annalsModel.getAntitle());
		this.mediaid=CommonUtil.trim(annalsModel.getMediaid());  
		this.anurl=CommonUtil.trim(annalsModel.getAnurl());  
		this.anupdatetime=CommonUtil.trim(annalsModel.getAnupdatetime());  
		this.ancreatetime=CommonUtil.trim(annalsModel.getAncreatetime()); 
		this.thumburl=CommonUtil.trim(annalsModel.getThumburl()); 
		this.thumbmediaid=CommonUtil.trim(annalsModel.getThumbmediaid()); 
		this.anvalid= annalsModel.getAnvalid()==null?false:  annalsModel.getAnvalid();
		this.remark=CommonUtil.trim(annalsModel.getRemark());
		 
	}

	@Override
	public AnnalsModel vertModel() {
		// TODO Auto-generated method stub
		
		return null;
	}
}