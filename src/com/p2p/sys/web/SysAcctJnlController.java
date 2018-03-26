/*
 * SysAcctJnlController.java created on 2016-07-02 下午 15:44:47 by roilatD
 */
package com.p2p.sys.web;

import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.BooleanUtils;
import com.p2p.sys.entity.SysAcctJnl;
import com.p2p.sys.service.SysAcctJnlService;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Constants;
import org.eking.framework.common.Pager;
import org.eking.framework.web.BaseController;
import org.eking.framework.web.system.interceptor.DoLog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 会计分录流水控制器
 * TODO javadoc for org.eking.SysAcctJnl.web.SysAcctJnlController
 * @Copyright: 2014海南易建科技股份有限公司
 * @author:roilatD
 * @since: 2016-07-02
 */
@Controller
@RequestMapping("/sysAcctJnl")
public class SysAcctJnlController extends BaseController {
	
	@Resource(name = "sysAcctJnlService")
	private SysAcctJnlService sysAcctJnlService;
	
	/**
	 * 去到会计分录流水列表页面
	 * @creator: roilatD
	 * @createDate: 2016-07-02 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param sysAcctJnl
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list") @DoLog(cnContent="查看会计分录流水列表信息") //@Permission(name="sysAcctJnl.view")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response,SysAcctJnl sysAcctJnl) throws Exception{
		HashMap<String, Object> modelMap=new LinkedHashMap<String, Object>();
		modelMap.put("sysAcctJnl", sysAcctJnl);
		return new ModelAndView("sysAcctJnl/list").addAllObjects(modelMap);
	}
	
	/**
	 * 会计分录流水列表ajax分页
	 * @creator: roilatD
	 * @createDate: 2016-07-02  
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param sysAcctJnl
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/ajaxPage") @DoLog(cnContent="会计分录流水列表ajax分页") //@Permission(name="sysAcctJnl.view")
	public String ajaxPage(HttpServletRequest request,HttpServletResponse response,SysAcctJnl sysAcctJnl) throws Exception{
		Pager p=new Pager();
		boolean exportExcel = BooleanUtils.toBoolean(request.getParameter(EXPORT_EXCEL));
		if (exportExcel) {
			return null;
		}else {
			String currentPage = request.getParameter(Pager.MY_PAGINATION_CURRENT_PAGE);
			p.setCurrentPage(Integer.parseInt(currentPage == null ? "1" : currentPage));
			Pager pager=sysAcctJnlService.search(p, sysAcctJnl);
			this.genPageJson(response, pager);
			return null;
		}
	}
	
	
	/**
	 * 去到添加会计分录流水页面
	 * @creator: roilatD
	 * @createDate: 2016-07-02 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param sysAcctJnl
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toAdd") @DoLog(cnContent="去到添加会计分录流水页面") //@Permission(name="sysAcctJnl.add")
	public ModelAndView toAdd(HttpServletRequest request, HttpServletResponse response, SysAcctJnl sysAcctJnl) throws Exception {
		return new ModelAndView("sysAcctJnl/add");
	}

	/**
	 * 添加会计分录流水
	 * @creator: roilatD
	 * @createDate: 2016-07-02 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param sysAcctJnl
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/add") @DoLog(cnContent="添加会计分录流水") //@Permission(name="sysAcctJnl.add")
	public String add(HttpServletRequest request, HttpServletResponse response, SysAcctJnl sysAcctJnl) throws Exception {
		BusinessMap bm = sysAcctJnlService.create(sysAcctJnl);
		return this.ajax(response, bm.getIsSucc() ? Constants.SUCCESS : bm.getAlertMesg());
	}
	
	/**
	 * 去到编辑会计分录流水页面
	 * @creator: roilatD
	 * @createDate: 2016-07-02 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param sysAcctJnl
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toEdit") @DoLog(cnContent="去到编辑会计分录流水页面") //@Permission(name="sysAcctJnl.edit")
	public ModelAndView toEdit(HttpServletRequest request, HttpServletResponse response, SysAcctJnl sysAcctJnl) throws Exception {
		SysAcctJnl result = sysAcctJnlService.getById(sysAcctJnl.getTxSeqNo());
		return new ModelAndView("sysAcctJnl/edit").addObject("sysAcctJnl",result);
	}
	
	/**
	 * 编辑会计分录流水
	 * @creator: roilatD
	 * @createDate: 2016-07-02 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param sysAcctJnl
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/edit") @DoLog(cnContent="编辑会计分录流水") //@Permission(name="sysAcctJnl.edit")
	public String edit(HttpServletRequest request, HttpServletResponse response, SysAcctJnl sysAcctJnl) throws Exception {
		BusinessMap bm = sysAcctJnlService.edit(sysAcctJnl);
		return this.ajax(response, bm.getIsSucc() ? Constants.SUCCESS : bm.getAlertMesg());
	}
	
	/**
	 * 查看会计分录流水信息
	 * @creator: roilatD
	 * @createDate: 2016-07-02 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param sysAcctJnl
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/view") @DoLog(cnContent="查看会计分录流水信息") //@Permission(name="sysAcctJnl.view")
	public ModelAndView view(HttpServletRequest request, HttpServletResponse response, SysAcctJnl sysAcctJnl) throws Exception {
		SysAcctJnl result = sysAcctJnlService.getById(sysAcctJnl.getTxSeqNo());
		return new ModelAndView("sysAcctJnl/view").addObject("sysAcctJnl",result);
	}
	
	/**
	 * 删除会计分录流水信息
	 * @creator: roilatD
	 * @createDate: 2016-07-02 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param sysAcctJnl
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete") @DoLog(cnContent="删除会计分录流水信息") //@Permission(name="sysAcctJnl.delete")
	public String delete(HttpServletRequest request, HttpServletResponse response, SysAcctJnl sysAcctJnl) throws Exception {
		boolean flag = sysAcctJnlService.delete(sysAcctJnl.getTxSeqNo());
		return this.ajax(response, flag ? Constants.SUCCESS : Constants.ERROR);
	}
	
}
