/*
 * SysSmsLogServiceImpl.java created on 2016-05-23 下午 18:14:59 by roilatD
 */
package com.p2p.sms.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import com.p2p.sms.entity.SysSmsLog;
import com.p2p.sms.service.SysSmsLogService;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Constants;
import org.eking.framework.common.Pager;
import org.eking.framework.dao.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 短信日志表 Service 实现
 * TODO javadoc for com.p2p.sms.service.impl.SysSmsLogServiceImpl
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-05-23
 */
@Service("sysSmsLogService")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class SysSmsLogServiceImpl implements SysSmsLogService {

	/**
	 * MyBatis 命名空间
	 */
	private final static String MAPPER_NAMESPACE = "com.p2p.sms.mappers.SysSmsLogMapper";

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Transactional
	@Override
	public BusinessMap create(SysSmsLog sysSmsLog) throws Exception {
		BusinessMap bm = new BusinessMap();
		//if (this.isExists(sysSmsLog)) {
		//	bm.put(Constants.WARNING_MSG, "该短信日志表名称已经存在");
		//	return bm;
		//}
		sqlSessionTemplate.insert(MAPPER_NAMESPACE + ".add", sysSmsLog);
		return bm;
	}

	@Override
	public boolean isExists(SysSmsLog sysSmsLog) throws Exception {
		return (Integer)sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".isExists", sysSmsLog) > 0;
	}
	
	@Override
	public SysSmsLog getById(String sysSmsLogId) throws Exception {
		return sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".getById", sysSmsLogId);
	}
	
	@Transactional
	@Override
	public BusinessMap edit(SysSmsLog sysSmsLog) throws Exception {
		BusinessMap bm = new BusinessMap();
		//if (this.isExists(sysSmsLog)) {
		//	bm.put(Constants.WARNING_MSG, "该短信日志表名称已经存在");
		//	return bm;
		//}
		sqlSessionTemplate.update(MAPPER_NAMESPACE + ".edit", sysSmsLog);
		return bm;
	}

	@Transactional
	@Override
	public boolean delete(String sysSmsLogId) throws Exception {
		sqlSessionTemplate.delete(MAPPER_NAMESPACE + ".deleteById", sysSmsLogId);
		return true;
	}

	@Override
	public Pager search(Pager pager, SysSmsLog sysSmsLog) throws Exception {
		List dataList = sqlSessionTemplate.selectList(MAPPER_NAMESPACE + ".page", sysSmsLog, new RowBounds((pager.getCurrentPage() - 1) * pager.getLimit(), pager.getLimit()));
		pager.setDataList(dataList);
		
		Long total = sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".getTotal", sysSmsLog);
		pager.setTotal(total);
		return pager;
	}

}
