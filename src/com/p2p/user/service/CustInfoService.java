/*
 * CustInfoService.java created on 2016-06-17 上午 10:49:08 by roilatD
 */
package com.p2p.user.service;

import com.p2p.user.entity.CustInfo;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Pager;

/**
 * 用户信息 Service 接口
 * TODO javadoc for com.p2p.user.service.CustInfoService
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-06-17
 */
public interface CustInfoService {
	
	/**
	 * 获取查询分页对象
	 * @creator: roilatD
	 * @createDate: 2016-06-17
	 * @modifier:
	 * @modifiedDate:
	 * @param pager
	 * @param custInfo
	 * @return
	 * @throws Exception
	 */
	public Pager search(Pager pager, CustInfo custInfo) throws Exception;
	
	/**
	 * 新增用户信息
	 * @creator: roilatD
	 * @createDate: 2016-06-17
	 * @modifier:
	 * @modifiedDate:
	 * @param custInfo
	 * @return
	 * @throws Exception
	 */
	public BusinessMap create(CustInfo custInfo) throws Exception;
	
	/**
	 * 判断是否存在
	 * @creator: roilatD
	 * @createDate: 2016-06-17
	 * @modifier:
	 * @modifiedDate:
	 * @param custInfo 用户信息
	 * @return
	 * @throws Exception
	 */
	public boolean isExists(CustInfo custInfo) throws Exception;
	
	/**
	 * 根据ID获取用户信息
	 * @creator: roilatD
	 * @createDate: 2016-06-17
	 * @modifier:
	 * @modifiedDate:
	 * @param custInfoId
	 * @return
	 * @throws Exception
	 */
	public CustInfo getById(String custInfoId) throws Exception;
	
	/**
	 * 编辑用户信息
	 * @creator: roilatD
	 * @createDate: 2016-06-17
	 * @modifier:
	 * @modifiedDate:
	 * @param custInfo 用户信息
	 * @return
	 * @throws Exception
	 */
	public BusinessMap edit(CustInfo custInfo) throws Exception;
	
	/**
	 * 根据ID删除用户信息
	 * @creator: roilatD
	 * @createDate: 2016-06-17
	 * @modifier:
	 * @modifiedDate:
	 * @param custInfoId
	 * @return
	 * @throws Exception
	 */
	public boolean delete(String custInfoId) throws Exception;
	

}
