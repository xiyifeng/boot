package com.xyf.boot.service;

import java.util.List;

import com.xyf.boot.domain.User;

public interface UserService {

	/** 用户查询 **/
	User findByName(String userCode);

	/** 获取用户权限 **/
	List<String> getUserPermission(String userCode);
}
