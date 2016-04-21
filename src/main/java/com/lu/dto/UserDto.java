package com.lu.dto;

import com.lu.model.User;

/**
 * 用户dto
 * 
 * @author lusm
 * @date 2016年3月26日
 *
 */
public class UserDto extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7010161204199573504L;
	/**
	 * 对应的角色id
	 */
	private String roleIds;

	public String getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}

}
