package com.wen.controller;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wen.dao.entity.CrmMember;
import com.wen.dao.query.CrmMemberQuery;
import com.wen.service.CrmMemberService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Alex.wen123
 * @since 2018-05-23
 */
@Controller
@RequestMapping("/crmMember")
public class CrmMemberController {
     @Resource CrmMemberService crmMemberService;
	
	@RequestMapping("/register.html")
	public String register(ModelMap model,CrmMember user) {
		boolean bn=false;
		CrmMemberQuery crmMember = new CrmMemberQuery();
		 BeanUtils.copyProperties(user, crmMember);//s1复制给s2
		 crmMember.setPageRows(1);
		List<CrmMember> list = crmMemberService.queryCrmMemberByPageCond(crmMember);
		if(CollectionUtils.isEmpty(list)) {
			 bn = crmMemberService.insert(user);
		}						
		if(bn) {
			return "cover/loginlight";
		}
		return "cover/loginflower";
		
	}
	@RequestMapping("/registerPage.html")
	public String registerPage(ModelMap model,CrmMember user) {
		
		return "member/register";
		
	}
}

