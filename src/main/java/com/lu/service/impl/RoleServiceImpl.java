package com.lu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.lu.common.MyException;
import com.lu.dto.RoleDto;
import com.lu.model.Role;
import com.lu.model.RoleExample;
import com.lu.persistence.dao.RoleMapper;
import com.lu.service.IRoleService;

@Service(value = "roleService")
public class RoleServiceImpl implements IRoleService {
	private Logger logger = Logger.getLogger(RoleServiceImpl.class);
	/** 角色mapper接口 */
	private @Resource RoleMapper roleMapper;

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

	@Override
	public Integer insertRole(RoleDto dto) {
		String methodName = "deleteRole";
		if (dto == null) {
			logAndThrowError(methodName, "dto不能为空");
		}
		if (StringUtils.isEmpty(dto.getName())) {
			logAndThrowError(methodName, "角色名不能为空");
		}
		if (dto.getLevel() == null) {
			logAndThrowError(methodName, "角色的级别不能为空");
		}
		Role role = new Role();
		return roleMapper.insert(role);
	}

	@Override
	public void deleteRole(Integer id) {
		String methodName = "deleteRole";
		if (id == null) {
			logAndThrowError(methodName, "id不能为空");
		}
		if (canBeDelete(id)) {
			roleMapper.deleteByPrimaryKey(id);
		}

	}

	/**
	 * 判断该数据能否被删除
	 * 
	 * @param id 主键
	 * @return
	 */
	private boolean canBeDelete(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateRole(RoleDto dto) {

		String methodName = "updateRole";
		if (dto == null) {
			logAndThrowError(methodName, "dto不能为空");
		}
		if (dto.getId() == null) {
			logAndThrowError(methodName, "id不能为空");
		}
		if (StringUtils.isEmpty(dto.getName())) {
			logAndThrowError(methodName, "角色名不能为空");
		}
		if (dto.getLevel() == null) {
			logAndThrowError(methodName, "角色的级别不能为空");
		}
		Role role = new Role();
		role.setDescription(dto.getDescription());
		role.setLevel(dto.getLevel());
		role.setName(dto.getName());
		roleMapper.updateByPrimaryKey(role);
	}

	@Override
	public boolean saveRole(RoleDto dto) {
		String methodName = "saveRole";
		if (dto == null) {
			logAndThrowError(methodName, "dto不能为空");
		}
		if (StringUtils.isEmpty(dto.getName())) {
			logAndThrowError(methodName, "角色名不能为空");
		}
		if (dto.getLevel() == null) {
			logAndThrowError(methodName, "角色的级别不能为空");
		}
		Role role = new Role();
		BeanUtils.copyProperties(dto, role);
		return roleMapper.insert(role) > 0;

	}

	@Override
	public List<Role> findList(int page, int rows) {
		PageHelper.startPage(page, rows);
		RoleExample example = new RoleExample();
		List<Role> list = roleMapper.selectByExample(example);
		return list;
	}

	@Override
	public RoleDto selectRoleById(Integer id) {
		String methodName = "selectRoleById";
		if (null == id) {
			logAndThrowError(methodName, "id不能为空");
		}
		Role role = roleMapper.selectByPrimaryKey(id);
		if (null == role) {
			logAndThrowError(methodName, "不存在id为" + id + "的角色");
		}
		RoleDto dto = new RoleDto();
		BeanUtils.copyProperties(role, dto);
		return dto;
	}

}
