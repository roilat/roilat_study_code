/*
 * InvstAcctRegController.java created on 2016-06-12 上午 09:37:57 by roilatD
 */
package com.p2p.invst.web;

import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.BooleanUtils;
import com.p2p.invst.entity.InvstAcctReg;
import com.p2p.invst.service.InvstAcctRegService;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Constants;
import org.eking.framework.common.Pager;
import org.eking.framework.web.BaseController;
import org.eking.framework.web.system.interceptor.DoLog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 投资登记薄控制器
 * TODO javadoc for org.eking.InvstAcctReg.web.InvstAcctRegController
 * @Copyright: 2014海南易建科技股份有限公司
 * @author:roilatD
 * @since: 2016-06-12
 */
@Controller
@RequestMapping("/invstAcctReg")
public class InvstAcctRegController extends BaseController {
	
	@Resource(name = "invstAcctRegService")
	private InvstAcctRegService invstAcctRegService;
	
	/**
	 * 去到投资登记薄列表页面
	 * @creator: roilatD
	 * @createDate: 2016-06-12 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param invstAcctReg
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list") @DoLog(cnContent="查看投资登记薄列表信息") //@Permission(name="invstAcctReg.view")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response,InvstAcctReg invstAcctReg) throws Exception{
		HashMap<String, Object> modelMap=new LinkedHashMap<String, Object>();
		modelMap.put("invstAcctReg", invstAcctReg);
		return new ModelAndView("invstAcctReg/list").addAllObjects(modelMap);
	}
	
	/**
	 * 投资登记薄列表ajax分页
	 * @creator: roilatD
	 * @createDate: 2016-06-12  
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param invstAcctReg
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/ajaxPage") @DoLog(cnContent="投资登记薄列表ajax分页") //@Permission(name="invstAcctReg.view")
	public String ajaxPage(HttpServletRequest request,HttpServletResponse response,InvstAcctReg invstAcctReg) throws Exception{
		Pager p=new Pager();
		boolean exportExcel = BooleanUtils.toBoolean(request.getParameter(EXPORT_EXCEL));
		if (exportExcel) {
			return null;
		}else {
			String currentPage = request.getParameter(Pager.MY_PAGINATION_CURRENT_PAGE);
			p.setCurrentPage(Integer.parseInt(currentPage == null ? "1" : currentPage));
			Pager pager=invstAcctRegService.search(p, invstAcctReg);
			this.genPageJson(response, pager);
			return null;
		}
	}
	
	
	/**
	 * 去到添加投资登记薄页面
	 * @creator: roilatD
	 * @createDate: 2016-06-12 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param invstAcctReg
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toAdd") @DoLog(cnContent="去到添加投资登记薄页面") //@Permission(name="invstAcctReg.add")
	public ModelAndView toAdd(HttpServletRequest request, HttpServletResponse response, InvstAcctReg invstAcctReg) throws Exception {
		return new ModelAndView("invstAcctReg/add");
	}

	/**
	 * 添加投资登记薄
	 * @creator: roilatD
	 * @createDate: 2016-06-12 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param invstAcctReg
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/add") @DoLog(cnContent="添加投资登记薄") //@Permission(name="invstAcctReg.add")
	public String add(HttpServletRequest request, HttpServletResponse response, InvstAcctReg invstAcctReg) throws Exception {
		BusinessMap bm = invstAcctRegService.create(invstAcctReg);
		return this.ajax(response, bm.getIsSucc() ? Constants.SUCCESS : bm.getAlertMesg());
	}
	
	/**
	 * 去到编辑投资登记薄页面
	 * @creator: roilatD
	 * @createDate: 2016-06-12 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param invstAcctReg
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toEdit") @DoLog(cnContent="去到编辑投资登记薄页面") //@Permission(name="invstAcctReg.edit")
	public ModelAndView toEdit(HttpServletRequest request, HttpServletResponse response, InvstAcctReg invstAcctReg) throws Exception {
		InvstAcctReg result = invstAcctRegService.getById(invstAcctReg.getInvstNo());
		return new ModelAndView("invstAcctReg/edit").addObject("invstAcctReg",result);
	}
	
	/**
	 * 编辑投资登记薄
	 * @creator: roilatD
	 * @createDate: 2016-06-12 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param invstAcctReg
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/edit") @DoLog(cnContent="编辑投资登记薄") //@Permission(name="invstAcctReg.edit")
	public String edit(HttpServletRequest request, HttpServletResponse response, InvstAcctReg invstAcctReg) throws Exception {
		BusinessMap bm = invstAcctRegService.edit(invstAcctReg);
		return this.ajax(response, bm.getIsSucc() ? Constants.SUCCESS : bm.getAlertMesg());
	}
	
	/**
	 * 查看投资登记薄信息
	 * @creator: roilatD
	 * @createDate: 2016-06-12 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param invstAcctReg
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/view") @DoLog(cnContent="查看投资登记薄信息") //@Permission(name="invstAcctReg.view")
	public ModelAndView view(HttpServletRequest request, HttpServletResponse response, InvstAcctReg invstAcctReg) throws Exception {
		InvstAcctReg result = invstAcctRegService.getById(invstAcctReg.getInvstNo());
		return new ModelAndView("invstAcctReg/view").addObject("invstAcctReg",result);
	}
	
	/**
	 * 删除投资登记薄信息
	 * @creator: roilatD
	 * @createDate: 2016-06-12 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param invstAcctReg
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete") @DoLog(cnContent="删除投资登记薄信息") //@Permission(name="invstAcctReg.delete")
	public String delete(HttpServletRequest request, HttpServletResponse response, InvstAcctReg invstAcctReg) throws Exception {
		boolean flag = invstAcctRegService.delete(invstAcctReg.getInvstNo());
		return this.ajax(response, flag ? Constants.SUCCESS : Constants.ERROR);
	}
	
}
