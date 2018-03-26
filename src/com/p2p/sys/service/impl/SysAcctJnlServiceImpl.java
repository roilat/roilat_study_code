/*
 * SysAcctJnlServiceImpl.java created on 2016-07-02 下午 15:44:48 by roilatD
 */
package com.p2p.sys.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import com.p2p.sys.entity.SysAcctJnl;
import com.p2p.sys.service.SysAcctJnlService;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Constants;
import org.eking.framework.common.Pager;
import org.eking.framework.dao.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 会计分录流水 Service 实现
 * TODO javadoc for com.p2p.sys.service.impl.SysAcctJnlServiceImpl
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-07-02
 */
@Service("sysAcctJnlService")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class SysAcctJnlServiceImpl implements SysAcctJnlService {

	/**
	 * MyBatis 命名空间
	 */
	private final static String MAPPER_NAMESPACE = "com.p2p.sys.mappers.SysAcctJnlMapper";

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Transactional
	@Override
	public BusinessMap create(SysAcctJnl sysAcctJnl) throws Exception {
		BusinessMap bm = new BusinessMap();
		//if (this.isExists(sysAcctJnl)) {
		//	bm.put(Constants.WARNING_MSG, "该会计分录流水名称已经存在");
		//	return bm;
		//}
		sqlSessionTemplate.insert(MAPPER_NAMESPACE + ".add", sysAcctJnl);
		return bm;
	}

	@Override
	public boolean isExists(SysAcctJnl sysAcctJnl) throws Exception {
		return (Integer)sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".isExists", sysAcctJnl) > 0;
	}
	
	@Override
	public SysAcctJnl getById(String sysAcctJnlId) throws Exception {
		return sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".getById", sysAcctJnlId);
	}
	
	@Transactional
	@Override
	public BusinessMap edit(SysAcctJnl sysAcctJnl) throws Exception {
		BusinessMap bm = new BusinessMap();
		//if (this.isExists(sysAcctJnl)) {
		//	bm.put(Constants.WARNING_MSG, "该会计分录流水名称已经存在");
		//	return bm;
		//}
		sqlSessionTemplate.update(MAPPER_NAMESPACE + ".edit", sysAcctJnl);
		return bm;
	}

	@Transactional
	@Override
	public boolean delete(String sysAcctJnlId) throws Exception {
		sqlSessionTemplate.delete(MAPPER_NAMESPACE + ".deleteById", sysAcctJnlId);
		return true;
	}

	@Override
	public Pager search(Pager pager, SysAcctJnl sysAcctJnl) throws Exception {
		List dataList = sqlSessionTemplate.selectList(MAPPER_NAMESPACE + ".page", sysAcctJnl, new RowBounds((pager.getCurrentPage() - 1) * pager.getLimit(), pager.getLimit()));
		pager.setDataList(dataList);
		
		Long total = sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".getTotal", sysAcctJnl);
		pager.setTotal(total);
		return pager;
	}

}
