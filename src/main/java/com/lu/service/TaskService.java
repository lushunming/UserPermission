package com.lu.service;

import java.util.List;

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
	 * @param dto dto实体
	 * @throws Exception
	 * @return 是否成功
	 */
	public boolean saveTask(TaskDto dto) throws Exception;

	/**
	 * 更新任务
	 * 
	 * @param dto dto实体
	 * @throws Exception
	 */
	public void updateTask(TaskDto dto) throws Exception;

	/**
	 * 
	 * 根据id查找一条task记录
	 * 
	 * @param id
	 * @return 返回taskDto实例
	 * @throws Exception
	 */
	public TaskDto selectTaskById(Integer id) throws Exception;
}
