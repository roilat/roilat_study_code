/*
 * InvstAcctController.java created on 2016-06-06 下午 16:57:32 by roilatD
 */
package com.p2p.invst.web;

import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.BooleanUtils;
import com.p2p.invst.entity.InvstAcct;
import com.p2p.invst.service.InvstAcctService;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Constants;
import org.eking.framework.common.Pager;
import org.eking.framework.web.BaseController;
import org.eking.framework.web.system.interceptor.DoLog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 投资人信息表控制器
 * TODO javadoc for org.eking.InvstAcct.web.InvstAcctController
 * @Copyright: 2014海南易建科技股份有限公司
 * @author:roilatD
 * @since: 2016-06-06
 */
@Controller
@RequestMapping("/invstAcct")
public class InvstAcctController extends BaseController {
	
	@Resource(name = "invstAcctService")
	private InvstAcctService invstAcctService;
	
	/**
	 * 去到投资人信息表列表页面
	 * @creator: roilatD
	 * @createDate: 2016-06-06 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param invstAcct
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list") @DoLog(cnContent="查看投资人信息表列表信息") //@Permission(name="invstAcct.view")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response,InvstAcct invstAcct) throws Exception{
		HashMap<String, Object> modelMap=new LinkedHashMap<String, Object>();
		modelMap.put("invstAcct", invstAcct);
		return new ModelAndView("invstAcct/list").addAllObjects(modelMap);
	}
	
	/**
	 * 投资人信息表列表ajax分页
	 * @creator: roilatD
	 * @createDate: 2016-06-06  
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param invstAcct
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/ajaxPage") @DoLog(cnContent="投资人信息表列表ajax分页") //@Permission(name="invstAcct.view")
	public String ajaxPage(HttpServletRequest request,HttpServletResponse response,InvstAcct invstAcct) throws Exception{
		Pager p=new Pager();
		boolean exportExcel = BooleanUtils.toBoolean(request.getParameter(EXPORT_EXCEL));
		if (exportExcel) {
			return null;
		}else {
			String currentPage = request.getParameter(Pager.MY_PAGINATION_CURRENT_PAGE);
			p.setCurrentPage(Integer.parseInt(currentPage == null ? "1" : currentPage));
			Pager pager=invstAcctService.search(p, invstAcct);
			this.genPageJson(response, pager);
			return null;
		}
	}
	
	
	/**
	 * 去到添加投资人信息表页面
	 * @creator: roilatD
	 * @createDate: 2016-06-06 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param invstAcct
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toAdd") @DoLog(cnContent="去到添加投资人信息表页面") //@Permission(name="invstAcct.add")
	public ModelAndView toAdd(HttpServletRequest request, HttpServletResponse response, InvstAcct invstAcct) throws Exception {
		return new ModelAndView("invstAcct/add");
	}

	/**
	 * 添加投资人信息表
	 * @creator: roilatD
	 * @createDate: 2016-06-06 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param invstAcct
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/add") @DoLog(cnContent="添加投资人信息表") //@Permission(name="invstAcct.add")
	public String add(HttpServletRequest request, HttpServletResponse response, InvstAcct invstAcct) throws Exception {
		BusinessMap bm = invstAcctService.create(invstAcct);
		return this.ajax(response, bm.getIsSucc() ? Constants.SUCCESS : bm.getAlertMesg());
	}
	
	/**
	 * 去到编辑投资人信息表页面
	 * @creator: roilatD
	 * @createDate: 2016-06-06 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param invstAcct
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toEdit") @DoLog(cnContent="去到编辑投资人信息表页面") //@Permission(name="invstAcct.edit")
	public ModelAndView toEdit(HttpServletRequest request, HttpServletResponse response, InvstAcct invstAcct) throws Exception {
		InvstAcct result = invstAcctService.getById(invstAcct.getAcctNo());
		return new ModelAndView("invstAcct/edit").addObject("invstAcct",result);
	}
	
	/**
	 * 编辑投资人信息表
	 * @creator: roilatD
	 * @createDate: 2016-06-06 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param invstAcct
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/edit") @DoLog(cnContent="编辑投资人信息表") //@Permission(name="invstAcct.edit")
	public String edit(HttpServletRequest request, HttpServletResponse response, InvstAcct invstAcct) throws Exception {
		BusinessMap bm = invstAcctService.edit(invstAcct);
		return this.ajax(response, bm.getIsSucc() ? Constants.SUCCESS : bm.getAlertMesg());
	}
	
	/**
	 * 查看投资人信息表信息
	 * @creator: roilatD
	 * @createDate: 2016-06-06 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param invstAcct
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/view") @DoLog(cnContent="查看投资人信息表信息") //@Permission(name="invstAcct.view")
	public ModelAndView view(HttpServletRequest request, HttpServletResponse response, InvstAcct invstAcct) throws Exception {
		InvstAcct result = invstAcctService.getById(invstAcct.getAcctNo());
		return new ModelAndView("invstAcct/view").addObject("invstAcct",result);
	}
	
	/**
	 * 删除投资人信息表信息
	 * @creator: roilatD
	 * @createDate: 2016-06-06 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param invstAcct
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete") @DoLog(cnContent="删除投资人信息表信息") //@Permission(name="invstAcct.delete")
	public String delete(HttpServletRequest request, HttpServletResponse response, InvstAcct invstAcct) throws Exception {
		boolean flag = invstAcctService.delete(invstAcct.getAcctNo());
		return this.ajax(response, flag ? Constants.SUCCESS : Constants.ERROR);
	}
	
}
