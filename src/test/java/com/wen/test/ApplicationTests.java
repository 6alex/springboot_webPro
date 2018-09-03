package com.wen.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wen.dao.entity.CrmMember;
import com.wen.dao.query.CrmMemberQuery;
import com.wen.service.CrmMemberService;

/**
 * 测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
   
	@Resource CrmMemberService crmMemberService;
	@Test
	public void testinsertBatch() throws Exception {
		List<CrmMember> entityList=new ArrayList<>();
		for(int i=1;i<3;i++) {
			CrmMember po=new CrmMember();
			po.setAddress("长沙"+i);
			po.setAge(18+i);
			po.setIdcard("430434"+i);
			po.setMobile("131111111"+i);
			po.setName("成功"+i);
			po.setUsername("wwcg"+i);
			po.setPassword("42345"+i);
			po.setResume("良好+"+i);
			entityList.add(po);
		}
		crmMemberService.insertBatch(entityList);
	}
	
	@Test
	public void testQueryMemberByCond() throws Exception {
		CrmMemberQuery crmMember=new CrmMemberQuery();
		crmMember.setUsername("xy1");
		List<CrmMember> queryCrmMemberByPageCond = crmMemberService.queryCrmMemberByPageCond(crmMember);
		System.err.println(queryCrmMemberByPageCond);
	}
	
	
	
}
