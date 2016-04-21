package com.lu.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 异常出错页面
 * 
 * @author lusm
 * @date 2016年3月26日
 *
 */
@Controller
@RequestMapping("/error")
public class ExceptionController {
	/**
	 * 404处理
	 * 
	 * @return 返回404页面
	 */
	@RequestMapping("/404")
	public String _404Error() {
		return "error/404";
	}

	/**
	 * 500处理
	 * 
	 * @return 返回500页面
	 */
	@RequestMapping("/500")
	public String _500Error() {
		return "error/500";
	}

}
