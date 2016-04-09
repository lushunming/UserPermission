package com.lu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.lu.common.MyException;
import com.lu.dto.PermissionDto;
import com.lu.model.Permission;
import com.lu.model.PermissionExample;
import com.lu.persistence.dao.PermissionMapper;
import com.lu.service.IPermissionService;

/**
 * 权限的service
 * 
 * @author lusm
 * @date 2016年3月27日
 *
 */
@Service("permissionService")
public class PermissionServiceImpl implements IPermissionService {
	private Logger logger = Logger.getLogger(PermissionServiceImpl.class);
	private @Resource PermissionMapper permissionMapper;

	@Override
	public List<Permission> findList(int page, int rows) {
		PermissionExample example = new PermissionExample();
		PageHelper.startPage(page, rows);
		List<Permission> permissions = permissionMapper.selectByExample(example);
		return permissions;
	}

	@Override
	public boolean savePermission(PermissionDto dto) throws Exception {
		if (dto == null) {
			throw new MyException("dto为空");
		}
		if (StringUtils.isEmpty(dto.getName())) {
			throw new MyException("权限名称不能为空");
		}
		Permission permission = new Permission();
		BeanUtils.copyProperties(dto, permission);
		int count = permissionMapper.insert(permission);
		return count > 0;
	}

	@Override
	public void updatePermission(PermissionDto dto) throws Exception {
		if (dto == null) {
			throw new MyException("dto为空");
		}
		if (dto.getId() == null) {
			throw new MyException("id不能为空");
		}
		if (StringUtils.isEmpty(dto.getName())) {
			throw new MyException("权限名称不能为空");
		}
		Permission permission = permissionMapper.selectByPrimaryKey(dto.getId());
		if (null == permission) {
			throw new Exception("数据库中不存在id为" + dto.getId() + "的权限数据");
		}
		permission.setName(dto.getName());
		permission.setDescription(dto.getDescription());
		permission.setTaskId(dto.getTaskId());
		permissionMapper.updateByPrimaryKey(permission);
	}

	@Override
	public PermissionDto selectPermissionById(Integer id) throws Exception {
		if (id == null) {
			throw new MyException("id不能为空");
		}
		Permission permission = permissionMapper.selectByPrimaryKey(id);
		if (permission == null) {
			logger.error("PermissionServiceImpl.selectPermissionById--不存在id为" + id + "的数据");
			throw new MyException("不存在id为" + id + "的数据");
		}
		PermissionDto dto = new PermissionDto();
		BeanUtils.copyProperties(permission, dto);
		return dto;
	}

	@Override
	public void deletePermission(Integer id) throws Exception {
		if (id == null) {
			throw new MyException("id不能为空");
		}
		if (canBeDelete(id)) {
			permissionMapper.deleteByPrimaryKey(id);
		}
	}

	/**
	 * 判断该条数据能否被删除，被使用了就不可以删除，没有就可以
	 * 
	 * @param id 主键id
	 * @return
	 */
	private boolean canBeDelete(Integer id) {
		// TODO Auto-generated method stub
		return true;
	}

}
