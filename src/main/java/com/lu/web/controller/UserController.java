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
import com.lu.dto.UserDto;
import com.lu.dto.UserRoleRelKeyDto;
import com.lu.model.User;
import com.lu.service.IUserRoleRelService;
import com.lu.service.IUserService;

/**
 * 用户的前端控制器
 * 
 * @author lusm
 * @date 2016年3月27日
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	private Logger logger = Logger.getLogger(UserController.class);
	/** 用户service */
	@Resource
	private IUserService userService;

	@Resource
	private IUserRoleRelService userRoleRelService;

	/**
	 * 到达用户列表页面
	 * 
	 * @return 页面
	 */
	@RequestMapping("/list.html")
	public String gotoList() {
		return "user/userList";
	}

	/**
	 * 到达用户新增
	 * 
	 * @return 页面
	 */
	@RequestMapping("/add.html")
	public String gotoAdd() {
		return "user/userAddForm";
	}

	/**
	 * 到达用户更新
	 * 
	 * @param id 数据的主键id
	 * @return 页面
	 */
	@RequestMapping("/update/{id}.html")
	public String gotoUpdate(@PathVariable Integer id, Model model) {
		UserDto dto = null;
		try {
			dto = userService.selectUserById(id);
		} catch (Exception e) {

			e.printStackTrace();
			logger.error("UserController.gotoUpdate--" + e.getMessage());
		}
		model.addAttribute("user", dto);
		return "user/userUpdateForm";
	}

	/**
	 * 到达用户查看
	 * 
	 * @param id 数据的主键id
	 * @return 页面
	 */
	@RequestMapping("/view/{id}.html")
	public String gotoView(@PathVariable Integer id, Model model) {
		UserDto dto = null;
		try {
			dto = userService.selectUserById(id);
		} catch (Exception e) {

			e.printStackTrace();
			logger.error("UserController.gotoView--" + e.getMessage());
		}
		model.addAttribute("user", dto);
		return "user/userViewForm";
	}

	/**
	 * 到达给用户分配角色的页面
	 * 
	 * @param userId 用户id
	 * @return
	 */
	@RequestMapping("/grantrole/{userId}.html")
	public String goGrantTaskPage(@PathVariable Integer userId, Model model) {
		/*
		 * List<RoleTaskRelKeyDto> tasks =
		 * roleTaskRelService.getTasksByRoleId(roleId);
		 * model.addAttribute("tasks", arg1)
		 */
		return "user/grantRole";

	}

	/**
	 * 给用户分配角色
	 * 
	 * @param roleId 角色id
	 * @return
	 */
	@RequestMapping("/grantrole/{userId}")
	@ResponseBody
	public ResultDto grantRole(@PathVariable Integer userId, HttpServletRequest request, @RequestParam("roleIds[]") String[] roleIds) {
		ResultDto resultDto = null;

		boolean success = false;
		try {
			userRoleRelService.grantRole(userId, roleIds);
			success = true;
		} catch (Exception e) {
			resultDto = new ResultDto("分配角色失败" + e.getMessage(), success, CommonConstant.DELETE_ERROR);
			e.printStackTrace();
			logger.error("UserController.grantRole--" + e.getMessage());
		}
		if (success) {
			resultDto = new ResultDto("分配角色成功", success, CommonConstant.DELETE_ERROR);
		} else {
			resultDto = new ResultDto("分配角色失败", success, CommonConstant.DELETE_ERROR);
		}
		return resultDto;
	}

	/**
	 * 获取所有的用户
	 * 
	 * @return 返回列表
	 */
	@RequestMapping("/querylist")
	@ResponseBody
	public Map<String, Object> queryUserList(int page, int rows) {
		/*
		 * Subject user = SecurityUtils.getSubject(); MyPrincipal principal =
		 * (MyPrincipal) user.getPrincipal(); List<Role> roles =
		 * principal.getRoles();
		 */
		List<User> users = userService.findList(page, rows);
		PageInfo<User> userPage = new PageInfo<User>(users);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", userPage.getTotal());
		result.put("rows", users);
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
	public ResultDto saveUser(UserDto dto) {
		ResultDto resultDto = null;
		boolean success = false;
		try {
			dto.setStatus(CommonConstant.STATUS_CHECKED);
			success = userService.saveUser(dto);
		} catch (Exception e) {
			resultDto = new ResultDto("保存失败" + e.getMessage(), success, CommonConstant.SAVE_ERROR);
			e.printStackTrace();
			logger.error("UserController.saveUser--" + e.getMessage());
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
	public ResultDto updateUser(UserDto dto) {
		ResultDto resultDto = null;
		boolean success = false;
		try {
			userService.updateUser(dto);
			success = true;
		} catch (Exception e) {
			resultDto = new ResultDto("更新失败" + e.getMessage(), success, CommonConstant.UPDATE_ERROR);
			e.printStackTrace();
			logger.error("UserController.updateUser--" + e.getMessage());
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
	public ResultDto deleteUser(@PathVariable Integer id) {
		ResultDto resultDto = null;
		boolean success = false;
		try {
			userService.deleteUser(id);
			success = true;
		} catch (Exception e) {
			resultDto = new ResultDto("删除失败", success, CommonConstant.DELETE_ERROR);
			e.printStackTrace();
			logger.error("UserController.deleteUser--" + e.getMessage());
		}
		if (success) {
			resultDto = new ResultDto("删除成功", success, CommonConstant.DELETE_ERROR);
		} else {
			resultDto = new ResultDto("删除失败", success, CommonConstant.DELETE_ERROR);
		}
		return resultDto;
	}

	/**
	 * 用户已经拥有的角色
	 * 
	 * @param userId 用户id
	 * @return
	 */
	@RequestMapping("/roleList/{userId}")
	@ResponseBody
	public List<UserRoleRelKeyDto> getRolesByUserId(@PathVariable Integer userId) {
		List<UserRoleRelKeyDto> roles = null;
		try {
			roles = userRoleRelService.getRolesByUserId(userId);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("UserController.getRolesByUserId--" + e.getMessage());
		}

		return roles;

	}

	/**
	 * 校验参数
	 * 
	 * @param paramName
	 * @param value
	 * @return
	 */
	@RequestMapping("/check/{param}")
	@ResponseBody
	public boolean checkForm(@PathVariable String paramName) {
		// TODO
		return true;
	}

}
