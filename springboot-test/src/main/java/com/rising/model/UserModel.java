/**
 * 
 */
package com.rising.model;

import java.io.Serializable;

/**
 * @author pg
 * @日期 2017-5-6
 */
@SuppressWarnings("serial")
public class UserModel implements Serializable{
	
	private String userName;
	private String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}