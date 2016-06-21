package com.xyf.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 异常管理
 * 
 * @author xiyifeng
 * @date 2016年6月15日
 */
@ControllerAdvice
public class ExceptionController {

	private static final Logger logger = LoggerFactory.getLogger(Logger.class);

	@ExceptionHandler(Exception.class)
	public String exception(Exception e) {
		logger.info("异常抛出，{}", e.getCause());
		return "error/error";
	}

}
