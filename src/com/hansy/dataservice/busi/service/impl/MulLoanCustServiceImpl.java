/*
 * MulLoanCustServiceImpl.java created on 2016-08-17 下午 16:14:14 by roilatD
 */
package com.hansy.dataservice.busi.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import com.hansy.dataservice.busi.entity.MulLoanCust;
import com.hansy.dataservice.busi.service.MulLoanCustService;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Constants;
import org.eking.framework.common.Pager;
import org.eking.framework.dao.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 多头借贷客户 Service 实现
 * TODO javadoc for com.hansy.dataservice.busi.service.impl.MulLoanCustServiceImpl
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-08-17
 */
@Service("mulLoanCustService")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class MulLoanCustServiceImpl implements MulLoanCustService {

	/**
	 * MyBatis 命名空间
	 */
	private final static String MAPPER_NAMESPACE = "com.hansy.dataservice.busi.mappers.MulLoanCustMapper";

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Transactional
	@Override
	public BusinessMap create(MulLoanCust mulLoanCust) throws Exception {
		BusinessMap bm = new BusinessMap();
		//if (this.isExists(mulLoanCust)) {
		//	bm.put(Constants.WARNING_MSG, "该多头借贷客户名称已经存在");
		//	return bm;
		//}
		sqlSessionTemplate.insert(MAPPER_NAMESPACE + ".add", mulLoanCust);
		return bm;
	}

	@Override
	public boolean isExists(MulLoanCust mulLoanCust) throws Exception {
		return (Integer)sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".isExists", mulLoanCust) > 0;
	}
	
	@Override
	public MulLoanCust getById(String mulLoanCustId) throws Exception {
		return sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".getById", mulLoanCustId);
	}
	
	@Transactional
	@Override
	public BusinessMap edit(MulLoanCust mulLoanCust) throws Exception {
		BusinessMap bm = new BusinessMap();
		//if (this.isExists(mulLoanCust)) {
		//	bm.put(Constants.WARNING_MSG, "该多头借贷客户名称已经存在");
		//	return bm;
		//}
		sqlSessionTemplate.update(MAPPER_NAMESPACE + ".edit", mulLoanCust);
		return bm;
	}

	@Transactional
	@Override
	public boolean delete(String mulLoanCustId) throws Exception {
		sqlSessionTemplate.delete(MAPPER_NAMESPACE + ".deleteById", mulLoanCustId);
		return true;
	}

	@Override
	public Pager search(Pager pager, MulLoanCust mulLoanCust) throws Exception {
		List dataList = sqlSessionTemplate.selectList(MAPPER_NAMESPACE + ".page", mulLoanCust, new RowBounds((pager.getCurrentPage() - 1) * pager.getLimit(), pager.getLimit()));
		pager.setDataList(dataList);
		
		Long total = sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".getTotal", mulLoanCust);
		pager.setTotal(total);
		return pager;
	}

}
