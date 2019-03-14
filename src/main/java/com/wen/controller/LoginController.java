package com.wen.controller;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.wen.dao.entity.CrmMember;
import com.wen.dao.entity.News;
import com.wen.dao.entity.User;
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
	@Resource
	CrmMemberService crmMemberService;
	@Resource
	NewsService newsService;

	@RequestMapping("crmMember/login.html")
	public String login(ModelMap modelMap, CrmMember user) {
		CrmMemberQuery crmMember = new CrmMemberQuery();
		BeanUtils.copyProperties(user, crmMember);// s1复制给s2
		crmMember.setPageRows(1);
		List<CrmMember> list = crmMemberService.queryCrmMemberByPageCond(crmMember);
		if (CollectionUtils.isEmpty(list)) {
			return "cover/loginlight";
			// return "cover/loginflower";
		}
		Wrapper<News> arg0 = new EntityWrapper<News>(new News());
		List<News> newsList = newsService.selectList(arg0);
		Collections.reverse(newsList);
		modelMap.put("news", newsList);
		return "news/news_list";
	}
	
	

	@RequestMapping("/queryNews")
	public String queryNews(ModelMap modelMap,int currentPage,int pageSize) {
		Wrapper<News> arg0 = new EntityWrapper<News>(new News());
		List<News> newsList = newsService.selectList(arg0);
		//分页
		//Page<News> page=new Page<>(currentPage, pageSize);
		//Page<News> selectPage = newsService.selectPage(page, arg0);
		//List<News> records = selectPage.getRecords();
		//Page<Map<String, Object>> selectMapsPage = newsService.selectMapsPage(page, arg0);
		//List<Map<String, Object>> records2 = selectMapsPage.getRecords();
		Collections.reverse(newsList);
		modelMap.put("news", newsList);
		return "news/news_list";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "shiro/login";
	}

	@RequestMapping("/loginUser")
	public String loginUser(String username, String password, HttpSession session) {
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(usernamePasswordToken); // 完成登录
			User user = (User) subject.getPrincipal();
			session.setAttribute("user", user);
			return "shiro/index";
		} catch (Exception e) {
			return "shiro/login";// 返回登录页面
		}

	}

	@RequestMapping("/logOut")
	public String logOut(HttpSession session) {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		// session.removeAttribute("user");
		return "shiro/login";
	}
}
