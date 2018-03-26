/*
 * InvstAcctRegService.java created on 2016-06-12 上午 09:37:58 by roilatD
 */
package com.p2p.invst.service;

import com.p2p.invst.entity.InvstAcctReg;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Pager;

/**
 * 投资登记薄 Service 接口
 * TODO javadoc for com.p2p.invst.service.InvstAcctRegService
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-06-12
 */
public interface InvstAcctRegService {
	
	/**
	 * 获取查询分页对象
	 * @creator: roilatD
	 * @createDate: 2016-06-12
	 * @modifier:
	 * @modifiedDate:
	 * @param pager
	 * @param invstAcctReg
	 * @return
	 * @throws Exception
	 */
	public Pager search(Pager pager, InvstAcctReg invstAcctReg) throws Exception;
	
	/**
	 * 新增投资登记薄
	 * @creator: roilatD
	 * @createDate: 2016-06-12
	 * @modifier:
	 * @modifiedDate:
	 * @param invstAcctReg
	 * @return
	 * @throws Exception
	 */
	public BusinessMap create(InvstAcctReg invstAcctReg) throws Exception;
	
	/**
	 * 判断是否存在
	 * @creator: roilatD
	 * @createDate: 2016-06-12
	 * @modifier:
	 * @modifiedDate:
	 * @param invstAcctReg 投资登记薄
	 * @return
	 * @throws Exception
	 */
	public boolean isExists(InvstAcctReg invstAcctReg) throws Exception;
	
	/**
	 * 根据ID获取投资登记薄
	 * @creator: roilatD
	 * @createDate: 2016-06-12
	 * @modifier:
	 * @modifiedDate:
	 * @param invstAcctRegId
	 * @return
	 * @throws Exception
	 */
	public InvstAcctReg getById(String invstAcctRegId) throws Exception;
	
	/**
	 * 编辑投资登记薄
	 * @creator: roilatD
	 * @createDate: 2016-06-12
	 * @modifier:
	 * @modifiedDate:
	 * @param invstAcctReg 投资登记薄
	 * @return
	 * @throws Exception
	 */
	public BusinessMap edit(InvstAcctReg invstAcctReg) throws Exception;
	
	/**
	 * 根据ID删除投资登记薄
	 * @creator: roilatD
	 * @createDate: 2016-06-12
	 * @modifier:
	 * @modifiedDate:
	 * @param invstAcctRegId
	 * @return
	 * @throws Exception
	 */
	public boolean delete(String invstAcctRegId) throws Exception;
	

}
