/*
 * BusiCodeServiceImpl.java created on 2016-08-17 下午 16:19:15 by roilatD
 */
package com.hansy.dataservice.busi.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import com.hansy.dataservice.busi.entity.BusiCode;
import com.hansy.dataservice.busi.service.BusiCodeService;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Constants;
import org.eking.framework.common.Pager;
import org.eking.framework.dao.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 业务参数设置 Service 实现
 * TODO javadoc for com.hansy.dataservice.busi.service.impl.BusiCodeServiceImpl
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-08-17
 */
@Service("busiCodeService")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class BusiCodeServiceImpl implements BusiCodeService {

	/**
	 * MyBatis 命名空间
	 */
	private final static String MAPPER_NAMESPACE = "com.hansy.dataservice.busi.mappers.BusiCodeMapper";

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Transactional
	@Override
	public BusinessMap create(BusiCode busiCode) throws Exception {
		BusinessMap bm = new BusinessMap();
		//if (this.isExists(busiCode)) {
		//	bm.put(Constants.WARNING_MSG, "该业务参数设置名称已经存在");
		//	return bm;
		//}
		sqlSessionTemplate.insert(MAPPER_NAMESPACE + ".add", busiCode);
		return bm;
	}

	@Override
	public boolean isExists(BusiCode busiCode) throws Exception {
		return (Integer)sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".isExists", busiCode) > 0;
	}
	
	@Override
	public BusiCode getById(String busiCodeId) throws Exception {
		return sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".getById", busiCodeId);
	}
	
	@Transactional
	@Override
	public BusinessMap edit(BusiCode busiCode) throws Exception {
		BusinessMap bm = new BusinessMap();
		//if (this.isExists(busiCode)) {
		//	bm.put(Constants.WARNING_MSG, "该业务参数设置名称已经存在");
		//	return bm;
		//}
		sqlSessionTemplate.update(MAPPER_NAMESPACE + ".edit", busiCode);
		return bm;
	}

	@Transactional
	@Override
	public boolean delete(String busiCodeId) throws Exception {
		sqlSessionTemplate.delete(MAPPER_NAMESPACE + ".deleteById", busiCodeId);
		return true;
	}

	@Override
	public Pager search(Pager pager, BusiCode busiCode) throws Exception {
		List dataList = sqlSessionTemplate.selectList(MAPPER_NAMESPACE + ".page", busiCode, new RowBounds((pager.getCurrentPage() - 1) * pager.getLimit(), pager.getLimit()));
		pager.setDataList(dataList);
		
		Long total = sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".getTotal", busiCode);
		pager.setTotal(total);
		return pager;
	}

}
