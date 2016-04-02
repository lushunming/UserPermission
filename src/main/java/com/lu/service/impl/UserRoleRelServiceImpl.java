package com.lu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.lu.model.UserRoleRelExample;
import com.lu.model.UserRoleRelExample.Criteria;
import com.lu.persistence.dao.UserRoleRelMapper;
import com.lu.service.UserRoleRelService;

@Service(value = "userRoleRelService")
public class UserRoleRelServiceImpl implements UserRoleRelService {
	private Logger logger = Logger.getLogger(UserRoleRelServiceImpl.class);
	/** 用户角色关系mapper接口 */
	private @Resource UserRoleRelMapper userRoleRelMapper;

	public List<Integer> findRolesByUserId(Integer userId) {
		UserRoleRelExample example = new UserRoleRelExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		List<Integer> roles = userRoleRelMapper.selectRolesByExample(example);
		return roles;

	}

}
