package com.lu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.lu.common.MyException;
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

	public List<Task> findList() {
		TaskExample example = new TaskExample();
		List<Task> tasks = taskMapper.selectByExample(example);
		return tasks;
	}

	public boolean saveTask(TaskDto dto) throws MyException {
		if (dto == null) {
			throw new MyException("dto为空");
		}
		if (StringUtils.isEmpty(dto.getName())) {
			throw new MyException("任务名称不能为空");
		}
		if (StringUtils.isEmpty(dto.getUrl())) {
			throw new MyException("任务的URl不能为空");
		}
		Task task = new Task();
		BeanUtils.copyProperties(dto, task);
		int count = taskMapper.insert(task);
		return count > 0;
	}
}
