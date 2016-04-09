package com.lu.web.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lu.dto.ResultDto;
import com.lu.dto.UserDto;
import com.lu.service.IUserService;

@Controller
@RequestMapping("test")
public class TestController {
	private @Resource IUserService userService;
	private Logger logger=Logger.getLogger(TestController.class);

	@RequestMapping("/user")
	@ResponseBody
	public ResultDto test() {
		UserDto dto = new UserDto();
		dto.setLoginname("ss");
		dto.setPassword("111111");
		dto.setStatus(1);
		Integer integer = userService.insertUser(dto);
		logger.debug("integer_____"+integer);
		System.out.println("id"+dto.getId());
		return new ResultDto("ss", true, integer);

	}

}
