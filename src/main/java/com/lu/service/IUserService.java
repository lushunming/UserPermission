package com.lu.service;

import java.util.List;

import com.lu.dto.UserDto;
import com.lu.model.Role;
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
	 * @throws Exception
	 */
	public Integer insertUser(UserDto dto) throws Exception;

	/**
	 * 根据用户名查找一个user
	 * 
	 * @param userName 用户名
	 * @return 返回user对象
	 * @throws Exception
	 */
	public User findUserByUserName(String userName) throws Exception;

	/**
	 * 根据id删除用户
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void deleteUser(Integer id) throws Exception;

	/**
	 * 更新用户信息
	 * 
	 * @param dto
	 * @throws Exception
	 */
	public void updateUser(UserDto dto) throws Exception;

	/**
	 * 保存用户信息
	 * 
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public boolean saveUser(UserDto dto) throws Exception;

	/**
	 * 根据当前任务的角色等级查询他等级之下的用户
	 * 
	 * @param page 第几页
	 * @param rows 每一页的数目
	 * @param roles 当前人拥有的角色
	 * @param id 主键id
	 * @return
	 * @throws Exception
	 */
	public List<User> findListLowLevel(int page, int rows, List<Role> roles, Integer id) throws Exception;

	/**
	 * 查找所有的用户
	 * 
	 * @param page 第几页
	 * @param rows 每一页的数目
	 * @return
	 * @throws Exception
	 */
	public List<User> findList(int page, int rows) throws Exception;

	/**
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public UserDto selectUserById(Integer id) throws Exception;

	/**
	 * 根据用户的id审核用户
	 * 
	 * @param id 用户id
	 * @param status 用户状态
	 * @throws Exception
	 * 
	 */
	public void vetUser(Integer id, Integer status) throws Exception;

	/**
	 * 根据用户id来获取用户的角色
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<Role> findRolesByUserId(Integer id) throws Exception;

	/**
	 * 注册用户
	 * 
	 * @param dto 用户信息dto
	 * @param roles 用户的角色ids
	 * @throws Exception
	 */
	public void register(UserDto dto, String[] roles) throws Exception;

	/**
	 * 校验用户名是否存在
	 * 
	 * @param loginName 用户名
	 * @param id 用户id
	 */
	public boolean isLoginNameExist(String loginName, String id);

}
