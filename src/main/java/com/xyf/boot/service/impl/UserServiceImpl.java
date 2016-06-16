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
		user.setUsercode(userCode);
		return (User) dao.selectOne(user);
	}

	@Override
	public List<String> getUserPermission(String userCode) {
		List list = dao.selectListByConds(User.class.getName()
				+ ".findUserAllPermission", userCode);
		return list;
	}

	@Override
	public List<User> selectEverPage(User user) {
		return dao.selectEverPage(User.class.getName() + ".selectEverPage",
				user);
	}

	@Override
	public int selectTotalSize(User user) {
		return dao.selectTotalSize(user);
	}

	@Override
	public void addUser(User user) {
		dao.save(user);
	}

	@Override
	public void updateUser(User user) {
		dao.modify(user);
	}

}
