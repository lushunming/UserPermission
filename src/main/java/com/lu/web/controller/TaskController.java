package com.lu.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lu.model.Task;
import com.lu.service.TaskService;

/**
 * 任务的前端控制器
 * 
 * @author lusm
 * @date 2016年3月27日
 *
 */
@Controller
@RequestMapping("/task")
public class TaskController {
	/** 任务service */
	@Resource
	private TaskService taskService;

	/**
	 * 到达任务列表页面
	 * 
	 * @return 页面
	 */
	@RequestMapping("/list.html")
	public String gotoList() {
		return "task/taskList";
	}
	/**
	 * 到达任务列表页面
	 * 
	 * @return 页面
	 */
	@RequestMapping("/add.html")
	public String gotoAdd() {
		return "task/taskAddForm";
	}

	/**
	 * 获取所有的任务
	 * 
	 * @return
	 */
	@RequestMapping("/querylist")
	@ResponseBody
	public List<Task> queryTaskList() {
		List<Task> tasks = taskService.findList();
		return tasks;
	}
}
