/*
 * InvstAcctServiceImpl.java created on 2016-06-06 下午 16:57:33 by roilatD
 */
package com.p2p.invst.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import com.p2p.invst.entity.InvstAcct;
import com.p2p.invst.service.InvstAcctService;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Constants;
import org.eking.framework.common.Pager;
import org.eking.framework.dao.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 投资人信息表 Service 实现
 * TODO javadoc for com.p2p.invst.service.impl.InvstAcctServiceImpl
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-06-06
 */
@Service("invstAcctService")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class InvstAcctServiceImpl implements InvstAcctService {

	/**
	 * MyBatis 命名空间
	 */
	private final static String MAPPER_NAMESPACE = "com.p2p.invst.mappers.InvstAcctMapper";

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Transactional
	@Override
	public BusinessMap create(InvstAcct invstAcct) throws Exception {
		BusinessMap bm = new BusinessMap();
		//if (this.isExists(invstAcct)) {
		//	bm.put(Constants.WARNING_MSG, "该投资人信息表名称已经存在");
		//	return bm;
		//}
		sqlSessionTemplate.insert(MAPPER_NAMESPACE + ".add", invstAcct);
		return bm;
	}

	@Override
	public boolean isExists(InvstAcct invstAcct) throws Exception {
		return (Integer)sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".isExists", invstAcct) > 0;
	}
	
	@Override
	public InvstAcct getById(String invstAcctId) throws Exception {
		return sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".getById", invstAcctId);
	}
	
	@Transactional
	@Override
	public BusinessMap edit(InvstAcct invstAcct) throws Exception {
		BusinessMap bm = new BusinessMap();
		//if (this.isExists(invstAcct)) {
		//	bm.put(Constants.WARNING_MSG, "该投资人信息表名称已经存在");
		//	return bm;
		//}
		sqlSessionTemplate.update(MAPPER_NAMESPACE + ".edit", invstAcct);
		return bm;
	}

	@Transactional
	@Override
	public boolean delete(String invstAcctId) throws Exception {
		sqlSessionTemplate.delete(MAPPER_NAMESPACE + ".deleteById", invstAcctId);
		return true;
	}

	@Override
	public Pager search(Pager pager, InvstAcct invstAcct) throws Exception {
		List dataList = sqlSessionTemplate.selectList(MAPPER_NAMESPACE + ".page", invstAcct, new RowBounds((pager.getCurrentPage() - 1) * pager.getLimit(), pager.getLimit()));
		pager.setDataList(dataList);
		
		Long total = sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".getTotal", invstAcct);
		pager.setTotal(total);
		return pager;
	}

}
