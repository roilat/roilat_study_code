/*
 * OrgAcctFlowController.java created on 2016-08-17 下午 16:16:01 by roilatD
 */
package com.hansy.dataservice.busi.web;

import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.BooleanUtils;
import com.hansy.dataservice.busi.entity.OrgAcctFlow;
import com.hansy.dataservice.busi.service.OrgAcctFlowService;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Constants;
import org.eking.framework.common.Pager;
import org.eking.framework.web.BaseController;
import org.eking.framework.web.system.interceptor.DoLog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 查询机构台账控制器
 * TODO javadoc for org.eking.OrgAcctFlow.web.OrgAcctFlowController
 * @Copyright: 2014海南易建科技股份有限公司
 * @author:roilatD
 * @since: 2016-08-17
 */
@Controller
@RequestMapping("/orgAcctFlow")
public class OrgAcctFlowController extends BaseController {
	
	@Resource(name = "orgAcctFlowService")
	private OrgAcctFlowService orgAcctFlowService;
	
	/**
	 * 去到查询机构台账列表页面
	 * @creator: roilatD
	 * @createDate: 2016-08-17 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param orgAcctFlow
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list") @DoLog(cnContent="查看查询机构台账列表信息") //@Permission(name="orgAcctFlow.view")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response,OrgAcctFlow orgAcctFlow) throws Exception{
		HashMap<String, Object> modelMap=new LinkedHashMap<String, Object>();
		modelMap.put("orgAcctFlow", orgAcctFlow);
		return new ModelAndView("orgAcctFlow/list").addAllObjects(modelMap);
	}
	
	/**
	 * 查询机构台账列表ajax分页
	 * @creator: roilatD
	 * @createDate: 2016-08-17  
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param orgAcctFlow
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/ajaxPage") @DoLog(cnContent="查询机构台账列表ajax分页") //@Permission(name="orgAcctFlow.view")
	public String ajaxPage(HttpServletRequest request,HttpServletResponse response,OrgAcctFlow orgAcctFlow) throws Exception{
		Pager p=new Pager();
		boolean exportExcel = BooleanUtils.toBoolean(request.getParameter(EXPORT_EXCEL));
		if (exportExcel) {
			return null;
		}else {
			String currentPage = request.getParameter(Pager.MY_PAGINATION_CURRENT_PAGE);
			p.setCurrentPage(Integer.parseInt(currentPage == null ? "1" : currentPage));
			Pager pager=orgAcctFlowService.search(p, orgAcctFlow);
			this.genPageJson(response, pager);
			return null;
		}
	}
	
	
	/**
	 * 去到添加查询机构台账页面
	 * @creator: roilatD
	 * @createDate: 2016-08-17 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param orgAcctFlow
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toAdd") @DoLog(cnContent="去到添加查询机构台账页面") //@Permission(name="orgAcctFlow.add")
	public ModelAndView toAdd(HttpServletRequest request, HttpServletResponse response, OrgAcctFlow orgAcctFlow) throws Exception {
		return new ModelAndView("orgAcctFlow/add");
	}

	/**
	 * 添加查询机构台账
	 * @creator: roilatD
	 * @createDate: 2016-08-17 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param orgAcctFlow
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/add") @DoLog(cnContent="添加查询机构台账") //@Permission(name="orgAcctFlow.add")
	public String add(HttpServletRequest request, HttpServletResponse response, OrgAcctFlow orgAcctFlow) throws Exception {
		BusinessMap bm = orgAcctFlowService.create(orgAcctFlow);
		return this.ajax(response, bm.getIsSucc() ? Constants.SUCCESS : bm.getAlertMesg());
	}
	
	/**
	 * 去到编辑查询机构台账页面
	 * @creator: roilatD
	 * @createDate: 2016-08-17 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param orgAcctFlow
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toEdit") @DoLog(cnContent="去到编辑查询机构台账页面") //@Permission(name="orgAcctFlow.edit")
	public ModelAndView toEdit(HttpServletRequest request, HttpServletResponse response, OrgAcctFlow orgAcctFlow) throws Exception {
		OrgAcctFlow result = orgAcctFlowService.getById(orgAcctFlow.getFlowId());
		return new ModelAndView("orgAcctFlow/edit").addObject("orgAcctFlow",result);
	}
	
	/**
	 * 编辑查询机构台账
	 * @creator: roilatD
	 * @createDate: 2016-08-17 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param orgAcctFlow
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/edit") @DoLog(cnContent="编辑查询机构台账") //@Permission(name="orgAcctFlow.edit")
	public String edit(HttpServletRequest request, HttpServletResponse response, OrgAcctFlow orgAcctFlow) throws Exception {
		BusinessMap bm = orgAcctFlowService.edit(orgAcctFlow);
		return this.ajax(response, bm.getIsSucc() ? Constants.SUCCESS : bm.getAlertMesg());
	}
	
	/**
	 * 查看查询机构台账信息
	 * @creator: roilatD
	 * @createDate: 2016-08-17 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param orgAcctFlow
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/view") @DoLog(cnContent="查看查询机构台账信息") //@Permission(name="orgAcctFlow.view")
	public ModelAndView view(HttpServletRequest request, HttpServletResponse response, OrgAcctFlow orgAcctFlow) throws Exception {
		OrgAcctFlow result = orgAcctFlowService.getById(orgAcctFlow.getFlowId());
		return new ModelAndView("orgAcctFlow/view").addObject("orgAcctFlow",result);
	}
	
	/**
	 * 删除查询机构台账信息
	 * @creator: roilatD
	 * @createDate: 2016-08-17 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param orgAcctFlow
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete") @DoLog(cnContent="删除查询机构台账信息") //@Permission(name="orgAcctFlow.delete")
	public String delete(HttpServletRequest request, HttpServletResponse response, OrgAcctFlow orgAcctFlow) throws Exception {
		boolean flag = orgAcctFlowService.delete(orgAcctFlow.getFlowId());
		return this.ajax(response, flag ? Constants.SUCCESS : Constants.ERROR);
	}
	
}
