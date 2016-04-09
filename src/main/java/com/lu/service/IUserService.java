package com.lu.service;

import com.lu.dto.UserDto;
import com.lu.model.User;

/**
 * user的service接口
 * 
 * @author lusm
 * @date 2016年3月26日
 *
 */
public interface IUserService {
	/**
	 * 保存一个user
	 * 
	 * @param dto 用户dto
	 * @return 返回插入数，1 成功 0 失败
	 */
	public Integer insertUser(UserDto dto);

	/**
	 * 根据用户名查找一个user
	 * 
	 * @param userName 用户名
	 * @return 返回user对象
	 */
	public User findUserByUserName(String userName);

}
