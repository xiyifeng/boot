package com.xyf.boot.service;

import java.util.List;

import com.xyf.boot.domain.Right;

public interface RightService {

	List<Right> findAllRightByUserCode(String userCode);
	
}
