package cn.roilat.framework.core.service;

import java.util.List;

public interface BaseService<T> {
	int save(T entity)throws Exception;
	int update(T entity)throws Exception;
	int insertOrUpdate(T entity) throws Exception;
	int delete(T entity) throws Exception;
	int deleteByPrimaryKey(Object entity)throws Exception;
	List<T> getAll()throws Exception;
	List<T> get(T entity)throws Exception;
	T getOne(T entity) throws Exception;
	T getByPrimaryKey(Object entity)throws Exception;
	int getCount(T entity)throws Exception;
}
