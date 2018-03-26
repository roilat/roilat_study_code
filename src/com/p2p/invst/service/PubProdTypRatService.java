/*
 * PubProdTypRatService.java created on 2016-06-14 下午 16:48:53 by roilatD
 */
package com.p2p.invst.service;

import com.p2p.invst.entity.PubProdTypRat;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Pager;

/**
 * pub_prod_typ_rat Service 接口
 * TODO javadoc for com.p2p.invst.service.PubProdTypRatService
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-06-14
 */
public interface PubProdTypRatService {
	
	/**
	 * 获取查询分页对象
	 * @creator: roilatD
	 * @createDate: 2016-06-14
	 * @modifier:
	 * @modifiedDate:
	 * @param pager
	 * @param pubProdTypRat
	 * @return
	 * @throws Exception
	 */
	public Pager search(Pager pager, PubProdTypRat pubProdTypRat) throws Exception;
	
	/**
	 * 新增pub_prod_typ_rat
	 * @creator: roilatD
	 * @createDate: 2016-06-14
	 * @modifier:
	 * @modifiedDate:
	 * @param pubProdTypRat
	 * @return
	 * @throws Exception
	 */
	public BusinessMap create(PubProdTypRat pubProdTypRat) throws Exception;
	
	/**
	 * 判断是否存在
	 * @creator: roilatD
	 * @createDate: 2016-06-14
	 * @modifier:
	 * @modifiedDate:
	 * @param pubProdTypRat pub_prod_typ_rat
	 * @return
	 * @throws Exception
	 */
	public boolean isExists(PubProdTypRat pubProdTypRat) throws Exception;
	
	/**
	 * 根据ID获取pub_prod_typ_rat
	 * @creator: roilatD
	 * @createDate: 2016-06-14
	 * @modifier:
	 * @modifiedDate:
	 * @param pubProdTypRatId
	 * @return
	 * @throws Exception
	 */
	public PubProdTypRat getById(String pubProdTypRatId) throws Exception;
	
	/**
	 * 编辑pub_prod_typ_rat
	 * @creator: roilatD
	 * @createDate: 2016-06-14
	 * @modifier:
	 * @modifiedDate:
	 * @param pubProdTypRat pub_prod_typ_rat
	 * @return
	 * @throws Exception
	 */
	public BusinessMap edit(PubProdTypRat pubProdTypRat) throws Exception;
	
	/**
	 * 根据ID删除pub_prod_typ_rat
	 * @creator: roilatD
	 * @createDate: 2016-06-14
	 * @modifier:
	 * @modifiedDate:
	 * @param pubProdTypRatId
	 * @return
	 * @throws Exception
	 */
	public boolean delete(String pubProdTypRatId) throws Exception;
	

}
