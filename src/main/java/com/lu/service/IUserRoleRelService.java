package com.lu.service;

import java.util.List;

import com.lu.dto.UserRoleRelKeyDto;

/**
 * 用户角色关系service
 * 
 * @author lusm
 * @date 2016年4月1日
 *
 */
public interface IUserRoleRelService {
	/**
	 * 根据用户的userid获取他的所有角色id
	 * 
	 * @param userId 用户id
	 * @return 返回的是角色列表
	 */
	public List<Integer> findRolesByUserId(Integer userId);

	/**
	 * 给用户分配角色
	 * 
	 * @param userId 用户id
	 * @param roleIds 角色ids
	 */
	public void grantRole(Integer userId, String[] roleIds);

	/**
	 * 根据用户的id查找已经拥有的角色
	 * @param userId
	 * @return
	 */
	public List<UserRoleRelKeyDto> getRolesByUserId(Integer userId);
}
