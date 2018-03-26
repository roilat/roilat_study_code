/*
 * InvstCardBindVoService.java created on 2016-05-27 下午 19:50:17 by roilatD
 */
package com.p2p.sms.service;

import com.p2p.sms.entity.InvstCardBindVo;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Pager;

/**
 * 投资人银行卡绑定 Service 接口
 * TODO javadoc for com.p2p.sms.service.InvstCardBindVoService
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-05-27
 */
public interface InvstCardBindVoService {
	
	/**
	 * 获取查询分页对象
	 * @creator: roilatD
	 * @createDate: 2016-05-27
	 * @modifier:
	 * @modifiedDate:
	 * @param pager
	 * @param invstCardBindVo
	 * @return
	 * @throws Exception
	 */
	public Pager search(Pager pager, InvstCardBindVo invstCardBindVo) throws Exception;
	
	/**
	 * 新增投资人银行卡绑定
	 * @creator: roilatD
	 * @createDate: 2016-05-27
	 * @modifier:
	 * @modifiedDate:
	 * @param invstCardBindVo
	 * @return
	 * @throws Exception
	 */
	public BusinessMap create(InvstCardBindVo invstCardBindVo) throws Exception;
	
	/**
	 * 判断是否存在
	 * @creator: roilatD
	 * @createDate: 2016-05-27
	 * @modifier:
	 * @modifiedDate:
	 * @param invstCardBindVo 投资人银行卡绑定
	 * @return
	 * @throws Exception
	 */
	public boolean isExists(InvstCardBindVo invstCardBindVo) throws Exception;
	
	/**
	 * 根据ID获取投资人银行卡绑定
	 * @creator: roilatD
	 * @createDate: 2016-05-27
	 * @modifier:
	 * @modifiedDate:
	 * @param invstCardBindVoId
	 * @return
	 * @throws Exception
	 */
	public InvstCardBindVo getById(String invstCardBindVoId) throws Exception;
	
	/**
	 * 编辑投资人银行卡绑定
	 * @creator: roilatD
	 * @createDate: 2016-05-27
	 * @modifier:
	 * @modifiedDate:
	 * @param invstCardBindVo 投资人银行卡绑定
	 * @return
	 * @throws Exception
	 */
	public BusinessMap edit(InvstCardBindVo invstCardBindVo) throws Exception;
	
	/**
	 * 根据ID删除投资人银行卡绑定
	 * @creator: roilatD
	 * @createDate: 2016-05-27
	 * @modifier:
	 * @modifiedDate:
	 * @param invstCardBindVoId
	 * @return
	 * @throws Exception
	 */
	public boolean delete(String invstCardBindVoId) throws Exception;
	

}
