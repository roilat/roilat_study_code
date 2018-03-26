/*
 * InvstRechgWithdCashService.java created on 2016-05-31 下午 22:14:30 by roilatD
 */
package com.p2p.user.service;

import com.p2p.user.entity.InvstRechgWithdCash;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Pager;

/**
 * 充值提现记录 Service 接口
 * TODO javadoc for com.p2p.user.service.InvstRechgWithdCashService
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-05-31
 */
public interface InvstRechgWithdCashService {
	
	/**
	 * 获取查询分页对象
	 * @creator: roilatD
	 * @createDate: 2016-05-31
	 * @modifier:
	 * @modifiedDate:
	 * @param pager
	 * @param invstRechgWithdCash
	 * @return
	 * @throws Exception
	 */
	public Pager search(Pager pager, InvstRechgWithdCash invstRechgWithdCash) throws Exception;
	
	/**
	 * 新增充值提现记录
	 * @creator: roilatD
	 * @createDate: 2016-05-31
	 * @modifier:
	 * @modifiedDate:
	 * @param invstRechgWithdCash
	 * @return
	 * @throws Exception
	 */
	public BusinessMap create(InvstRechgWithdCash invstRechgWithdCash) throws Exception;
	
	/**
	 * 判断是否存在
	 * @creator: roilatD
	 * @createDate: 2016-05-31
	 * @modifier:
	 * @modifiedDate:
	 * @param invstRechgWithdCash 充值提现记录
	 * @return
	 * @throws Exception
	 */
	public boolean isExists(InvstRechgWithdCash invstRechgWithdCash) throws Exception;
	
	/**
	 * 根据ID获取充值提现记录
	 * @creator: roilatD
	 * @createDate: 2016-05-31
	 * @modifier:
	 * @modifiedDate:
	 * @param invstRechgWithdCashId
	 * @return
	 * @throws Exception
	 */
	public InvstRechgWithdCash getById(String invstRechgWithdCashId) throws Exception;
	
	/**
	 * 编辑充值提现记录
	 * @creator: roilatD
	 * @createDate: 2016-05-31
	 * @modifier:
	 * @modifiedDate:
	 * @param invstRechgWithdCash 充值提现记录
	 * @return
	 * @throws Exception
	 */
	public BusinessMap edit(InvstRechgWithdCash invstRechgWithdCash) throws Exception;
	
	/**
	 * 根据ID删除充值提现记录
	 * @creator: roilatD
	 * @createDate: 2016-05-31
	 * @modifier:
	 * @modifiedDate:
	 * @param invstRechgWithdCashId
	 * @return
	 * @throws Exception
	 */
	public boolean delete(String invstRechgWithdCashId) throws Exception;
	

}
