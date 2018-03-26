/*
 * MarBlackListService.java created on 2016-08-18 下午 14:03:52 by roilatD
 */
package com.hansy.dataservice.busi1.service;

import com.hansy.dataservice.busi1.entity.MarBlackList;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Pager;

/**
 * 商户黑名单 Service 接口
 * TODO javadoc for com.hansy.dataservice.busi1.service.MarBlackListService
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-08-18
 */
public interface MarBlackListService {
	
	/**
	 * 获取查询分页对象
	 * @creator: roilatD
	 * @createDate: 2016-08-18
	 * @modifier:
	 * @modifiedDate:
	 * @param pager
	 * @param marBlackList
	 * @return
	 * @throws Exception
	 */
	public Pager search(Pager pager, MarBlackList marBlackList) throws Exception;
	
	/**
	 * 新增商户黑名单
	 * @creator: roilatD
	 * @createDate: 2016-08-18
	 * @modifier:
	 * @modifiedDate:
	 * @param marBlackList
	 * @return
	 * @throws Exception
	 */
	public BusinessMap create(MarBlackList marBlackList) throws Exception;
	
	/**
	 * 判断是否存在
	 * @creator: roilatD
	 * @createDate: 2016-08-18
	 * @modifier:
	 * @modifiedDate:
	 * @param marBlackList 商户黑名单
	 * @return
	 * @throws Exception
	 */
	public boolean isExists(MarBlackList marBlackList) throws Exception;
	
	/**
	 * 根据ID获取商户黑名单
	 * @creator: roilatD
	 * @createDate: 2016-08-18
	 * @modifier:
	 * @modifiedDate:
	 * @param marBlackListId
	 * @return
	 * @throws Exception
	 */
	public MarBlackList getById(String marBlackListId) throws Exception;
	
	/**
	 * 编辑商户黑名单
	 * @creator: roilatD
	 * @createDate: 2016-08-18
	 * @modifier:
	 * @modifiedDate:
	 * @param marBlackList 商户黑名单
	 * @return
	 * @throws Exception
	 */
	public BusinessMap edit(MarBlackList marBlackList) throws Exception;
	
	/**
	 * 根据ID删除商户黑名单
	 * @creator: roilatD
	 * @createDate: 2016-08-18
	 * @modifier:
	 * @modifiedDate:
	 * @param marBlackListId
	 * @return
	 * @throws Exception
	 */
	public boolean delete(String marBlackListId) throws Exception;
	

}
