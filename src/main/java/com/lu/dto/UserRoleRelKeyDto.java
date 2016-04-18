package com.lu.dto;

import com.lu.model.UserRoleRelKey;

public class UserRoleRelKeyDto extends UserRoleRelKey {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4834327777927025422L;

	private String roleName;

	private String roleDescription;

	private String roleLevel;

	public String getRoleLevel() {
		return roleLevel;
	}

	public void setRoleLevel(String roleLevel) {
		this.roleLevel = roleLevel;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

}
