package com.xyf.boot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyf.boot.dao.Dao;
import com.xyf.boot.domain.Right;
import com.xyf.boot.service.RightService;

@Service("RightService")
@SuppressWarnings({ "unchecked", "rawtypes" })
public class RightServiceImpl implements RightService {

	@Autowired
	private Dao<Right> dao;

	@Override
	public List<Right> findAllRightByUserCode(String userCode) {
		List list = dao.selectListByConds(Right.class.getName()
				+ ".findUserMenu", userCode);
		return list;
	}

}
