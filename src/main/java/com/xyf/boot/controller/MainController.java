/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.xyf.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 主控
 * 
 * @author xiyifeng
 * @date 2016-5-24
 */
@Controller
@RequestMapping("/")
public class MainController {

	private static final Logger logger = LoggerFactory
			.getLogger(MainController.class);

	public MainController() {
	}

	@RequestMapping
	public ModelAndView index() {
		logger.info("进入首页面");
		logger.info("=========================");
		return new ModelAndView("index");
	}

}