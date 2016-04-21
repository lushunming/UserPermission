package com.lu.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * index 首页，可以跳转到注册或者登陆
 * 
 * @author lusm
 * @date 2016年3月26日
 *
 */

@Controller
@RequestMapping("/")
public class IndexController {
	/**
	 * 主页面
	 * 
	 * @return 登录页面
	 */
	@RequestMapping("index.html")
	public String index() {
		return "index";
	}

}
