package com.cqrcb.boot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cqrcb.boot.dao.intc.Dao;
import com.cqrcb.boot.domain.User;
import com.cqrcb.boot.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private Dao<User> dao;
	
	@Override
	public User findByName(String userCode) {
		User user = new User();
		user.setUser_code(userCode);
		user  = (User) dao.selectOne(user);
		return user;
	}

}
