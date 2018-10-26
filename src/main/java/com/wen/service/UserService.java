package com.wen.service;

import com.wen.dao.entity.User;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author Alex.wen123
 * @since 2018-10-16
 */
public interface UserService extends IService<User> {
	public User findByUserName(String username);
}
