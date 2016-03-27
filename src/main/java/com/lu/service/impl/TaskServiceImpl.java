package com.lu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lu.model.Task;
import com.lu.model.TaskExample;
import com.lu.persistence.dao.TaskMapper;
import com.lu.service.TaskService;

/**
 * 任务的service
 * 
 * @author lusm
 * @date 2016年3月27日
 *
 */
@Service("taskService")
public class TaskServiceImpl implements TaskService {
	private @Resource TaskMapper taskMapper;

	/**
	 * 查找所有的任务
	 */
	public List<Task> findList() {
		TaskExample example = new TaskExample();
		List<Task> tasks = taskMapper.selectByExample(example);
		return tasks;
	}
}
