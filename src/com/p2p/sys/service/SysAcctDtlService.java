/*
 * SysAcctDtlService.java created on 2016-07-02 下午 15:59:30 by roilatD
 */
package com.p2p.sys.service;

import com.p2p.sys.entity.SysAcctDtl;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Pager;

/**
 * 内部账交易明细 Service 接口
 * TODO javadoc for com.p2p.sys.service.SysAcctDtlService
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-07-02
 */
public interface SysAcctDtlService {
	
	/**
	 * 获取查询分页对象
	 * @creator: roilatD
	 * @createDate: 2016-07-02
	 * @modifier:
	 * @modifiedDate:
	 * @param pager
	 * @param sysAcctDtl
	 * @return
	 * @throws Exception
	 */
	public Pager search(Pager pager, SysAcctDtl sysAcctDtl) throws Exception;
	
	/**
	 * 新增内部账交易明细
	 * @creator: roilatD
	 * @createDate: 2016-07-02
	 * @modifier:
	 * @modifiedDate:
	 * @param sysAcctDtl
	 * @return
	 * @throws Exception
	 */
	public BusinessMap create(SysAcctDtl sysAcctDtl) throws Exception;
	
	/**
	 * 判断是否存在
	 * @creator: roilatD
	 * @createDate: 2016-07-02
	 * @modifier:
	 * @modifiedDate:
	 * @param sysAcctDtl 内部账交易明细
	 * @return
	 * @throws Exception
	 */
	public boolean isExists(SysAcctDtl sysAcctDtl) throws Exception;
	
	/**
	 * 根据ID获取内部账交易明细
	 * @creator: roilatD
	 * @createDate: 2016-07-02
	 * @modifier:
	 * @modifiedDate:
	 * @param sysAcctDtlId
	 * @return
	 * @throws Exception
	 */
	public SysAcctDtl getById(String sysAcctDtlId) throws Exception;
	
	/**
	 * 编辑内部账交易明细
	 * @creator: roilatD
	 * @createDate: 2016-07-02
	 * @modifier:
	 * @modifiedDate:
	 * @param sysAcctDtl 内部账交易明细
	 * @return
	 * @throws Exception
	 */
	public BusinessMap edit(SysAcctDtl sysAcctDtl) throws Exception;
	
	/**
	 * 根据ID删除内部账交易明细
	 * @creator: roilatD
	 * @createDate: 2016-07-02
	 * @modifier:
	 * @modifiedDate:
	 * @param sysAcctDtlId
	 * @return
	 * @throws Exception
	 */
	public boolean delete(String sysAcctDtlId) throws Exception;
	

}
