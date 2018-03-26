/*
 * SysDealRecordsService.java created on 2016-06-14 下午 19:55:21 by roilatD
 */
package com.p2p.invst.service;

import com.p2p.invst.entity.SysDealRecords;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Pager;

/**
 * 系统交易记录 Service 接口
 * TODO javadoc for com.p2p.invst.service.SysDealRecordsService
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-06-14
 */
public interface SysDealRecordsService {
	
	/**
	 * 获取查询分页对象
	 * @creator: roilatD
	 * @createDate: 2016-06-14
	 * @modifier:
	 * @modifiedDate:
	 * @param pager
	 * @param sysDealRecords
	 * @return
	 * @throws Exception
	 */
	public Pager search(Pager pager, SysDealRecords sysDealRecords) throws Exception;
	
	/**
	 * 新增系统交易记录
	 * @creator: roilatD
	 * @createDate: 2016-06-14
	 * @modifier:
	 * @modifiedDate:
	 * @param sysDealRecords
	 * @return
	 * @throws Exception
	 */
	public BusinessMap create(SysDealRecords sysDealRecords) throws Exception;
	
	/**
	 * 判断是否存在
	 * @creator: roilatD
	 * @createDate: 2016-06-14
	 * @modifier:
	 * @modifiedDate:
	 * @param sysDealRecords 系统交易记录
	 * @return
	 * @throws Exception
	 */
	public boolean isExists(SysDealRecords sysDealRecords) throws Exception;
	
	/**
	 * 根据ID获取系统交易记录
	 * @creator: roilatD
	 * @createDate: 2016-06-14
	 * @modifier:
	 * @modifiedDate:
	 * @param sysDealRecordsId
	 * @return
	 * @throws Exception
	 */
	public SysDealRecords getById(String sysDealRecordsId) throws Exception;
	
	/**
	 * 编辑系统交易记录
	 * @creator: roilatD
	 * @createDate: 2016-06-14
	 * @modifier:
	 * @modifiedDate:
	 * @param sysDealRecords 系统交易记录
	 * @return
	 * @throws Exception
	 */
	public BusinessMap edit(SysDealRecords sysDealRecords) throws Exception;
	
	/**
	 * 根据ID删除系统交易记录
	 * @creator: roilatD
	 * @createDate: 2016-06-14
	 * @modifier:
	 * @modifiedDate:
	 * @param sysDealRecordsId
	 * @return
	 * @throws Exception
	 */
	public boolean delete(String sysDealRecordsId) throws Exception;
	

}
