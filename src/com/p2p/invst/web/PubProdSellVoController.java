/*
 * PubProdSellVoController.java created on 2016-06-04 下午 15:00:21 by roilatD
 */
package com.p2p.invst.web;

import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.BooleanUtils;
import com.p2p.invst.entity.PubProdSellVo;
import com.p2p.invst.service.PubProdSellVoService;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Constants;
import org.eking.framework.common.Pager;
import org.eking.framework.web.BaseController;
import org.eking.framework.web.system.interceptor.DoLog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 产品销售表控制器
 * TODO javadoc for org.eking.PubProdSellVo.web.PubProdSellVoController
 * @Copyright: 2014海南易建科技股份有限公司
 * @author:roilatD
 * @since: 2016-06-04
 */
@Controller
@RequestMapping("/pubProdSellVo")
public class PubProdSellVoController extends BaseController {
	
	@Resource(name = "pubProdSellVoService")
	private PubProdSellVoService pubProdSellVoService;
	
	/**
	 * 去到产品销售表列表页面
	 * @creator: roilatD
	 * @createDate: 2016-06-04 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param pubProdSellVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list") @DoLog(cnContent="查看产品销售表列表信息") //@Permission(name="pubProdSellVo.view")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response,PubProdSellVo pubProdSellVo) throws Exception{
		HashMap<String, Object> modelMap=new LinkedHashMap<String, Object>();
		modelMap.put("pubProdSellVo", pubProdSellVo);
		return new ModelAndView("pubProdSellVo/list").addAllObjects(modelMap);
	}
	
	/**
	 * 产品销售表列表ajax分页
	 * @creator: roilatD
	 * @createDate: 2016-06-04  
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param pubProdSellVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/ajaxPage") @DoLog(cnContent="产品销售表列表ajax分页") //@Permission(name="pubProdSellVo.view")
	public String ajaxPage(HttpServletRequest request,HttpServletResponse response,PubProdSellVo pubProdSellVo) throws Exception{
		Pager p=new Pager();
		boolean exportExcel = BooleanUtils.toBoolean(request.getParameter(EXPORT_EXCEL));
		if (exportExcel) {
			return null;
		}else {
			String currentPage = request.getParameter(Pager.MY_PAGINATION_CURRENT_PAGE);
			p.setCurrentPage(Integer.parseInt(currentPage == null ? "1" : currentPage));
			Pager pager=pubProdSellVoService.search(p, pubProdSellVo);
			this.genPageJson(response, pager);
			return null;
		}
	}
	
	
	/**
	 * 去到添加产品销售表页面
	 * @creator: roilatD
	 * @createDate: 2016-06-04 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param pubProdSellVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toAdd") @DoLog(cnContent="去到添加产品销售表页面") //@Permission(name="pubProdSellVo.add")
	public ModelAndView toAdd(HttpServletRequest request, HttpServletResponse response, PubProdSellVo pubProdSellVo) throws Exception {
		return new ModelAndView("pubProdSellVo/add");
	}

	/**
	 * 添加产品销售表
	 * @creator: roilatD
	 * @createDate: 2016-06-04 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param pubProdSellVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/add") @DoLog(cnContent="添加产品销售表") //@Permission(name="pubProdSellVo.add")
	public String add(HttpServletRequest request, HttpServletResponse response, PubProdSellVo pubProdSellVo) throws Exception {
		BusinessMap bm = pubProdSellVoService.create(pubProdSellVo);
		return this.ajax(response, bm.getIsSucc() ? Constants.SUCCESS : bm.getAlertMesg());
	}
	
	/**
	 * 去到编辑产品销售表页面
	 * @creator: roilatD
	 * @createDate: 2016-06-04 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param pubProdSellVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toEdit") @DoLog(cnContent="去到编辑产品销售表页面") //@Permission(name="pubProdSellVo.edit")
	public ModelAndView toEdit(HttpServletRequest request, HttpServletResponse response, PubProdSellVo pubProdSellVo) throws Exception {
		PubProdSellVo result = pubProdSellVoService.getById(pubProdSellVo.getProdNo());
		return new ModelAndView("pubProdSellVo/edit").addObject("pubProdSellVo",result);
	}
	
	/**
	 * 编辑产品销售表
	 * @creator: roilatD
	 * @createDate: 2016-06-04 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param pubProdSellVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/edit") @DoLog(cnContent="编辑产品销售表") //@Permission(name="pubProdSellVo.edit")
	public String edit(HttpServletRequest request, HttpServletResponse response, PubProdSellVo pubProdSellVo) throws Exception {
		BusinessMap bm = pubProdSellVoService.edit(pubProdSellVo);
		return this.ajax(response, bm.getIsSucc() ? Constants.SUCCESS : bm.getAlertMesg());
	}
	
	/**
	 * 查看产品销售表信息
	 * @creator: roilatD
	 * @createDate: 2016-06-04 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param pubProdSellVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/view") @DoLog(cnContent="查看产品销售表信息") //@Permission(name="pubProdSellVo.view")
	public ModelAndView view(HttpServletRequest request, HttpServletResponse response, PubProdSellVo pubProdSellVo) throws Exception {
		PubProdSellVo result = pubProdSellVoService.getById(pubProdSellVo.getProdNo());
		return new ModelAndView("pubProdSellVo/view").addObject("pubProdSellVo",result);
	}
	
	/**
	 * 删除产品销售表信息
	 * @creator: roilatD
	 * @createDate: 2016-06-04 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param pubProdSellVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete") @DoLog(cnContent="删除产品销售表信息") //@Permission(name="pubProdSellVo.delete")
	public String delete(HttpServletRequest request, HttpServletResponse response, PubProdSellVo pubProdSellVo) throws Exception {
		boolean flag = pubProdSellVoService.delete(pubProdSellVo.getProdNo());
		return this.ajax(response, flag ? Constants.SUCCESS : Constants.ERROR);
	}
	
}
