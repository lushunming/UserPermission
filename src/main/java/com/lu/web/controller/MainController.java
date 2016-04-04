package com.lu.web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lu.model.MyPrincipal;

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
	public String index(Model model) {
		Subject user = SecurityUtils.getSubject();
		MyPrincipal principal = (MyPrincipal) user.getPrincipal();
		model.addAttribute("user", principal);
		return "main/main";
	}

}
