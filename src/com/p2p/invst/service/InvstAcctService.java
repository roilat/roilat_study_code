/*
 * InvstAcctService.java created on 2016-06-06 下午 16:57:33 by roilatD
 */
package com.p2p.invst.service;

import com.p2p.invst.entity.InvstAcct;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Pager;

/**
 * 投资人信息表 Service 接口
 * TODO javadoc for com.p2p.invst.service.InvstAcctService
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-06-06
 */
public interface InvstAcctService {
	
	/**
	 * 获取查询分页对象
	 * @creator: roilatD
	 * @createDate: 2016-06-06
	 * @modifier:
	 * @modifiedDate:
	 * @param pager
	 * @param invstAcct
	 * @return
	 * @throws Exception
	 */
	public Pager search(Pager pager, InvstAcct invstAcct) throws Exception;
	
	/**
	 * 新增投资人信息表
	 * @creator: roilatD
	 * @createDate: 2016-06-06
	 * @modifier:
	 * @modifiedDate:
	 * @param invstAcct
	 * @return
	 * @throws Exception
	 */
	public BusinessMap create(InvstAcct invstAcct) throws Exception;
	
	/**
	 * 判断是否存在
	 * @creator: roilatD
	 * @createDate: 2016-06-06
	 * @modifier:
	 * @modifiedDate:
	 * @param invstAcct 投资人信息表
	 * @return
	 * @throws Exception
	 */
	public boolean isExists(InvstAcct invstAcct) throws Exception;
	
	/**
	 * 根据ID获取投资人信息表
	 * @creator: roilatD
	 * @createDate: 2016-06-06
	 * @modifier:
	 * @modifiedDate:
	 * @param invstAcctId
	 * @return
	 * @throws Exception
	 */
	public InvstAcct getById(String invstAcctId) throws Exception;
	
	/**
	 * 编辑投资人信息表
	 * @creator: roilatD
	 * @createDate: 2016-06-06
	 * @modifier:
	 * @modifiedDate:
	 * @param invstAcct 投资人信息表
	 * @return
	 * @throws Exception
	 */
	public BusinessMap edit(InvstAcct invstAcct) throws Exception;
	
	/**
	 * 根据ID删除投资人信息表
	 * @creator: roilatD
	 * @createDate: 2016-06-06
	 * @modifier:
	 * @modifiedDate:
	 * @param invstAcctId
	 * @return
	 * @throws Exception
	 */
	public boolean delete(String invstAcctId) throws Exception;
	

}
