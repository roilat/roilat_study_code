/*
 * BusiCodeService.java created on 2016-08-17 下午 16:19:15 by roilatD
 */
package com.hansy.dataservice.busi.service;

import com.hansy.dataservice.busi.entity.BusiCode;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Pager;

/**
 * 业务参数设置 Service 接口
 * TODO javadoc for com.hansy.dataservice.busi.service.BusiCodeService
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-08-17
 */
public interface BusiCodeService {
	
	/**
	 * 获取查询分页对象
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param pager
	 * @param busiCode
	 * @return
	 * @throws Exception
	 */
	public Pager search(Pager pager, BusiCode busiCode) throws Exception;
	
	/**
	 * 新增业务参数设置
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param busiCode
	 * @return
	 * @throws Exception
	 */
	public BusinessMap create(BusiCode busiCode) throws Exception;
	
	/**
	 * 判断是否存在
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param busiCode 业务参数设置
	 * @return
	 * @throws Exception
	 */
	public boolean isExists(BusiCode busiCode) throws Exception;
	
	/**
	 * 根据ID获取业务参数设置
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param busiCodeId
	 * @return
	 * @throws Exception
	 */
	public BusiCode getById(String busiCodeId) throws Exception;
	
	/**
	 * 编辑业务参数设置
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param busiCode 业务参数设置
	 * @return
	 * @throws Exception
	 */
	public BusinessMap edit(BusiCode busiCode) throws Exception;
	
	/**
	 * 根据ID删除业务参数设置
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param busiCodeId
	 * @return
	 * @throws Exception
	 */
	public boolean delete(String busiCodeId) throws Exception;
	

}
