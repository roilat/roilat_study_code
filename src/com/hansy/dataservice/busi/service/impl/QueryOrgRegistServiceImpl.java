/*
 * QueryOrgRegistServiceImpl.java created on 2016-08-17 下午 16:11:54 by roilatD
 */
package com.hansy.dataservice.busi.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import com.hansy.dataservice.busi.entity.QueryOrgRegist;
import com.hansy.dataservice.busi.service.QueryOrgRegistService;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Constants;
import org.eking.framework.common.Pager;
import org.eking.framework.dao.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 查询机构登记 Service 实现
 * TODO javadoc for com.hansy.dataservice.busi.service.impl.QueryOrgRegistServiceImpl
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-08-17
 */
@Service("queryOrgRegistService")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class QueryOrgRegistServiceImpl implements QueryOrgRegistService {

	/**
	 * MyBatis 命名空间
	 */
	private final static String MAPPER_NAMESPACE = "com.hansy.dataservice.busi.mappers.QueryOrgRegistMapper";

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Transactional
	@Override
	public BusinessMap create(QueryOrgRegist queryOrgRegist) throws Exception {
		BusinessMap bm = new BusinessMap();
		//if (this.isExists(queryOrgRegist)) {
		//	bm.put(Constants.WARNING_MSG, "该查询机构登记名称已经存在");
		//	return bm;
		//}
		sqlSessionTemplate.insert(MAPPER_NAMESPACE + ".add", queryOrgRegist);
		return bm;
	}

	@Override
	public boolean isExists(QueryOrgRegist queryOrgRegist) throws Exception {
		return (Integer)sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".isExists", queryOrgRegist) > 0;
	}
	
	@Override
	public QueryOrgRegist getById(String queryOrgRegistId) throws Exception {
		return sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".getById", queryOrgRegistId);
	}
	
	@Transactional
	@Override
	public BusinessMap edit(QueryOrgRegist queryOrgRegist) throws Exception {
		BusinessMap bm = new BusinessMap();
		//if (this.isExists(queryOrgRegist)) {
		//	bm.put(Constants.WARNING_MSG, "该查询机构登记名称已经存在");
		//	return bm;
		//}
		sqlSessionTemplate.update(MAPPER_NAMESPACE + ".edit", queryOrgRegist);
		return bm;
	}

	@Transactional
	@Override
	public boolean delete(String queryOrgRegistId) throws Exception {
		sqlSessionTemplate.delete(MAPPER_NAMESPACE + ".deleteById", queryOrgRegistId);
		return true;
	}

	@Override
	public Pager search(Pager pager, QueryOrgRegist queryOrgRegist) throws Exception {
		List dataList = sqlSessionTemplate.selectList(MAPPER_NAMESPACE + ".page", queryOrgRegist, new RowBounds((pager.getCurrentPage() - 1) * pager.getLimit(), pager.getLimit()));
		pager.setDataList(dataList);
		
		Long total = sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".getTotal", queryOrgRegist);
		pager.setTotal(total);
		return pager;
	}

}
