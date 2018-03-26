/*
 * InvstAcctDtlService.java created on 2016-07-02 下午 15:46:47 by roilatD
 */
package com.p2p.sys.service;

import com.p2p.sys.entity.InvstAcctDtl;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Pager;

/**
 * 投资交易明细 Service 接口
 * TODO javadoc for com.p2p.sys.service.InvstAcctDtlService
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-07-02
 */
public interface InvstAcctDtlService {
	
	/**
	 * 获取查询分页对象
	 * @creator: roilatD
	 * @createDate: 2016-07-02
	 * @modifier:
	 * @modifiedDate:
	 * @param pager
	 * @param invstAcctDtl
	 * @return
	 * @throws Exception
	 */
	public Pager search(Pager pager, InvstAcctDtl invstAcctDtl) throws Exception;
	
	/**
	 * 新增投资交易明细
	 * @creator: roilatD
	 * @createDate: 2016-07-02
	 * @modifier:
	 * @modifiedDate:
	 * @param invstAcctDtl
	 * @return
	 * @throws Exception
	 */
	public BusinessMap create(InvstAcctDtl invstAcctDtl) throws Exception;
	
	/**
	 * 判断是否存在
	 * @creator: roilatD
	 * @createDate: 2016-07-02
	 * @modifier:
	 * @modifiedDate:
	 * @param invstAcctDtl 投资交易明细
	 * @return
	 * @throws Exception
	 */
	public boolean isExists(InvstAcctDtl invstAcctDtl) throws Exception;
	
	/**
	 * 根据ID获取投资交易明细
	 * @creator: roilatD
	 * @createDate: 2016-07-02
	 * @modifier:
	 * @modifiedDate:
	 * @param invstAcctDtlId
	 * @return
	 * @throws Exception
	 */
	public InvstAcctDtl getById(String invstAcctDtlId) throws Exception;
	
	/**
	 * 编辑投资交易明细
	 * @creator: roilatD
	 * @createDate: 2016-07-02
	 * @modifier:
	 * @modifiedDate:
	 * @param invstAcctDtl 投资交易明细
	 * @return
	 * @throws Exception
	 */
	public BusinessMap edit(InvstAcctDtl invstAcctDtl) throws Exception;
	
	/**
	 * 根据ID删除投资交易明细
	 * @creator: roilatD
	 * @createDate: 2016-07-02
	 * @modifier:
	 * @modifiedDate:
	 * @param invstAcctDtlId
	 * @return
	 * @throws Exception
	 */
	public boolean delete(String invstAcctDtlId) throws Exception;
	

}
