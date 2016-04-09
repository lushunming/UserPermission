package com.lu.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.lu.persistence.dao.RoleMapper;
import com.lu.service.IRoleService;

@Service(value = "roleService")
public class RoleServiceImpl implements IRoleService {
	private Logger logger = Logger.getLogger(RoleServiceImpl.class);
	/** 角色mapper接口 */
	private @Resource RoleMapper roleMapper;

}
