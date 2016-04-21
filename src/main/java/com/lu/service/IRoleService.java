package com.lu.service;

import java.util.List;

import com.lu.dto.RoleDto;
import com.lu.model.Role;

/**
 * 角色service
 * 
 * @author lusm
 * @date 2016年4月1日
 *
 */
public interface IRoleService {

	/**
	 * 保存一个role
	 * 
	 * @param dto 角色dto
	 * @return 返回插入数，1 成功 0 失败
	 * @throws Exception 
	 */
	public Integer insertRole(RoleDto dto) throws Exception;

	/**
	 * 根据id删除角色
	 * 
	 * @param id
	 * @throws Exception 
	 */
	public void deleteRole(Integer id) throws Exception;

	/**
	 * 更新角色信息
	 * 
	 * @param dto
	 * @throws Exception 
	 */
	public void updateRole(RoleDto dto) throws Exception;

	/**
	 * 保存角色信息
	 * 
	 * @param dto
	 * @return
	 * @throws Exception 
	 */
	public boolean saveRole(RoleDto dto) throws Exception;

	/**
	 * 查找角色列表
	 * 
	 * @param page 第几页
	 * @param rows 每一页的数目
	 * 
	 * @return
	 * @throws Exception 
	 */
	public List<Role> findList(int page, int rows) throws Exception;

	/**
	 * 查找角色列表(不分页)
	 * 
	 * @return
	 * @throws Exception 
	 */
	public List<Role> findListWithoutPage() throws Exception;

	/**
	 * 
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	public RoleDto selectRoleById(Integer id) throws Exception;

}
