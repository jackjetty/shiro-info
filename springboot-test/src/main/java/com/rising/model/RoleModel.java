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
public class RoleModel implements Serializable {
    private String roleCode;
    private String roleName;
    private String info;
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
    
}
