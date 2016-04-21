package com.lu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.lu.common.MyException;
import com.lu.dto.UserRoleRelKeyDto;
import com.lu.model.UserRoleRelExample;
import com.lu.model.UserRoleRelExample.Criteria;
import com.lu.model.UserRoleRelKey;
import com.lu.persistence.dao.UserRoleRelMapper;
import com.lu.service.IUserRoleRelService;

@Service(value = "userRoleRelService")
public class UserRoleRelServiceImpl implements IUserRoleRelService {

	private Logger logger = Logger.getLogger(UserRoleRelServiceImpl.class);
	/** 用户角色关系mapper接口 */
	@Resource
	private UserRoleRelMapper userRoleRelMapper;

	/**
	 * 记log和跑出异常
	 * 
	 * @param methodName 当前方法名
	 * @param msg 错误信息
	 */
	private void logAndThrowError(String methodName, String msg) {
		logger.error("UserRoleRelServiceImpl." + methodName + msg);
		throw new MyException(msg);
	}

	public List<Integer> findRolesByUserId(Integer userId) throws Exception{
		UserRoleRelExample example = new UserRoleRelExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		// TODO
		// List<Integer> roles = userRoleRelMapper.selectByExample(example);
		return null;

	}

	@Override
	public void grantRole(Integer userId, String[] roleIds) throws Exception {
		String methodName = "grantRole";

		if (userId == null) {
			logAndThrowError(methodName, "userId 不能为空");
		}
		// 首先删除该角色拥有的关系
		UserRoleRelExample example = new UserRoleRelExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		userRoleRelMapper.deleteByExample(example);
		// 然后保存关系
		if (roleIds != null && roleIds.length > 0) {
			UserRoleRelKey record = null;
			for (String roleId : roleIds) {
				record = new UserRoleRelKey();
				record.setRoleId(Integer.valueOf(roleId));
				record.setUserId(userId);
				userRoleRelMapper.insert(record);
			}
		}
	}

	@Override
	public List<UserRoleRelKeyDto> getRolesByUserId(Integer userId) throws Exception {
		String methodName = "getRolesByUserId";
		if (userId == null) {
			logAndThrowError(methodName, "userId 不能为空");
		}
		List<UserRoleRelKeyDto> roles = userRoleRelMapper.getRolesByUserId(userId);
		return roles;
	}

}
