/*
 * LoanCustBaseInfoService.java created on 2016-08-17 下午 16:20:39 by roilatD
 */
package com.hansy.dataservice.busi1.service;

import com.hansy.dataservice.busi1.entity.LoanCustBaseInfo;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Pager;

/**
 * 贷款客户基本信息 Service 接口
 * TODO javadoc for com.hansy.dataservice.busi1.service.LoanCustBaseInfoService
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-08-17
 */
public interface LoanCustBaseInfoService {
	
	/**
	 * 获取查询分页对象
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param pager
	 * @param loanCustBaseInfo
	 * @return
	 * @throws Exception
	 */
	public Pager search(Pager pager, LoanCustBaseInfo loanCustBaseInfo) throws Exception;
	
	/**
	 * 新增贷款客户基本信息
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param loanCustBaseInfo
	 * @return
	 * @throws Exception
	 */
	public BusinessMap create(LoanCustBaseInfo loanCustBaseInfo) throws Exception;
	
	/**
	 * 判断是否存在
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param loanCustBaseInfo 贷款客户基本信息
	 * @return
	 * @throws Exception
	 */
	public boolean isExists(LoanCustBaseInfo loanCustBaseInfo) throws Exception;
	
	/**
	 * 根据ID获取贷款客户基本信息
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param loanCustBaseInfoId
	 * @return
	 * @throws Exception
	 */
	public LoanCustBaseInfo getById(String loanCustBaseInfoId) throws Exception;
	
	/**
	 * 编辑贷款客户基本信息
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param loanCustBaseInfo 贷款客户基本信息
	 * @return
	 * @throws Exception
	 */
	public BusinessMap edit(LoanCustBaseInfo loanCustBaseInfo) throws Exception;
	
	/**
	 * 根据ID删除贷款客户基本信息
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param loanCustBaseInfoId
	 * @return
	 * @throws Exception
	 */
	public boolean delete(String loanCustBaseInfoId) throws Exception;
	

}
