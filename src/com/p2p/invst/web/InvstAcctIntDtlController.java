/*
 * InvstAcctIntDtlController.java created on 2016-06-12 上午 09:38:21 by roilatD
 */
package com.p2p.invst.web;

import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.BooleanUtils;
import com.p2p.invst.entity.InvstAcctIntDtl;
import com.p2p.invst.service.InvstAcctIntDtlService;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Constants;
import org.eking.framework.common.Pager;
import org.eking.framework.web.BaseController;
import org.eking.framework.web.system.interceptor.DoLog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 投资预期收益表控制器
 * TODO javadoc for org.eking.InvstAcctIntDtl.web.InvstAcctIntDtlController
 * @Copyright: 2014海南易建科技股份有限公司
 * @author:roilatD
 * @since: 2016-06-12
 */
@Controller
@RequestMapping("/invstAcctIntDtl")
public class InvstAcctIntDtlController extends BaseController {
	
	@Resource(name = "invstAcctIntDtlService")
	private InvstAcctIntDtlService invstAcctIntDtlService;
	
	/**
	 * 去到投资预期收益表列表页面
	 * @creator: roilatD
	 * @createDate: 2016-06-12 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param invstAcctIntDtl
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list") @DoLog(cnContent="查看投资预期收益表列表信息") //@Permission(name="invstAcctIntDtl.view")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response,InvstAcctIntDtl invstAcctIntDtl) throws Exception{
		HashMap<String, Object> modelMap=new LinkedHashMap<String, Object>();
		modelMap.put("invstAcctIntDtl", invstAcctIntDtl);
		return new ModelAndView("invstAcctIntDtl/list").addAllObjects(modelMap);
	}
	
	/**
	 * 投资预期收益表列表ajax分页
	 * @creator: roilatD
	 * @createDate: 2016-06-12  
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param invstAcctIntDtl
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/ajaxPage") @DoLog(cnContent="投资预期收益表列表ajax分页") //@Permission(name="invstAcctIntDtl.view")
	public String ajaxPage(HttpServletRequest request,HttpServletResponse response,InvstAcctIntDtl invstAcctIntDtl) throws Exception{
		Pager p=new Pager();
		boolean exportExcel = BooleanUtils.toBoolean(request.getParameter(EXPORT_EXCEL));
		if (exportExcel) {
			return null;
		}else {
			String currentPage = request.getParameter(Pager.MY_PAGINATION_CURRENT_PAGE);
			p.setCurrentPage(Integer.parseInt(currentPage == null ? "1" : currentPage));
			Pager pager=invstAcctIntDtlService.search(p, invstAcctIntDtl);
			this.genPageJson(response, pager);
			return null;
		}
	}
	
	
	/**
	 * 去到添加投资预期收益表页面
	 * @creator: roilatD
	 * @createDate: 2016-06-12 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param invstAcctIntDtl
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toAdd") @DoLog(cnContent="去到添加投资预期收益表页面") //@Permission(name="invstAcctIntDtl.add")
	public ModelAndView toAdd(HttpServletRequest request, HttpServletResponse response, InvstAcctIntDtl invstAcctIntDtl) throws Exception {
		return new ModelAndView("invstAcctIntDtl/add");
	}

	/**
	 * 添加投资预期收益表
	 * @creator: roilatD
	 * @createDate: 2016-06-12 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param invstAcctIntDtl
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/add") @DoLog(cnContent="添加投资预期收益表") //@Permission(name="invstAcctIntDtl.add")
	public String add(HttpServletRequest request, HttpServletResponse response, InvstAcctIntDtl invstAcctIntDtl) throws Exception {
		BusinessMap bm = invstAcctIntDtlService.create(invstAcctIntDtl);
		return this.ajax(response, bm.getIsSucc() ? Constants.SUCCESS : bm.getAlertMesg());
	}
	
	/**
	 * 去到编辑投资预期收益表页面
	 * @creator: roilatD
	 * @createDate: 2016-06-12 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param invstAcctIntDtl
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toEdit") @DoLog(cnContent="去到编辑投资预期收益表页面") //@Permission(name="invstAcctIntDtl.edit")
	public ModelAndView toEdit(HttpServletRequest request, HttpServletResponse response, InvstAcctIntDtl invstAcctIntDtl) throws Exception {
		InvstAcctIntDtl result = invstAcctIntDtlService.getById(invstAcctIntDtl.getTxSeqNo());
		return new ModelAndView("invstAcctIntDtl/edit").addObject("invstAcctIntDtl",result);
	}
	
	/**
	 * 编辑投资预期收益表
	 * @creator: roilatD
	 * @createDate: 2016-06-12 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param invstAcctIntDtl
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/edit") @DoLog(cnContent="编辑投资预期收益表") //@Permission(name="invstAcctIntDtl.edit")
	public String edit(HttpServletRequest request, HttpServletResponse response, InvstAcctIntDtl invstAcctIntDtl) throws Exception {
		BusinessMap bm = invstAcctIntDtlService.edit(invstAcctIntDtl);
		return this.ajax(response, bm.getIsSucc() ? Constants.SUCCESS : bm.getAlertMesg());
	}
	
	/**
	 * 查看投资预期收益表信息
	 * @creator: roilatD
	 * @createDate: 2016-06-12 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param invstAcctIntDtl
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/view") @DoLog(cnContent="查看投资预期收益表信息") //@Permission(name="invstAcctIntDtl.view")
	public ModelAndView view(HttpServletRequest request, HttpServletResponse response, InvstAcctIntDtl invstAcctIntDtl) throws Exception {
		InvstAcctIntDtl result = invstAcctIntDtlService.getById(invstAcctIntDtl.getTxSeqNo());
		return new ModelAndView("invstAcctIntDtl/view").addObject("invstAcctIntDtl",result);
	}
	
	/**
	 * 删除投资预期收益表信息
	 * @creator: roilatD
	 * @createDate: 2016-06-12 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param invstAcctIntDtl
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete") @DoLog(cnContent="删除投资预期收益表信息") //@Permission(name="invstAcctIntDtl.delete")
	public String delete(HttpServletRequest request, HttpServletResponse response, InvstAcctIntDtl invstAcctIntDtl) throws Exception {
		boolean flag = invstAcctIntDtlService.delete(invstAcctIntDtl.getTxSeqNo());
		return this.ajax(response, flag ? Constants.SUCCESS : Constants.ERROR);
	}
	
}
