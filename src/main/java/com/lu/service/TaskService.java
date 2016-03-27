package com.lu.service;

import java.util.List;

import com.lu.common.MyException;
import com.lu.model.Task;
import com.lu.service.impl.TaskDto;

/**
 * task的service接口
 * 
 * @author lusm
 * @date 2016年3月26日
 *
 */
public interface TaskService {
	/**
	 * 查找所有的任务
	 */
	public List<Task> findList();

	/**
	 * 保存任务
	 * 
	 * @param dto
	 *            dto实体
	 * @throws MyException
	 */
	public boolean saveTask(TaskDto dto) throws MyException;
}
