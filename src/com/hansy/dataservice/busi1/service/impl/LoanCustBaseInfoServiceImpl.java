/*
 * LoanCustBaseInfoServiceImpl.java created on 2016-08-17 下午 16:20:39 by roilatD
 */
package com.hansy.dataservice.busi1.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import com.hansy.dataservice.busi1.entity.LoanCustBaseInfo;
import com.hansy.dataservice.busi1.service.LoanCustBaseInfoService;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Constants;
import org.eking.framework.common.Pager;
import org.eking.framework.dao.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 贷款客户基本信息 Service 实现
 * TODO javadoc for com.hansy.dataservice.busi1.service.impl.LoanCustBaseInfoServiceImpl
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-08-17
 */
@Service("loanCustBaseInfoService")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class LoanCustBaseInfoServiceImpl implements LoanCustBaseInfoService {

	/**
	 * MyBatis 命名空间
	 */
	private final static String MAPPER_NAMESPACE = "com.hansy.dataservice.busi1.mappers.LoanCustBaseInfoMapper";

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Transactional
	@Override
	public BusinessMap create(LoanCustBaseInfo loanCustBaseInfo) throws Exception {
		BusinessMap bm = new BusinessMap();
		//if (this.isExists(loanCustBaseInfo)) {
		//	bm.put(Constants.WARNING_MSG, "该贷款客户基本信息名称已经存在");
		//	return bm;
		//}
		sqlSessionTemplate.insert(MAPPER_NAMESPACE + ".add", loanCustBaseInfo);
		return bm;
	}

	@Override
	public boolean isExists(LoanCustBaseInfo loanCustBaseInfo) throws Exception {
		return (Integer)sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".isExists", loanCustBaseInfo) > 0;
	}
	
	@Override
	public LoanCustBaseInfo getById(String loanCustBaseInfoId) throws Exception {
		return sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".getById", loanCustBaseInfoId);
	}
	
	@Transactional
	@Override
	public BusinessMap edit(LoanCustBaseInfo loanCustBaseInfo) throws Exception {
		BusinessMap bm = new BusinessMap();
		//if (this.isExists(loanCustBaseInfo)) {
		//	bm.put(Constants.WARNING_MSG, "该贷款客户基本信息名称已经存在");
		//	return bm;
		//}
		sqlSessionTemplate.update(MAPPER_NAMESPACE + ".edit", loanCustBaseInfo);
		return bm;
	}

	@Transactional
	@Override
	public boolean delete(String loanCustBaseInfoId) throws Exception {
		sqlSessionTemplate.delete(MAPPER_NAMESPACE + ".deleteById", loanCustBaseInfoId);
		return true;
	}

	@Override
	public Pager search(Pager pager, LoanCustBaseInfo loanCustBaseInfo) throws Exception {
		List dataList = sqlSessionTemplate.selectList(MAPPER_NAMESPACE + ".page", loanCustBaseInfo, new RowBounds((pager.getCurrentPage() - 1) * pager.getLimit(), pager.getLimit()));
		pager.setDataList(dataList);
		
		Long total = sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".getTotal", loanCustBaseInfo);
		pager.setTotal(total);
		return pager;
	}

}
