package com.lu.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * index 首页，将会自动转到登录界面
 * 
 * @author lusm
 * @date 2016年3月26日
 *
 */

@Controller
@RequestMapping("/main")
public class MainController {
	/**
	 * 返回首页即登录页面
	 * 
	 * @return 登录页面
	 */
	@RequestMapping("")
	public String index() {
		return "main/main";
	}

	

}
