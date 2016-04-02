package com.lu.web.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lu.dto.ResultDto;

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

	/**
	 * 获取login界面
	 * 
	 * @return 登录界面
	 */
	@RequestMapping("login/index")
	public String gotoLogin() {
		return "/account/login";
	}

	/**
	 * 登录操作，返回登录的结果，如果成功，前台跳转，如果不成功那么不跳转
	 * 
	 * @return 操作的结果
	 */
	@RequestMapping("login")
	@ResponseBody
	public ResultDto login() {
		return null;

	}

}
