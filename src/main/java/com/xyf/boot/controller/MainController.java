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

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.xyf.boot.domain.Right;
import com.xyf.boot.domain.User;
import com.xyf.boot.domain.info.Menu;
import com.xyf.boot.service.RightService;
import com.xyf.boot.util.Constants;
import com.xyf.boot.util.JsonUtil;
import com.xyf.boot.util.SystemUtil;

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

	@Autowired
	private RightService rightService;

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
		// boolean dn = SecurityUtils.getSubject().isPermitted("/index");
		logger.info("进入主页面");
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Object login(User user, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		logger.info("登陆用户{} ", user);
		if (bindingResult.hasErrors()) {
			return JsonUtil.genResultMessage(bindingResult);
		}

		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(
				user.getUsercode(), user.getPassword());
		try {
			subject.login(token);
		} catch (UnknownSessionException use) {
			subject = new Subject.Builder().buildSubject();
			subject.login(token);
			return JsonUtil.genFailResultMessage("1001");
		} catch (UnknownAccountException ex) {
			return JsonUtil.genFailResultMessage("1002");
		} catch (IncorrectCredentialsException ice) {
			return JsonUtil.genFailResultMessage("1003");
		} catch (LockedAccountException lae) {
			return JsonUtil.genFailResultMessage("1004");
		} catch (AuthenticationException ae) {
			return JsonUtil.genFailResultMessage("1005");
		} catch (Exception e) {
			return JsonUtil.genFailResultMessage("1006");
		}
		return JsonUtil.genSuccessResultMessage();
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout(User user) {
		Subject subject = SecurityUtils.getSubject();
		logger.info("用户登出{}",
				subject.getSession().getAttribute(Constants.KEY_USER));
		subject.logout();
		return "login";
	}

	@RequestMapping(value = "/loadMenu", method = RequestMethod.POST)
	@ResponseBody
	public Object loadMenu() {
		logger.debug("加载菜单!");
		List<Right> rights = rightService.findAllRightByUserCode(SystemUtil
				.currentUserCode());
		logger.debug("权限__{}", rights);
		if (rights == null || rights.size() == 0) {
			return JsonUtil.genFailResultMessage("1007");
		}
		List<Menu> menus = new ArrayList<Menu>();
		Menu menu = null;
		// D-主菜单 处理
		for (Right right : rights) {
			if ("D".equals(right.getRightType())) {
				menu = new Menu();
				menu.setId(right.getRightId() + "");
				menu.setName(right.getRightName());
				menu.setUrl(right.getUrl());
				menu.setIconCls(right.getIconCls());
				menus.add(menu);
			}
		}
		for (Menu mn : menus) {
			for (Right right : rights) {
				if (mn.getId().equals(right.getSuperRightId() + "")) {
					menu = new Menu();
					menu.setId(right.getRightId() + "");
					menu.setName(right.getRightName());
					menu.setUrl(right.getUrl());
					menu.setIconCls(right.getIconCls());
					mn.addItem(menu);
				}
			}
		}
		logger.debug("菜单:{}", menus);
		return menus;
	}

	@RequestMapping("/noRight")
	public String error() {
		return "error/noRight";
	}
}