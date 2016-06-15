package com.xyf.boot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xyf.boot.domain.User;
import com.xyf.boot.domain.base.JsonResult;
import com.xyf.boot.service.UserService;
import com.xyf.boot.util.JsonUtil;

/**
 * 用户管理
 * 
 * @author xiyifeng
 * @date 2016年6月15日
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	/**
	 * 用户分页查询
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public JsonResult findAllUser(User user) {
		int total;
		List<User> users;
		total = userService.selectTotalSize(user);
		users = userService.selectEverPage(user);
		JsonResult res = JsonUtil.genJsonResultModel(total, users);
		logger.info("查询结果:{}" , res);
		return res;
	}

	/**
	 * 用户查询首页面
	 * 
	 * @return
	 */
	@RequestMapping
	public String userMain() {
		return "user/list";
	}
}
