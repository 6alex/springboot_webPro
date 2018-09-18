package com.wen.service.impl;

import com.wen.dao.entity.Module;
import com.wen.dao.repository.ModuleMapper;
import com.wen.service.ModuleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户权限表 服务实现类
 * </p>
 *
 * @author Alex.wen123
 * @since 2018-09-18
 */
@Service
public class ModuleServiceImpl extends ServiceImpl<ModuleMapper, Module> implements ModuleService {

}
