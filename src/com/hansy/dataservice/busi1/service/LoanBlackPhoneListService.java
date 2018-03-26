/*
 * LoanBlackPhoneListService.java created on 2016-08-17 下午 16:21:38 by roilatD
 */
package com.hansy.dataservice.busi1.service;

import com.hansy.dataservice.busi1.entity.LoanBlackPhoneList;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Pager;

/**
 * 电话黑名单 Service 接口
 * TODO javadoc for com.hansy.dataservice.busi1.service.LoanBlackPhoneListService
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-08-17
 */
public interface LoanBlackPhoneListService {
	
	/**
	 * 获取查询分页对象
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param pager
	 * @param loanBlackPhoneList
	 * @return
	 * @throws Exception
	 */
	public Pager search(Pager pager, LoanBlackPhoneList loanBlackPhoneList) throws Exception;
	
	/**
	 * 新增电话黑名单
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param loanBlackPhoneList
	 * @return
	 * @throws Exception
	 */
	public BusinessMap create(LoanBlackPhoneList loanBlackPhoneList) throws Exception;
	
	/**
	 * 判断是否存在
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param loanBlackPhoneList 电话黑名单
	 * @return
	 * @throws Exception
	 */
	public boolean isExists(LoanBlackPhoneList loanBlackPhoneList) throws Exception;
	
	/**
	 * 根据ID获取电话黑名单
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param loanBlackPhoneListId
	 * @return
	 * @throws Exception
	 */
	public LoanBlackPhoneList getById(String loanBlackPhoneListId) throws Exception;
	
	/**
	 * 编辑电话黑名单
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param loanBlackPhoneList 电话黑名单
	 * @return
	 * @throws Exception
	 */
	public BusinessMap edit(LoanBlackPhoneList loanBlackPhoneList) throws Exception;
	
	/**
	 * 根据ID删除电话黑名单
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param loanBlackPhoneListId
	 * @return
	 * @throws Exception
	 */
	public boolean delete(String loanBlackPhoneListId) throws Exception;
	

}
