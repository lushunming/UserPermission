package com.lu.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lu.common.CommonConstant;
import com.lu.dto.ResultDto;
import com.lu.model.Task;
import com.lu.service.TaskService;
import com.lu.service.impl.TaskDto;

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
	private Logger logger = Logger.getLogger(TaskController.class);
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
	 * 到达任务新增
	 * 
	 * @return 页面
	 */
	@RequestMapping("/add.html")
	public String gotoAdd() {
		return "task/taskAddForm";
	}

	/**
	 * 到达任务更新
	 * 
	 * @param id 数据的主键id
	 * @return 页面
	 */
	@RequestMapping("/update/{id}.html")
	public String gotoUpdate(@PathVariable Integer id, Model model) {
		TaskDto dto = null;
		try {
			dto = taskService.selectTaskById(id);
		} catch (Exception e) {

			e.printStackTrace();
			logger.error("TaskController.gotoUpdate--" + e.getMessage());
		}
		model.addAttribute("task", dto);
		return "task/taskUpdateForm";
	}

	/**
	 * 到达任务查看
	 * 
	 * @param id 数据的主键id
	 * @return 页面
	 */
	@RequestMapping("/view/{id}.html")
	public String gotoView(@PathVariable Integer id, Model model) {
		TaskDto dto = null;
		try {
			dto = taskService.selectTaskById(id);
		} catch (Exception e) {

			e.printStackTrace();
			logger.error("TaskController.gotoView--" + e.getMessage());
		}
		model.addAttribute("task", dto);
		return "task/taskViewForm";
	}

	/**
	 * 获取所有的任务
	 * 
	 * @return 返回列表
	 */
	@RequestMapping("/querylist")
	@ResponseBody
	public List<Task> queryTaskList() {
		// TODO 需要改成分页
		List<Task> tasks = taskService.findList();
		return tasks;
	}

	/**
	 * 保存数据操作
	 * 
	 * @param dto 需要保存的dto
	 * @return 返回保存结果
	 */
	@RequestMapping("/save")
	@ResponseBody
	public ResultDto saveTask(TaskDto dto) {
		ResultDto resultDto = null;
		boolean success = false;
		try {
			success = taskService.saveTask(dto);
		} catch (Exception e) {
			resultDto = new ResultDto("保存失败", success, CommonConstant.SAVE_ERROR);
			e.printStackTrace();
			logger.error("TaskController.saveTask--" + e.getMessage());
		}
		if (success) {
			resultDto = new ResultDto("保存成功", success, CommonConstant.SAVE_SUCCESS);
		} else {
			resultDto = new ResultDto("保存失败", success, CommonConstant.SAVE_ERROR);
		}
		return resultDto;

	}

	/**
	 * 更新数据操作
	 * 
	 * @param dto 需要更新的dto
	 * @return 返回更新结果
	 */
	@RequestMapping("/update")
	@ResponseBody
	public ResultDto updateTask(TaskDto dto) {
		ResultDto resultDto = null;
		boolean success = false;
		try {
			taskService.updateTask(dto);
			success = true;
		} catch (Exception e) {
			resultDto = new ResultDto("更新失败", success, CommonConstant.UPDATE_ERROR);
			e.printStackTrace();
			logger.error("TaskController.updateTask--" + e.getMessage());
		}
		if (success) {
			resultDto = new ResultDto("更新成功", success, CommonConstant.UPDATE_SUCCESS);
		} else {
			resultDto = new ResultDto("更新失败", success, CommonConstant.UPDATE_ERROR);
		}
		return resultDto;
	}

	/**
	 * 删除数据操作
	 * 
	 * @param dto 需要删除的dto
	 * @return 返回删除结果
	 */
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public ResultDto deleteTask(@PathVariable Integer id) {
		ResultDto resultDto = null;
		boolean success = false;
		try {
			taskService.deleteTask(id);
			success = true;
		} catch (Exception e) {
			resultDto = new ResultDto("删除失败", success, CommonConstant.DELETE_ERROR);
			e.printStackTrace();
			logger.error("TaskController.deleteTask--" + e.getMessage());
		}
		if (success) {
			resultDto = new ResultDto("删除成功", success, CommonConstant.DELETE_ERROR);
		} else {
			resultDto = new ResultDto("删除失败", success, CommonConstant.DELETE_ERROR);
		}
		return resultDto;
	}

}
