/*
 * LoanBlackPhoneListController.java created on 2016-08-17 下午 16:21:38 by roilatD
 */
package com.hansy.dataservice.busi1.web;

import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.BooleanUtils;
import com.hansy.dataservice.busi1.entity.LoanBlackPhoneList;
import com.hansy.dataservice.busi1.service.LoanBlackPhoneListService;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Constants;
import org.eking.framework.common.Pager;
import org.eking.framework.web.BaseController;
import org.eking.framework.web.system.interceptor.DoLog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 电话黑名单控制器
 * TODO javadoc for org.eking.LoanBlackPhoneList.web.LoanBlackPhoneListController
 * @Copyright: 2014海南易建科技股份有限公司
 * @author:roilatD
 * @since: 2016-08-17
 */
@Controller
@RequestMapping("/loanBlackPhoneList")
public class LoanBlackPhoneListController extends BaseController {
	
	@Resource(name = "loanBlackPhoneListService")
	private LoanBlackPhoneListService loanBlackPhoneListService;
	
	/**
	 * 去到电话黑名单列表页面
	 * @creator: roilatD
	 * @createDate: 2016-08-17 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param loanBlackPhoneList
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list") @DoLog(cnContent="查看电话黑名单列表信息") //@Permission(name="loanBlackPhoneList.view")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response,LoanBlackPhoneList loanBlackPhoneList) throws Exception{
		HashMap<String, Object> modelMap=new LinkedHashMap<String, Object>();
		modelMap.put("loanBlackPhoneList", loanBlackPhoneList);
		return new ModelAndView("loanBlackPhoneList/list").addAllObjects(modelMap);
	}
	
	/**
	 * 电话黑名单列表ajax分页
	 * @creator: roilatD
	 * @createDate: 2016-08-17  
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param loanBlackPhoneList
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/ajaxPage") @DoLog(cnContent="电话黑名单列表ajax分页") //@Permission(name="loanBlackPhoneList.view")
	public String ajaxPage(HttpServletRequest request,HttpServletResponse response,LoanBlackPhoneList loanBlackPhoneList) throws Exception{
		Pager p=new Pager();
		boolean exportExcel = BooleanUtils.toBoolean(request.getParameter(EXPORT_EXCEL));
		if (exportExcel) {
			return null;
		}else {
			String currentPage = request.getParameter(Pager.MY_PAGINATION_CURRENT_PAGE);
			p.setCurrentPage(Integer.parseInt(currentPage == null ? "1" : currentPage));
			Pager pager=loanBlackPhoneListService.search(p, loanBlackPhoneList);
			this.genPageJson(response, pager);
			return null;
		}
	}
	
	
	/**
	 * 去到添加电话黑名单页面
	 * @creator: roilatD
	 * @createDate: 2016-08-17 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param loanBlackPhoneList
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toAdd") @DoLog(cnContent="去到添加电话黑名单页面") //@Permission(name="loanBlackPhoneList.add")
	public ModelAndView toAdd(HttpServletRequest request, HttpServletResponse response, LoanBlackPhoneList loanBlackPhoneList) throws Exception {
		return new ModelAndView("loanBlackPhoneList/add");
	}

	/**
	 * 添加电话黑名单
	 * @creator: roilatD
	 * @createDate: 2016-08-17 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param loanBlackPhoneList
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/add") @DoLog(cnContent="添加电话黑名单") //@Permission(name="loanBlackPhoneList.add")
	public String add(HttpServletRequest request, HttpServletResponse response, LoanBlackPhoneList loanBlackPhoneList) throws Exception {
		BusinessMap bm = loanBlackPhoneListService.create(loanBlackPhoneList);
		return this.ajax(response, bm.getIsSucc() ? Constants.SUCCESS : bm.getAlertMesg());
	}
	
	/**
	 * 去到编辑电话黑名单页面
	 * @creator: roilatD
	 * @createDate: 2016-08-17 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param loanBlackPhoneList
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toEdit") @DoLog(cnContent="去到编辑电话黑名单页面") //@Permission(name="loanBlackPhoneList.edit")
	public ModelAndView toEdit(HttpServletRequest request, HttpServletResponse response, LoanBlackPhoneList loanBlackPhoneList) throws Exception {
		LoanBlackPhoneList result = loanBlackPhoneListService.getById(loanBlackPhoneList.getTableKey());
		return new ModelAndView("loanBlackPhoneList/edit").addObject("loanBlackPhoneList",result);
	}
	
	/**
	 * 编辑电话黑名单
	 * @creator: roilatD
	 * @createDate: 2016-08-17 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param loanBlackPhoneList
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/edit") @DoLog(cnContent="编辑电话黑名单") //@Permission(name="loanBlackPhoneList.edit")
	public String edit(HttpServletRequest request, HttpServletResponse response, LoanBlackPhoneList loanBlackPhoneList) throws Exception {
		BusinessMap bm = loanBlackPhoneListService.edit(loanBlackPhoneList);
		return this.ajax(response, bm.getIsSucc() ? Constants.SUCCESS : bm.getAlertMesg());
	}
	
	/**
	 * 查看电话黑名单信息
	 * @creator: roilatD
	 * @createDate: 2016-08-17 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param loanBlackPhoneList
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/view") @DoLog(cnContent="查看电话黑名单信息") //@Permission(name="loanBlackPhoneList.view")
	public ModelAndView view(HttpServletRequest request, HttpServletResponse response, LoanBlackPhoneList loanBlackPhoneList) throws Exception {
		LoanBlackPhoneList result = loanBlackPhoneListService.getById(loanBlackPhoneList.getTableKey());
		return new ModelAndView("loanBlackPhoneList/view").addObject("loanBlackPhoneList",result);
	}
	
	/**
	 * 删除电话黑名单信息
	 * @creator: roilatD
	 * @createDate: 2016-08-17 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param loanBlackPhoneList
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete") @DoLog(cnContent="删除电话黑名单信息") //@Permission(name="loanBlackPhoneList.delete")
	public String delete(HttpServletRequest request, HttpServletResponse response, LoanBlackPhoneList loanBlackPhoneList) throws Exception {
		boolean flag = loanBlackPhoneListService.delete(loanBlackPhoneList.getTableKey());
		return this.ajax(response, flag ? Constants.SUCCESS : Constants.ERROR);
	}
	
}
