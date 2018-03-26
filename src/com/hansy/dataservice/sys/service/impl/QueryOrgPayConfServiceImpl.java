/*
 * QueryOrgPayConfServiceImpl.java created on 2016-08-24 上午 10:27:38 by roilatD
 */
package com.hansy.dataservice.sys.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import com.hansy.dataservice.sys.entity.QueryOrgPayConf;
import com.hansy.dataservice.sys.service.QueryOrgPayConfService;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Constants;
import org.eking.framework.common.Pager;
import org.eking.framework.dao.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 查询机构收费配置 Service 实现
 * TODO javadoc for com.hansy.dataservice.sys.service.impl.QueryOrgPayConfServiceImpl
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-08-24
 */
@Service("queryOrgPayConfService")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class QueryOrgPayConfServiceImpl implements QueryOrgPayConfService {

	/**
	 * MyBatis 命名空间
	 */
	private final static String MAPPER_NAMESPACE = "com.hansy.dataservice.sys.mappers.QueryOrgPayConfMapper";

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Transactional
	@Override
	public BusinessMap create(QueryOrgPayConf queryOrgPayConf) throws Exception {
		BusinessMap bm = new BusinessMap();
		//if (this.isExists(queryOrgPayConf)) {
		//	bm.put(Constants.WARNING_MSG, "该查询机构收费配置名称已经存在");
		//	return bm;
		//}
		sqlSessionTemplate.insert(MAPPER_NAMESPACE + ".add", queryOrgPayConf);
		return bm;
	}

	@Override
	public boolean isExists(QueryOrgPayConf queryOrgPayConf) throws Exception {
		return (Integer)sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".isExists", queryOrgPayConf) > 0;
	}
	
	@Override
	public QueryOrgPayConf getById(String queryOrgPayConfId) throws Exception {
		return sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".getById", queryOrgPayConfId);
	}
	
	@Transactional
	@Override
	public BusinessMap edit(QueryOrgPayConf queryOrgPayConf) throws Exception {
		BusinessMap bm = new BusinessMap();
		//if (this.isExists(queryOrgPayConf)) {
		//	bm.put(Constants.WARNING_MSG, "该查询机构收费配置名称已经存在");
		//	return bm;
		//}
		sqlSessionTemplate.update(MAPPER_NAMESPACE + ".edit", queryOrgPayConf);
		return bm;
	}

	@Transactional
	@Override
	public boolean delete(String queryOrgPayConfId) throws Exception {
		sqlSessionTemplate.delete(MAPPER_NAMESPACE + ".deleteById", queryOrgPayConfId);
		return true;
	}

	@Override
	public Pager search(Pager pager, QueryOrgPayConf queryOrgPayConf) throws Exception {
		List dataList = sqlSessionTemplate.selectList(MAPPER_NAMESPACE + ".page", queryOrgPayConf, new RowBounds((pager.getCurrentPage() - 1) * pager.getLimit(), pager.getLimit()));
		pager.setDataList(dataList);
		
		Long total = sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".getTotal", queryOrgPayConf);
		pager.setTotal(total);
		return pager;
	}

}
