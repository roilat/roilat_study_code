/*
 * InvstAcctDtlServiceImpl.java created on 2016-07-02 下午 15:46:48 by roilatD
 */
package com.p2p.sys.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import com.p2p.sys.entity.InvstAcctDtl;
import com.p2p.sys.service.InvstAcctDtlService;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Constants;
import org.eking.framework.common.Pager;
import org.eking.framework.dao.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 投资交易明细 Service 实现
 * TODO javadoc for com.p2p.sys.service.impl.InvstAcctDtlServiceImpl
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-07-02
 */
@Service("invstAcctDtlService")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class InvstAcctDtlServiceImpl implements InvstAcctDtlService {

	/**
	 * MyBatis 命名空间
	 */
	private final static String MAPPER_NAMESPACE = "com.p2p.sys.mappers.InvstAcctDtlMapper";

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Transactional
	@Override
	public BusinessMap create(InvstAcctDtl invstAcctDtl) throws Exception {
		BusinessMap bm = new BusinessMap();
		//if (this.isExists(invstAcctDtl)) {
		//	bm.put(Constants.WARNING_MSG, "该投资交易明细名称已经存在");
		//	return bm;
		//}
		sqlSessionTemplate.insert(MAPPER_NAMESPACE + ".add", invstAcctDtl);
		return bm;
	}

	@Override
	public boolean isExists(InvstAcctDtl invstAcctDtl) throws Exception {
		return (Integer)sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".isExists", invstAcctDtl) > 0;
	}
	
	@Override
	public InvstAcctDtl getById(String invstAcctDtlId) throws Exception {
		return sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".getById", invstAcctDtlId);
	}
	
	@Transactional
	@Override
	public BusinessMap edit(InvstAcctDtl invstAcctDtl) throws Exception {
		BusinessMap bm = new BusinessMap();
		//if (this.isExists(invstAcctDtl)) {
		//	bm.put(Constants.WARNING_MSG, "该投资交易明细名称已经存在");
		//	return bm;
		//}
		sqlSessionTemplate.update(MAPPER_NAMESPACE + ".edit", invstAcctDtl);
		return bm;
	}

	@Transactional
	@Override
	public boolean delete(String invstAcctDtlId) throws Exception {
		sqlSessionTemplate.delete(MAPPER_NAMESPACE + ".deleteById", invstAcctDtlId);
		return true;
	}

	@Override
	public Pager search(Pager pager, InvstAcctDtl invstAcctDtl) throws Exception {
		List dataList = sqlSessionTemplate.selectList(MAPPER_NAMESPACE + ".page", invstAcctDtl, new RowBounds((pager.getCurrentPage() - 1) * pager.getLimit(), pager.getLimit()));
		pager.setDataList(dataList);
		
		Long total = sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".getTotal", invstAcctDtl);
		pager.setTotal(total);
		return pager;
	}

}
