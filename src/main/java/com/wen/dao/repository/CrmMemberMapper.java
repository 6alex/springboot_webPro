package com.wen.dao.repository;

import com.wen.dao.entity.CrmMember;
import com.wen.dao.query.CrmMemberQuery;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Alex.wen123
 * @since 2018-05-30
 */
public interface CrmMemberMapper extends BaseMapper<CrmMember> {
      public List<CrmMember> queryCrmMemberByPageCond(CrmMemberQuery crmMemberQuery);
}
