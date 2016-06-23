package com.xyf.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 异常管理
 * 
 * @author xiyifeng
 * @date 2016年6月15日
 */
@ControllerAdvice
public class ExceptionController {

	private static final Logger logger = LoggerFactory.getLogger(Logger.class);

	@ExceptionHandler
	public ModelAndView exception(Exception e) {
		logger.info("异常抛出，{}", e.getCause());
		ModelAndView mv = new ModelAndView("error/error");
		mv.addObject("message", e.getMessage());
		return mv;
	}

}
