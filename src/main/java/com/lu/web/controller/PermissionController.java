package com.lu.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.lu.common.CommonConstant;
import com.lu.dto.PermissionDto;
import com.lu.dto.ResultDto;
import com.lu.model.Permission;
import com.lu.service.IPermissionService;

/**
 * 权限的前端控制器
 * 
 * @author lusm
 * @date 2016年3月27日
 *
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {
	private Logger logger = Logger.getLogger(PermissionController.class);
	/** 权限service */
	@Resource
	private IPermissionService permissionService;

	/**
	 * 到达权限列表页面
	 * 
	 * @return 页面
	 */
	@RequestMapping("/list.html")
	public String gotoList() {
		return "permission/permissionList";
	}

	/**
	 * 到达权限新增
	 * 
	 * @return 页面
	 */
	@RequestMapping("/add.html")
	public String gotoAdd() {
		return "permission/permissionAddForm";
	}

	/**
	 * 到达权限更新
	 * 
	 * @param id 数据的主键id
	 * @return 页面
	 */
	@RequestMapping("/update/{id}.html")
	public String gotoUpdate(@PathVariable Integer id, Model model) {
		PermissionDto dto = null;
		try {
			dto = permissionService.selectPermissionById(id);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("permissionController.gotoUpdate--" + e.getMessage());
		}
		model.addAttribute("permission", dto);
		return "permission/permissionUpdateForm";
	}

	/**
	 * 到达权限查看
	 * 
	 * @param id 数据的主键id
	 * @return 页面
	 */
	@RequestMapping("/view/{id}.html")
	public String gotoView(@PathVariable Integer id, Model model) {
		PermissionDto dto = null;
		try {
			dto = permissionService.selectPermissionById(id);
		} catch (Exception e) {

			e.printStackTrace();
			logger.error("permissionController.gotoView--" + e.getMessage());
		}
		model.addAttribute("permission", dto);
		return "permission/permissionViewForm";
	}

	/**
	 * 获取所有的权限
	 * 
	 * @return 返回列表
	 */
	@RequestMapping("/querylist")
	@ResponseBody
	public Map<String, Object> queryPermissionList(int page, int rows) {
		List<Permission> permissions = permissionService.findList(page, rows);
		PageInfo<Permission> taskPage = new PageInfo<Permission>(permissions);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", taskPage.getTotal());
		result.put("rows", permissions);
		return result;

	}

	/**
	 * 保存数据操作
	 * 
	 * @param dto 需要保存的dto
	 * @return 返回保存结果
	 */
	@RequestMapping("/save")
	@ResponseBody
	public ResultDto savePermission(PermissionDto dto) {
		ResultDto resultDto = null;
		boolean success = false;
		try {
			success = permissionService.savePermission(dto);
		} catch (Exception e) {
			resultDto = new ResultDto("保存失败", success, CommonConstant.SAVE_ERROR);
			e.printStackTrace();
			logger.error("permissionController.savepermission--" + e.getMessage());
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
	public ResultDto updatePermission(PermissionDto dto) {
		ResultDto resultDto = null;
		boolean success = false;
		try {
			permissionService.updatePermission(dto);
			success = true;
		} catch (Exception e) {
			resultDto = new ResultDto("更新失败", success, CommonConstant.UPDATE_ERROR);
			e.printStackTrace();
			logger.error("permissionController.updatepermission--" + e.getMessage());
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
	public ResultDto deletePermission(@PathVariable Integer id) {
		ResultDto resultDto = null;
		boolean success = false;
		try {
			permissionService.deletePermission(id);
			success = true;
		} catch (Exception e) {
			resultDto = new ResultDto("删除失败", success, CommonConstant.DELETE_ERROR);
			e.printStackTrace();
			logger.error("permissionController.deletepermission--" + e.getMessage());
		}
		if (success) {
			resultDto = new ResultDto("删除成功", success, CommonConstant.DELETE_ERROR);
		} else {
			resultDto = new ResultDto("删除失败", success, CommonConstant.DELETE_ERROR);
		}
		return resultDto;
	}

}
