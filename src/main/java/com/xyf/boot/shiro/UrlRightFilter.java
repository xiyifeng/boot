package com.xyf.boot.shiro;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UrlRightFilter extends AuthorizationFilter {

	private static final Logger logger = LoggerFactory
			.getLogger(UrlRightFilter.class);

	@Override
	public boolean isAccessAllowed(ServletRequest request,
			ServletResponse response, Object mappedValue) throws IOException {
		String url = WebUtils
				.getPathWithinApplication(WebUtils.toHttp(request));
		logger.info("URL权限检查[ " + url + " ]");
		
		Subject subject = SecurityUtils.getSubject();
		boolean isAllowed = subject.isPermitted(url);
		logger.info("权限检查结果为: " + isAllowed);
		return isAllowed;
	}

}
