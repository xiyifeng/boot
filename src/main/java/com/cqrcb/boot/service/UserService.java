package com.cqrcb.boot.service;

import com.cqrcb.boot.domain.User;

public interface UserService {

	/** 用户查询 **/
	User findByName(String userCode);

}
