/*
 * PubDebtService.java created on 2016-06-21 下午 16:14:33 by roilatD
 */
package com.p2p.user.service;

import com.p2p.user.entity.PubDebt;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Pager;

/**
 * 债权信息 Service 接口
 * TODO javadoc for com.p2p.user.service.PubDebtService
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-06-21
 */
public interface PubDebtService {
	
	/**
	 * 获取查询分页对象
	 * @creator: roilatD
	 * @createDate: 2016-06-21
	 * @modifier:
	 * @modifiedDate:
	 * @param pager
	 * @param pubDebt
	 * @return
	 * @throws Exception
	 */
	public Pager search(Pager pager, PubDebt pubDebt) throws Exception;
	
	/**
	 * 新增债权信息
	 * @creator: roilatD
	 * @createDate: 2016-06-21
	 * @modifier:
	 * @modifiedDate:
	 * @param pubDebt
	 * @return
	 * @throws Exception
	 */
	public BusinessMap create(PubDebt pubDebt) throws Exception;
	
	/**
	 * 判断是否存在
	 * @creator: roilatD
	 * @createDate: 2016-06-21
	 * @modifier:
	 * @modifiedDate:
	 * @param pubDebt 债权信息
	 * @return
	 * @throws Exception
	 */
	public boolean isExists(PubDebt pubDebt) throws Exception;
	
	/**
	 * 根据ID获取债权信息
	 * @creator: roilatD
	 * @createDate: 2016-06-21
	 * @modifier:
	 * @modifiedDate:
	 * @param pubDebtId
	 * @return
	 * @throws Exception
	 */
	public PubDebt getById(String pubDebtId) throws Exception;
	
	/**
	 * 编辑债权信息
	 * @creator: roilatD
	 * @createDate: 2016-06-21
	 * @modifier:
	 * @modifiedDate:
	 * @param pubDebt 债权信息
	 * @return
	 * @throws Exception
	 */
	public BusinessMap edit(PubDebt pubDebt) throws Exception;
	
	/**
	 * 根据ID删除债权信息
	 * @creator: roilatD
	 * @createDate: 2016-06-21
	 * @modifier:
	 * @modifiedDate:
	 * @param pubDebtId
	 * @return
	 * @throws Exception
	 */
	public boolean delete(String pubDebtId) throws Exception;
	

}
