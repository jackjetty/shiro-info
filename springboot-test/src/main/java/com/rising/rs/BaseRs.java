/**
 * 
 */
package com.rising.rs;

import java.io.Serializable;

/**
 * @author pg
 * @日期 2017-5-6
 */
public class BaseRs implements Serializable {

	/**
	 * 
	 */
	//序列化
	private static final long serialVersionUID = -2686044427673999268L;
	protected int code;
	protected String info;
	public BaseRs(){
		code=0;
		info="";
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	
}
