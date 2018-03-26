/*
 * CustInfoServiceImpl.java created on 2016-06-17 上午 10:49:09 by roilatD
 */
package com.p2p.user.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import com.p2p.user.entity.CustInfo;
import com.p2p.user.service.CustInfoService;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Constants;
import org.eking.framework.common.Pager;
import org.eking.framework.dao.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户信息 Service 实现
 * TODO javadoc for com.p2p.user.service.impl.CustInfoServiceImpl
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-06-17
 */
@Service("custInfoService")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class CustInfoServiceImpl implements CustInfoService {

	/**
	 * MyBatis 命名空间
	 */
	private final static String MAPPER_NAMESPACE = "com.p2p.user.mappers.CustInfoMapper";

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Transactional
	@Override
	public BusinessMap create(CustInfo custInfo) throws Exception {
		BusinessMap bm = new BusinessMap();
		//if (this.isExists(custInfo)) {
		//	bm.put(Constants.WARNING_MSG, "该用户信息名称已经存在");
		//	return bm;
		//}
		sqlSessionTemplate.insert(MAPPER_NAMESPACE + ".add", custInfo);
		return bm;
	}

	@Override
	public boolean isExists(CustInfo custInfo) throws Exception {
		return (Integer)sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".isExists", custInfo) > 0;
	}
	
	@Override
	public CustInfo getById(String custInfoId) throws Exception {
		return sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".getById", custInfoId);
	}
	
	@Transactional
	@Override
	public BusinessMap edit(CustInfo custInfo) throws Exception {
		BusinessMap bm = new BusinessMap();
		//if (this.isExists(custInfo)) {
		//	bm.put(Constants.WARNING_MSG, "该用户信息名称已经存在");
		//	return bm;
		//}
		sqlSessionTemplate.update(MAPPER_NAMESPACE + ".edit", custInfo);
		return bm;
	}

	@Transactional
	@Override
	public boolean delete(String custInfoId) throws Exception {
		sqlSessionTemplate.delete(MAPPER_NAMESPACE + ".deleteById", custInfoId);
		return true;
	}

	@Override
	public Pager search(Pager pager, CustInfo custInfo) throws Exception {
		List dataList = sqlSessionTemplate.selectList(MAPPER_NAMESPACE + ".page", custInfo, new RowBounds((pager.getCurrentPage() - 1) * pager.getLimit(), pager.getLimit()));
		pager.setDataList(dataList);
		
		Long total = sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".getTotal", custInfo);
		pager.setTotal(total);
		return pager;
	}

}
