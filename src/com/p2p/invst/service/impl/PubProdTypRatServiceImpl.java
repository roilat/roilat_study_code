/*
 * PubProdTypRatServiceImpl.java created on 2016-06-14 下午 16:48:54 by roilatD
 */
package com.p2p.invst.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import com.p2p.invst.entity.PubProdTypRat;
import com.p2p.invst.service.PubProdTypRatService;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Constants;
import org.eking.framework.common.Pager;
import org.eking.framework.dao.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * pub_prod_typ_rat Service 实现
 * TODO javadoc for com.p2p.invst.service.impl.PubProdTypRatServiceImpl
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-06-14
 */
@Service("pubProdTypRatService")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class PubProdTypRatServiceImpl implements PubProdTypRatService {

	/**
	 * MyBatis 命名空间
	 */
	private final static String MAPPER_NAMESPACE = "com.p2p.invst.mappers.PubProdTypRatMapper";

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Transactional
	@Override
	public BusinessMap create(PubProdTypRat pubProdTypRat) throws Exception {
		BusinessMap bm = new BusinessMap();
		//if (this.isExists(pubProdTypRat)) {
		//	bm.put(Constants.WARNING_MSG, "该pub_prod_typ_rat名称已经存在");
		//	return bm;
		//}
		sqlSessionTemplate.insert(MAPPER_NAMESPACE + ".add", pubProdTypRat);
		return bm;
	}

	@Override
	public boolean isExists(PubProdTypRat pubProdTypRat) throws Exception {
		return (Integer)sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".isExists", pubProdTypRat) > 0;
	}
	
	@Override
	public PubProdTypRat getById(String pubProdTypRatId) throws Exception {
		return sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".getById", pubProdTypRatId);
	}
	
	@Transactional
	@Override
	public BusinessMap edit(PubProdTypRat pubProdTypRat) throws Exception {
		BusinessMap bm = new BusinessMap();
		//if (this.isExists(pubProdTypRat)) {
		//	bm.put(Constants.WARNING_MSG, "该pub_prod_typ_rat名称已经存在");
		//	return bm;
		//}
		sqlSessionTemplate.update(MAPPER_NAMESPACE + ".edit", pubProdTypRat);
		return bm;
	}

	@Transactional
	@Override
	public boolean delete(String pubProdTypRatId) throws Exception {
		sqlSessionTemplate.delete(MAPPER_NAMESPACE + ".deleteById", pubProdTypRatId);
		return true;
	}

	@Override
	public Pager search(Pager pager, PubProdTypRat pubProdTypRat) throws Exception {
		List dataList = sqlSessionTemplate.selectList(MAPPER_NAMESPACE + ".page", pubProdTypRat, new RowBounds((pager.getCurrentPage() - 1) * pager.getLimit(), pager.getLimit()));
		pager.setDataList(dataList);
		
		Long total = sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".getTotal", pubProdTypRat);
		pager.setTotal(total);
		return pager;
	}

}
