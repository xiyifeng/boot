package com.xyf.boot.service;

import java.util.List;

import com.xyf.boot.domain.User;

public interface UserService {

	/**
	 * 用户查询
	 * @param userCode 用户ID
	 * @return
	 */
	User findByName(String userCode);

	/** 
	 * 获取用户权限
	 * @param userCode 用户ID 
	 * @return
	 */
	List<String> getUserPermission(String userCode);
	
	/**
	 * 根据条件查询用户信息(分页)
	 * @param user 用户信息条件
	 * @return 符合条件用户
	 */
	List<User> selectEverPage(User user);
	
	/**
	 * 根据条件查询总记录数
	 * @param user 用户信息条件
	 * @return 总记录数
	 */
	int selectTotalSize(User user);

	/**
	 * 用户新增
	 * @param user 用户
	 */
	void addUser(User user);

	
	void updateUser(User user);
}
