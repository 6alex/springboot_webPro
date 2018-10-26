package com.wen.service.impl;

import com.wen.dao.entity.User;
import com.wen.dao.repository.UserMapper;
import com.wen.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Alex.wen123
 * @since 2018-10-16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
	@Autowired
	UserMapper userMapper;
	
	@Override
	public User findByUserName(String username) {
		return userMapper.findByUserName(username);
	}

}
