package com.xyf.boot.filter;

import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfigure {

	@Bean
	public FilterRegistrationBean someFilterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new ShiroFilter());
		registration.addUrlPatterns("/replay/*");
		registration.addInitParameter("paramName", "paramValue");
		registration.setName("shiroFilter");
		registration.setOrder(1);
		return registration;
	}

}
