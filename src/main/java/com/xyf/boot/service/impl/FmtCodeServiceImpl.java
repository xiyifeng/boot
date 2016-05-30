package com.xyf.boot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyf.boot.dao.Dao;
import com.xyf.boot.domain.FmtCode;
import com.xyf.boot.service.FmtCodeService;

@Service("fmtCodeService")
public class FmtCodeServiceImpl implements FmtCodeService {

	@Autowired
	private Dao<FmtCode> dao;

	@Override
	public FmtCode save(FmtCode message) {
		return null;
	}

	@Override
	public FmtCode findFmtCode(String uuid) {
		FmtCode fc = new FmtCode();
		fc.setUuid(uuid);
		return (FmtCode) dao.selectOne(fc);
	}

	@Override
	public void deleteFmtCode(String uuid) {

	}

	@Override
	public void passFmtCode(String uuid) {

	}

	@Override
	public int selectTotalSize(FmtCode fmtCode) {
		return dao.selectTotalSize(fmtCode);
	}

	@Override
	public List<FmtCode> selectEverPage(FmtCode fmtCode) {
		return dao.selectEverPage(
				FmtCode.class.getName()+".selectEverPage", fmtCode);
	}

}
