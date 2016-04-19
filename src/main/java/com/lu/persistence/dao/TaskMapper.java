package com.lu.persistence.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lu.dto.TaskDto;
import com.lu.model.Task;
import com.lu.model.TaskExample;

public interface TaskMapper {
	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table public.t_task
	 *
	 * @mbggenerated Sun Apr 10 11:22:04 CST 2016
	 */
	int countByExample(TaskExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table public.t_task
	 *
	 * @mbggenerated Sun Apr 10 11:22:04 CST 2016
	 */
	int deleteByExample(TaskExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table public.t_task
	 *
	 * @mbggenerated Sun Apr 10 11:22:04 CST 2016
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table public.t_task
	 *
	 * @mbggenerated Sun Apr 10 11:22:04 CST 2016
	 */
	int insert(Task record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table public.t_task
	 *
	 * @mbggenerated Sun Apr 10 11:22:04 CST 2016
	 */
	int insertSelective(Task record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table public.t_task
	 *
	 * @mbggenerated Sun Apr 10 11:22:04 CST 2016
	 */
	List<Task> selectByExample(TaskExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table public.t_task
	 *
	 * @mbggenerated Sun Apr 10 11:22:04 CST 2016
	 */
	Task selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table public.t_task
	 *
	 * @mbggenerated Sun Apr 10 11:22:04 CST 2016
	 */
	int updateByExampleSelective(@Param("record") Task record, @Param("example") TaskExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table public.t_task
	 *
	 * @mbggenerated Sun Apr 10 11:22:04 CST 2016
	 */
	int updateByExample(@Param("record") Task record, @Param("example") TaskExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table public.t_task
	 *
	 * @mbggenerated Sun Apr 10 11:22:04 CST 2016
	 */
	int updateByPrimaryKeySelective(Task record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table public.t_task
	 *
	 * @mbggenerated Sun Apr 10 11:22:04 CST 2016
	 */
	int updateByPrimaryKey(Task record);

	/**
	 * 获取当前用户的任务
	 * @param id
	 */
	List<TaskDto> getTasksByUser(Integer id);
}