package com.lu.service;

import java.util.List;

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

	/**
	 * 根据id删除用户
	 * 
	 * @param id
	 */
	public void deleteUser(Integer id);

	/**
	 * 更新用户信息
	 * 
	 * @param dto
	 */
	public void updateUser(UserDto dto);

	/**
	 * 保存用户信息
	 * 
	 * @param dto
	 * @return
	 */
	public boolean saveUser(UserDto dto);

	/**
	 * 更具当前任务的角色等级查询他等级之下的用户
	 * 
	 * @param page 第几页
	 * @param rows 每一页的数目
	 * @param level 当前人的角色等级
	 * @return
	 */
	public List<User> findList(int page, int rows, Integer level);

	/**
	 * 
	 * @param id
	 * @return
	 */
	public UserDto selectUserById(Integer id);

	/**
	 * 根据用户的id审核用户
	 * 
	 * @param id 用户id
	 * @param status 用户状态
	 * 
	 */
	public void vetUser(Integer id, Integer status);

}
