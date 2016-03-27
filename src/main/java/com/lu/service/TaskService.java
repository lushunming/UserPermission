package com.lu.service;

import java.util.List;

import com.lu.model.Task;


/**
 * task的service接口
 * 
 * @author lusm
 * @date 2016年3月26日
 *
 */
public interface TaskService {
	public List<Task> findList();

}
