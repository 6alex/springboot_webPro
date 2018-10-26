package com.wen.service.impl;

import com.wen.dao.entity.UserRole;
import com.wen.dao.repository.UserRoleMapper;
import com.wen.service.UserRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色中间表 服务实现类
 * </p>
 *
 * @author Alex.wen123
 * @since 2018-10-16
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

}
