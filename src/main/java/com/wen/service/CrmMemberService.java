package com.wen.service;

import com.wen.dao.entity.CrmMember;
import com.wen.dao.query.CrmMemberQuery;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Alex.wen123
 * @since 2018-05-30
 */
public interface CrmMemberService extends IService<CrmMember> {
	 public List<CrmMember> queryCrmMemberByPageCond(CrmMemberQuery crmMemberQuery);
}
