/*
 * QueryOrgRegistService.java created on 2016-08-17 下午 16:11:54 by roilatD
 */
package com.hansy.dataservice.busi.service;

import com.hansy.dataservice.busi.entity.QueryOrgRegist;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Pager;

/**
 * 查询机构登记 Service 接口
 * TODO javadoc for com.hansy.dataservice.busi.service.QueryOrgRegistService
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-08-17
 */
public interface QueryOrgRegistService {
	
	/**
	 * 获取查询分页对象
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param pager
	 * @param queryOrgRegist
	 * @return
	 * @throws Exception
	 */
	public Pager search(Pager pager, QueryOrgRegist queryOrgRegist) throws Exception;
	
	/**
	 * 新增查询机构登记
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param queryOrgRegist
	 * @return
	 * @throws Exception
	 */
	public BusinessMap create(QueryOrgRegist queryOrgRegist) throws Exception;
	
	/**
	 * 判断是否存在
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param queryOrgRegist 查询机构登记
	 * @return
	 * @throws Exception
	 */
	public boolean isExists(QueryOrgRegist queryOrgRegist) throws Exception;
	
	/**
	 * 根据ID获取查询机构登记
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param queryOrgRegistId
	 * @return
	 * @throws Exception
	 */
	public QueryOrgRegist getById(String queryOrgRegistId) throws Exception;
	
	/**
	 * 编辑查询机构登记
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param queryOrgRegist 查询机构登记
	 * @return
	 * @throws Exception
	 */
	public BusinessMap edit(QueryOrgRegist queryOrgRegist) throws Exception;
	
	/**
	 * 根据ID删除查询机构登记
	 * @creator: roilatD
	 * @createDate: 2016-08-17
	 * @modifier:
	 * @modifiedDate:
	 * @param queryOrgRegistId
	 * @return
	 * @throws Exception
	 */
	public boolean delete(String queryOrgRegistId) throws Exception;
	

}
