/*
 * SysAcctDtlServiceImpl.java created on 2016-07-02 下午 15:59:31 by roilatD
 */
package com.p2p.sys.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import com.p2p.sys.entity.SysAcctDtl;
import com.p2p.sys.service.SysAcctDtlService;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Constants;
import org.eking.framework.common.Pager;
import org.eking.framework.dao.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 内部账交易明细 Service 实现
 * TODO javadoc for com.p2p.sys.service.impl.SysAcctDtlServiceImpl
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-07-02
 */
@Service("sysAcctDtlService")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class SysAcctDtlServiceImpl implements SysAcctDtlService {

	/**
	 * MyBatis 命名空间
	 */
	private final static String MAPPER_NAMESPACE = "com.p2p.sys.mappers.SysAcctDtlMapper";

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Transactional
	@Override
	public BusinessMap create(SysAcctDtl sysAcctDtl) throws Exception {
		BusinessMap bm = new BusinessMap();
		//if (this.isExists(sysAcctDtl)) {
		//	bm.put(Constants.WARNING_MSG, "该内部账交易明细名称已经存在");
		//	return bm;
		//}
		sqlSessionTemplate.insert(MAPPER_NAMESPACE + ".add", sysAcctDtl);
		return bm;
	}

	@Override
	public boolean isExists(SysAcctDtl sysAcctDtl) throws Exception {
		return (Integer)sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".isExists", sysAcctDtl) > 0;
	}
	
	@Override
	public SysAcctDtl getById(String sysAcctDtlId) throws Exception {
		return sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".getById", sysAcctDtlId);
	}
	
	@Transactional
	@Override
	public BusinessMap edit(SysAcctDtl sysAcctDtl) throws Exception {
		BusinessMap bm = new BusinessMap();
		//if (this.isExists(sysAcctDtl)) {
		//	bm.put(Constants.WARNING_MSG, "该内部账交易明细名称已经存在");
		//	return bm;
		//}
		sqlSessionTemplate.update(MAPPER_NAMESPACE + ".edit", sysAcctDtl);
		return bm;
	}

	@Transactional
	@Override
	public boolean delete(String sysAcctDtlId) throws Exception {
		sqlSessionTemplate.delete(MAPPER_NAMESPACE + ".deleteById", sysAcctDtlId);
		return true;
	}

	@Override
	public Pager search(Pager pager, SysAcctDtl sysAcctDtl) throws Exception {
		List dataList = sqlSessionTemplate.selectList(MAPPER_NAMESPACE + ".page", sysAcctDtl, new RowBounds((pager.getCurrentPage() - 1) * pager.getLimit(), pager.getLimit()));
		pager.setDataList(dataList);
		
		Long total = sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".getTotal", sysAcctDtl);
		pager.setTotal(total);
		return pager;
	}

}
