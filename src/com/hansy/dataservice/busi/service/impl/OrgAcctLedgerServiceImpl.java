/*
 * OrgAcctLedgerServiceImpl.java created on 2016-08-17 下午 16:17:44 by roilatD
 */
package com.hansy.dataservice.busi.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import com.hansy.dataservice.busi.entity.OrgAcctLedger;
import com.hansy.dataservice.busi.service.OrgAcctLedgerService;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Constants;
import org.eking.framework.common.Pager;
import org.eking.framework.dao.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 查询机构充值台账 Service 实现
 * TODO javadoc for com.hansy.dataservice.busi.service.impl.OrgAcctLedgerServiceImpl
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-08-17
 */
@Service("orgAcctLedgerService")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class OrgAcctLedgerServiceImpl implements OrgAcctLedgerService {

	/**
	 * MyBatis 命名空间
	 */
	private final static String MAPPER_NAMESPACE = "com.hansy.dataservice.busi.mappers.OrgAcctLedgerMapper";

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Transactional
	@Override
	public BusinessMap create(OrgAcctLedger orgAcctLedger) throws Exception {
		BusinessMap bm = new BusinessMap();
		//if (this.isExists(orgAcctLedger)) {
		//	bm.put(Constants.WARNING_MSG, "该查询机构充值台账名称已经存在");
		//	return bm;
		//}
		sqlSessionTemplate.insert(MAPPER_NAMESPACE + ".add", orgAcctLedger);
		return bm;
	}

	@Override
	public boolean isExists(OrgAcctLedger orgAcctLedger) throws Exception {
		return (Integer)sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".isExists", orgAcctLedger) > 0;
	}
	
	@Override
	public OrgAcctLedger getById(String orgAcctLedgerId) throws Exception {
		return sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".getById", orgAcctLedgerId);
	}
	
	@Transactional
	@Override
	public BusinessMap edit(OrgAcctLedger orgAcctLedger) throws Exception {
		BusinessMap bm = new BusinessMap();
		//if (this.isExists(orgAcctLedger)) {
		//	bm.put(Constants.WARNING_MSG, "该查询机构充值台账名称已经存在");
		//	return bm;
		//}
		sqlSessionTemplate.update(MAPPER_NAMESPACE + ".edit", orgAcctLedger);
		return bm;
	}

	@Transactional
	@Override
	public boolean delete(String orgAcctLedgerId) throws Exception {
		sqlSessionTemplate.delete(MAPPER_NAMESPACE + ".deleteById", orgAcctLedgerId);
		return true;
	}

	@Override
	public Pager search(Pager pager, OrgAcctLedger orgAcctLedger) throws Exception {
		List dataList = sqlSessionTemplate.selectList(MAPPER_NAMESPACE + ".page", orgAcctLedger, new RowBounds((pager.getCurrentPage() - 1) * pager.getLimit(), pager.getLimit()));
		pager.setDataList(dataList);
		
		Long total = sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".getTotal", orgAcctLedger);
		pager.setTotal(total);
		return pager;
	}

}
