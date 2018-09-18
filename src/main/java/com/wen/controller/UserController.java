package com.wen.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import com.wen.dao.entity.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

/**
 * <p>
 * 后台管理用户表 前端控制器
 * </p>
 *
 * @author Alex.wen123
 * @since 2018-05-23
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	
	@RequestMapping("/login.html")
	public  String  userLogin(ModelMap modelMap,User user) {
		
		return null;
		
	}
}

