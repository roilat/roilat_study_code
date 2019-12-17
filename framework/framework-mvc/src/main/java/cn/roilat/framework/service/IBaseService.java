package cn.roilat.framework.service;

import java.util.List;

import cn.roilat.framework.common.result.CommonResult;

public interface IBaseService<T> {
	/**
	 * save the data
	 */
	CommonResult<T> save(T entity);

	/**
	 * update data by primary key
	 */
	CommonResult<T> update(T entity);

	/**
	 * insert data while fail to update
	 */
	CommonResult<T> insertOrUpdate(T entity);

	/**
	 * delete by condition
	 */
	CommonResult<T> delete(T entity);

	/**
	 * delete by primary key
	 */
	CommonResult<T> deleteByPrimaryKey(T entity);

	/**
	 * query all records exist(NOT RECOMMEND)
	 */
	CommonResult<List<T>> getAll();

	/**
	 * query all matched records(NOT RECOMMEND)
	 */
	CommonResult<List<T>> getByCondition(T entity);

	/**
	 * query the first record by condition
	 */
	CommonResult<T> getOne(T entity);

	/**
	 * query the record by primary key
	 */
	CommonResult<T> getByPrimaryKey(T entity);

	/**
	 * query the record count
	 */
	CommonResult<Integer> getCount(T entity);
}
