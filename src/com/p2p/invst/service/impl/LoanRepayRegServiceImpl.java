/*
 * LoanRepayRegServiceImpl.java created on 2016-06-24 下午 15:14:47 by roilatD
 */
package com.p2p.invst.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import com.p2p.invst.entity.LoanRepayReg;
import com.p2p.invst.service.LoanRepayRegService;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Constants;
import org.eking.framework.common.Pager;
import org.eking.framework.dao.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 还款记录 Service 实现
 * TODO javadoc for com.p2p.invst.service.impl.LoanRepayRegServiceImpl
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-06-24
 */
@Service("loanRepayRegService")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class LoanRepayRegServiceImpl implements LoanRepayRegService {

	/**
	 * MyBatis 命名空间
	 */
	private final static String MAPPER_NAMESPACE = "com.p2p.invst.mappers.LoanRepayRegMapper";

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Transactional
	@Override
	public BusinessMap create(LoanRepayReg loanRepayReg) throws Exception {
		BusinessMap bm = new BusinessMap();
		//if (this.isExists(loanRepayReg)) {
		//	bm.put(Constants.WARNING_MSG, "该还款记录名称已经存在");
		//	return bm;
		//}
		sqlSessionTemplate.insert(MAPPER_NAMESPACE + ".add", loanRepayReg);
		return bm;
	}

	@Override
	public boolean isExists(LoanRepayReg loanRepayReg) throws Exception {
		return (Integer)sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".isExists", loanRepayReg) > 0;
	}
	
	@Override
	public LoanRepayReg getById(String loanRepayRegId) throws Exception {
		return sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".getById", loanRepayRegId);
	}
	
	@Transactional
	@Override
	public BusinessMap edit(LoanRepayReg loanRepayReg) throws Exception {
		BusinessMap bm = new BusinessMap();
		//if (this.isExists(loanRepayReg)) {
		//	bm.put(Constants.WARNING_MSG, "该还款记录名称已经存在");
		//	return bm;
		//}
		sqlSessionTemplate.update(MAPPER_NAMESPACE + ".edit", loanRepayReg);
		return bm;
	}

	@Transactional
	@Override
	public boolean delete(String loanRepayRegId) throws Exception {
		sqlSessionTemplate.delete(MAPPER_NAMESPACE + ".deleteById", loanRepayRegId);
		return true;
	}

	@Override
	public Pager search(Pager pager, LoanRepayReg loanRepayReg) throws Exception {
		List dataList = sqlSessionTemplate.selectList(MAPPER_NAMESPACE + ".page", loanRepayReg, new RowBounds((pager.getCurrentPage() - 1) * pager.getLimit(), pager.getLimit()));
		pager.setDataList(dataList);
		
		Long total = sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".getTotal", loanRepayReg);
		pager.setTotal(total);
		return pager;
	}

}
