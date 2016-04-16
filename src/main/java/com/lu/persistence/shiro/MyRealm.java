package com.lu.persistence.shiro;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.lu.common.CommonConstant;
import com.lu.model.MyPrincipal;
import com.lu.model.Role;
import com.lu.model.User;
import com.lu.service.IUserRoleRelService;
import com.lu.service.IUserService;

public class MyRealm extends AuthorizingRealm {
	/** 用户service */
	@Resource
	private IUserService userService;
	/** 用户角色关系service */
	@Resource
	private IUserRoleRelService userRoleRelService;

	/**
	 * 获取授权信息
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		MyPrincipal principal=	(MyPrincipal) arg0.getPrimaryPrincipal();
		SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
		//String loginName=principal.getLoginName();
		return info;
	}

	/**
	 * 身份验证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) arg0;
		User user = userService.findUserByUserName(token.getUsername());
		// 账号不存在
		if (user == null) {
			return null;
		}
		// 账号未审核或者是审核不通过
		if (user.getStatus().equals(CommonConstant.STATUS_CHECK_NOPASS) || user.getStatus().equals(CommonConstant.STATUS_UNCHECK)) {
			return null;
		}
		List<Role> roles = userService.findRolesByUserId(user.getId());
		
		//TODO
		MyPrincipal principal=new MyPrincipal(user,roles);
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, user.getPassword(),getName());
		return info;
	}
}
