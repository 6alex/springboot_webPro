package com.wen.service.impl;

import com.wen.dao.entity.CrmMember;
import com.wen.dao.query.CrmMemberQuery;
import com.wen.dao.repository.CrmMemberMapper;
import com.wen.service.CrmMemberService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Alex.wen123
 * @since 2018-05-30
 */
@Service
@Transactional//配置事务
public class CrmMemberServiceImpl extends ServiceImpl<CrmMemberMapper, CrmMember> implements CrmMemberService {
    @Resource CrmMemberMapper crmMemberMapper;
	
	@Override
	public List<CrmMember> queryCrmMemberByPageCond(CrmMemberQuery crmMemberQuery) {
		List<CrmMember> crmMemberList= crmMemberMapper.queryCrmMemberByPageCond(crmMemberQuery);
		return crmMemberList;
	}

}
