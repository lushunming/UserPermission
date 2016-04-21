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
import com.lu.model.RoleTaskRelExample;
import com.lu.model.RoleTaskRelExample.Criteria;
import com.lu.model.Task;
import com.lu.model.TaskExample;
import com.lu.persistence.dao.RoleTaskRelMapper;
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
	private @Resource RoleTaskRelMapper roleTaskRelMapper;

	/**
	 * 记log和跑出异常
	 * 
	 * @param methodName 当前方法名
	 * @param msg 错误信息
	 */
	private void logAndThrowError(String methodName, String msg) {
		logger.error("TaskServiceImpl." + methodName + msg);
		throw new MyException(msg);
	}

	public List<Task> findList(int pageNumber, int pageSize) {
		TaskExample example = new TaskExample();
		PageHelper.startPage(pageNumber, pageSize);
		List<Task> tasks = taskMapper.selectByExample(example);
		return tasks;
	}

	public boolean saveTask(TaskDto dto) throws Exception {
		String methodName = "saveTask";
		if (dto == null) {
			logAndThrowError(methodName, "dto为空");
		}
		if (StringUtils.isEmpty(dto.getName())) {
			logAndThrowError(methodName, "任务名称不能为空");
		}
		if (StringUtils.isEmpty(dto.getUrl())) {
			logAndThrowError(methodName, "任务的URl不能为空");
		}
		Task task = new Task();
		BeanUtils.copyProperties(dto, task);
		int count = taskMapper.insert(task);
		return count > 0;
	}

	@Override
	public void updateTask(TaskDto dto) throws Exception {
		String methodName = "updateTask";
		if (null == dto.getId()) {
			logAndThrowError(methodName, "该条数据的id为空");
		}
		if (StringUtils.isEmpty(dto.getName())) {
			logAndThrowError(methodName, "任务名称不能为空");
		}
		if (StringUtils.isEmpty(dto.getUrl())) {
			logAndThrowError(methodName, "任务url不能为空");
		}
		Task task = taskMapper.selectByPrimaryKey(dto.getId());
		task.setName(dto.getName());
		task.setUrl(dto.getUrl());
		task.setDescription(dto.getDescription());
		taskMapper.updateByPrimaryKey(task);

	}

	@Override
	public TaskDto selectTaskById(Integer id) throws Exception {
		String methodName = "selectTaskById";
		if (id == null) {
			logAndThrowError(methodName, "id不能为空");
		}

		Task task = taskMapper.selectByPrimaryKey(id);
		if (task == null) {
			logAndThrowError(methodName, "不存在id为" + id + "的数据");
		}
		TaskDto dto = new TaskDto();
		BeanUtils.copyProperties(task, dto);
		return dto;

	}

	@Override
	public void deleteTask(Integer id) throws Exception {
		String methodName = "deleteTask";
		if (id == null) {
			logAndThrowError(methodName, "id不能为空");
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
		String methodName = "canBeDelete";
		if (id == null) {
			logAndThrowError(methodName, "id不能为空");
		}
		RoleTaskRelExample example = new RoleTaskRelExample();
		Criteria criteria = example.createCriteria();
		criteria.andTaskIdEqualTo(id);
		int count = roleTaskRelMapper.countByExample(example);
		if (count > 0) {
			logAndThrowError(methodName, "该任务已经被分配给角色");
		}
		return count <= 0;
	}

	@Override
	public List<Task> findList() throws Exception {
		TaskExample example = new TaskExample();
		List<Task> tasks = taskMapper.selectByExample(example);
		return tasks;
	}

	@Override
	public List<TaskDto> getTasksByUser(Integer id) throws Exception {
		String methodName = "getTasksByUser";
		if (id == null) {
			logAndThrowError(methodName, "id不能为空");
		}
		List<TaskDto> tasks = taskMapper.getTasksByUser(id);
		return tasks;
	}

}
