/*
 * LoanBlackListServiceImpl.java created on 2016-08-17 下午 16:21:06 by roilatD
 */
package com.hansy.dataservice.busi1.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import com.hansy.dataservice.busi1.entity.LoanBlackList;
import com.hansy.dataservice.busi1.service.LoanBlackListService;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Constants;
import org.eking.framework.common.Pager;
import org.eking.framework.dao.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 黑名单表 Service 实现
 * TODO javadoc for com.hansy.dataservice.busi1.service.impl.LoanBlackListServiceImpl
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-08-17
 */
@Service("loanBlackListService")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class LoanBlackListServiceImpl implements LoanBlackListService {

	/**
	 * MyBatis 命名空间
	 */
	private final static String MAPPER_NAMESPACE = "com.hansy.dataservice.busi1.mappers.LoanBlackListMapper";

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Transactional
	@Override
	public BusinessMap create(LoanBlackList loanBlackList) throws Exception {
		BusinessMap bm = new BusinessMap();
		//if (this.isExists(loanBlackList)) {
		//	bm.put(Constants.WARNING_MSG, "该黑名单表名称已经存在");
		//	return bm;
		//}
		sqlSessionTemplate.insert(MAPPER_NAMESPACE + ".add", loanBlackList);
		return bm;
	}

	@Override
	public boolean isExists(LoanBlackList loanBlackList) throws Exception {
		return (Integer)sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".isExists", loanBlackList) > 0;
	}
	
	@Override
	public LoanBlackList getById(String loanBlackListId) throws Exception {
		return sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".getById", loanBlackListId);
	}
	
	@Transactional
	@Override
	public BusinessMap edit(LoanBlackList loanBlackList) throws Exception {
		BusinessMap bm = new BusinessMap();
		//if (this.isExists(loanBlackList)) {
		//	bm.put(Constants.WARNING_MSG, "该黑名单表名称已经存在");
		//	return bm;
		//}
		sqlSessionTemplate.update(MAPPER_NAMESPACE + ".edit", loanBlackList);
		return bm;
	}

	@Transactional
	@Override
	public boolean delete(String loanBlackListId) throws Exception {
		sqlSessionTemplate.delete(MAPPER_NAMESPACE + ".deleteById", loanBlackListId);
		return true;
	}

	@Override
	public Pager search(Pager pager, LoanBlackList loanBlackList) throws Exception {
		List dataList = sqlSessionTemplate.selectList(MAPPER_NAMESPACE + ".page", loanBlackList, new RowBounds((pager.getCurrentPage() - 1) * pager.getLimit(), pager.getLimit()));
		pager.setDataList(dataList);
		
		Long total = sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".getTotal", loanBlackList);
		pager.setTotal(total);
		return pager;
	}

}
