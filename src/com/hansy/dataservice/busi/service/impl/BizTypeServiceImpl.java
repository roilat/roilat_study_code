/*
 * BizTypeServiceImpl.java created on 2016-08-17 下午 16:19:39 by roilatD
 */
package com.hansy.dataservice.busi.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import com.hansy.dataservice.busi.entity.BizType;
import com.hansy.dataservice.busi.service.BizTypeService;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Constants;
import org.eking.framework.common.Pager;
import org.eking.framework.dao.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 业务参数类型设置 Service 实现
 * TODO javadoc for com.hansy.dataservice.busi.service.impl.BizTypeServiceImpl
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-08-17
 */
@Service("bizTypeService")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class BizTypeServiceImpl implements BizTypeService {

	/**
	 * MyBatis 命名空间
	 */
	private final static String MAPPER_NAMESPACE = "com.hansy.dataservice.busi.mappers.BizTypeMapper";

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Transactional
	@Override
	public BusinessMap create(BizType bizType) throws Exception {
		BusinessMap bm = new BusinessMap();
		//if (this.isExists(bizType)) {
		//	bm.put(Constants.WARNING_MSG, "该业务参数类型设置名称已经存在");
		//	return bm;
		//}
		sqlSessionTemplate.insert(MAPPER_NAMESPACE + ".add", bizType);
		return bm;
	}

	@Override
	public boolean isExists(BizType bizType) throws Exception {
		return (Integer)sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".isExists", bizType) > 0;
	}
	
	@Override
	public BizType getById(String bizTypeId) throws Exception {
		return sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".getById", bizTypeId);
	}
	
	@Transactional
	@Override
	public BusinessMap edit(BizType bizType) throws Exception {
		BusinessMap bm = new BusinessMap();
		//if (this.isExists(bizType)) {
		//	bm.put(Constants.WARNING_MSG, "该业务参数类型设置名称已经存在");
		//	return bm;
		//}
		sqlSessionTemplate.update(MAPPER_NAMESPACE + ".edit", bizType);
		return bm;
	}

	@Transactional
	@Override
	public boolean delete(String bizTypeId) throws Exception {
		sqlSessionTemplate.delete(MAPPER_NAMESPACE + ".deleteById", bizTypeId);
		return true;
	}

	@Override
	public Pager search(Pager pager, BizType bizType) throws Exception {
		List dataList = sqlSessionTemplate.selectList(MAPPER_NAMESPACE + ".page", bizType, new RowBounds((pager.getCurrentPage() - 1) * pager.getLimit(), pager.getLimit()));
		pager.setDataList(dataList);
		
		Long total = sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".getTotal", bizType);
		pager.setTotal(total);
		return pager;
	}

}
