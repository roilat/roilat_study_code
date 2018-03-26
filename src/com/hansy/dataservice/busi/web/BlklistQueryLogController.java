/*
 * BlklistQueryLogController.java created on 2016-08-17 下午 16:18:45 by roilatD
 */
package com.hansy.dataservice.busi.web;

import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.BooleanUtils;
import com.hansy.dataservice.busi.entity.BlklistQueryLog;
import com.hansy.dataservice.busi.service.BlklistQueryLogService;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Constants;
import org.eking.framework.common.Pager;
import org.eking.framework.web.BaseController;
import org.eking.framework.web.system.interceptor.DoLog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 黑名单查询日志控制器
 * TODO javadoc for org.eking.BlklistQueryLog.web.BlklistQueryLogController
 * @Copyright: 2014海南易建科技股份有限公司
 * @author:roilatD
 * @since: 2016-08-17
 */
@Controller
@RequestMapping("/blklistQueryLog")
public class BlklistQueryLogController extends BaseController {
	
	@Resource(name = "blklistQueryLogService")
	private BlklistQueryLogService blklistQueryLogService;
	
	/**
	 * 去到黑名单查询日志列表页面
	 * @creator: roilatD
	 * @createDate: 2016-08-17 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param blklistQueryLog
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list") @DoLog(cnContent="查看黑名单查询日志列表信息") //@Permission(name="blklistQueryLog.view")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response,BlklistQueryLog blklistQueryLog) throws Exception{
		HashMap<String, Object> modelMap=new LinkedHashMap<String, Object>();
		modelMap.put("blklistQueryLog", blklistQueryLog);
		return new ModelAndView("blklistQueryLog/list").addAllObjects(modelMap);
	}
	
	/**
	 * 黑名单查询日志列表ajax分页
	 * @creator: roilatD
	 * @createDate: 2016-08-17  
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param blklistQueryLog
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/ajaxPage") @DoLog(cnContent="黑名单查询日志列表ajax分页") //@Permission(name="blklistQueryLog.view")
	public String ajaxPage(HttpServletRequest request,HttpServletResponse response,BlklistQueryLog blklistQueryLog) throws Exception{
		Pager p=new Pager();
		boolean exportExcel = BooleanUtils.toBoolean(request.getParameter(EXPORT_EXCEL));
		if (exportExcel) {
			return null;
		}else {
			String currentPage = request.getParameter(Pager.MY_PAGINATION_CURRENT_PAGE);
			p.setCurrentPage(Integer.parseInt(currentPage == null ? "1" : currentPage));
			Pager pager=blklistQueryLogService.search(p, blklistQueryLog);
			this.genPageJson(response, pager);
			return null;
		}
	}
	
	
	/**
	 * 去到添加黑名单查询日志页面
	 * @creator: roilatD
	 * @createDate: 2016-08-17 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param blklistQueryLog
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toAdd") @DoLog(cnContent="去到添加黑名单查询日志页面") //@Permission(name="blklistQueryLog.add")
	public ModelAndView toAdd(HttpServletRequest request, HttpServletResponse response, BlklistQueryLog blklistQueryLog) throws Exception {
		return new ModelAndView("blklistQueryLog/add");
	}

	/**
	 * 添加黑名单查询日志
	 * @creator: roilatD
	 * @createDate: 2016-08-17 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param blklistQueryLog
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/add") @DoLog(cnContent="添加黑名单查询日志") //@Permission(name="blklistQueryLog.add")
	public String add(HttpServletRequest request, HttpServletResponse response, BlklistQueryLog blklistQueryLog) throws Exception {
		BusinessMap bm = blklistQueryLogService.create(blklistQueryLog);
		return this.ajax(response, bm.getIsSucc() ? Constants.SUCCESS : bm.getAlertMesg());
	}
	
	/**
	 * 去到编辑黑名单查询日志页面
	 * @creator: roilatD
	 * @createDate: 2016-08-17 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param blklistQueryLog
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toEdit") @DoLog(cnContent="去到编辑黑名单查询日志页面") //@Permission(name="blklistQueryLog.edit")
	public ModelAndView toEdit(HttpServletRequest request, HttpServletResponse response, BlklistQueryLog blklistQueryLog) throws Exception {
		BlklistQueryLog result = blklistQueryLogService.getById(blklistQueryLog.getOrgId());
		return new ModelAndView("blklistQueryLog/edit").addObject("blklistQueryLog",result);
	}
	
	/**
	 * 编辑黑名单查询日志
	 * @creator: roilatD
	 * @createDate: 2016-08-17 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param blklistQueryLog
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/edit") @DoLog(cnContent="编辑黑名单查询日志") //@Permission(name="blklistQueryLog.edit")
	public String edit(HttpServletRequest request, HttpServletResponse response, BlklistQueryLog blklistQueryLog) throws Exception {
		BusinessMap bm = blklistQueryLogService.edit(blklistQueryLog);
		return this.ajax(response, bm.getIsSucc() ? Constants.SUCCESS : bm.getAlertMesg());
	}
	
	/**
	 * 查看黑名单查询日志信息
	 * @creator: roilatD
	 * @createDate: 2016-08-17 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param blklistQueryLog
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/view") @DoLog(cnContent="查看黑名单查询日志信息") //@Permission(name="blklistQueryLog.view")
	public ModelAndView view(HttpServletRequest request, HttpServletResponse response, BlklistQueryLog blklistQueryLog) throws Exception {
		BlklistQueryLog result = blklistQueryLogService.getById(blklistQueryLog.getOrgId());
		return new ModelAndView("blklistQueryLog/view").addObject("blklistQueryLog",result);
	}
	
	/**
	 * 删除黑名单查询日志信息
	 * @creator: roilatD
	 * @createDate: 2016-08-17 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param blklistQueryLog
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete") @DoLog(cnContent="删除黑名单查询日志信息") //@Permission(name="blklistQueryLog.delete")
	public String delete(HttpServletRequest request, HttpServletResponse response, BlklistQueryLog blklistQueryLog) throws Exception {
		boolean flag = blklistQueryLogService.delete(blklistQueryLog.getOrgId());
		return this.ajax(response, flag ? Constants.SUCCESS : Constants.ERROR);
	}
	
}
