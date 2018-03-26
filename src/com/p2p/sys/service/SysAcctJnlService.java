/*
 * SysAcctJnlService.java created on 2016-07-02 下午 15:44:47 by roilatD
 */
package com.p2p.sys.service;

import com.p2p.sys.entity.SysAcctJnl;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Pager;

/**
 * 会计分录流水 Service 接口
 * TODO javadoc for com.p2p.sys.service.SysAcctJnlService
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-07-02
 */
public interface SysAcctJnlService {
	
	/**
	 * 获取查询分页对象
	 * @creator: roilatD
	 * @createDate: 2016-07-02
	 * @modifier:
	 * @modifiedDate:
	 * @param pager
	 * @param sysAcctJnl
	 * @return
	 * @throws Exception
	 */
	public Pager search(Pager pager, SysAcctJnl sysAcctJnl) throws Exception;
	
	/**
	 * 新增会计分录流水
	 * @creator: roilatD
	 * @createDate: 2016-07-02
	 * @modifier:
	 * @modifiedDate:
	 * @param sysAcctJnl
	 * @return
	 * @throws Exception
	 */
	public BusinessMap create(SysAcctJnl sysAcctJnl) throws Exception;
	
	/**
	 * 判断是否存在
	 * @creator: roilatD
	 * @createDate: 2016-07-02
	 * @modifier:
	 * @modifiedDate:
	 * @param sysAcctJnl 会计分录流水
	 * @return
	 * @throws Exception
	 */
	public boolean isExists(SysAcctJnl sysAcctJnl) throws Exception;
	
	/**
	 * 根据ID获取会计分录流水
	 * @creator: roilatD
	 * @createDate: 2016-07-02
	 * @modifier:
	 * @modifiedDate:
	 * @param sysAcctJnlId
	 * @return
	 * @throws Exception
	 */
	public SysAcctJnl getById(String sysAcctJnlId) throws Exception;
	
	/**
	 * 编辑会计分录流水
	 * @creator: roilatD
	 * @createDate: 2016-07-02
	 * @modifier:
	 * @modifiedDate:
	 * @param sysAcctJnl 会计分录流水
	 * @return
	 * @throws Exception
	 */
	public BusinessMap edit(SysAcctJnl sysAcctJnl) throws Exception;
	
	/**
	 * 根据ID删除会计分录流水
	 * @creator: roilatD
	 * @createDate: 2016-07-02
	 * @modifier:
	 * @modifiedDate:
	 * @param sysAcctJnlId
	 * @return
	 * @throws Exception
	 */
	public boolean delete(String sysAcctJnlId) throws Exception;
	

}
