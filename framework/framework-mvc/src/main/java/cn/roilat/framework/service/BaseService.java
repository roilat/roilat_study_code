package cn.roilat.framework.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import cn.roilat.framework.common.result.CommonResult;
import tk.mybatis.mapper.common.Mapper;

public abstract class BaseService<T> {
	@Autowired
	private Mapper<T> mapper;

	/**
	 * save the data
	 */
	protected CommonResult<T> doSave(T entity){
		if (mapper.insertSelective(entity) > 0) {
			return CommonResult.succ("保存成功！", entity);
		} else {
			return CommonResult.fail("保存失败！");
		}
	}

	/**
	 * update data by primary key
	 */
	protected CommonResult<T> doUpdate(T entity){
		if (mapper.updateByPrimaryKeySelective(entity) > 0) {
			return CommonResult.succ("更新成功！", entity);
		} else {
			return CommonResult.fail("更新失败！");
		}
	}

	/**
	 * insert data while fail to update
	 */
	@Transactional
	protected CommonResult<T> doInsertOrUpdate(T entity){
		T t = mapper.selectByPrimaryKey(entity);
		if (t == null) {
			return doSave(entity);
		}
		return doUpdate(entity);
	}

	/**
	 * delete by condition
	 */
	protected CommonResult<T> doDelete(T entity){
		int n = 0;
		List<T> list;
		if ((n = CollectionUtils.isEmpty(list = mapper.select(entity)) ? 0 : list.size()) > 0) {
			if (n != mapper.delete(entity)) {
				return CommonResult.fail("删除失败！");
			}
		}
		return CommonResult.succ("删除成功！", entity);
	}

	/**
	 * delete by primary key
	 */
	protected CommonResult<T> doDeleteByPrimaryKey(T entity){
		if (mapper.deleteByPrimaryKey(entity) > 0) {
			return CommonResult.succ("删除成功！", entity);
		} else {
			return CommonResult.fail("删除失败！");
		}
	}

	/**
	 * query all records exist(NOT RECOMMEND)
	 */
	protected CommonResult<List<T>> doGetAll(){
		return CommonResult.succ("查询成功！", mapper.selectAll());
	}

	/**
	 * query the first record by condition
	 */
	protected CommonResult<T> doGetOne(T entity){
		List<T> list = mapper.select(entity);
		if (list != null && list.size() == 1) {
			return CommonResult.succ("查询成功！", list.get(0));
		}
		return CommonResult.fail("数据不存在！");
	}

	/**
	 * query the record by primary key
	 */
	protected CommonResult<T> doGetByPrimaryKey(T entity){
		T data;
		if ((data = mapper.selectByPrimaryKey(entity)) != null) {
			return CommonResult.succ("", data);
		} else {
			return CommonResult.fail("对像不存在！");
		}
	}

	/**
	 * query all matched records(NOT RECOMMEND)
	 */
	protected CommonResult<List<T>> doGetList(T entity){
		return CommonResult.succ("查询成功！", mapper.select(entity));
	}

	/**
	 * query the record count
	 */
	protected CommonResult<Integer> doGetCount(T entity){
		return CommonResult.succ("查询成功！", mapper.selectCount(entity));
	}
}
