package com.lu.persistence.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lu.dto.UserRoleRelKeyDto;
import com.lu.model.UserRoleRelExample;
import com.lu.model.UserRoleRelKey;

public interface UserRoleRelMapper {
	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table public.t_user_role_rel
	 *
	 * @mbggenerated Sun Apr 10 11:22:04 CST 2016
	 */
	int countByExample(UserRoleRelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table public.t_user_role_rel
	 *
	 * @mbggenerated Sun Apr 10 11:22:04 CST 2016
	 */
	int deleteByExample(UserRoleRelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table public.t_user_role_rel
	 *
	 * @mbggenerated Sun Apr 10 11:22:04 CST 2016
	 */
	int deleteByPrimaryKey(UserRoleRelKey key);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table public.t_user_role_rel
	 *
	 * @mbggenerated Sun Apr 10 11:22:04 CST 2016
	 */
	int insert(UserRoleRelKey record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table public.t_user_role_rel
	 *
	 * @mbggenerated Sun Apr 10 11:22:04 CST 2016
	 */
	int insertSelective(UserRoleRelKey record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table public.t_user_role_rel
	 *
	 * @mbggenerated Sun Apr 10 11:22:04 CST 2016
	 */
	List<UserRoleRelKey> selectByExample(UserRoleRelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table public.t_user_role_rel
	 *
	 * @mbggenerated Sun Apr 10 11:22:04 CST 2016
	 */
	int updateByExampleSelective(@Param("record") UserRoleRelKey record, @Param("example") UserRoleRelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table public.t_user_role_rel
	 *
	 * @mbggenerated Sun Apr 10 11:22:04 CST 2016
	 */
	int updateByExample(@Param("record") UserRoleRelKey record, @Param("example") UserRoleRelExample example);

	/**
	 * 根据用户id查找已经拥有的角色
	 * 
	 * @param userId 用户id
	 * @return 返回角色列表
	 */
	List<UserRoleRelKeyDto> getRolesByUserId(Integer userId);
}