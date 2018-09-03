package com.wen.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.wen.dao.entity.CrmMember;
import com.wen.dao.entity.News;
import com.wen.dao.query.CrmMemberQuery;
import com.wen.service.CrmMemberService;
import com.wen.service.NewsService;

/**
 * @author wencun
 * @date 2018年5月22日 下午3:26:39
 * @version 1.0
 * @since JDK 1.8
 */

@Controller
public class LoginController {
	@Resource CrmMemberService crmMemberService;
	@Resource NewsService newsService;
	
	@RequestMapping("/login.html")
	public  String  login(ModelMap modelMap,CrmMember user) {
		CrmMemberQuery crmMember = new CrmMemberQuery();
		 BeanUtils.copyProperties(user, crmMember);//s1复制给s2
		 crmMember.setPageRows(1);
		List<CrmMember> list = crmMemberService.queryCrmMemberByPageCond(crmMember);
		if(CollectionUtils.isEmpty(list)) {
            return "cover/loginlight";
		}
		Wrapper<News> arg0=new EntityWrapper<News>(new News());
		List<News> newsList = newsService.selectList(arg0);
		modelMap.put("news", newsList);
		return "news/news_list";
	}

}
