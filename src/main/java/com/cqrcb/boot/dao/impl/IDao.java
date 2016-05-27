package com.cqrcb.boot.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cqrcb.boot.dao.intc.Dao;

@Component("dao")
public class IDao<T> implements Dao<T> {

	private static final Logger logger = LoggerFactory.getLogger(IDao.class);
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public void save(T t) {
		logger.debug("dao save invoke  【" + t.getClass().getName()
				+ ".insert 】");
		sqlSessionTemplate.insert(t.getClass().getName() + ".insert", t);
	}

	@Override
	public void delete(T t) {
		logger.debug("dao delete invoke  【" + t.getClass().getName()
				+ ".deleteByPrimaryKey 】");
		sqlSessionTemplate.delete(t.getClass().getName()
				+ ".deleteByPrimaryKey", t);
	}

	@Override
	public List<T> selectList(T t) {
		logger.debug("dao selectList invoke  【" + t.getClass().getName()
				+ ".selectList 】");
		return sqlSessionTemplate.selectList(t.getClass().getName()
				+ ".selectList", t);
	}

	@Override
	public int selectTotalSize(T t) {
		logger.debug("dao selectTotalSize invoke  【" + t.getClass().getName()
				+ ".selectTotalSize】");
		logger.debug("=====" + sqlSessionTemplate);
		logger.debug("=====" + t.getClass().getName() + ".selectTotalSize");
		logger.debug("=====" + t);
		Object sn = sqlSessionTemplate.selectOne(t.getClass().getName()
				+ ".selectTotalSize", t);
		logger.debug("========" + sn);
		return Integer.valueOf(sn.toString()).intValue();
	}

	@Override
	public void modify(T t) {
		logger.debug("dao modify invoke  【" + t.getClass().getName()
				+ ".modifyByPrimaryKey】");
		sqlSessionTemplate.selectOne(t.getClass().getName()
				+ ".modifyByPrimaryKey", t);
	}

	@Override
	public List<T> selectList(String statement) {
		logger.debug("dao selectList invoke 【" + statement + "】");
		return sqlSessionTemplate.selectList(statement);
	}

	@Override
	public List<T> selectList(String statement, T t) {
		logger.debug("dao selectList invoke  【" + statement + "】");
		return sqlSessionTemplate.selectList(statement, t);
	}

	@Override
	public Object selectOne(T t) {
		logger.debug("dao selectOne invoke  【" + t.getClass().getName()
				+ ".selectByPrimaryKey】");
		return sqlSessionTemplate.selectOne(t.getClass().getName()
				+ ".selectByPrimaryKey", t);
	}

	@Override
	public Object selectOne(String statement) {
		logger.debug("dao selectOne invoke  【" + statement + "】");
		return sqlSessionTemplate.selectOne(statement);
	}

	@Override
	public Object selectOne(String statement, T t) {
		logger.debug("dao selectOne invoke  【" + statement + "】");
		return sqlSessionTemplate.selectOne(statement, t);
	}

	@Override
	public List<T> selectEverPage(T t) {
		logger.debug("dao selectList invoke  【" + t.getClass().getName()
				+ ".selectEverPage" + "】");
		return sqlSessionTemplate.selectList(t.getClass().getName()
				+ ".selectEverPage", t);
	}

	@Override
	public Object selectOneByConds(String statement, Object condObj) {
		logger.debug("dao selectOne invoke  【" + statement + "】");
		return sqlSessionTemplate.selectOne(statement, condObj);
	}

}
