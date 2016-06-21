package com.xyf.boot.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	private static final Logger logger = LoggerFactory
			.getLogger(UserController.class);

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
		logger.info("查询结果:{}", res);
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

	@RequestMapping("/detail")
	public String showDetail(@RequestParam("usercode") String usercode,
			ModelMap modelMap) {
		logger.debug("传入参数: " + usercode);
		User user = userService.findByName(usercode);
		modelMap.addAttribute("user", user);
		return "user/detail";
	}

	/**
	 * 用户新增主页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String userAdd() {
		return "user/add";
	}

	/**
	 * 用户新增
	 * 
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Object userAddPost(@Valid User user, BindingResult bindingResult) {
		// 初始密码
		user.setPassword("123456");
		if (bindingResult.hasErrors()) {
			return JsonUtil.genResultMessage(bindingResult);
		}
		try {
			userService.addUser(user);
		} catch (Exception e) {
			logger.error("新增用户错误，{}", e.getCause());
			return JsonUtil.genFailResultMessage("用户新增失败，" + e.getMessage());
		}
		return JsonUtil.genSuccessResultMessage();
	}

	/**
	 * 用户修改
	 * 
	 * @return
	 */
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	@ResponseBody
	public Object userModifyPost(User user) {
		logger.info("modify 传入参数： " + user);
		try {
			userService.updateUser(user);
		} catch (Exception e) {
			logger.error("修改用户错误，{}", e.getCause());
			return JsonUtil.genFailResultMessage("用户修改失败，" + e.getMessage());
		}
		return JsonUtil.genSuccessResultMessage();
	}
}
