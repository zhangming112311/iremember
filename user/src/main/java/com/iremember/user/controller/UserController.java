package com.iremember.user.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iremember.user.service.UserService;
import com.iremember.user.vo.UserVO;

@RestController
@RequestMapping
public class UserController {
	
	@Resource
	UserService userService;
	
	@GetMapping("user/{id}")
	public UserVO getUser(@PathVariable int id) {
		return userService.getUser(id);
	}
}
