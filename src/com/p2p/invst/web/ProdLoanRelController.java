/*
 * ProdLoanRelController.java created on 2016-06-12 上午 09:35:29 by roilatD
 */
package com.p2p.invst.web;

import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.BooleanUtils;
import com.p2p.invst.entity.ProdLoanRel;
import com.p2p.invst.service.ProdLoanRelService;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Constants;
import org.eking.framework.common.Pager;
import org.eking.framework.web.BaseController;
import org.eking.framework.web.system.interceptor.DoLog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 产品与借款人关系表控制器
 * TODO javadoc for org.eking.ProdLoanRel.web.ProdLoanRelController
 * @Copyright: 2014海南易建科技股份有限公司
 * @author:roilatD
 * @since: 2016-06-12
 */
@Controller
@RequestMapping("/prodLoanRel")
public class ProdLoanRelController extends BaseController {
	
	@Resource(name = "prodLoanRelService")
	private ProdLoanRelService prodLoanRelService;
	
	/**
	 * 去到产品与借款人关系表列表页面
	 * @creator: roilatD
	 * @createDate: 2016-06-12 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param prodLoanRel
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list") @DoLog(cnContent="查看产品与借款人关系表列表信息") //@Permission(name="prodLoanRel.view")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response,ProdLoanRel prodLoanRel) throws Exception{
		HashMap<String, Object> modelMap=new LinkedHashMap<String, Object>();
		modelMap.put("prodLoanRel", prodLoanRel);
		return new ModelAndView("prodLoanRel/list").addAllObjects(modelMap);
	}
	
	/**
	 * 产品与借款人关系表列表ajax分页
	 * @creator: roilatD
	 * @createDate: 2016-06-12  
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param prodLoanRel
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/ajaxPage") @DoLog(cnContent="产品与借款人关系表列表ajax分页") //@Permission(name="prodLoanRel.view")
	public String ajaxPage(HttpServletRequest request,HttpServletResponse response,ProdLoanRel prodLoanRel) throws Exception{
		Pager p=new Pager();
		boolean exportExcel = BooleanUtils.toBoolean(request.getParameter(EXPORT_EXCEL));
		if (exportExcel) {
			return null;
		}else {
			String currentPage = request.getParameter(Pager.MY_PAGINATION_CURRENT_PAGE);
			p.setCurrentPage(Integer.parseInt(currentPage == null ? "1" : currentPage));
			Pager pager=prodLoanRelService.search(p, prodLoanRel);
			this.genPageJson(response, pager);
			return null;
		}
	}
	
	
	/**
	 * 去到添加产品与借款人关系表页面
	 * @creator: roilatD
	 * @createDate: 2016-06-12 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param prodLoanRel
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toAdd") @DoLog(cnContent="去到添加产品与借款人关系表页面") //@Permission(name="prodLoanRel.add")
	public ModelAndView toAdd(HttpServletRequest request, HttpServletResponse response, ProdLoanRel prodLoanRel) throws Exception {
		return new ModelAndView("prodLoanRel/add");
	}

	/**
	 * 添加产品与借款人关系表
	 * @creator: roilatD
	 * @createDate: 2016-06-12 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param prodLoanRel
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/add") @DoLog(cnContent="添加产品与借款人关系表") //@Permission(name="prodLoanRel.add")
	public String add(HttpServletRequest request, HttpServletResponse response, ProdLoanRel prodLoanRel) throws Exception {
		BusinessMap bm = prodLoanRelService.create(prodLoanRel);
		return this.ajax(response, bm.getIsSucc() ? Constants.SUCCESS : bm.getAlertMesg());
	}
	
	/**
	 * 去到编辑产品与借款人关系表页面
	 * @creator: roilatD
	 * @createDate: 2016-06-12 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param prodLoanRel
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toEdit") @DoLog(cnContent="去到编辑产品与借款人关系表页面") //@Permission(name="prodLoanRel.edit")
	public ModelAndView toEdit(HttpServletRequest request, HttpServletResponse response, ProdLoanRel prodLoanRel) throws Exception {
		ProdLoanRel result = prodLoanRelService.getById(prodLoanRel.getProdTyp());
		return new ModelAndView("prodLoanRel/edit").addObject("prodLoanRel",result);
	}
	
	/**
	 * 编辑产品与借款人关系表
	 * @creator: roilatD
	 * @createDate: 2016-06-12 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param prodLoanRel
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/edit") @DoLog(cnContent="编辑产品与借款人关系表") //@Permission(name="prodLoanRel.edit")
	public String edit(HttpServletRequest request, HttpServletResponse response, ProdLoanRel prodLoanRel) throws Exception {
		BusinessMap bm = prodLoanRelService.edit(prodLoanRel);
		return this.ajax(response, bm.getIsSucc() ? Constants.SUCCESS : bm.getAlertMesg());
	}
	
	/**
	 * 查看产品与借款人关系表信息
	 * @creator: roilatD
	 * @createDate: 2016-06-12 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param prodLoanRel
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/view") @DoLog(cnContent="查看产品与借款人关系表信息") //@Permission(name="prodLoanRel.view")
	public ModelAndView view(HttpServletRequest request, HttpServletResponse response, ProdLoanRel prodLoanRel) throws Exception {
		ProdLoanRel result = prodLoanRelService.getById(prodLoanRel.getProdTyp());
		return new ModelAndView("prodLoanRel/view").addObject("prodLoanRel",result);
	}
	
	/**
	 * 删除产品与借款人关系表信息
	 * @creator: roilatD
	 * @createDate: 2016-06-12 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param prodLoanRel
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete") @DoLog(cnContent="删除产品与借款人关系表信息") //@Permission(name="prodLoanRel.delete")
	public String delete(HttpServletRequest request, HttpServletResponse response, ProdLoanRel prodLoanRel) throws Exception {
		boolean flag = prodLoanRelService.delete(prodLoanRel.getProdTyp());
		return this.ajax(response, flag ? Constants.SUCCESS : Constants.ERROR);
	}
	
}
