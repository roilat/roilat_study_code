/*
 * BizTypeService.java created on 2016-08-17 下午 16:19:39 by roilatD
 */
package com.hansy.dataservice.busi.service;

import com.hansy.dataservice.busi.entity.BizType;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Pager;

/**
 * 业务参数类型设置 Service 接口
 * TODO javadoc for com.hansy.dataservice.busi.service.BizTypeService
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-08-17
 */
public interface BizTypeService {
	
	/**
	 * 获取查询分页对象
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param pager
	 * @param bizType
	 * @return
	 * @throws Exception
	 */
	public Pager search(Pager pager, BizType bizType) throws Exception;
	
	/**
	 * 新增业务参数类型设置
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param bizType
	 * @return
	 * @throws Exception
	 */
	public BusinessMap create(BizType bizType) throws Exception;
	
	/**
	 * 判断是否存在
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param bizType 业务参数类型设置
	 * @return
	 * @throws Exception
	 */
	public boolean isExists(BizType bizType) throws Exception;
	
	/**
	 * 根据ID获取业务参数类型设置
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param bizTypeId
	 * @return
	 * @throws Exception
	 */
	public BizType getById(String bizTypeId) throws Exception;
	
	/**
	 * 编辑业务参数类型设置
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param bizType 业务参数类型设置
	 * @return
	 * @throws Exception
	 */
	public BusinessMap edit(BizType bizType) throws Exception;
	
	/**
	 * 根据ID删除业务参数类型设置
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param bizTypeId
	 * @return
	 * @throws Exception
	 */
	public boolean delete(String bizTypeId) throws Exception;
	

}
