package com.lu.persistence.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.lu.model.Role;
import com.lu.model.User;
import com.lu.model.UserExample;

public interface UserMapper {
	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table public.t_user
	 *
	 * @mbggenerated Sun Apr 10 11:22:04 CST 2016
	 */
	int countByExample(UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table public.t_user
	 *
	 * @mbggenerated Sun Apr 10 11:22:04 CST 2016
	 */
	int deleteByExample(UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table public.t_user
	 *
	 * @mbggenerated Sun Apr 10 11:22:04 CST 2016
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table public.t_user
	 *
	 * @mbggenerated Sun Apr 10 11:22:04 CST 2016
	 */
	int insert(User record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table public.t_user
	 *
	 * @mbggenerated Sun Apr 10 11:22:04 CST 2016
	 */
	int insertSelective(User record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table public.t_user
	 *
	 * @mbggenerated Sun Apr 10 11:22:04 CST 2016
	 */
	List<User> selectByExample(UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table public.t_user
	 *
	 * @mbggenerated Sun Apr 10 11:22:04 CST 2016
	 */
	User selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table public.t_user
	 *
	 * @mbggenerated Sun Apr 10 11:22:04 CST 2016
	 */
	int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table public.t_user
	 *
	 * @mbggenerated Sun Apr 10 11:22:04 CST 2016
	 */
	int updateByExample(@Param("record") User record, @Param("example") UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table public.t_user
	 *
	 * @mbggenerated Sun Apr 10 11:22:04 CST 2016
	 */
	int updateByPrimaryKeySelective(User record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table public.t_user
	 *
	 * @mbggenerated Sun Apr 10 11:22:04 CST 2016
	 */
	int updateByPrimaryKey(User record);

	/**
	 * 根据用户id获取用户的角色列表
	 * 
	 * @param id
	 * @return
	 */
	List<Role> findRolesByUserId(Integer id);

	/**
	 * 查找等级比自己低的用户
	 * @param map
	 * @return
	 */
	List<User> findListLowLevel(Map<String, Object> map);
}