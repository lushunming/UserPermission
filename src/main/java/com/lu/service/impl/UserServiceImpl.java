package com.lu.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.lu.common.MyException;
import com.lu.dto.UserDto;
import com.lu.model.Role;
import com.lu.model.User;
import com.lu.model.UserExample;
import com.lu.model.UserExample.Criteria;
import com.lu.persistence.dao.UserMapper;
import com.lu.service.IUserService;

@Service(value = "userService")
public class UserServiceImpl implements IUserService {
	private Logger logger = Logger.getLogger(UserServiceImpl.class);
	/** 用户mapper接口 */
	private @Resource UserMapper userMapper;

	@Override
	public Integer insertUser(UserDto dto) throws Exception {
		String methodName = "insertUser";
		if (dto == null) {
			logAndThrowError(methodName, "dto不能为空");
		}
		if (StringUtils.isEmpty(dto.getLoginname())) {
			logAndThrowError(methodName, "用户名不能为空");
		}
		if (StringUtils.isEmpty(dto.getPassword())) {
			logAndThrowError(methodName, "密码不能为空");
		}
		if (dto.getStatus() == null) {
			logAndThrowError(methodName, "用户状态不能为空");
		}
		int count = userMapper.insert(dto);
		return count;
	}

	@Override
	public User findUserByUserName(String userName) throws Exception {
		String methodName = "findUserByUserName";
		if (StringUtils.isEmpty(userName)) {
			logAndThrowError(methodName, "用户名不能为空");
		}
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andLoginnameEqualTo(userName);
		List<User> users = userMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(users)) {
			logAndThrowError(methodName, "不存在该用户");
		}
		return users.get(0);

	}

	@Override
	public void deleteUser(Integer id) throws Exception {
		String methodName = "deleteUser";
		if (id == null) {
			logAndThrowError(methodName, "id不能为空");
		}
		if (canBeDelete(id)) {
			userMapper.deleteByPrimaryKey(id);
		}
	}

	@Override
	public void updateUser(UserDto dto) throws Exception {
		String methodName = "updateUser";
		if (null == dto) {
			logAndThrowError(methodName, "dto为空");
		}
		if (null == dto.getId()) {
			logAndThrowError(methodName, "这条数据的id为空");
		}
		// TODO 校验用户的用户名
		if (checkIfExists(dto.getLoginname(), dto.getId())) {
			logAndThrowError(methodName, "该用户名已存在，请重选一个");

		}
		User user = userMapper.selectByPrimaryKey(dto.getId());

		if (user == null) {
			logAndThrowError(methodName, "数据库不存在id为" + dto.getId() + "的数据");
		}
		user.setLoginname(dto.getLoginname());
		user.setStatus(dto.getStatus());
		user.setPassword(dto.getPassword());
		userMapper.updateByPrimaryKey(user);
	}

	/**
	 * 根据用户和id判断改用户是否存在
	 * 
	 * @param loginname 用户名
	 * @param id
	 * @return
	 */
	private boolean checkIfExists(String loginname, Integer id) throws Exception {
		// TODO
		return false;
	}

	@Override
	public boolean saveUser(UserDto dto) throws Exception {
		String methodName = "saveUser";
		if (null == dto) {
			logAndThrowError(methodName, "dto为空");
		}
		if (StringUtils.isEmpty(dto.getLoginname())) {
			logAndThrowError(methodName, "登录名为空");
		}
		if (StringUtils.isEmpty(dto.getPassword())) {
			logAndThrowError(methodName, "密码不能为空");
		}
		if (null == dto.getStatus()) {
			logAndThrowError(methodName, "用户状态不能为空");
		}
		// TODO 校验用户的用户名
		if (checkIfExists(dto.getLoginname(), null)) {
			logAndThrowError(methodName, "该用户名已存在，请重选一个");

		}
		User user = new User();
		user.setLoginname(dto.getLoginname());
		user.setPassword(dto.getPassword());
		user.setStatus(dto.getStatus());

		return userMapper.insert(user) > 0;
	}

	@Override
	public List<User> findList(int page, int rows) throws Exception {
		PageHelper.startPage(page, rows);
		UserExample example = new UserExample();
		List<User> users = userMapper.selectByExample(example);
		return users;
	}

	@Override
	public UserDto selectUserById(Integer id) throws Exception {
		String methodName = "selectUserById";
		if (null == id) {
			logAndThrowError(methodName, "用户id不能为空");
		}
		User user = userMapper.selectByPrimaryKey(id);

		UserDto dto = new UserDto();
		BeanUtils.copyProperties(user, dto);
		return dto;
	}

	@Override
	public void vetUser(Integer id, Integer status) throws Exception {
		String methodName = "vetUser";
		if (null == id) {
			logAndThrowError(methodName, "用户id不能为空");
		}
		if (null == status) {
			logAndThrowError(methodName, "状态不能为空");
		}
		User user = userMapper.selectByPrimaryKey(id);
		if (user == null) {
			logAndThrowError(methodName, "数据库不存在id为" + id + "的数据");
		}
		user.setStatus(status);
		userMapper.updateByPrimaryKey(user);

	}

	/**
	 * 记log和跑出异常
	 * 
	 * @param methodName 当前方法名
	 * @param msg 错误信息
	 */
	private void logAndThrowError(String methodName, String msg) {
		logger.error("UserServiceImpl." + methodName + msg);
		throw new MyException(msg);
	}

	/**
	 * 判断该用户是否可以删除
	 * 
	 * @param id 用户id
	 * @return 返回结果
	 */
	private boolean canBeDelete(Integer id) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public List<Role> findRolesByUserId(Integer id) throws Exception {
		List<Role> roles = userMapper.findRolesByUserId(id);
		return roles;
	}

	@Override
	public List<User> findListLowLevel(int page, int rows, List<Role> roles, Integer id) throws Exception {
		PageHelper.startPage(page, rows);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("roles", roles);
		List<User> users = userMapper.findListLowLevel(map);
		return users;
	}

}
