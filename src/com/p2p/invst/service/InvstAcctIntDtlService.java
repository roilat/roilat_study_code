/*
 * InvstAcctIntDtlService.java created on 2016-06-12 上午 09:38:21 by roilatD
 */
package com.p2p.invst.service;

import com.p2p.invst.entity.InvstAcctIntDtl;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Pager;

/**
 * 投资预期收益表 Service 接口
 * TODO javadoc for com.p2p.invst.service.InvstAcctIntDtlService
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-06-12
 */
public interface InvstAcctIntDtlService {
	
	/**
	 * 获取查询分页对象
	 * @creator: roilatD
	 * @createDate: 2016-06-12
	 * @modifier:
	 * @modifiedDate:
	 * @param pager
	 * @param invstAcctIntDtl
	 * @return
	 * @throws Exception
	 */
	public Pager search(Pager pager, InvstAcctIntDtl invstAcctIntDtl) throws Exception;
	
	/**
	 * 新增投资预期收益表
	 * @creator: roilatD
	 * @createDate: 2016-06-12
	 * @modifier:
	 * @modifiedDate:
	 * @param invstAcctIntDtl
	 * @return
	 * @throws Exception
	 */
	public BusinessMap create(InvstAcctIntDtl invstAcctIntDtl) throws Exception;
	
	/**
	 * 判断是否存在
	 * @creator: roilatD
	 * @createDate: 2016-06-12
	 * @modifier:
	 * @modifiedDate:
	 * @param invstAcctIntDtl 投资预期收益表
	 * @return
	 * @throws Exception
	 */
	public boolean isExists(InvstAcctIntDtl invstAcctIntDtl) throws Exception;
	
	/**
	 * 根据ID获取投资预期收益表
	 * @creator: roilatD
	 * @createDate: 2016-06-12
	 * @modifier:
	 * @modifiedDate:
	 * @param invstAcctIntDtlId
	 * @return
	 * @throws Exception
	 */
	public InvstAcctIntDtl getById(String invstAcctIntDtlId) throws Exception;
	
	/**
	 * 编辑投资预期收益表
	 * @creator: roilatD
	 * @createDate: 2016-06-12
	 * @modifier:
	 * @modifiedDate:
	 * @param invstAcctIntDtl 投资预期收益表
	 * @return
	 * @throws Exception
	 */
	public BusinessMap edit(InvstAcctIntDtl invstAcctIntDtl) throws Exception;
	
	/**
	 * 根据ID删除投资预期收益表
	 * @creator: roilatD
	 * @createDate: 2016-06-12
	 * @modifier:
	 * @modifiedDate:
	 * @param invstAcctIntDtlId
	 * @return
	 * @throws Exception
	 */
	public boolean delete(String invstAcctIntDtlId) throws Exception;
	

}
