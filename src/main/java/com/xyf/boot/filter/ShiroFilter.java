package com.xyf.boot.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShiroFilter implements Filter{

	public static final Logger logger = LoggerFactory
			.getLogger(ShiroFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("-------shiro Filter doFilter_  init");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		chain.doFilter(request, response);
		logger.info("-------shiro Filter doFilter");
	}

	@Override
	public void destroy() {
		logger.info("-------shiro Filter doFilter_  destroy");
	}


}
