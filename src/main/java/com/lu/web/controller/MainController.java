package com.lu.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lu.common.CommonConstant;
import com.lu.dto.ResultDto;
import com.lu.dto.TaskDto;
import com.lu.model.MyPrincipal;
import com.lu.service.ITaskService;

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
	@Resource
	private ITaskService taskService;

	private Logger log = Logger.getLogger(MainController.class);

	/**
	 * 返回首页即登录页面
	 * 
	 * @return 登录页面
	 */
	@RequestMapping("/main.html")
	public String index(Model model) {
		Subject user = SecurityUtils.getSubject();
		MyPrincipal principal = (MyPrincipal) user.getPrincipal();
		model.addAttribute("user", principal);
		return "main/main";
	}

	/**
	 * 获取当前用户的任务
	 * 
	 * @return
	 */
	@RequestMapping("/getTasks")
	@ResponseBody
	public ResultDto getTasksByUser() {
		boolean success = false;
		ResultDto dto = null;
		Subject user = SecurityUtils.getSubject();
		MyPrincipal principal = (MyPrincipal) user.getPrincipal();
		List<TaskDto> tasks = null;
		try {
			tasks = taskService.getTasksByUser(principal.getUser().getId());
			success = true;
			dto = new ResultDto("获取成功", success, CommonConstant.SELECT_SUCCESS, tasks);
		
		} catch (Exception e) {
			e.printStackTrace();
			dto = new ResultDto("获取失败" + e.getMessage(), success, CommonConstant.SELECT_SUCCESS, tasks);
			log.error("获取失败" + e.getMessage(), e);
		}
		return dto;
	}

}
