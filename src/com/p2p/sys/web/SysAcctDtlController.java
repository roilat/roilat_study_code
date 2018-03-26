/*
 * SysAcctDtlController.java created on 2016-07-02 下午 15:59:30 by roilatD
 */
package com.p2p.sys.web;

import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.BooleanUtils;
import com.p2p.sys.entity.SysAcctDtl;
import com.p2p.sys.service.SysAcctDtlService;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Constants;
import org.eking.framework.common.Pager;
import org.eking.framework.web.BaseController;
import org.eking.framework.web.system.interceptor.DoLog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 内部账交易明细控制器
 * TODO javadoc for org.eking.SysAcctDtl.web.SysAcctDtlController
 * @Copyright: 2014海南易建科技股份有限公司
 * @author:roilatD
 * @since: 2016-07-02
 */
@Controller
@RequestMapping("/sysAcctDtl")
public class SysAcctDtlController extends BaseController {
	
	@Resource(name = "sysAcctDtlService")
	private SysAcctDtlService sysAcctDtlService;
	
	/**
	 * 去到内部账交易明细列表页面
	 * @creator: roilatD
	 * @createDate: 2016-07-02 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param sysAcctDtl
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list") @DoLog(cnContent="查看内部账交易明细列表信息") //@Permission(name="sysAcctDtl.view")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response,SysAcctDtl sysAcctDtl) throws Exception{
		HashMap<String, Object> modelMap=new LinkedHashMap<String, Object>();
		modelMap.put("sysAcctDtl", sysAcctDtl);
		return new ModelAndView("sysAcctDtl/list").addAllObjects(modelMap);
	}
	
	/**
	 * 内部账交易明细列表ajax分页
	 * @creator: roilatD
	 * @createDate: 2016-07-02  
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param sysAcctDtl
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/ajaxPage") @DoLog(cnContent="内部账交易明细列表ajax分页") //@Permission(name="sysAcctDtl.view")
	public String ajaxPage(HttpServletRequest request,HttpServletResponse response,SysAcctDtl sysAcctDtl) throws Exception{
		Pager p=new Pager();
		boolean exportExcel = BooleanUtils.toBoolean(request.getParameter(EXPORT_EXCEL));
		if (exportExcel) {
			return null;
		}else {
			String currentPage = request.getParameter(Pager.MY_PAGINATION_CURRENT_PAGE);
			p.setCurrentPage(Integer.parseInt(currentPage == null ? "1" : currentPage));
			Pager pager=sysAcctDtlService.search(p, sysAcctDtl);
			this.genPageJson(response, pager);
			return null;
		}
	}
	
	
	/**
	 * 去到添加内部账交易明细页面
	 * @creator: roilatD
	 * @createDate: 2016-07-02 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param sysAcctDtl
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toAdd") @DoLog(cnContent="去到添加内部账交易明细页面") //@Permission(name="sysAcctDtl.add")
	public ModelAndView toAdd(HttpServletRequest request, HttpServletResponse response, SysAcctDtl sysAcctDtl) throws Exception {
		return new ModelAndView("sysAcctDtl/add");
	}

	/**
	 * 添加内部账交易明细
	 * @creator: roilatD
	 * @createDate: 2016-07-02 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param sysAcctDtl
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/add") @DoLog(cnContent="添加内部账交易明细") //@Permission(name="sysAcctDtl.add")
	public String add(HttpServletRequest request, HttpServletResponse response, SysAcctDtl sysAcctDtl) throws Exception {
		BusinessMap bm = sysAcctDtlService.create(sysAcctDtl);
		return this.ajax(response, bm.getIsSucc() ? Constants.SUCCESS : bm.getAlertMesg());
	}
	
	/**
	 * 去到编辑内部账交易明细页面
	 * @creator: roilatD
	 * @createDate: 2016-07-02 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param sysAcctDtl
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toEdit") @DoLog(cnContent="去到编辑内部账交易明细页面") //@Permission(name="sysAcctDtl.edit")
	public ModelAndView toEdit(HttpServletRequest request, HttpServletResponse response, SysAcctDtl sysAcctDtl) throws Exception {
		SysAcctDtl result = sysAcctDtlService.getById(sysAcctDtl.getTxSeqNo());
		return new ModelAndView("sysAcctDtl/edit").addObject("sysAcctDtl",result);
	}
	
	/**
	 * 编辑内部账交易明细
	 * @creator: roilatD
	 * @createDate: 2016-07-02 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param sysAcctDtl
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/edit") @DoLog(cnContent="编辑内部账交易明细") //@Permission(name="sysAcctDtl.edit")
	public String edit(HttpServletRequest request, HttpServletResponse response, SysAcctDtl sysAcctDtl) throws Exception {
		BusinessMap bm = sysAcctDtlService.edit(sysAcctDtl);
		return this.ajax(response, bm.getIsSucc() ? Constants.SUCCESS : bm.getAlertMesg());
	}
	
	/**
	 * 查看内部账交易明细信息
	 * @creator: roilatD
	 * @createDate: 2016-07-02 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param sysAcctDtl
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/view") @DoLog(cnContent="查看内部账交易明细信息") //@Permission(name="sysAcctDtl.view")
	public ModelAndView view(HttpServletRequest request, HttpServletResponse response, SysAcctDtl sysAcctDtl) throws Exception {
		SysAcctDtl result = sysAcctDtlService.getById(sysAcctDtl.getTxSeqNo());
		return new ModelAndView("sysAcctDtl/view").addObject("sysAcctDtl",result);
	}
	
	/**
	 * 删除内部账交易明细信息
	 * @creator: roilatD
	 * @createDate: 2016-07-02 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param sysAcctDtl
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete") @DoLog(cnContent="删除内部账交易明细信息") //@Permission(name="sysAcctDtl.delete")
	public String delete(HttpServletRequest request, HttpServletResponse response, SysAcctDtl sysAcctDtl) throws Exception {
		boolean flag = sysAcctDtlService.delete(sysAcctDtl.getTxSeqNo());
		return this.ajax(response, flag ? Constants.SUCCESS : Constants.ERROR);
	}
	
}
