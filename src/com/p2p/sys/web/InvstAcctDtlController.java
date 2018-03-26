/*
 * InvstAcctDtlController.java created on 2016-07-02 下午 15:46:46 by roilatD
 */
package com.p2p.sys.web;

import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.BooleanUtils;
import com.p2p.sys.entity.InvstAcctDtl;
import com.p2p.sys.service.InvstAcctDtlService;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Constants;
import org.eking.framework.common.Pager;
import org.eking.framework.web.BaseController;
import org.eking.framework.web.system.interceptor.DoLog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 投资交易明细控制器
 * TODO javadoc for org.eking.InvstAcctDtl.web.InvstAcctDtlController
 * @Copyright: 2014海南易建科技股份有限公司
 * @author:roilatD
 * @since: 2016-07-02
 */
@Controller
@RequestMapping("/invstAcctDtl")
public class InvstAcctDtlController extends BaseController {
	
	@Resource(name = "invstAcctDtlService")
	private InvstAcctDtlService invstAcctDtlService;
	
	/**
	 * 去到投资交易明细列表页面
	 * @creator: roilatD
	 * @createDate: 2016-07-02 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param invstAcctDtl
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list") @DoLog(cnContent="查看投资交易明细列表信息") //@Permission(name="invstAcctDtl.view")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response,InvstAcctDtl invstAcctDtl) throws Exception{
		HashMap<String, Object> modelMap=new LinkedHashMap<String, Object>();
		modelMap.put("invstAcctDtl", invstAcctDtl);
		return new ModelAndView("invstAcctDtl/list").addAllObjects(modelMap);
	}
	
	/**
	 * 投资交易明细列表ajax分页
	 * @creator: roilatD
	 * @createDate: 2016-07-02  
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param invstAcctDtl
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/ajaxPage") @DoLog(cnContent="投资交易明细列表ajax分页") //@Permission(name="invstAcctDtl.view")
	public String ajaxPage(HttpServletRequest request,HttpServletResponse response,InvstAcctDtl invstAcctDtl) throws Exception{
		Pager p=new Pager();
		boolean exportExcel = BooleanUtils.toBoolean(request.getParameter(EXPORT_EXCEL));
		if (exportExcel) {
			return null;
		}else {
			String currentPage = request.getParameter(Pager.MY_PAGINATION_CURRENT_PAGE);
			p.setCurrentPage(Integer.parseInt(currentPage == null ? "1" : currentPage));
			Pager pager=invstAcctDtlService.search(p, invstAcctDtl);
			this.genPageJson(response, pager);
			return null;
		}
	}
	
	
	/**
	 * 去到添加投资交易明细页面
	 * @creator: roilatD
	 * @createDate: 2016-07-02 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param invstAcctDtl
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toAdd") @DoLog(cnContent="去到添加投资交易明细页面") //@Permission(name="invstAcctDtl.add")
	public ModelAndView toAdd(HttpServletRequest request, HttpServletResponse response, InvstAcctDtl invstAcctDtl) throws Exception {
		return new ModelAndView("invstAcctDtl/add");
	}

	/**
	 * 添加投资交易明细
	 * @creator: roilatD
	 * @createDate: 2016-07-02 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param invstAcctDtl
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/add") @DoLog(cnContent="添加投资交易明细") //@Permission(name="invstAcctDtl.add")
	public String add(HttpServletRequest request, HttpServletResponse response, InvstAcctDtl invstAcctDtl) throws Exception {
		BusinessMap bm = invstAcctDtlService.create(invstAcctDtl);
		return this.ajax(response, bm.getIsSucc() ? Constants.SUCCESS : bm.getAlertMesg());
	}
	
	/**
	 * 去到编辑投资交易明细页面
	 * @creator: roilatD
	 * @createDate: 2016-07-02 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param invstAcctDtl
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toEdit") @DoLog(cnContent="去到编辑投资交易明细页面") //@Permission(name="invstAcctDtl.edit")
	public ModelAndView toEdit(HttpServletRequest request, HttpServletResponse response, InvstAcctDtl invstAcctDtl) throws Exception {
		InvstAcctDtl result = invstAcctDtlService.getById(invstAcctDtl.getTxSeqNo());
		return new ModelAndView("invstAcctDtl/edit").addObject("invstAcctDtl",result);
	}
	
	/**
	 * 编辑投资交易明细
	 * @creator: roilatD
	 * @createDate: 2016-07-02 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param invstAcctDtl
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/edit") @DoLog(cnContent="编辑投资交易明细") //@Permission(name="invstAcctDtl.edit")
	public String edit(HttpServletRequest request, HttpServletResponse response, InvstAcctDtl invstAcctDtl) throws Exception {
		BusinessMap bm = invstAcctDtlService.edit(invstAcctDtl);
		return this.ajax(response, bm.getIsSucc() ? Constants.SUCCESS : bm.getAlertMesg());
	}
	
	/**
	 * 查看投资交易明细信息
	 * @creator: roilatD
	 * @createDate: 2016-07-02 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param invstAcctDtl
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/view") @DoLog(cnContent="查看投资交易明细信息") //@Permission(name="invstAcctDtl.view")
	public ModelAndView view(HttpServletRequest request, HttpServletResponse response, InvstAcctDtl invstAcctDtl) throws Exception {
		InvstAcctDtl result = invstAcctDtlService.getById(invstAcctDtl.getTxSeqNo());
		return new ModelAndView("invstAcctDtl/view").addObject("invstAcctDtl",result);
	}
	
	/**
	 * 删除投资交易明细信息
	 * @creator: roilatD
	 * @createDate: 2016-07-02 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param invstAcctDtl
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete") @DoLog(cnContent="删除投资交易明细信息") //@Permission(name="invstAcctDtl.delete")
	public String delete(HttpServletRequest request, HttpServletResponse response, InvstAcctDtl invstAcctDtl) throws Exception {
		boolean flag = invstAcctDtlService.delete(invstAcctDtl.getTxSeqNo());
		return this.ajax(response, flag ? Constants.SUCCESS : Constants.ERROR);
	}
	
}
