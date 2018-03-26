/*
 * OrgAcctLedgerService.java created on 2016-08-17 下午 16:17:44 by roilatD
 */
package com.hansy.dataservice.busi.service;

import com.hansy.dataservice.busi.entity.OrgAcctLedger;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Pager;

/**
 * 查询机构充值台账 Service 接口
 * TODO javadoc for com.hansy.dataservice.busi.service.OrgAcctLedgerService
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-08-17
 */
public interface OrgAcctLedgerService {
	
	/**
	 * 获取查询分页对象
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param pager
	 * @param orgAcctLedger
	 * @return
	 * @throws Exception
	 */
	public Pager search(Pager pager, OrgAcctLedger orgAcctLedger) throws Exception;
	
	/**
	 * 新增查询机构充值台账
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param orgAcctLedger
	 * @return
	 * @throws Exception
	 */
	public BusinessMap create(OrgAcctLedger orgAcctLedger) throws Exception;
	
	/**
	 * 判断是否存在
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param orgAcctLedger 查询机构充值台账
	 * @return
	 * @throws Exception
	 */
	public boolean isExists(OrgAcctLedger orgAcctLedger) throws Exception;
	
	/**
	 * 根据ID获取查询机构充值台账
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param orgAcctLedgerId
	 * @return
	 * @throws Exception
	 */
	public OrgAcctLedger getById(String orgAcctLedgerId) throws Exception;
	
	/**
	 * 编辑查询机构充值台账
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param orgAcctLedger 查询机构充值台账
	 * @return
	 * @throws Exception
	 */
	public BusinessMap edit(OrgAcctLedger orgAcctLedger) throws Exception;
	
	/**
	 * 根据ID删除查询机构充值台账
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param orgAcctLedgerId
	 * @return
	 * @throws Exception
	 */
	public boolean delete(String orgAcctLedgerId) throws Exception;
	

}
