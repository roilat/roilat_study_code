/*
 * BlklistQueryLogService.java created on 2016-08-17 下午 16:18:45 by roilatD
 */
package com.hansy.dataservice.busi.service;

import com.hansy.dataservice.busi.entity.BlklistQueryLog;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Pager;

/**
 * 黑名单查询日志 Service 接口
 * TODO javadoc for com.hansy.dataservice.busi.service.BlklistQueryLogService
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-08-17
 */
public interface BlklistQueryLogService {
	
	/**
	 * 获取查询分页对象
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param pager
	 * @param blklistQueryLog
	 * @return
	 * @throws Exception
	 */
	public Pager search(Pager pager, BlklistQueryLog blklistQueryLog) throws Exception;
	
	/**
	 * 新增黑名单查询日志
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param blklistQueryLog
	 * @return
	 * @throws Exception
	 */
	public BusinessMap create(BlklistQueryLog blklistQueryLog) throws Exception;
	
	/**
	 * 判断是否存在
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param blklistQueryLog 黑名单查询日志
	 * @return
	 * @throws Exception
	 */
	public boolean isExists(BlklistQueryLog blklistQueryLog) throws Exception;
	
	/**
	 * 根据ID获取黑名单查询日志
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param blklistQueryLogId
	 * @return
	 * @throws Exception
	 */
	public BlklistQueryLog getById(String blklistQueryLogId) throws Exception;
	
	/**
	 * 编辑黑名单查询日志
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param blklistQueryLog 黑名单查询日志
	 * @return
	 * @throws Exception
	 */
	public BusinessMap edit(BlklistQueryLog blklistQueryLog) throws Exception;
	
	/**
	 * 根据ID删除黑名单查询日志
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param blklistQueryLogId
	 * @return
	 * @throws Exception
	 */
	public boolean delete(String blklistQueryLogId) throws Exception;
	

}
