/*
 * LoanBlackListService.java created on 2016-08-17 下午 16:21:06 by roilatD
 */
package com.hansy.dataservice.busi1.service;

import com.hansy.dataservice.busi1.entity.LoanBlackList;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Pager;

/**
 * 黑名单表 Service 接口
 * TODO javadoc for com.hansy.dataservice.busi1.service.LoanBlackListService
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-08-17
 */
public interface LoanBlackListService {
	
	/**
	 * 获取查询分页对象
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param pager
	 * @param loanBlackList
	 * @return
	 * @throws Exception
	 */
	public Pager search(Pager pager, LoanBlackList loanBlackList) throws Exception;
	
	/**
	 * 新增黑名单表
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param loanBlackList
	 * @return
	 * @throws Exception
	 */
	public BusinessMap create(LoanBlackList loanBlackList) throws Exception;
	
	/**
	 * 判断是否存在
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param loanBlackList 黑名单表
	 * @return
	 * @throws Exception
	 */
	public boolean isExists(LoanBlackList loanBlackList) throws Exception;
	
	/**
	 * 根据ID获取黑名单表
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param loanBlackListId
	 * @return
	 * @throws Exception
	 */
	public LoanBlackList getById(String loanBlackListId) throws Exception;
	
	/**
	 * 编辑黑名单表
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param loanBlackList 黑名单表
	 * @return
	 * @throws Exception
	 */
	public BusinessMap edit(LoanBlackList loanBlackList) throws Exception;
	
	/**
	 * 根据ID删除黑名单表
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param loanBlackListId
	 * @return
	 * @throws Exception
	 */
	public boolean delete(String loanBlackListId) throws Exception;
	

}
