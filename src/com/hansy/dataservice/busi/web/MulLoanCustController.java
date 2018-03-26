/*
 * MulLoanCustController.java created on 2016-08-17 下午 16:14:14 by roilatD
 */
package com.hansy.dataservice.busi.web;

import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.BooleanUtils;
import com.hansy.dataservice.busi.entity.MulLoanCust;
import com.hansy.dataservice.busi.service.MulLoanCustService;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Constants;
import org.eking.framework.common.Pager;
import org.eking.framework.web.BaseController;
import org.eking.framework.web.system.interceptor.DoLog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 多头借贷客户控制器
 * TODO javadoc for org.eking.MulLoanCust.web.MulLoanCustController
 * @Copyright: 2014海南易建科技股份有限公司
 * @author:roilatD
 * @since: 2016-08-17
 */
@Controller
@RequestMapping("/mulLoanCust")
public class MulLoanCustController extends BaseController {
	
	@Resource(name = "mulLoanCustService")
	private MulLoanCustService mulLoanCustService;
	
	/**
	 * 去到多头借贷客户列表页面
	 * @creator: roilatD
	 * @createDate: 2016-08-17 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param mulLoanCust
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list") @DoLog(cnContent="查看多头借贷客户列表信息") //@Permission(name="mulLoanCust.view")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response,MulLoanCust mulLoanCust) throws Exception{
		HashMap<String, Object> modelMap=new LinkedHashMap<String, Object>();
		modelMap.put("mulLoanCust", mulLoanCust);
		return new ModelAndView("mulLoanCust/list").addAllObjects(modelMap);
	}
	
	/**
	 * 多头借贷客户列表ajax分页
	 * @creator: roilatD
	 * @createDate: 2016-08-17  
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param mulLoanCust
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/ajaxPage") @DoLog(cnContent="多头借贷客户列表ajax分页") //@Permission(name="mulLoanCust.view")
	public String ajaxPage(HttpServletRequest request,HttpServletResponse response,MulLoanCust mulLoanCust) throws Exception{
		Pager p=new Pager();
		boolean exportExcel = BooleanUtils.toBoolean(request.getParameter(EXPORT_EXCEL));
		if (exportExcel) {
			return null;
		}else {
			String currentPage = request.getParameter(Pager.MY_PAGINATION_CURRENT_PAGE);
			p.setCurrentPage(Integer.parseInt(currentPage == null ? "1" : currentPage));
			Pager pager=mulLoanCustService.search(p, mulLoanCust);
			this.genPageJson(response, pager);
			return null;
		}
	}
	
	
	/**
	 * 去到添加多头借贷客户页面
	 * @creator: roilatD
	 * @createDate: 2016-08-17 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param mulLoanCust
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toAdd") @DoLog(cnContent="去到添加多头借贷客户页面") //@Permission(name="mulLoanCust.add")
	public ModelAndView toAdd(HttpServletRequest request, HttpServletResponse response, MulLoanCust mulLoanCust) throws Exception {
		return new ModelAndView("mulLoanCust/add");
	}

	/**
	 * 添加多头借贷客户
	 * @creator: roilatD
	 * @createDate: 2016-08-17 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param mulLoanCust
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/add") @DoLog(cnContent="添加多头借贷客户") //@Permission(name="mulLoanCust.add")
	public String add(HttpServletRequest request, HttpServletResponse response, MulLoanCust mulLoanCust) throws Exception {
		BusinessMap bm = mulLoanCustService.create(mulLoanCust);
		return this.ajax(response, bm.getIsSucc() ? Constants.SUCCESS : bm.getAlertMesg());
	}
	
	/**
	 * 去到编辑多头借贷客户页面
	 * @creator: roilatD
	 * @createDate: 2016-08-17 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param mulLoanCust
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toEdit") @DoLog(cnContent="去到编辑多头借贷客户页面") //@Permission(name="mulLoanCust.edit")
	public ModelAndView toEdit(HttpServletRequest request, HttpServletResponse response, MulLoanCust mulLoanCust) throws Exception {
		MulLoanCust result = mulLoanCustService.getById(mulLoanCust.getCustName());
		return new ModelAndView("mulLoanCust/edit").addObject("mulLoanCust",result);
	}
	
	/**
	 * 编辑多头借贷客户
	 * @creator: roilatD
	 * @createDate: 2016-08-17 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param mulLoanCust
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/edit") @DoLog(cnContent="编辑多头借贷客户") //@Permission(name="mulLoanCust.edit")
	public String edit(HttpServletRequest request, HttpServletResponse response, MulLoanCust mulLoanCust) throws Exception {
		BusinessMap bm = mulLoanCustService.edit(mulLoanCust);
		return this.ajax(response, bm.getIsSucc() ? Constants.SUCCESS : bm.getAlertMesg());
	}
	
	/**
	 * 查看多头借贷客户信息
	 * @creator: roilatD
	 * @createDate: 2016-08-17 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param mulLoanCust
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/view") @DoLog(cnContent="查看多头借贷客户信息") //@Permission(name="mulLoanCust.view")
	public ModelAndView view(HttpServletRequest request, HttpServletResponse response, MulLoanCust mulLoanCust) throws Exception {
		MulLoanCust result = mulLoanCustService.getById(mulLoanCust.getCustName());
		return new ModelAndView("mulLoanCust/view").addObject("mulLoanCust",result);
	}
	
	/**
	 * 删除多头借贷客户信息
	 * @creator: roilatD
	 * @createDate: 2016-08-17 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param mulLoanCust
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete") @DoLog(cnContent="删除多头借贷客户信息") //@Permission(name="mulLoanCust.delete")
	public String delete(HttpServletRequest request, HttpServletResponse response, MulLoanCust mulLoanCust) throws Exception {
		boolean flag = mulLoanCustService.delete(mulLoanCust.getCustName());
		return this.ajax(response, flag ? Constants.SUCCESS : Constants.ERROR);
	}
	
}
