package com.xyf.boot.configure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;

@Configuration
public class FilterConfigure {

	private static final Logger logger = LoggerFactory
			.getLogger(FilterConfigure.class);

	@Bean
	public FilterRegistrationBean shiroFilterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		DelegatingFilterProxy proxy = new DelegatingFilterProxy("shiroFilter");
		registration.setFilter(proxy);
		registration.setEnabled(true);
		registration.addUrlPatterns("/*");
		registration.addInitParameter("targetFilterLifecycle", "false");
		registration.setOrder(1);
		logger.debug("______load filter shiroFilter!<<<" + proxy);
		return registration;
	}
	
	@Bean
	public FilterRegistrationBean characterEncodingFilter() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(crtCharacterEncodingFilter());
		registration.addUrlPatterns("/replay/*");
		registration.setOrder(2);
		logger.debug("______load filter characterEncodingFilter!");
		return registration;
	}

	@Bean
	public CharacterEncodingFilter crtCharacterEncodingFilter() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		return characterEncodingFilter;
	}
}
