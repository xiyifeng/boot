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

import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.xyf.boot.domain.User;
import com.xyf.boot.domain.base.ResultMessage;
import com.xyf.boot.util.Constants;
import com.xyf.boot.util.JsonUtil;

/**
 * 主控
 * 
 * @author xiyifeng
 * @date 2016-5-24
 */
@Controller
@RequestMapping
public class MainController {
	private static final Logger logger = LoggerFactory
			.getLogger(MainController.class);

	public MainController() {
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String root() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping("/index")
	public String index() {
		logger.info("登陆成功后进入主页面");
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Object login(@Valid User user, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		logger.info("登陆用户{} ", user);
		if (bindingResult.hasErrors()) {
			return JsonUtil.genResultMessage(bindingResult);
		}

		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(
				user.getUsername(), user.getPassword());
		ResultMessage res = new ResultMessage();
		try {
			subject.login(token);
		} catch (UnknownSessionException use) {
			subject = new Subject.Builder().buildSubject();
			subject.login(token);
			logger.error("{}{}", Constants.UNKNOWN_SESSION_EXCEPTION,
					use.getCause());
			logger.error(Constants.UNKNOWN_SESSION_EXCEPTION);
			res.setErrorMessage(Constants.UNKNOWN_SESSION_EXCEPTION);
		} catch (UnknownAccountException ex) {
			logger.error("{}{}", Constants.UNKNOWN_ACCOUNT_EXCEPTION,
					ex.getCause());
			res.setErrorMessage(Constants.UNKNOWN_ACCOUNT_EXCEPTION);
		} catch (IncorrectCredentialsException ice) {
			logger.error("{}{}", Constants.INCORRECT_CREDENTIALS_EXCEPTION,
					ice.getCause());
			res.setErrorMessage(Constants.INCORRECT_CREDENTIALS_EXCEPTION);
		} catch (LockedAccountException lae) {
			logger.error("{}{}", Constants.LOCKED_ACCOUNT_EXCEPTION,
					lae.getCause());
			res.setErrorMessage(Constants.LOCKED_ACCOUNT_EXCEPTION);
		} catch (AuthenticationException ae) {
			logger.error("{}{}", Constants.AUTHENTICATION_EXCEPTION,
					ae.getCause());
			res.setErrorMessage(Constants.AUTHENTICATION_EXCEPTION);
		} catch (Exception e) {
			logger.error("{}{}", Constants.UNKNOWN_EXCEPTION, e.getCause());
			res.setErrorMessage(Constants.UNKNOWN_EXCEPTION);
		}
		return res;
	}

	@RequestMapping(value="/logout", method=RequestMethod.POST)
	public String logout(User user) {
		Subject subject = SecurityUtils.getSubject();
		logger.info("用户登出{}", subject.getSession().getAttribute(Constants.KEY_USER));
		subject.logout();
		return "login";
	}

}