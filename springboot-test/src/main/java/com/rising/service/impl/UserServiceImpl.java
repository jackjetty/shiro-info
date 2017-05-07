/**
 * 
 */
package com.rising.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rising.model.RoleModel;
import com.rising.model.UserModel;
import com.rising.service.UserService;

/**
 * @author pg
 * @日期 2017-5-6
 */
@Service
public class UserServiceImpl implements UserService{

	
	@Override
	public UserModel checkUser(String userName, String password) {
		UserModel userModel=new UserModel();
		userModel.setUserName("张三");
		userModel.setPassword("123456");
		return userModel;
	}

	/* (non-Javadoc)
	 * @see com.rising.service.UserService#getRolesByName(java.lang.String)
	 */
	@Override
	public List<RoleModel> getRolesByName(String userName) {
		List<RoleModel> roleModelList=new ArrayList<RoleModel>();
		RoleModel roleModel=new RoleModel();
		roleModel.setRoleCode("admin");
		roleModel.setRoleName("管理员");
		roleModel.setInfo("");
		roleModelList.add(roleModel);
		roleModel=new RoleModel();
		roleModel.setRoleCode("guest");
		roleModel.setRoleName("游客");
		roleModel.setInfo("");
		roleModelList.add(roleModel);
		
		
		return roleModelList;
	}
	

}
