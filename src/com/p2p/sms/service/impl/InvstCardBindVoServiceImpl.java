/*
 * InvstCardBindVoServiceImpl.java created on 2016-05-27 下午 19:50:18 by roilatD
 */
package com.p2p.sms.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import com.p2p.sms.entity.InvstCardBindVo;
import com.p2p.sms.service.InvstCardBindVoService;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Constants;
import org.eking.framework.common.Pager;
import org.eking.framework.dao.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 投资人银行卡绑定 Service 实现
 * TODO javadoc for com.p2p.sms.service.impl.InvstCardBindVoServiceImpl
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-05-27
 */
@Service("invstCardBindVoService")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class InvstCardBindVoServiceImpl implements InvstCardBindVoService {

	/**
	 * MyBatis 命名空间
	 */
	private final static String MAPPER_NAMESPACE = "com.p2p.sms.mappers.InvstCardBindVoMapper";

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Transactional
	@Override
	public BusinessMap create(InvstCardBindVo invstCardBindVo) throws Exception {
		BusinessMap bm = new BusinessMap();
		//if (this.isExists(invstCardBindVo)) {
		//	bm.put(Constants.WARNING_MSG, "该投资人银行卡绑定名称已经存在");
		//	return bm;
		//}
		sqlSessionTemplate.insert(MAPPER_NAMESPACE + ".add", invstCardBindVo);
		return bm;
	}

	@Override
	public boolean isExists(InvstCardBindVo invstCardBindVo) throws Exception {
		return (Integer)sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".isExists", invstCardBindVo) > 0;
	}
	
	@Override
	public InvstCardBindVo getById(String invstCardBindVoId) throws Exception {
		return sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".getById", invstCardBindVoId);
	}
	
	@Transactional
	@Override
	public BusinessMap edit(InvstCardBindVo invstCardBindVo) throws Exception {
		BusinessMap bm = new BusinessMap();
		//if (this.isExists(invstCardBindVo)) {
		//	bm.put(Constants.WARNING_MSG, "该投资人银行卡绑定名称已经存在");
		//	return bm;
		//}
		sqlSessionTemplate.update(MAPPER_NAMESPACE + ".edit", invstCardBindVo);
		return bm;
	}

	@Transactional
	@Override
	public boolean delete(String invstCardBindVoId) throws Exception {
		sqlSessionTemplate.delete(MAPPER_NAMESPACE + ".deleteById", invstCardBindVoId);
		return true;
	}

	@Override
	public Pager search(Pager pager, InvstCardBindVo invstCardBindVo) throws Exception {
		List dataList = sqlSessionTemplate.selectList(MAPPER_NAMESPACE + ".page", invstCardBindVo, new RowBounds((pager.getCurrentPage() - 1) * pager.getLimit(), pager.getLimit()));
		pager.setDataList(dataList);
		
		Long total = sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".getTotal", invstCardBindVo);
		pager.setTotal(total);
		return pager;
	}

}
