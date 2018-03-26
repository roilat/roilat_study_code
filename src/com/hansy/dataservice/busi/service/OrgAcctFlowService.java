/*
 * OrgAcctFlowService.java created on 2016-08-17 下午 16:16:02 by roilatD
 */
package com.hansy.dataservice.busi.service;

import com.hansy.dataservice.busi.entity.OrgAcctFlow;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Pager;

/**
 * 查询机构台账 Service 接口
 * TODO javadoc for com.hansy.dataservice.busi.service.OrgAcctFlowService
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-08-17
 */
public interface OrgAcctFlowService {
	
	/**
	 * 获取查询分页对象
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param pager
	 * @param orgAcctFlow
	 * @return
	 * @throws Exception
	 */
	public Pager search(Pager pager, OrgAcctFlow orgAcctFlow) throws Exception;
	
	/**
	 * 新增查询机构台账
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param orgAcctFlow
	 * @return
	 * @throws Exception
	 */
	public BusinessMap create(OrgAcctFlow orgAcctFlow) throws Exception;
	
	/**
	 * 判断是否存在
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param orgAcctFlow 查询机构台账
	 * @return
	 * @throws Exception
	 */
	public boolean isExists(OrgAcctFlow orgAcctFlow) throws Exception;
	
	/**
	 * 根据ID获取查询机构台账
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param orgAcctFlowId
	 * @return
	 * @throws Exception
	 */
	public OrgAcctFlow getById(String orgAcctFlowId) throws Exception;
	
	/**
	 * 编辑查询机构台账
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param orgAcctFlow 查询机构台账
	 * @return
	 * @throws Exception
	 */
	public BusinessMap edit(OrgAcctFlow orgAcctFlow) throws Exception;
	
	/**
	 * 根据ID删除查询机构台账
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param orgAcctFlowId
	 * @return
	 * @throws Exception
	 */
	public boolean delete(String orgAcctFlowId) throws Exception;
	

}
