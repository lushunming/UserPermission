package com.lu.model;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author lusm
 * @date 2016年4月1日
 *
 */
public class MyPrincipal implements Serializable {

	
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public List<Integer> getRoles() {
		return roles;
	}

	public void setRoles(List<Integer> roles) {
		this.roles = roles;
	}

	public List<Integer> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Integer> permissions) {
		this.permissions = permissions;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 9759234926125474L;
	/**
	 * 登录名
	 */
	private String loginName;
	/**
	 * 用户的所有角色
	 */
	private List<Integer> roles;
	/**
	 * 用户的权限
	 */
	private List<Integer> permissions;

	public MyPrincipal(String loginName, List<Integer> roles, List<Integer> permissions) {
		super();
		this.loginName = loginName;
		this.roles = roles;
		this.permissions = permissions;
	}

}
