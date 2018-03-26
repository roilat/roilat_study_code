/*
 * OrgAcctLedgerController.java created on 2016-08-17 下午 16:17:44 by roilatD
 */
package com.hansy.dataservice.busi.web;

import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.BooleanUtils;
import com.hansy.dataservice.busi.entity.OrgAcctLedger;
import com.hansy.dataservice.busi.service.OrgAcctLedgerService;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Constants;
import org.eking.framework.common.Pager;
import org.eking.framework.web.BaseController;
import org.eking.framework.web.system.interceptor.DoLog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 查询机构充值台账控制器
 * TODO javadoc for org.eking.OrgAcctLedger.web.OrgAcctLedgerController
 * @Copyright: 2014海南易建科技股份有限公司
 * @author:roilatD
 * @since: 2016-08-17
 */
@Controller
@RequestMapping("/orgAcctLedger")
public class OrgAcctLedgerController extends BaseController {
	
	@Resource(name = "orgAcctLedgerService")
	private OrgAcctLedgerService orgAcctLedgerService;
	
	/**
	 * 去到查询机构充值台账列表页面
	 * @creator: roilatD
	 * @createDate: 2016-08-17 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param orgAcctLedger
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list") @DoLog(cnContent="查看查询机构充值台账列表信息") //@Permission(name="orgAcctLedger.view")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response,OrgAcctLedger orgAcctLedger) throws Exception{
		HashMap<String, Object> modelMap=new LinkedHashMap<String, Object>();
		modelMap.put("orgAcctLedger", orgAcctLedger);
		return new ModelAndView("orgAcctLedger/list").addAllObjects(modelMap);
	}
	
	/**
	 * 查询机构充值台账列表ajax分页
	 * @creator: roilatD
	 * @createDate: 2016-08-17  
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param orgAcctLedger
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/ajaxPage") @DoLog(cnContent="查询机构充值台账列表ajax分页") //@Permission(name="orgAcctLedger.view")
	public String ajaxPage(HttpServletRequest request,HttpServletResponse response,OrgAcctLedger orgAcctLedger) throws Exception{
		Pager p=new Pager();
		boolean exportExcel = BooleanUtils.toBoolean(request.getParameter(EXPORT_EXCEL));
		if (exportExcel) {
			return null;
		}else {
			String currentPage = request.getParameter(Pager.MY_PAGINATION_CURRENT_PAGE);
			p.setCurrentPage(Integer.parseInt(currentPage == null ? "1" : currentPage));
			Pager pager=orgAcctLedgerService.search(p, orgAcctLedger);
			this.genPageJson(response, pager);
			return null;
		}
	}
	
	
	/**
	 * 去到添加查询机构充值台账页面
	 * @creator: roilatD
	 * @createDate: 2016-08-17 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param orgAcctLedger
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toAdd") @DoLog(cnContent="去到添加查询机构充值台账页面") //@Permission(name="orgAcctLedger.add")
	public ModelAndView toAdd(HttpServletRequest request, HttpServletResponse response, OrgAcctLedger orgAcctLedger) throws Exception {
		return new ModelAndView("orgAcctLedger/add");
	}

	/**
	 * 添加查询机构充值台账
	 * @creator: roilatD
	 * @createDate: 2016-08-17 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param orgAcctLedger
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/add") @DoLog(cnContent="添加查询机构充值台账") //@Permission(name="orgAcctLedger.add")
	public String add(HttpServletRequest request, HttpServletResponse response, OrgAcctLedger orgAcctLedger) throws Exception {
		BusinessMap bm = orgAcctLedgerService.create(orgAcctLedger);
		return this.ajax(response, bm.getIsSucc() ? Constants.SUCCESS : bm.getAlertMesg());
	}
	
	/**
	 * 去到编辑查询机构充值台账页面
	 * @creator: roilatD
	 * @createDate: 2016-08-17 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param orgAcctLedger
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toEdit") @DoLog(cnContent="去到编辑查询机构充值台账页面") //@Permission(name="orgAcctLedger.edit")
	public ModelAndView toEdit(HttpServletRequest request, HttpServletResponse response, OrgAcctLedger orgAcctLedger) throws Exception {
		OrgAcctLedger result = orgAcctLedgerService.getById(orgAcctLedger.getFlowId());
		return new ModelAndView("orgAcctLedger/edit").addObject("orgAcctLedger",result);
	}
	
	/**
	 * 编辑查询机构充值台账
	 * @creator: roilatD
	 * @createDate: 2016-08-17 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param orgAcctLedger
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/edit") @DoLog(cnContent="编辑查询机构充值台账") //@Permission(name="orgAcctLedger.edit")
	public String edit(HttpServletRequest request, HttpServletResponse response, OrgAcctLedger orgAcctLedger) throws Exception {
		BusinessMap bm = orgAcctLedgerService.edit(orgAcctLedger);
		return this.ajax(response, bm.getIsSucc() ? Constants.SUCCESS : bm.getAlertMesg());
	}
	
	/**
	 * 查看查询机构充值台账信息
	 * @creator: roilatD
	 * @createDate: 2016-08-17 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param orgAcctLedger
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/view") @DoLog(cnContent="查看查询机构充值台账信息") //@Permission(name="orgAcctLedger.view")
	public ModelAndView view(HttpServletRequest request, HttpServletResponse response, OrgAcctLedger orgAcctLedger) throws Exception {
		OrgAcctLedger result = orgAcctLedgerService.getById(orgAcctLedger.getFlowId());
		return new ModelAndView("orgAcctLedger/view").addObject("orgAcctLedger",result);
	}
	
	/**
	 * 删除查询机构充值台账信息
	 * @creator: roilatD
	 * @createDate: 2016-08-17 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param orgAcctLedger
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete") @DoLog(cnContent="删除查询机构充值台账信息") //@Permission(name="orgAcctLedger.delete")
	public String delete(HttpServletRequest request, HttpServletResponse response, OrgAcctLedger orgAcctLedger) throws Exception {
		boolean flag = orgAcctLedgerService.delete(orgAcctLedger.getFlowId());
		return this.ajax(response, flag ? Constants.SUCCESS : Constants.ERROR);
	}
	
}
