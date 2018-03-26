/*
 * LoanBlackListController.java created on 2016-08-17 下午 16:21:06 by roilatD
 */
package com.hansy.dataservice.busi1.web;

import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.BooleanUtils;
import com.hansy.dataservice.busi1.entity.LoanBlackList;
import com.hansy.dataservice.busi1.service.LoanBlackListService;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Constants;
import org.eking.framework.common.Pager;
import org.eking.framework.web.BaseController;
import org.eking.framework.web.system.interceptor.DoLog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 黑名单表控制器
 * TODO javadoc for org.eking.LoanBlackList.web.LoanBlackListController
 * @Copyright: 2014海南易建科技股份有限公司
 * @author:roilatD
 * @since: 2016-08-17
 */
@Controller
@RequestMapping("/loanBlackList")
public class LoanBlackListController extends BaseController {
	
	@Resource(name = "loanBlackListService")
	private LoanBlackListService loanBlackListService;
	
	/**
	 * 去到黑名单表列表页面
	 * @creator: roilatD
	 * @createDate: 2016-08-17 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param loanBlackList
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list") @DoLog(cnContent="查看黑名单表列表信息") //@Permission(name="loanBlackList.view")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response,LoanBlackList loanBlackList) throws Exception{
		HashMap<String, Object> modelMap=new LinkedHashMap<String, Object>();
		modelMap.put("loanBlackList", loanBlackList);
		return new ModelAndView("loanBlackList/list").addAllObjects(modelMap);
	}
	
	/**
	 * 黑名单表列表ajax分页
	 * @creator: roilatD
	 * @createDate: 2016-08-17  
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param loanBlackList
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/ajaxPage") @DoLog(cnContent="黑名单表列表ajax分页") //@Permission(name="loanBlackList.view")
	public String ajaxPage(HttpServletRequest request,HttpServletResponse response,LoanBlackList loanBlackList) throws Exception{
		Pager p=new Pager();
		boolean exportExcel = BooleanUtils.toBoolean(request.getParameter(EXPORT_EXCEL));
		if (exportExcel) {
			return null;
		}else {
			String currentPage = request.getParameter(Pager.MY_PAGINATION_CURRENT_PAGE);
			p.setCurrentPage(Integer.parseInt(currentPage == null ? "1" : currentPage));
			Pager pager=loanBlackListService.search(p, loanBlackList);
			this.genPageJson(response, pager);
			return null;
		}
	}
	
	
	/**
	 * 去到添加黑名单表页面
	 * @creator: roilatD
	 * @createDate: 2016-08-17 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param loanBlackList
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toAdd") @DoLog(cnContent="去到添加黑名单表页面") //@Permission(name="loanBlackList.add")
	public ModelAndView toAdd(HttpServletRequest request, HttpServletResponse response, LoanBlackList loanBlackList) throws Exception {
		return new ModelAndView("loanBlackList/add");
	}

	/**
	 * 添加黑名单表
	 * @creator: roilatD
	 * @createDate: 2016-08-17 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param loanBlackList
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/add") @DoLog(cnContent="添加黑名单表") //@Permission(name="loanBlackList.add")
	public String add(HttpServletRequest request, HttpServletResponse response, LoanBlackList loanBlackList) throws Exception {
		BusinessMap bm = loanBlackListService.create(loanBlackList);
		return this.ajax(response, bm.getIsSucc() ? Constants.SUCCESS : bm.getAlertMesg());
	}
	
	/**
	 * 去到编辑黑名单表页面
	 * @creator: roilatD
	 * @createDate: 2016-08-17 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param loanBlackList
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toEdit") @DoLog(cnContent="去到编辑黑名单表页面") //@Permission(name="loanBlackList.edit")
	public ModelAndView toEdit(HttpServletRequest request, HttpServletResponse response, LoanBlackList loanBlackList) throws Exception {
		LoanBlackList result = loanBlackListService.getById(loanBlackList.getTableKey());
		return new ModelAndView("loanBlackList/edit").addObject("loanBlackList",result);
	}
	
	/**
	 * 编辑黑名单表
	 * @creator: roilatD
	 * @createDate: 2016-08-17 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param loanBlackList
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/edit") @DoLog(cnContent="编辑黑名单表") //@Permission(name="loanBlackList.edit")
	public String edit(HttpServletRequest request, HttpServletResponse response, LoanBlackList loanBlackList) throws Exception {
		BusinessMap bm = loanBlackListService.edit(loanBlackList);
		return this.ajax(response, bm.getIsSucc() ? Constants.SUCCESS : bm.getAlertMesg());
	}
	
	/**
	 * 查看黑名单表信息
	 * @creator: roilatD
	 * @createDate: 2016-08-17 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param loanBlackList
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/view") @DoLog(cnContent="查看黑名单表信息") //@Permission(name="loanBlackList.view")
	public ModelAndView view(HttpServletRequest request, HttpServletResponse response, LoanBlackList loanBlackList) throws Exception {
		LoanBlackList result = loanBlackListService.getById(loanBlackList.getTableKey());
		return new ModelAndView("loanBlackList/view").addObject("loanBlackList",result);
	}
	
	/**
	 * 删除黑名单表信息
	 * @creator: roilatD
	 * @createDate: 2016-08-17 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param loanBlackList
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete") @DoLog(cnContent="删除黑名单表信息") //@Permission(name="loanBlackList.delete")
	public String delete(HttpServletRequest request, HttpServletResponse response, LoanBlackList loanBlackList) throws Exception {
		boolean flag = loanBlackListService.delete(loanBlackList.getTableKey());
		return this.ajax(response, flag ? Constants.SUCCESS : Constants.ERROR);
	}
	
}
