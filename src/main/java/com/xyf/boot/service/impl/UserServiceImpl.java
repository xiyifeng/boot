package com.xyf.boot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyf.boot.dao.Dao;
import com.xyf.boot.domain.User;
import com.xyf.boot.service.UserService;

@SuppressWarnings({ "unchecked", "rawtypes" })
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private Dao<User> dao;

	@Override
	public User findByName(String userCode) {
		User user = new User();
		user.setUserCode(userCode);
		return (User) dao.selectOne(user);
	}

	@Override
	public List<String> getUserPermission(String userCode) {
		List list = dao.selectListByConds(
				User.class.getName()+".findUserAllPermission", userCode);
		return list;
	}

}
