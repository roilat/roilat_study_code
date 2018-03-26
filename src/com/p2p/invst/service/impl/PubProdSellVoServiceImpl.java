/*
 * PubProdSellVoServiceImpl.java created on 2016-06-04 下午 15:00:22 by roilatD
 */
package com.p2p.invst.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import com.p2p.invst.entity.PubProdSellVo;
import com.p2p.invst.service.PubProdSellVoService;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Constants;
import org.eking.framework.common.Pager;
import org.eking.framework.dao.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 产品销售表 Service 实现
 * TODO javadoc for com.p2p.invst.service.impl.PubProdSellVoServiceImpl
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-06-04
 */
@Service("pubProdSellVoService")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class PubProdSellVoServiceImpl implements PubProdSellVoService {

	/**
	 * MyBatis 命名空间
	 */
	private final static String MAPPER_NAMESPACE = "com.p2p.invst.mappers.PubProdSellVoMapper";

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Transactional
	@Override
	public BusinessMap create(PubProdSellVo pubProdSellVo) throws Exception {
		BusinessMap bm = new BusinessMap();
		//if (this.isExists(pubProdSellVo)) {
		//	bm.put(Constants.WARNING_MSG, "该产品销售表名称已经存在");
		//	return bm;
		//}
		sqlSessionTemplate.insert(MAPPER_NAMESPACE + ".add", pubProdSellVo);
		return bm;
	}

	@Override
	public boolean isExists(PubProdSellVo pubProdSellVo) throws Exception {
		return (Integer)sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".isExists", pubProdSellVo) > 0;
	}
	
	@Override
	public PubProdSellVo getById(String pubProdSellVoId) throws Exception {
		return sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".getById", pubProdSellVoId);
	}
	
	@Transactional
	@Override
	public BusinessMap edit(PubProdSellVo pubProdSellVo) throws Exception {
		BusinessMap bm = new BusinessMap();
		//if (this.isExists(pubProdSellVo)) {
		//	bm.put(Constants.WARNING_MSG, "该产品销售表名称已经存在");
		//	return bm;
		//}
		sqlSessionTemplate.update(MAPPER_NAMESPACE + ".edit", pubProdSellVo);
		return bm;
	}

	@Transactional
	@Override
	public boolean delete(String pubProdSellVoId) throws Exception {
		sqlSessionTemplate.delete(MAPPER_NAMESPACE + ".deleteById", pubProdSellVoId);
		return true;
	}

	@Override
	public Pager search(Pager pager, PubProdSellVo pubProdSellVo) throws Exception {
		List dataList = sqlSessionTemplate.selectList(MAPPER_NAMESPACE + ".page", pubProdSellVo, new RowBounds((pager.getCurrentPage() - 1) * pager.getLimit(), pager.getLimit()));
		pager.setDataList(dataList);
		
		Long total = sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".getTotal", pubProdSellVo);
		pager.setTotal(total);
		return pager;
	}

}
