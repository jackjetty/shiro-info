package com.sx.weixin.dto;
import com.sx.weixin.model.WeiUserModel;
import com.sx.weixin.util.CommonUtil;
import com.sx.weixin.util.DateUtil;
public class WeiUserDto   extends BaseDto<WeiUserModel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2355329999996881111L;
	
	private String openid;

    private String userid;

    private boolean subscribe;

    private String nickname;

    private String sex;

    private String city;

    private String country;

    private String province;

    private String language;

    private String headimgurl;

    private String subscribeTime;

    private String realname;

    private String phonenumber;

    private String sceneid;

    private String createtime;

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public boolean isSubscribe() {
		return subscribe;
	}

	public void setSubscribe(boolean subscribe) {
		this.subscribe = subscribe;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	} 

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getHeadimgurl() {
		return headimgurl;
	}

	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}

	public String getSubscribeTime() {
		return subscribeTime;
	}

	public void setSubscribeTime(String subscribeTime) {
		this.subscribeTime = subscribeTime;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getSceneid() {
		return sceneid;
	}

	public void setSceneid(String sceneid) {
		this.sceneid = sceneid;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
    
	@Override
	public void buildDto(WeiUserModel weiUserModel) {
		
		weiUserModel.setSubscribe(weiUserModel.getSubscribe()==null?0:weiUserModel.getSubscribe());
		 
		this.openid=CommonUtil.trim(weiUserModel.getOpenid());
		this.userid=CommonUtil.trim(weiUserModel.getUserid());
		this.subscribe=weiUserModel.getSubscribe()==0?false:true;
		this.nickname=CommonUtil.trim(weiUserModel.getNickname());
		this.sex=CommonUtil.trim(weiUserModel.getSex());
		this.city=CommonUtil.trim(weiUserModel.getCity());
		this.country=CommonUtil.trim(weiUserModel.getCountry());
		this.province=CommonUtil.trim(weiUserModel.getProvince());
		this.language=CommonUtil.trim(weiUserModel.getLanguage());
		this.headimgurl=CommonUtil.trim(weiUserModel.getHeadimgurl());
		this.subscribeTime=CommonUtil.trim(weiUserModel.getSubscribeTime());
		this.realname=CommonUtil.trim(weiUserModel.getRealname());
		this.phonenumber=CommonUtil.trim(weiUserModel.getPhonenumber()); 
		this.sceneid=CommonUtil.trim(weiUserModel.getSceneid());
		this.createtime=DateUtil.getDateForm(weiUserModel.getCreatetime());
		 
	}
	@Override
	public WeiUserModel vertModel() {
		// TODO Auto-generated method stub
		
		return null;
	}
    
}