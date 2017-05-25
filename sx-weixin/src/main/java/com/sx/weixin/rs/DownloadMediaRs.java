package com.sx.weixin.rs; 

public class DownloadMediaRs extends BaseRs{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3848543154001973234L;
	private String mediaUrl; 
	private String mediaPath;
	
	public String getMediaUrl() {
		return mediaUrl;
	}
	public void setMediaUrl(String mediaUrl) {
		this.mediaUrl = mediaUrl;
	}
	public String getMediaPath() {
		return mediaPath;
	}
	public void setMediaPath(String mediaPath) {
		this.mediaPath = mediaPath;
	} 
	
}