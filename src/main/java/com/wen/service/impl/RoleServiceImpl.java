package com.wen.service.impl;

import com.wen.dao.entity.Role;
import com.wen.dao.repository.RoleMapper;
import com.wen.service.RoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色表 服务实现类
 * </p>
 *
 * @author Alex.wen123
 * @since 2018-09-18
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
