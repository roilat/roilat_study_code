/*
 * LoanCustBaseInfoController.java created on 2016-08-17 下午 16:20:39 by roilatD
 */
package com.hansy.dataservice.busi1.web;

import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.BooleanUtils;
import com.hansy.dataservice.busi1.entity.LoanCustBaseInfo;
import com.hansy.dataservice.busi1.service.LoanCustBaseInfoService;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Constants;
import org.eking.framework.common.Pager;
import org.eking.framework.web.BaseController;
import org.eking.framework.web.system.interceptor.DoLog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 贷款客户基本信息控制器
 * TODO javadoc for org.eking.LoanCustBaseInfo.web.LoanCustBaseInfoController
 * @Copyright: 2014海南易建科技股份有限公司
 * @author:roilatD
 * @since: 2016-08-17
 */
@Controller
@RequestMapping("/loanCustBaseInfo")
public class LoanCustBaseInfoController extends BaseController {
	
	@Resource(name = "loanCustBaseInfoService")
	private LoanCustBaseInfoService loanCustBaseInfoService;
	
	/**
	 * 去到贷款客户基本信息列表页面
	 * @creator: roilatD
	 * @createDate: 2016-08-17 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param loanCustBaseInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list") @DoLog(cnContent="查看贷款客户基本信息列表信息") //@Permission(name="loanCustBaseInfo.view")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response,LoanCustBaseInfo loanCustBaseInfo) throws Exception{
		HashMap<String, Object> modelMap=new LinkedHashMap<String, Object>();
		modelMap.put("loanCustBaseInfo", loanCustBaseInfo);
		return new ModelAndView("loanCustBaseInfo/list").addAllObjects(modelMap);
	}
	
	/**
	 * 贷款客户基本信息列表ajax分页
	 * @creator: roilatD
	 * @createDate: 2016-08-17  
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param loanCustBaseInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/ajaxPage") @DoLog(cnContent="贷款客户基本信息列表ajax分页") //@Permission(name="loanCustBaseInfo.view")
	public String ajaxPage(HttpServletRequest request,HttpServletResponse response,LoanCustBaseInfo loanCustBaseInfo) throws Exception{
		Pager p=new Pager();
		boolean exportExcel = BooleanUtils.toBoolean(request.getParameter(EXPORT_EXCEL));
		if (exportExcel) {
			return null;
		}else {
			String currentPage = request.getParameter(Pager.MY_PAGINATION_CURRENT_PAGE);
			p.setCurrentPage(Integer.parseInt(currentPage == null ? "1" : currentPage));
			Pager pager=loanCustBaseInfoService.search(p, loanCustBaseInfo);
			this.genPageJson(response, pager);
			return null;
		}
	}
	
	
	/**
	 * 去到添加贷款客户基本信息页面
	 * @creator: roilatD
	 * @createDate: 2016-08-17 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param loanCustBaseInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toAdd") @DoLog(cnContent="去到添加贷款客户基本信息页面") //@Permission(name="loanCustBaseInfo.add")
	public ModelAndView toAdd(HttpServletRequest request, HttpServletResponse response, LoanCustBaseInfo loanCustBaseInfo) throws Exception {
		return new ModelAndView("loanCustBaseInfo/add");
	}

	/**
	 * 添加贷款客户基本信息
	 * @creator: roilatD
	 * @createDate: 2016-08-17 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param loanCustBaseInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/add") @DoLog(cnContent="添加贷款客户基本信息") //@Permission(name="loanCustBaseInfo.add")
	public String add(HttpServletRequest request, HttpServletResponse response, LoanCustBaseInfo loanCustBaseInfo) throws Exception {
		BusinessMap bm = loanCustBaseInfoService.create(loanCustBaseInfo);
		return this.ajax(response, bm.getIsSucc() ? Constants.SUCCESS : bm.getAlertMesg());
	}
	
	/**
	 * 去到编辑贷款客户基本信息页面
	 * @creator: roilatD
	 * @createDate: 2016-08-17 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param loanCustBaseInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toEdit") @DoLog(cnContent="去到编辑贷款客户基本信息页面") //@Permission(name="loanCustBaseInfo.edit")
	public ModelAndView toEdit(HttpServletRequest request, HttpServletResponse response, LoanCustBaseInfo loanCustBaseInfo) throws Exception {
		LoanCustBaseInfo result = loanCustBaseInfoService.getById(loanCustBaseInfo.getCustName());
		return new ModelAndView("loanCustBaseInfo/edit").addObject("loanCustBaseInfo",result);
	}
	
	/**
	 * 编辑贷款客户基本信息
	 * @creator: roilatD
	 * @createDate: 2016-08-17 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param loanCustBaseInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/edit") @DoLog(cnContent="编辑贷款客户基本信息") //@Permission(name="loanCustBaseInfo.edit")
	public String edit(HttpServletRequest request, HttpServletResponse response, LoanCustBaseInfo loanCustBaseInfo) throws Exception {
		BusinessMap bm = loanCustBaseInfoService.edit(loanCustBaseInfo);
		return this.ajax(response, bm.getIsSucc() ? Constants.SUCCESS : bm.getAlertMesg());
	}
	
	/**
	 * 查看贷款客户基本信息信息
	 * @creator: roilatD
	 * @createDate: 2016-08-17 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param loanCustBaseInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/view") @DoLog(cnContent="查看贷款客户基本信息信息") //@Permission(name="loanCustBaseInfo.view")
	public ModelAndView view(HttpServletRequest request, HttpServletResponse response, LoanCustBaseInfo loanCustBaseInfo) throws Exception {
		LoanCustBaseInfo result = loanCustBaseInfoService.getById(loanCustBaseInfo.getCustName());
		return new ModelAndView("loanCustBaseInfo/view").addObject("loanCustBaseInfo",result);
	}
	
	/**
	 * 删除贷款客户基本信息信息
	 * @creator: roilatD
	 * @createDate: 2016-08-17 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param loanCustBaseInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete") @DoLog(cnContent="删除贷款客户基本信息信息") //@Permission(name="loanCustBaseInfo.delete")
	public String delete(HttpServletRequest request, HttpServletResponse response, LoanCustBaseInfo loanCustBaseInfo) throws Exception {
		boolean flag = loanCustBaseInfoService.delete(loanCustBaseInfo.getCustName());
		return this.ajax(response, flag ? Constants.SUCCESS : Constants.ERROR);
	}
	
}
