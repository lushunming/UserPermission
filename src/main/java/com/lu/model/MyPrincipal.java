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

	/**
	 * 
	 */
	private static final long serialVersionUID = 9759234926125474L;
	/**
	 * 用户信息
	 */
	private User user;

	public MyPrincipal(User user, List<Role> roles) {
		super();
		this.user = user;
		this.roles = roles;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	/**
	 * 用户的所有角色
	 */
	private List<Role> roles;

}
