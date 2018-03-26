/*
 * SysSmsLogService.java created on 2016-05-23 下午 18:14:58 by roilatD
 */
package com.p2p.sms.service;

import com.p2p.sms.entity.SysSmsLog;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Pager;

/**
 * 短信日志表 Service 接口
 * TODO javadoc for com.p2p.sms.service.SysSmsLogService
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-05-23
 */
public interface SysSmsLogService {
	
	/**
	 * 获取查询分页对象
	 * @creator: roilatD
	 * @createDate: 2016-05-23
	 * @modifier:
	 * @modifiedDate:
	 * @param pager
	 * @param sysSmsLog
	 * @return
	 * @throws Exception
	 */
	public Pager search(Pager pager, SysSmsLog sysSmsLog) throws Exception;
	
	/**
	 * 新增短信日志表
	 * @creator: roilatD
	 * @createDate: 2016-05-23
	 * @modifier:
	 * @modifiedDate:
	 * @param sysSmsLog
	 * @return
	 * @throws Exception
	 */
	public BusinessMap create(SysSmsLog sysSmsLog) throws Exception;
	
	/**
	 * 判断是否存在
	 * @creator: roilatD
	 * @createDate: 2016-05-23
	 * @modifier:
	 * @modifiedDate:
	 * @param sysSmsLog 短信日志表
	 * @return
	 * @throws Exception
	 */
	public boolean isExists(SysSmsLog sysSmsLog) throws Exception;
	
	/**
	 * 根据ID获取短信日志表
	 * @creator: roilatD
	 * @createDate: 2016-05-23
	 * @modifier:
	 * @modifiedDate:
	 * @param sysSmsLogId
	 * @return
	 * @throws Exception
	 */
	public SysSmsLog getById(String sysSmsLogId) throws Exception;
	
	/**
	 * 编辑短信日志表
	 * @creator: roilatD
	 * @createDate: 2016-05-23
	 * @modifier:
	 * @modifiedDate:
	 * @param sysSmsLog 短信日志表
	 * @return
	 * @throws Exception
	 */
	public BusinessMap edit(SysSmsLog sysSmsLog) throws Exception;
	
	/**
	 * 根据ID删除短信日志表
	 * @creator: roilatD
	 * @createDate: 2016-05-23
	 * @modifier:
	 * @modifiedDate:
	 * @param sysSmsLogId
	 * @return
	 * @throws Exception
	 */
	public boolean delete(String sysSmsLogId) throws Exception;
	

}
