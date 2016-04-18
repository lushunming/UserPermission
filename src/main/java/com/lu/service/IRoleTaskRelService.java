package com.lu.service;

import java.util.List;

import com.lu.dto.RoleTaskRelKeyDto;

/**
 * 角色和任务之间的关系
 * 
 * @author lusm
 * @date 2016年4月17日
 *
 */
public interface IRoleTaskRelService {
	/**
	 * 保存角色和任务之间的关系
	 * 
	 * @param dto
	 * @return 插入条数
	 */
	int saveRoleTaskRel(RoleTaskRelKeyDto dto) throws Exception;

	/**
	 * 给角色分配任务
	 * 
	 * @param roleId 角色id
	 * @param taskIds 对应的任务id
	 */
	void grantTask(Integer roleId, String[] taskIds)  throws Exception;

	/**
	 * 根据角色id获取她拥有的任务列表
	 * 
	 * @param roleId
	 * @return
	 */
	List<RoleTaskRelKeyDto> getTasksByRoleId(Integer roleId)  throws Exception;
}
