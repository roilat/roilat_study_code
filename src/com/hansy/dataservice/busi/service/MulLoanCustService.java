/*
 * MulLoanCustService.java created on 2016-08-17 下午 16:14:14 by roilatD
 */
package com.hansy.dataservice.busi.service;

import com.hansy.dataservice.busi.entity.MulLoanCust;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Pager;

/**
 * 多头借贷客户 Service 接口
 * TODO javadoc for com.hansy.dataservice.busi.service.MulLoanCustService
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-08-17
 */
public interface MulLoanCustService {
	
	/**
	 * 获取查询分页对象
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param pager
	 * @param mulLoanCust
	 * @return
	 * @throws Exception
	 */
	public Pager search(Pager pager, MulLoanCust mulLoanCust) throws Exception;
	
	/**
	 * 新增多头借贷客户
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param mulLoanCust
	 * @return
	 * @throws Exception
	 */
	public BusinessMap create(MulLoanCust mulLoanCust) throws Exception;
	
	/**
	 * 判断是否存在
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param mulLoanCust 多头借贷客户
	 * @return
	 * @throws Exception
	 */
	public boolean isExists(MulLoanCust mulLoanCust) throws Exception;
	
	/**
	 * 根据ID获取多头借贷客户
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param mulLoanCustId
	 * @return
	 * @throws Exception
	 */
	public MulLoanCust getById(String mulLoanCustId) throws Exception;
	
	/**
	 * 编辑多头借贷客户
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param mulLoanCust 多头借贷客户
	 * @return
	 * @throws Exception
	 */
	public BusinessMap edit(MulLoanCust mulLoanCust) throws Exception;
	
	/**
	 * 根据ID删除多头借贷客户
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param mulLoanCustId
	 * @return
	 * @throws Exception
	 */
	public boolean delete(String mulLoanCustId) throws Exception;
	

}
