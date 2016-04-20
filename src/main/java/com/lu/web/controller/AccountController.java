package com.lu.web.controller;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lu.common.CommonConstant;
import com.lu.dto.ResultDto;
import com.lu.dto.UserDto;
import com.lu.model.MyPrincipal;
import com.lu.service.IUserService;

/**
 * 用户账号控制器 主要是用户的登录登出等操作。
 * 
 * @author lusm
 * @date 2016年4月1日
 *
 */

@Controller
@RequestMapping("account")
public class AccountController {
	/** 登录logger */
	private Logger logger = Logger.getLogger(AccountController.class);
	/** 用户service */
	@Resource
	private IUserService userService;

	/**
	 * 获取login界面
	 * 
	 * @return 登录界面
	 */
	@RequestMapping("/login.html")
	public String gotoLogin() {
		return "account/login";
	}

	/**
	 * 获取注册界面
	 * 
	 * @return 注册界面
	 */
	@RequestMapping("/register.html")
	public String goToRegister() {
		return "account/register";
	}

	/**
	 * 获取修改密码的页面
	 * 
	 * @return 注册界面
	 */
	@RequestMapping("/password/change.html")
	public String goToChangePassword() {
		return "account/changepassword";
	}

	/**
	 * 登录操作，返回登录的结果，如果成功，前台跳转，如果不成功那么不跳转
	 * 
	 * @return 操作的结果
	 */
	@RequestMapping("/login")
	@ResponseBody
	public ResultDto login(String loginName, String password) {

		if (StringUtils.isBlank(loginName)) {
			logger.error("AccountController.login--用户名不能为空");
			return new ResultDto("用户名不能为空", false, CommonConstant.LOGIN_FAILED);
		}
		if (StringUtils.isBlank(password)) {
			logger.error("AccountController.login--密码不能为空");
			return new ResultDto("密码不能为空", false, CommonConstant.LOGIN_FAILED);
		}
		UsernamePasswordToken token = new UsernamePasswordToken(loginName, password);
		Subject user = SecurityUtils.getSubject();
		Session session = user.getSession(true);
		session.setAttribute("user", user.getPrincipal());
		Object object = user.getPrincipal();
		token.setRememberMe(true);
		try {
			user.login(token);
		} catch (UnknownAccountException e) {
			logger.error("账号不存在：{}", e);
			return new ResultDto("账号不存在", false, CommonConstant.LOGIN_FAILED);
		} catch (DisabledAccountException e) {
			logger.error("账号未启用：{}", e);
			return new ResultDto("账号未启用", false, CommonConstant.LOGIN_FAILED);
		} catch (IncorrectCredentialsException e) {
			logger.error("密码错误：{}", e);
			return new ResultDto("密码错误", false, CommonConstant.LOGIN_FAILED);
		} catch (RuntimeException e) {
			logger.error("未知错误,请联系管理员：{}", e);
			return new ResultDto("未知错误,请联系管理员", false, CommonConstant.LOGIN_FAILED);
		}
		return new ResultDto("登录成功", true, CommonConstant.LOGIN_SUCCESS);

	}

	/**
	 * 登出
	 * 
	 * @return 操作的结果
	 */
	@RequestMapping("/logout")
	@ResponseBody
	public ResultDto logout() {
		Subject user = SecurityUtils.getSubject();
		user.logout();
		return new ResultDto("退出系统成功", true, CommonConstant.LOGOUT_SUCCESS);
	}

	/**
	 * 修改密码
	 * 
	 * @return 操作的结果
	 */
	@RequestMapping("/password/change")
	@ResponseBody
	public ResultDto changePassword(String password) {
		ResultDto resultDto = null;
		boolean success = false;
		Subject user = SecurityUtils.getSubject();
		MyPrincipal principal = (MyPrincipal) user.getPrincipal();
		Integer id = principal.getUser().getId();
		UserDto dto;
		try {
			dto = userService.selectUserById(id);
			dto.setPassword(password);
			userService.updateUser(dto);
			success = true;
			resultDto = new ResultDto("修改密码成功", success, CommonConstant.UPDATE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			resultDto = new ResultDto("修改密码失败" + e.getMessage(), success, CommonConstant.UPDATE_ERROR);
			logger.error("修改密码失败" + e.getMessage(), e);
		}

		return resultDto;
	}

	/**
	 * 注册用户
	 * 
	 * @return 操作的结果
	 */
	@RequestMapping("/register")
	@ResponseBody
	public ResultDto register(UserDto dto) {
		ResultDto resultDto = null;
		boolean success = false;

		try {
			dto.setStatus(CommonConstant.STATUS_UNCHECK);
			userService.insertUser(dto);
			success = true;
			resultDto = new ResultDto("注册成功", success, CommonConstant.SAVE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("注册失败" + e.getMessage(), e);
			resultDto = new ResultDto("注册失败" + e.getMessage(), success, CommonConstant.SAVE_ERROR);
		}
		return resultDto;
	}
}
