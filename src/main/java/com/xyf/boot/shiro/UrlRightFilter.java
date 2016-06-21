package com.xyf.boot.shiro;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.StringUtils;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xyf.boot.util.JsonUtil;

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

	@Override
	protected boolean onAccessDenied(ServletRequest request,
			ServletResponse response) throws IOException {
		Subject subject = getSubject(request, response);
		HttpServletRequest httpRequest = WebUtils.toHttp(request);
		boolean isAjax = true;
		String ptType = httpRequest.getParameter("ptStyle");
		if (ptType == null || ptType.trim().length() == 0) {
			isAjax = false;
		}
		if (subject.getPrincipal() == null) {
			if (isAjax) {
				JsonUtil.OutputJson(WebUtils.toHttp(response),
						JsonUtil.genFailResultMessage("1008"));
			} else {
				saveRequestAndRedirectToLogin(request, response);
			}
		} else {
			if (isAjax) {
				JsonUtil.OutputJson(WebUtils.toHttp(response),
						JsonUtil.genFailResultMessage("1008"));
			} else {
				String unauthorizedUrl = getUnauthorizedUrl();
				if (StringUtils.hasText(unauthorizedUrl)) {
					WebUtils.issueRedirect(request, response, unauthorizedUrl);
				} else {
					WebUtils.toHttp(response).sendError(
							HttpServletResponse.SC_UNAUTHORIZED);
				}
			}
		}
		return false;
	}

}
