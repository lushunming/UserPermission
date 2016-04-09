package com.lu.service;

import java.util.List;

import com.lu.dto.PermissionDto;
import com.lu.model.Permission;

/**
 * Permission的service接口
 * 
 * @author lusm
 * @date 2016年3月26日
 *
 */
public interface IPermissionService {
	/**
	 * 返回分页
	 * 
	 * @param page 页数
	 * @param rows 一页的数目
	 * @return 返回分页
	 */
	public List<Permission> findList(int page, int rows);

	/**
	 * 保存权限
	 * 
	 * @param dto dto实体
	 * @throws Exception
	 * @return 是否成功
	 */
	public boolean savePermission(PermissionDto dto) throws Exception;

	/**
	 * 更新权限
	 * 
	 * @param dto dto实体
	 * @throws Exception
	 */
	public void updatePermission(PermissionDto dto) throws Exception;

	/**
	 * 
	 * 根据id查找一条Permission记录
	 * 
	 * @param id
	 * @return 返回PermissionDto实例
	 * @throws Exception
	 */
	public PermissionDto selectPermissionById(Integer id) throws Exception;

	/**
	 * 根据id删除一条数剧
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void deletePermission(Integer id) throws Exception;
}
