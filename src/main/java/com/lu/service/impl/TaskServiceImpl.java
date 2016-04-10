package com.lu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.lu.common.MyException;
import com.lu.dto.TaskDto;
import com.lu.model.Task;
import com.lu.model.TaskExample;
import com.lu.persistence.dao.TaskMapper;
import com.lu.service.ITaskService;

/**
 * 任务的service
 * 
 * @author lusm
 * @date 2016年3月27日
 *
 */
@Service("taskService")
public class TaskServiceImpl implements ITaskService {
	private Logger logger = Logger.getLogger(TaskServiceImpl.class);
	private @Resource TaskMapper taskMapper;

	public List<Task> findList(int pageNumber, int pageSize) {
		TaskExample example = new TaskExample();
		PageHelper.startPage(pageNumber, pageSize);
		List<Task> tasks = taskMapper.selectByExample(example);

		return tasks;
	}

	public boolean saveTask(TaskDto dto) throws Exception {
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

	@Override
	public void updateTask(TaskDto dto) throws Exception {
		if (null == dto.getId()) {
			logger.error("TaskServiceImpl.UpdateTask--该条数据的id为空");
			throw new MyException("该条数据的id为空");
		}
		if (StringUtils.isEmpty(dto.getName())) {
			logger.error("TaskServiceImpl.UpdateTask--任务名称不能为空");
			throw new MyException("任务名称不能为空");
		}
		if (StringUtils.isEmpty(dto.getUrl())) {
			logger.error("TaskServiceImpl.UpdateTask--任务url不能为空");
			throw new MyException("任务url不能为空");
		}
		Task task = taskMapper.selectByPrimaryKey(dto.getId());
		task.setName(dto.getName());
		task.setUrl(dto.getUrl());
		task.setDescription(dto.getDescription());
		taskMapper.updateByPrimaryKey(task);

	}

	@Override
	public TaskDto selectTaskById(Integer id) throws Exception {

		if (id == null) {
			logger.error("TaskServiceImpl.selectTaskById--id不能为空");
			throw new MyException("id不能为空");
		}

		Task task = taskMapper.selectByPrimaryKey(id);
		if (task == null) {
			logger.error("TaskServiceImpl.selectTaskById--不存在id为" + id + "的数据");
			throw new MyException("不存在id为" + id + "的数据");
		}
		TaskDto dto = new TaskDto();
		BeanUtils.copyProperties(task, dto);
		return dto;

	}

	@Override
	public void deleteTask(Integer id) throws Exception {
		if (id == null) {
			logger.error("TaskServiceImpl.selectTaskById--id不能为空");
			throw new MyException("id不能为空");
		}
		if (canBeDelete(id)) {
			taskMapper.deleteByPrimaryKey(id);
		}

	}

	/**
	 * 判断这条数据是否能被删除，要看看他是否被引用了，如果是不能删除，不是就可以删除
	 * 
	 * @param id 数据id
	 * @return
	 */
	private boolean canBeDelete(Integer id) {
		// TODO Auto-generated method stub
		return true;
	}
}
