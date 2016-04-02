package com.lu.service;

import java.util.List;

/**
 * 用户角色关系service
 * 
 * @author lusm
 * @date 2016年4月1日
 *
 */
public interface UserRoleRelService {
	/**
	 * 根据用户的userid获取他的所有角色id
	 * @param userId  用户id
	 * @return 返回的是角色列表
	 */
	public List<Integer> findRolesByUserId(Integer userId);
}
