/*
 * MarBlackListServiceImpl.java created on 2016-08-18 下午 14:03:52 by roilatD
 */
package com.hansy.dataservice.busi1.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import com.hansy.dataservice.busi1.entity.MarBlackList;
import com.hansy.dataservice.busi1.service.MarBlackListService;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Constants;
import org.eking.framework.common.Pager;
import org.eking.framework.dao.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 商户黑名单 Service 实现
 * TODO javadoc for com.hansy.dataservice.busi1.service.impl.MarBlackListServiceImpl
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-08-18
 */
@Service("marBlackListService")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class MarBlackListServiceImpl implements MarBlackListService {

	/**
	 * MyBatis 命名空间
	 */
	private final static String MAPPER_NAMESPACE = "com.hansy.dataservice.busi1.mappers.MarBlackListMapper";

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Transactional
	@Override
	public BusinessMap create(MarBlackList marBlackList) throws Exception {
		BusinessMap bm = new BusinessMap();
		//if (this.isExists(marBlackList)) {
		//	bm.put(Constants.WARNING_MSG, "该商户黑名单名称已经存在");
		//	return bm;
		//}
		sqlSessionTemplate.insert(MAPPER_NAMESPACE + ".add", marBlackList);
		return bm;
	}

	@Override
	public boolean isExists(MarBlackList marBlackList) throws Exception {
		return (Integer)sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".isExists", marBlackList) > 0;
	}
	
	@Override
	public MarBlackList getById(String marBlackListId) throws Exception {
		return sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".getById", marBlackListId);
	}
	
	@Transactional
	@Override
	public BusinessMap edit(MarBlackList marBlackList) throws Exception {
		BusinessMap bm = new BusinessMap();
		//if (this.isExists(marBlackList)) {
		//	bm.put(Constants.WARNING_MSG, "该商户黑名单名称已经存在");
		//	return bm;
		//}
		sqlSessionTemplate.update(MAPPER_NAMESPACE + ".edit", marBlackList);
		return bm;
	}

	@Transactional
	@Override
	public boolean delete(String marBlackListId) throws Exception {
		sqlSessionTemplate.delete(MAPPER_NAMESPACE + ".deleteById", marBlackListId);
		return true;
	}

	@Override
	public Pager search(Pager pager, MarBlackList marBlackList) throws Exception {
		List dataList = sqlSessionTemplate.selectList(MAPPER_NAMESPACE + ".page", marBlackList, new RowBounds((pager.getCurrentPage() - 1) * pager.getLimit(), pager.getLimit()));
		pager.setDataList(dataList);
		
		Long total = sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".getTotal", marBlackList);
		pager.setTotal(total);
		return pager;
	}

}
