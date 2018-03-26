/*
 * ProdLoanRelServiceImpl.java created on 2016-06-12 上午 09:35:32 by roilatD
 */
package com.p2p.invst.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import com.p2p.invst.entity.ProdLoanRel;
import com.p2p.invst.service.ProdLoanRelService;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Constants;
import org.eking.framework.common.Pager;
import org.eking.framework.dao.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 产品与借款人关系表 Service 实现
 * TODO javadoc for com.p2p.invst.service.impl.ProdLoanRelServiceImpl
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-06-12
 */
@Service("prodLoanRelService")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class ProdLoanRelServiceImpl implements ProdLoanRelService {

	/**
	 * MyBatis 命名空间
	 */
	private final static String MAPPER_NAMESPACE = "com.p2p.invst.mappers.ProdLoanRelMapper";

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Transactional
	@Override
	public BusinessMap create(ProdLoanRel prodLoanRel) throws Exception {
		BusinessMap bm = new BusinessMap();
		//if (this.isExists(prodLoanRel)) {
		//	bm.put(Constants.WARNING_MSG, "该产品与借款人关系表名称已经存在");
		//	return bm;
		//}
		sqlSessionTemplate.insert(MAPPER_NAMESPACE + ".add", prodLoanRel);
		return bm;
	}

	@Override
	public boolean isExists(ProdLoanRel prodLoanRel) throws Exception {
		return (Integer)sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".isExists", prodLoanRel) > 0;
	}
	
	@Override
	public ProdLoanRel getById(String prodLoanRelId) throws Exception {
		return sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".getById", prodLoanRelId);
	}
	
	@Transactional
	@Override
	public BusinessMap edit(ProdLoanRel prodLoanRel) throws Exception {
		BusinessMap bm = new BusinessMap();
		//if (this.isExists(prodLoanRel)) {
		//	bm.put(Constants.WARNING_MSG, "该产品与借款人关系表名称已经存在");
		//	return bm;
		//}
		sqlSessionTemplate.update(MAPPER_NAMESPACE + ".edit", prodLoanRel);
		return bm;
	}

	@Transactional
	@Override
	public boolean delete(String prodLoanRelId) throws Exception {
		sqlSessionTemplate.delete(MAPPER_NAMESPACE + ".deleteById", prodLoanRelId);
		return true;
	}

	@Override
	public Pager search(Pager pager, ProdLoanRel prodLoanRel) throws Exception {
		List dataList = sqlSessionTemplate.selectList(MAPPER_NAMESPACE + ".page", prodLoanRel, new RowBounds((pager.getCurrentPage() - 1) * pager.getLimit(), pager.getLimit()));
		pager.setDataList(dataList);
		
		Long total = sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".getTotal", prodLoanRel);
		pager.setTotal(total);
		return pager;
	}

}
