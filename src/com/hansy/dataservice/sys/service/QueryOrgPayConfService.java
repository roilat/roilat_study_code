/*
 * QueryOrgPayConfService.java created on 2016-08-24 上午 10:27:38 by roilatD
 */
package com.hansy.dataservice.sys.service;

import com.hansy.dataservice.sys.entity.QueryOrgPayConf;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Pager;

/**
 * 查询机构收费配置 Service 接口
 * TODO javadoc for com.hansy.dataservice.sys.service.QueryOrgPayConfService
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-08-24
 */
public interface QueryOrgPayConfService {
	
	/**
	 * 获取查询分页对象
	 * @creator: roilatD
	 * @createDate: 2016-08-24
	 * @modifier:
	 * @modifiedDate:
	 * @param pager
	 * @param queryOrgPayConf
	 * @return
	 * @throws Exception
	 */
	public Pager search(Pager pager, QueryOrgPayConf queryOrgPayConf) throws Exception;
	
	/**
	 * 新增查询机构收费配置
	 * @creator: roilatD
	 * @createDate: 2016-08-24
	 * @modifier:
	 * @modifiedDate:
	 * @param queryOrgPayConf
	 * @return
	 * @throws Exception
	 */
	public BusinessMap create(QueryOrgPayConf queryOrgPayConf) throws Exception;
	
	/**
	 * 判断是否存在
	 * @creator: roilatD
	 * @createDate: 2016-08-24
	 * @modifier:
	 * @modifiedDate:
	 * @param queryOrgPayConf 查询机构收费配置
	 * @return
	 * @throws Exception
	 */
	public boolean isExists(QueryOrgPayConf queryOrgPayConf) throws Exception;
	
	/**
	 * 根据ID获取查询机构收费配置
	 * @creator: roilatD
	 * @createDate: 2016-08-24
	 * @modifier:
	 * @modifiedDate:
	 * @param queryOrgPayConfId
	 * @return
	 * @throws Exception
	 */
	public QueryOrgPayConf getById(String queryOrgPayConfId) throws Exception;
	
	/**
	 * 编辑查询机构收费配置
	 * @creator: roilatD
	 * @createDate: 2016-08-24
	 * @modifier:
	 * @modifiedDate:
	 * @param queryOrgPayConf 查询机构收费配置
	 * @return
	 * @throws Exception
	 */
	public BusinessMap edit(QueryOrgPayConf queryOrgPayConf) throws Exception;
	
	/**
	 * 根据ID删除查询机构收费配置
	 * @creator: roilatD
	 * @createDate: 2016-08-24
	 * @modifier:
	 * @modifiedDate:
	 * @param queryOrgPayConfId
	 * @return
	 * @throws Exception
	 */
	public boolean delete(String queryOrgPayConfId) throws Exception;
	

}
