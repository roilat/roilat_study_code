/*
 * PubDebtServiceImpl.java created on 2016-06-21 下午 16:14:34 by roilatD
 */
package com.p2p.user.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import com.p2p.user.entity.PubDebt;
import com.p2p.user.service.PubDebtService;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Constants;
import org.eking.framework.common.Pager;
import org.eking.framework.dao.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 债权信息 Service 实现
 * TODO javadoc for com.p2p.user.service.impl.PubDebtServiceImpl
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-06-21
 */
@Service("pubDebtService")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class PubDebtServiceImpl implements PubDebtService {

	/**
	 * MyBatis 命名空间
	 */
	private final static String MAPPER_NAMESPACE = "com.p2p.user.mappers.PubDebtMapper";

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Transactional
	@Override
	public BusinessMap create(PubDebt pubDebt) throws Exception {
		BusinessMap bm = new BusinessMap();
		//if (this.isExists(pubDebt)) {
		//	bm.put(Constants.WARNING_MSG, "该债权信息名称已经存在");
		//	return bm;
		//}
		sqlSessionTemplate.insert(MAPPER_NAMESPACE + ".add", pubDebt);
		return bm;
	}

	@Override
	public boolean isExists(PubDebt pubDebt) throws Exception {
		return (Integer)sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".isExists", pubDebt) > 0;
	}
	
	@Override
	public PubDebt getById(String pubDebtId) throws Exception {
		return sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".getById", pubDebtId);
	}
	
	@Transactional
	@Override
	public BusinessMap edit(PubDebt pubDebt) throws Exception {
		BusinessMap bm = new BusinessMap();
		//if (this.isExists(pubDebt)) {
		//	bm.put(Constants.WARNING_MSG, "该债权信息名称已经存在");
		//	return bm;
		//}
		sqlSessionTemplate.update(MAPPER_NAMESPACE + ".edit", pubDebt);
		return bm;
	}

	@Transactional
	@Override
	public boolean delete(String pubDebtId) throws Exception {
		sqlSessionTemplate.delete(MAPPER_NAMESPACE + ".deleteById", pubDebtId);
		return true;
	}

	@Override
	public Pager search(Pager pager, PubDebt pubDebt) throws Exception {
		List dataList = sqlSessionTemplate.selectList(MAPPER_NAMESPACE + ".page", pubDebt, new RowBounds((pager.getCurrentPage() - 1) * pager.getLimit(), pager.getLimit()));
		pager.setDataList(dataList);
		
		Long total = sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".getTotal", pubDebt);
		pager.setTotal(total);
		return pager;
	}

}
