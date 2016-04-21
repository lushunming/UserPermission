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
import com.lu.model.RoleTaskRelExample;
import com.lu.model.UserRoleRelExample;
import com.lu.model.UserRoleRelExample.Criteria;
import com.lu.persistence.dao.RoleMapper;
import com.lu.persistence.dao.RoleTaskRelMapper;
import com.lu.persistence.dao.UserRoleRelMapper;
import com.lu.service.IRoleService;

@Service(value = "roleService")
public class RoleServiceImpl implements IRoleService {
	private Logger logger = Logger.getLogger(RoleServiceImpl.class);
	/** 角色mapper接口 */
	private @Resource RoleMapper roleMapper;
	/** 角色 任务mapper接口 */
	private @Resource RoleTaskRelMapper roleTaskRelMapper;
	/** 用户 角色 mapper接口 */
	private @Resource UserRoleRelMapper userRoleRelMapper;

	/**
	 * 记log和跑出异常
	 * 
	 * @param methodName 当前方法名
	 * @param msg 错误信息
	 */
	private void logAndThrowError(String methodName, String msg) {
		logger.error("RoleServiceImpl." + methodName + msg);
		throw new MyException(msg);
	}

	@Override
	public Integer insertRole(RoleDto dto) throws Exception {
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
	public void deleteRole(Integer id) throws Exception {
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
		RoleTaskRelExample example = new RoleTaskRelExample();
		com.lu.model.RoleTaskRelExample.Criteria criteria = example.createCriteria();
		criteria.andRoleIdEqualTo(id);
		int count1 = roleTaskRelMapper.countByExample(example);

		UserRoleRelExample example2 = new UserRoleRelExample();
		Criteria criteria2 = example2.createCriteria();
		criteria2.andRoleIdEqualTo(id);
		int count2 = userRoleRelMapper.countByExample(example2);
		if (count1 > 0) {
			logAndThrowError("canBeDelete", "该角色已被分配任务");
		}
		if (count2 > 0) {
			logAndThrowError("canBeDelete", "该角色已被分配给用户");
		}
		return count1 <= 0 && count2 <= 0;
	}

	@Override
	public void updateRole(RoleDto dto) throws Exception {

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
		Role role = selectRoleById(dto.getId());
		role.setDescription(dto.getDescription());
		role.setLevel(dto.getLevel());
		role.setName(dto.getName());
		roleMapper.updateByPrimaryKey(role);
	}

	@Override
	public boolean saveRole(RoleDto dto) throws Exception {
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
	public List<Role> findList(int page, int rows) throws Exception {
		PageHelper.startPage(page, rows);
		RoleExample example = new RoleExample();
		List<Role> list = roleMapper.selectByExample(example);
		return list;
	}

	@Override
	public RoleDto selectRoleById(Integer id) throws Exception {
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

	@Override
	public List<Role> findListWithoutPage() throws Exception {
		RoleExample example = new RoleExample();
		List<Role> list = roleMapper.selectByExample(example);
		return list;
	}

}
