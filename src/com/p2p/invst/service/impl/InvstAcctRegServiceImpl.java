/*
 * InvstAcctRegServiceImpl.java created on 2016-06-12 上午 09:37:59 by roilatD
 */
package com.p2p.invst.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import com.p2p.invst.entity.InvstAcctReg;
import com.p2p.invst.service.InvstAcctRegService;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Constants;
import org.eking.framework.common.Pager;
import org.eking.framework.dao.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 投资登记薄 Service 实现
 * TODO javadoc for com.p2p.invst.service.impl.InvstAcctRegServiceImpl
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-06-12
 */
@Service("invstAcctRegService")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class InvstAcctRegServiceImpl implements InvstAcctRegService {

	/**
	 * MyBatis 命名空间
	 */
	private final static String MAPPER_NAMESPACE = "com.p2p.invst.mappers.InvstAcctRegMapper";

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Transactional
	@Override
	public BusinessMap create(InvstAcctReg invstAcctReg) throws Exception {
		BusinessMap bm = new BusinessMap();
		//if (this.isExists(invstAcctReg)) {
		//	bm.put(Constants.WARNING_MSG, "该投资登记薄名称已经存在");
		//	return bm;
		//}
		sqlSessionTemplate.insert(MAPPER_NAMESPACE + ".add", invstAcctReg);
		return bm;
	}

	@Override
	public boolean isExists(InvstAcctReg invstAcctReg) throws Exception {
		return (Integer)sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".isExists", invstAcctReg) > 0;
	}
	
	@Override
	public InvstAcctReg getById(String invstAcctRegId) throws Exception {
		return sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".getById", invstAcctRegId);
	}
	
	@Transactional
	@Override
	public BusinessMap edit(InvstAcctReg invstAcctReg) throws Exception {
		BusinessMap bm = new BusinessMap();
		//if (this.isExists(invstAcctReg)) {
		//	bm.put(Constants.WARNING_MSG, "该投资登记薄名称已经存在");
		//	return bm;
		//}
		sqlSessionTemplate.update(MAPPER_NAMESPACE + ".edit", invstAcctReg);
		return bm;
	}

	@Transactional
	@Override
	public boolean delete(String invstAcctRegId) throws Exception {
		sqlSessionTemplate.delete(MAPPER_NAMESPACE + ".deleteById", invstAcctRegId);
		return true;
	}

	@Override
	public Pager search(Pager pager, InvstAcctReg invstAcctReg) throws Exception {
		List dataList = sqlSessionTemplate.selectList(MAPPER_NAMESPACE + ".page", invstAcctReg, new RowBounds((pager.getCurrentPage() - 1) * pager.getLimit(), pager.getLimit()));
		pager.setDataList(dataList);
		
		Long total = sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".getTotal", invstAcctReg);
		pager.setTotal(total);
		return pager;
	}

}
