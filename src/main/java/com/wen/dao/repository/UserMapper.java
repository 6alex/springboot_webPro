package com.wen.dao.repository;

import com.wen.dao.entity.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author Alex.wen123
 * @since 2018-10-16
 */
public interface UserMapper extends BaseMapper<User> {
	public User findByUserName(String username);
}
