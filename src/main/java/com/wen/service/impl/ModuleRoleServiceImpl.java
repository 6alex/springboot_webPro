package com.wen.service.impl;

import com.wen.dao.entity.ModuleRole;
import com.wen.dao.repository.ModuleRoleMapper;
import com.wen.service.ModuleRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限-角色中间表 服务实现类
 * </p>
 *
 * @author Alex.wen123
 * @since 2018-09-18
 */
@Service
public class ModuleRoleServiceImpl extends ServiceImpl<ModuleRoleMapper, ModuleRole> implements ModuleRoleService {

}
