package com.xyf.boot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyf.boot.dao.Dao;
import com.xyf.boot.domain.User;
import com.xyf.boot.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private Dao<User> dao;
	
	@Override
	public User findByName(String userCode) {
		User user = new User();
		user.setUserCode(userCode);
		user  = (User) dao.selectOne(user);
		return user;
	}

}
