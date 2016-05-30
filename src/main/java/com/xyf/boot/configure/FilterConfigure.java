package com.xyf.boot.configure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.xyf.boot.filter.ShiroFilter;

@Configuration
public class FilterConfigure {

	private static final Logger logger = LoggerFactory
			.getLogger(FilterConfigure.class);

	@Bean
	public FilterRegistrationBean shiroFilterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new ShiroFilter());
		registration.addUrlPatterns("/*");
		registration.addInitParameter("paramName", "paramValue");
		registration.setName("shiroFilter");
		registration.setOrder(1);
		logger.debug("______load filter shiroFilter!");
		return registration;
	}

	@Bean
	public FilterRegistrationBean characterEncodingFilter() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		registration.setFilter(characterEncodingFilter);
		registration.addUrlPatterns("/replay/*");
		registration.setName("encodeFilter");
		registration.setOrder(3);
		logger.debug("______load filter characterEncodingFilter!");
		return registration;
	}
}
