/*
 * LoanBlackPhoneListServiceImpl.java created on 2016-08-17 下午 16:21:39 by roilatD
 */
package com.hansy.dataservice.busi1.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import com.hansy.dataservice.busi1.entity.LoanBlackPhoneList;
import com.hansy.dataservice.busi1.service.LoanBlackPhoneListService;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Constants;
import org.eking.framework.common.Pager;
import org.eking.framework.dao.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 电话黑名单 Service 实现
 * TODO javadoc for com.hansy.dataservice.busi1.service.impl.LoanBlackPhoneListServiceImpl
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-08-17
 */
@Service("loanBlackPhoneListService")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class LoanBlackPhoneListServiceImpl implements LoanBlackPhoneListService {

	/**
	 * MyBatis 命名空间
	 */
	private final static String MAPPER_NAMESPACE = "com.hansy.dataservice.busi1.mappers.LoanBlackPhoneListMapper";

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Transactional
	@Override
	public BusinessMap create(LoanBlackPhoneList loanBlackPhoneList) throws Exception {
		BusinessMap bm = new BusinessMap();
		//if (this.isExists(loanBlackPhoneList)) {
		//	bm.put(Constants.WARNING_MSG, "该电话黑名单名称已经存在");
		//	return bm;
		//}
		sqlSessionTemplate.insert(MAPPER_NAMESPACE + ".add", loanBlackPhoneList);
		return bm;
	}

	@Override
	public boolean isExists(LoanBlackPhoneList loanBlackPhoneList) throws Exception {
		return (Integer)sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".isExists", loanBlackPhoneList) > 0;
	}
	
	@Override
	public LoanBlackPhoneList getById(String loanBlackPhoneListId) throws Exception {
		return sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".getById", loanBlackPhoneListId);
	}
	
	@Transactional
	@Override
	public BusinessMap edit(LoanBlackPhoneList loanBlackPhoneList) throws Exception {
		BusinessMap bm = new BusinessMap();
		//if (this.isExists(loanBlackPhoneList)) {
		//	bm.put(Constants.WARNING_MSG, "该电话黑名单名称已经存在");
		//	return bm;
		//}
		sqlSessionTemplate.update(MAPPER_NAMESPACE + ".edit", loanBlackPhoneList);
		return bm;
	}

	@Transactional
	@Override
	public boolean delete(String loanBlackPhoneListId) throws Exception {
		sqlSessionTemplate.delete(MAPPER_NAMESPACE + ".deleteById", loanBlackPhoneListId);
		return true;
	}

	@Override
	public Pager search(Pager pager, LoanBlackPhoneList loanBlackPhoneList) throws Exception {
		List dataList = sqlSessionTemplate.selectList(MAPPER_NAMESPACE + ".page", loanBlackPhoneList, new RowBounds((pager.getCurrentPage() - 1) * pager.getLimit(), pager.getLimit()));
		pager.setDataList(dataList);
		
		Long total = sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".getTotal", loanBlackPhoneList);
		pager.setTotal(total);
		return pager;
	}

}
