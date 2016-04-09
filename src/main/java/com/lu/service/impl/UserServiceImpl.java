package com.lu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.lu.common.MyException;
import com.lu.dto.UserDto;
import com.lu.model.User;
import com.lu.model.UserExample;
import com.lu.model.UserExample.Criteria;
import com.lu.persistence.dao.UserMapper;
import com.lu.service.IUserService;

@Service(value = "userService")
public class UserServiceImpl implements IUserService {
	private Logger logger = Logger.getLogger(UserServiceImpl.class);
	/** 用户mapper接口 */
	private @Resource UserMapper usermapper;

	@Override
	public Integer insertUser(UserDto dto) {
		int id = usermapper.insert(dto);
		return id;
	}

	@Override
	public User findUserByUserName(String userName) {
		if (StringUtils.isEmpty(userName)) {
			logger.error("UserServiceImpl.findUserByUserName" + "用户名不能为空");
			throw new MyException("用户名不能为空");
		}
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andLoginnameEqualTo(userName);
		List<User> users = usermapper.selectByExample(example);
		if (CollectionUtils.isEmpty(users)) {
			logger.error("UserServiceImpl.findUserByUserName" + "不存在该用户");
			throw new MyException("不存在该用户");
		}
		return users.get(0);

	}
}
