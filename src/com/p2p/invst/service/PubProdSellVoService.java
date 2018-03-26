/*
 * PubProdSellVoService.java created on 2016-06-04 下午 15:00:22 by roilatD
 */
package com.p2p.invst.service;

import com.p2p.invst.entity.PubProdSellVo;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Pager;

/**
 * 产品销售表 Service 接口
 * TODO javadoc for com.p2p.invst.service.PubProdSellVoService
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-06-04
 */
public interface PubProdSellVoService {
	
	/**
	 * 获取查询分页对象
	 * @creator: roilatD
	 * @createDate: 2016-06-04
	 * @modifier:
	 * @modifiedDate:
	 * @param pager
	 * @param pubProdSellVo
	 * @return
	 * @throws Exception
	 */
	public Pager search(Pager pager, PubProdSellVo pubProdSellVo) throws Exception;
	
	/**
	 * 新增产品销售表
	 * @creator: roilatD
	 * @createDate: 2016-06-04
	 * @modifier:
	 * @modifiedDate:
	 * @param pubProdSellVo
	 * @return
	 * @throws Exception
	 */
	public BusinessMap create(PubProdSellVo pubProdSellVo) throws Exception;
	
	/**
	 * 判断是否存在
	 * @creator: roilatD
	 * @createDate: 2016-06-04
	 * @modifier:
	 * @modifiedDate:
	 * @param pubProdSellVo 产品销售表
	 * @return
	 * @throws Exception
	 */
	public boolean isExists(PubProdSellVo pubProdSellVo) throws Exception;
	
	/**
	 * 根据ID获取产品销售表
	 * @creator: roilatD
	 * @createDate: 2016-06-04
	 * @modifier:
	 * @modifiedDate:
	 * @param pubProdSellVoId
	 * @return
	 * @throws Exception
	 */
	public PubProdSellVo getById(String pubProdSellVoId) throws Exception;
	
	/**
	 * 编辑产品销售表
	 * @creator: roilatD
	 * @createDate: 2016-06-04
	 * @modifier:
	 * @modifiedDate:
	 * @param pubProdSellVo 产品销售表
	 * @return
	 * @throws Exception
	 */
	public BusinessMap edit(PubProdSellVo pubProdSellVo) throws Exception;
	
	/**
	 * 根据ID删除产品销售表
	 * @creator: roilatD
	 * @createDate: 2016-06-04
	 * @modifier:
	 * @modifiedDate:
	 * @param pubProdSellVoId
	 * @return
	 * @throws Exception
	 */
	public boolean delete(String pubProdSellVoId) throws Exception;
	

}
