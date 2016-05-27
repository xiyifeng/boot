package com.cqrcb.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cqrcb.boot.dao.intc.Dao;
import com.cqrcb.boot.domain.FmtCode;

@Service("fmtCodeService")
public class FmtCodeServiceImpl implements FmtCodeService {

	@Autowired
	private Dao<FmtCode> dao;

	@Override
	public List<FmtCode> findAll() {
		return dao.selectList("selectFmtCodeById");
	}

	@Override
	public FmtCode save(FmtCode message) {
		return null;
	}

	@Override
	public FmtCode findFmtCode(String uuid) {
		return (FmtCode) dao.selectOneByConds(FmtCode.class.getName()
				+ ".selectByPrimaryKey", uuid);
	}

	@Override
	public void deleteFmtCode(String uuid) {

	}

	@Override
	public void passFmtCode(String uuid) {

	}

	@Override
	public List<FmtCode> selectList(FmtCode fmtCode) {
		return dao.selectList(fmtCode);
	}

	@Override
	public int selectTotalSize(FmtCode fmtCode) {
		return dao.selectTotalSize(fmtCode);
	}

	@Override
	public List<FmtCode> selectEverPage(FmtCode fmtCode) {
		return dao.selectEverPage(fmtCode);
	}

}
