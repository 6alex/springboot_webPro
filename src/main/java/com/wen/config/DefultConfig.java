package com.wen.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author wencun
 * @date 2018年5月21日 下午12:17:21
 * @version 1.0
 * @since JDK 1.8
 */
@Configuration
public class DefultConfig extends WebMvcConfigurerAdapter{

	
		@Override
		public void addViewControllers(ViewControllerRegistry registry) {
			  registry.addViewController("/").setViewName("/login");//webapp下默认有index.jsp就无效    
			   registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
			super.addViewControllers(registry);
		}
	   @Bean
	    public InternalResourceViewResolver viewResolver() {
	        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	        viewResolver.setPrefix("/WEB-INF/view/");
	        viewResolver.setSuffix(".jsp");
	        // viewResolver.setViewClass(JstlView.class); // 这个属性通常并不需要手动配置，高版本的Spring会自动检测
	        return viewResolver;
	    }

	    /*@Override
	    public void addInterceptors(InterceptorRegistry registry) {
	        registry.addInterceptor(new Interceptor1()).addPathPatterns("/**");
	        registry.addInterceptor(new Interceptor2()).addPathPatterns("/users").addPathPatterns("/users/**");
	        super.addInterceptors(registry);
	    }*/
}
