/*
 * BlklistQueryLogServiceImpl.java created on 2016-08-17 下午 16:18:45 by roilatD
 */
package com.hansy.dataservice.busi.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import com.hansy.dataservice.busi.entity.BlklistQueryLog;
import com.hansy.dataservice.busi.service.BlklistQueryLogService;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Constants;
import org.eking.framework.common.Pager;
import org.eking.framework.dao.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 黑名单查询日志 Service 实现
 * TODO javadoc for com.hansy.dataservice.busi.service.impl.BlklistQueryLogServiceImpl
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-08-17
 */
@Service("blklistQueryLogService")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class BlklistQueryLogServiceImpl implements BlklistQueryLogService {

	/**
	 * MyBatis 命名空间
	 */
	private final static String MAPPER_NAMESPACE = "com.hansy.dataservice.busi.mappers.BlklistQueryLogMapper";

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Transactional
	@Override
	public BusinessMap create(BlklistQueryLog blklistQueryLog) throws Exception {
		BusinessMap bm = new BusinessMap();
		//if (this.isExists(blklistQueryLog)) {
		//	bm.put(Constants.WARNING_MSG, "该黑名单查询日志名称已经存在");
		//	return bm;
		//}
		sqlSessionTemplate.insert(MAPPER_NAMESPACE + ".add", blklistQueryLog);
		return bm;
	}

	@Override
	public boolean isExists(BlklistQueryLog blklistQueryLog) throws Exception {
		return (Integer)sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".isExists", blklistQueryLog) > 0;
	}
	
	@Override
	public BlklistQueryLog getById(String blklistQueryLogId) throws Exception {
		return sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".getById", blklistQueryLogId);
	}
	
	@Transactional
	@Override
	public BusinessMap edit(BlklistQueryLog blklistQueryLog) throws Exception {
		BusinessMap bm = new BusinessMap();
		//if (this.isExists(blklistQueryLog)) {
		//	bm.put(Constants.WARNING_MSG, "该黑名单查询日志名称已经存在");
		//	return bm;
		//}
		sqlSessionTemplate.update(MAPPER_NAMESPACE + ".edit", blklistQueryLog);
		return bm;
	}

	@Transactional
	@Override
	public boolean delete(String blklistQueryLogId) throws Exception {
		sqlSessionTemplate.delete(MAPPER_NAMESPACE + ".deleteById", blklistQueryLogId);
		return true;
	}

	@Override
	public Pager search(Pager pager, BlklistQueryLog blklistQueryLog) throws Exception {
		List dataList = sqlSessionTemplate.selectList(MAPPER_NAMESPACE + ".page", blklistQueryLog, new RowBounds((pager.getCurrentPage() - 1) * pager.getLimit(), pager.getLimit()));
		pager.setDataList(dataList);
		
		Long total = sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".getTotal", blklistQueryLog);
		pager.setTotal(total);
		return pager;
	}

}
