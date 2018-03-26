/*
 * InvstAcctRegVoServiceImpl.java created on 2016-06-04 下午 14:58:56 by roilatD
 */
package com.p2p.invst.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import com.p2p.invst.entity.InvstAcctRegVo;
import com.p2p.invst.service.InvstAcctRegVoService;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Constants;
import org.eking.framework.common.Pager;
import org.eking.framework.dao.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 投资登记薄 Service 实现
 * TODO javadoc for com.p2p.invst.service.impl.InvstAcctRegVoServiceImpl
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-06-04
 */
@Service("invstAcctRegVoService")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class InvstAcctRegVoServiceImpl implements InvstAcctRegVoService {

	/**
	 * MyBatis 命名空间
	 */
	private final static String MAPPER_NAMESPACE = "com.p2p.invst.mappers.InvstAcctRegVoMapper";

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Transactional
	@Override
	public BusinessMap create(InvstAcctRegVo invstAcctRegVo) throws Exception {
		BusinessMap bm = new BusinessMap();
		//if (this.isExists(invstAcctRegVo)) {
		//	bm.put(Constants.WARNING_MSG, "该投资登记薄名称已经存在");
		//	return bm;
		//}
		sqlSessionTemplate.insert(MAPPER_NAMESPACE + ".add", invstAcctRegVo);
		return bm;
	}

	@Override
	public boolean isExists(InvstAcctRegVo invstAcctRegVo) throws Exception {
		return (Integer)sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".isExists", invstAcctRegVo) > 0;
	}
	
	@Override
	public InvstAcctRegVo getById(String invstAcctRegVoId) throws Exception {
		return sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".getById", invstAcctRegVoId);
	}
	
	@Transactional
	@Override
	public BusinessMap edit(InvstAcctRegVo invstAcctRegVo) throws Exception {
		BusinessMap bm = new BusinessMap();
		//if (this.isExists(invstAcctRegVo)) {
		//	bm.put(Constants.WARNING_MSG, "该投资登记薄名称已经存在");
		//	return bm;
		//}
		sqlSessionTemplate.update(MAPPER_NAMESPACE + ".edit", invstAcctRegVo);
		return bm;
	}

	@Transactional
	@Override
	public boolean delete(String invstAcctRegVoId) throws Exception {
		sqlSessionTemplate.delete(MAPPER_NAMESPACE + ".deleteById", invstAcctRegVoId);
		return true;
	}

	@Override
	public Pager search(Pager pager, InvstAcctRegVo invstAcctRegVo) throws Exception {
		List dataList = sqlSessionTemplate.selectList(MAPPER_NAMESPACE + ".page", invstAcctRegVo, new RowBounds((pager.getCurrentPage() - 1) * pager.getLimit(), pager.getLimit()));
		pager.setDataList(dataList);
		
		Long total = sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".getTotal", invstAcctRegVo);
		pager.setTotal(total);
		return pager;
	}

}
