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
	 */
	public Integer insertRole(RoleDto dto);

	/**
	 * 根据id删除角色
	 * 
	 * @param id
	 */
	public void deleteRole(Integer id);

	/**
	 * 更新角色信息
	 * 
	 * @param dto
	 */
	public void updateRole(RoleDto dto);

	/**
	 * 保存角色信息
	 * 
	 * @param dto
	 * @return
	 */
	public boolean saveRole(RoleDto dto);

	/**
	 * 查找角色列表
	 * 
	 * @param page 第几页
	 * @param rows 每一页的数目
	 * 
	 * @return
	 */
	public List<Role> findList(int page, int rows);

	/**
	 * 查找角色列表(不分页)
	 * 
	 * @return
	 */
	public List<Role> findListWithoutPage();

	/**
	 * 
	 * @param id
	 * @return
	 */
	public RoleDto selectRoleById(Integer id);

}
