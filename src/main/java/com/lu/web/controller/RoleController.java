package com.lu.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.lu.common.CommonConstant;
import com.lu.dto.ResultDto;
import com.lu.dto.RoleDto;
import com.lu.dto.RoleTaskRelKeyDto;
import com.lu.model.Role;
import com.lu.service.IRoleService;
import com.lu.service.IRoleTaskRelService;

/**
 * 角色的前端控制器
 * 
 * @author lusm
 * @date 2016年3月27日
 *
 */
@Controller
@RequestMapping("/role")
public class RoleController {
	private Logger logger = Logger.getLogger(RoleController.class);
	/** 角色service */
	@Resource
	private IRoleService roleService;
	/** 角色任务关系 */
	@Resource
	private IRoleTaskRelService roleTaskRelService;

	/**
	 * 到达角色列表页面
	 * 
	 * @return 页面
	 */
	@RequestMapping("/list.html")
	public String gotoList() {
		return "role/roleList";
	}

	/**
	 * 到达角色新增
	 * 
	 * @return 页面
	 */
	@RequestMapping("/add.html")
	public String gotoAdd() {
		return "role/roleAddForm";
	}

	/**
	 * 到达角色更新
	 * 
	 * @param id 数据的主键id
	 * @return 页面
	 */
	@RequestMapping("/update/{id}.html")
	public String gotoUpdate(@PathVariable Integer id, Model model) {
		RoleDto dto = null;
		try {
			dto = roleService.selectRoleById(id);
		} catch (Exception e) {

			e.printStackTrace();
			logger.error("RoleController.gotoUpdate--" + e.getMessage(), e);
		}
		model.addAttribute("role", dto);
		return "role/roleUpdateForm";
	}

	/**
	 * 到达角色查看
	 * 
	 * @param id 数据的主键id
	 * @return 页面
	 */
	@RequestMapping("/view/{id}.html")
	public String gotoView(@PathVariable Integer id, Model model) {
		RoleDto dto = null;
		try {
			dto = roleService.selectRoleById(id);
		} catch (Exception e) {

			e.printStackTrace();
			logger.error("RoleController.gotoView--" + e.getMessage(), e);
		}
		model.addAttribute("role", dto);
		return "role/roleViewForm";
	}

	/**
	 * 获取所有的角色（分页）
	 * 
	 * @return 返回列表
	 */
	@RequestMapping("/querylist")
	@ResponseBody
	public Map<String, Object> queryRoleList(int page, int rows) {
		List<Role> roles = null;
		try {
			roles = roleService.findList(page, rows);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}
		PageInfo<Role> rolePage = new PageInfo<Role>(roles);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", rolePage.getTotal());
		result.put("rows", roles);
		return result;
	}

	/**
	 * 获取所有的角色(不分页)
	 * 
	 * @return 返回列表
	 */
	@RequestMapping("/queryalllist")
	@ResponseBody
	public List<Role> findListWithoutPage() {
		List<Role> roles = null;
		try {
			roles = roleService.findListWithoutPage();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}
		return roles;
	}

	/**
	 * 保存数据操作
	 * 
	 * @param dto 需要保存的dto
	 * @return 返回保存结果
	 */
	@RequestMapping("/save")
	@ResponseBody
	public ResultDto saveRole(RoleDto dto) {
		ResultDto resultDto = null;
		boolean success = false;
		try {
			success = roleService.saveRole(dto);
		} catch (Exception e) {
			resultDto = new ResultDto("保存失败", success, CommonConstant.SAVE_ERROR);
			e.printStackTrace();
			logger.error("RoleController.saveRole--" + e.getMessage(), e);
		}
		if (success) {
			resultDto = new ResultDto("保存成功", success, CommonConstant.SAVE_SUCCESS);
		} else {
			resultDto = new ResultDto("保存失败", success, CommonConstant.SAVE_ERROR);
		}
		return resultDto;

	}

	/**
	 * 更新数据操作
	 * 
	 * @param dto 需要更新的dto
	 * @return 返回更新结果
	 */
	@RequestMapping("/update")
	@ResponseBody
	public ResultDto updateRole(RoleDto dto) {
		ResultDto resultDto = null;
		boolean success = false;
		try {
			roleService.updateRole(dto);
			success = true;
		} catch (Exception e) {
			resultDto = new ResultDto("更新失败", success, CommonConstant.UPDATE_ERROR);
			e.printStackTrace();
			logger.error("RoleController.updateRole--" + e.getMessage(), e);
		}
		if (success) {
			resultDto = new ResultDto("更新成功", success, CommonConstant.UPDATE_SUCCESS);
		} else {
			resultDto = new ResultDto("更新失败", success, CommonConstant.UPDATE_ERROR);
		}
		return resultDto;
	}

	/**
	 * 删除数据操作
	 * 
	 * @param dto 需要删除的dto
	 * @return 返回删除结果
	 */
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public ResultDto deleteRole(@PathVariable Integer id) {
		ResultDto resultDto = null;
		boolean success = false;
		try {
			roleService.deleteRole(id);
			success = true;
		} catch (Exception e) {
			resultDto = new ResultDto("删除失败", success, CommonConstant.DELETE_ERROR);
			e.printStackTrace();
			logger.error("RoleController.deleteRole--" + e.getMessage(), e);
		}
		if (success) {
			resultDto = new ResultDto("删除成功", success, CommonConstant.DELETE_ERROR);
		} else {
			resultDto = new ResultDto("删除失败", success, CommonConstant.DELETE_ERROR);
		}
		return resultDto;
	}

	/**
	 * 校验参数(暂时不需要)
	 * 
	 * @param paramName
	 * @param value
	 * @return
	 */
	@RequestMapping("/check/{param}")
	@ResponseBody
	public boolean checkForm(@PathVariable String paramName, String value) {
		// TODO
		return true;
	}

	/**
	 * 给角色分配任务
	 * 
	 * @param roleId 角色id
	 * @return
	 */
	@RequestMapping("/granttask/{roleId}")
	@ResponseBody
	public ResultDto grantTask(@PathVariable Integer roleId, HttpServletRequest request, @RequestParam("taskIds[]") String[] taskIds) {
		ResultDto resultDto = null;

		boolean success = false;
		try {
			roleTaskRelService.grantTask(roleId, taskIds);
			success = true;
		} catch (Exception e) {
			resultDto = new ResultDto("分配任务失败" + e.getMessage(), success, CommonConstant.DELETE_ERROR);
			e.printStackTrace();
			logger.error("RoleController.deleteRole--" + e.getMessage(), e);
		}
		if (success) {
			resultDto = new ResultDto("分配任务成功", success, CommonConstant.DELETE_ERROR);
		} else {
			resultDto = new ResultDto("分配任务失败", success, CommonConstant.DELETE_ERROR);
		}
		return resultDto;
	}

	/**
	 * 到达给角色分配任务的页面
	 * 
	 * @param roleId
	 * @return
	 */
	@RequestMapping("/granttask/{roleId}.html")
	public String goGrantTaskPage(@PathVariable Integer roleId, Model model) {
		return "role/grantTask";

	}

	/**
	 * 角色已经拥有的任务
	 * 
	 * @param roleId
	 * @return
	 */
	@RequestMapping("/taskList/{roleId}")
	@ResponseBody
	public List<RoleTaskRelKeyDto> getTasksByRoleId(@PathVariable Integer roleId) {
		List<RoleTaskRelKeyDto> tasks = null;
		try {
			tasks = roleTaskRelService.getTasksByRoleId(roleId);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("RoleController.deleteRole--" + e.getMessage(), e);
		}

		return tasks;

	}
}
