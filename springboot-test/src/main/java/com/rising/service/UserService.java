/**
 * 
 */
package com.rising.service;

import java.util.List;

import com.rising.model.RoleModel;
import com.rising.model.UserModel;

/**
 * @author pg
 * @日期 2017-5-6
 */
public interface UserService {
	public UserModel checkUser(String userName,String password);
    public List <RoleModel> getRolesByName(String userName);
}
