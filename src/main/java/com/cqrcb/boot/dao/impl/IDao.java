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
		logger.debug("dao save invoke  【mybatis.defaultMapper."+t.getClass().getSimpleName()+"Mapper.insert 】");
		sqlSessionTemplate.insert("mybatis.defaultMapper."+t.getClass().getSimpleName()+"Mapper.insert", t);
	}

	@Override
	public void delete(T t) {
		logger.debug("dao delete invoke  【mybatis.defaultMapper."+t.getClass().getSimpleName()+"Mapper.deleteByPrimaryKey 】");
		sqlSessionTemplate
				.delete("mybatis.defaultMapper."+t.getClass().getSimpleName()+"Mapper.deleteByPrimaryKey", t);
	}

	@Override
	public int selectTotalSize(T t) {
		logger.debug("dao selectTotalSize invoke  【" + t.getClass().getName()
				+ ".selectTotalSize】");
		Object sn = sqlSessionTemplate.selectOne(t.getClass().getName()
				+ ".selectTotalSize", t);
		return Integer.valueOf(sn.toString()).intValue();
	}

	@Override
	public void modify(T t) {
		logger.debug("dao modify invoke  【mybatis.defaultMapper."+t.getClass().getSimpleName()+"Mapper.modifyByPrimaryKey】");
		sqlSessionTemplate
				.update("mybatis.defaultMapper."+t.getClass().getSimpleName()+"Mapper.updateByPrimaryKey", t);
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
		logger.debug("dao selectOne invoke  【mybatis.defaultMapper."+t.getClass().getSimpleName()+"Mapper.selectByPrimaryKey】");
		return sqlSessionTemplate.selectOne(
				"mybatis.defaultMapper."+t.getClass().getSimpleName()+"Mapper.selectByPrimaryKey", t);
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
	public List<T> selectEverPage(String statement, T t) {
		logger.debug("dao selectList invoke  【 " + statement + "】");
		return sqlSessionTemplate.selectList(statement, t);
	}

	@Override
	public Object selectOneByConds(String statement, Object condObj) {
		logger.debug("dao selectOne invoke  【" + statement + "】");
		return sqlSessionTemplate.selectOne(statement, condObj);
	}

}
