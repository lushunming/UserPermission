package com.lu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.lu.common.MyException;
import com.lu.dto.RoleTaskRelKeyDto;
import com.lu.model.RoleTaskRelKey;
import com.lu.persistence.dao.RoleTaskRelMapper;
import com.lu.service.IRoleTaskRelService;

/**
 * 角色与任务的service的实现
 * 
 * @author lusm
 * @date 2016年4月17日
 *
 */

@Service("roleTaskRelService")
public class RoleTaskRelServiceImpl implements IRoleTaskRelService {
	private Logger logger = Logger.getLogger(RoleServiceImpl.class);
	@Resource
	private RoleTaskRelMapper roleTaskRelMapper;

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
	public int saveRoleTaskRel(RoleTaskRelKeyDto dto) {
		String methodName = "saveRoleTaskRel";
		if (null == dto) {
			logAndThrowError(methodName, "dto不能为空");
		}
		RoleTaskRelKey record = new RoleTaskRelKey();
		BeanUtils.copyProperties(dto, record);
		int count = roleTaskRelMapper.insert(record);

		return count;
	}

	@Override
	public void saveRoleTaskRelByIds(Integer roleId, String[] taskIds) {
		String methodName = "saveRoleTaskRelByIds";

		if (roleId == null) {
			logAndThrowError(methodName, "roleId 不能为空");
		}
		if (taskIds != null && taskIds.length > 0) {
			RoleTaskRelKey record = null;
			for (String taskId : taskIds) {
				record = new RoleTaskRelKey();
				record.setRoleId(roleId);
				record.setTaskId(Integer.parseInt(taskId));
				roleTaskRelMapper.insert(record);
			}
		}
	}

	@Override
	public List<RoleTaskRelKeyDto> getTasksByRoleId(Integer roleId) {
		List<RoleTaskRelKeyDto> tasks = roleTaskRelMapper.getTasksByRoleId(roleId);
		return tasks;
	}

}