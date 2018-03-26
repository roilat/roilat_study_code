/*
 * SysDealRecordsServiceImpl.java created on 2016-06-14 下午 19:55:21 by roilatD
 */
package com.p2p.invst.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import com.p2p.invst.entity.SysDealRecords;
import com.p2p.invst.service.SysDealRecordsService;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Constants;
import org.eking.framework.common.Pager;
import org.eking.framework.dao.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 系统交易记录 Service 实现
 * TODO javadoc for com.p2p.invst.service.impl.SysDealRecordsServiceImpl
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-06-14
 */
@Service("sysDealRecordsService")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class SysDealRecordsServiceImpl implements SysDealRecordsService {

	/**
	 * MyBatis 命名空间
	 */
	private final static String MAPPER_NAMESPACE = "com.p2p.invst.mappers.SysDealRecordsMapper";

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Transactional
	@Override
	public BusinessMap create(SysDealRecords sysDealRecords) throws Exception {
		BusinessMap bm = new BusinessMap();
		//if (this.isExists(sysDealRecords)) {
		//	bm.put(Constants.WARNING_MSG, "该系统交易记录名称已经存在");
		//	return bm;
		//}
		sqlSessionTemplate.insert(MAPPER_NAMESPACE + ".add", sysDealRecords);
		return bm;
	}

	@Override
	public boolean isExists(SysDealRecords sysDealRecords) throws Exception {
		return (Integer)sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".isExists", sysDealRecords) > 0;
	}
	
	@Override
	public SysDealRecords getById(String sysDealRecordsId) throws Exception {
		return sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".getById", sysDealRecordsId);
	}
	
	@Transactional
	@Override
	public BusinessMap edit(SysDealRecords sysDealRecords) throws Exception {
		BusinessMap bm = new BusinessMap();
		//if (this.isExists(sysDealRecords)) {
		//	bm.put(Constants.WARNING_MSG, "该系统交易记录名称已经存在");
		//	return bm;
		//}
		sqlSessionTemplate.update(MAPPER_NAMESPACE + ".edit", sysDealRecords);
		return bm;
	}

	@Transactional
	@Override
	public boolean delete(String sysDealRecordsId) throws Exception {
		sqlSessionTemplate.delete(MAPPER_NAMESPACE + ".deleteById", sysDealRecordsId);
		return true;
	}

	@Override
	public Pager search(Pager pager, SysDealRecords sysDealRecords) throws Exception {
		List dataList = sqlSessionTemplate.selectList(MAPPER_NAMESPACE + ".page", sysDealRecords, new RowBounds((pager.getCurrentPage() - 1) * pager.getLimit(), pager.getLimit()));
		pager.setDataList(dataList);
		
		Long total = sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".getTotal", sysDealRecords);
		pager.setTotal(total);
		return pager;
	}

}
