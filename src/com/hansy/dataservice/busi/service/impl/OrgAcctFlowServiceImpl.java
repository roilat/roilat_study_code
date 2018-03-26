/*
 * OrgAcctFlowServiceImpl.java created on 2016-08-17 下午 16:16:02 by roilatD
 */
package com.hansy.dataservice.busi.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import com.hansy.dataservice.busi.entity.OrgAcctFlow;
import com.hansy.dataservice.busi.service.OrgAcctFlowService;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Constants;
import org.eking.framework.common.Pager;
import org.eking.framework.dao.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 查询机构台账 Service 实现
 * TODO javadoc for com.hansy.dataservice.busi.service.impl.OrgAcctFlowServiceImpl
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-08-17
 */
@Service("orgAcctFlowService")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class OrgAcctFlowServiceImpl implements OrgAcctFlowService {

	/**
	 * MyBatis 命名空间
	 */
	private final static String MAPPER_NAMESPACE = "com.hansy.dataservice.busi.mappers.OrgAcctFlowMapper";

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Transactional
	@Override
	public BusinessMap create(OrgAcctFlow orgAcctFlow) throws Exception {
		BusinessMap bm = new BusinessMap();
		//if (this.isExists(orgAcctFlow)) {
		//	bm.put(Constants.WARNING_MSG, "该查询机构台账名称已经存在");
		//	return bm;
		//}
		sqlSessionTemplate.insert(MAPPER_NAMESPACE + ".add", orgAcctFlow);
		return bm;
	}

	@Override
	public boolean isExists(OrgAcctFlow orgAcctFlow) throws Exception {
		return (Integer)sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".isExists", orgAcctFlow) > 0;
	}
	
	@Override
	public OrgAcctFlow getById(String orgAcctFlowId) throws Exception {
		return sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".getById", orgAcctFlowId);
	}
	
	@Transactional
	@Override
	public BusinessMap edit(OrgAcctFlow orgAcctFlow) throws Exception {
		BusinessMap bm = new BusinessMap();
		//if (this.isExists(orgAcctFlow)) {
		//	bm.put(Constants.WARNING_MSG, "该查询机构台账名称已经存在");
		//	return bm;
		//}
		sqlSessionTemplate.update(MAPPER_NAMESPACE + ".edit", orgAcctFlow);
		return bm;
	}

	@Transactional
	@Override
	public boolean delete(String orgAcctFlowId) throws Exception {
		sqlSessionTemplate.delete(MAPPER_NAMESPACE + ".deleteById", orgAcctFlowId);
		return true;
	}

	@Override
	public Pager search(Pager pager, OrgAcctFlow orgAcctFlow) throws Exception {
		List dataList = sqlSessionTemplate.selectList(MAPPER_NAMESPACE + ".page", orgAcctFlow, new RowBounds((pager.getCurrentPage() - 1) * pager.getLimit(), pager.getLimit()));
		pager.setDataList(dataList);
		
		Long total = sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".getTotal", orgAcctFlow);
		pager.setTotal(total);
		return pager;
	}

}
