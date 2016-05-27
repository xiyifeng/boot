package com.cqrcb.boot.dao.intc;

import java.util.List;

/**
 * 通用DAO
 * 
 * @author xiyifeng
 * @date 2016-5-25
 * @param <T>
 */
public interface Dao<T> {

	public void save(T t);

	public void delete(T t);

	public void modify(T t);

	public List<T> selectList(T t);

	public List<T> selectList(String statement);

	public List<T> selectList(String statement, T t);

	public List<T> selectEverPage(T t);

	public int selectTotalSize(T t);

	public Object selectOne(T t);

	public Object selectOne(String statement);

	public Object selectOne(String statement, T t);

	public Object selectOneByConds(String statement, Object condObj);

}
