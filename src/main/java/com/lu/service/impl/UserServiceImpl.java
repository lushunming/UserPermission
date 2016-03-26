package com.lu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lu.dto.UserDto;
import com.lu.persistence.dao.UserMapper;
import com.lu.service.UserService;
@Service(value="userService")
public class UserServiceImpl implements UserService {
	/** 用户mapper接口 */
	private @Resource UserMapper usermapper;

	@Override
	public Integer insertUser(UserDto dto) {
		int id = usermapper.insert(dto);
		return id;
	}

}
