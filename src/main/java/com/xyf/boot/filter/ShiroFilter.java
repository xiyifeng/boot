package com.xyf.boot.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.DelegatingFilterProxy;

public class ShiroFilter extends DelegatingFilterProxy{

	public static final Logger logger = LoggerFactory
			.getLogger(ShiroFilter.class);

}
