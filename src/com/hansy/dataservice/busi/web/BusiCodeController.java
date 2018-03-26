/*
 * BusiCodeController.java created on 2016-08-17 下午 16:19:15 by roilatD
 */
package com.hansy.dataservice.busi.web;

import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.BooleanUtils;
import com.hansy.dataservice.busi.entity.BusiCode;
import com.hansy.dataservice.busi.service.BusiCodeService;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Constants;
import org.eking.framework.common.Pager;
import org.eking.framework.web.BaseController;
import org.eking.framework.web.system.interceptor.DoLog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 业务参数设置控制器
 * TODO javadoc for org.eking.BusiCode.web.BusiCodeController
 * @Copyright: 2014海南易建科技股份有限公司
 * @author:roilatD
 * @since: 2016-08-17
 */
@Controller
@RequestMapping("/busiCode")
public class BusiCodeController extends BaseController {
	
	@Resource(name = "busiCodeService")
	private BusiCodeService busiCodeService;
	
	/**
	 * 去到业务参数设置列表页面
	 * @creator: roilatD
	 * @createDate: 2016-08-17 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param busiCode
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list") @DoLog(cnContent="查看业务参数设置列表信息") //@Permission(name="busiCode.view")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response,BusiCode busiCode) throws Exception{
		HashMap<String, Object> modelMap=new LinkedHashMap<String, Object>();
		modelMap.put("busiCode", busiCode);
		return new ModelAndView("busiCode/list").addAllObjects(modelMap);
	}
	
	/**
	 * 业务参数设置列表ajax分页
	 * @creator: roilatD
	 * @createDate: 2016-08-17  
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param busiCode
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/ajaxPage") @DoLog(cnContent="业务参数设置列表ajax分页") //@Permission(name="busiCode.view")
	public String ajaxPage(HttpServletRequest request,HttpServletResponse response,BusiCode busiCode) throws Exception{
		Pager p=new Pager();
		boolean exportExcel = BooleanUtils.toBoolean(request.getParameter(EXPORT_EXCEL));
		if (exportExcel) {
			return null;
		}else {
			String currentPage = request.getParameter(Pager.MY_PAGINATION_CURRENT_PAGE);
			p.setCurrentPage(Integer.parseInt(currentPage == null ? "1" : currentPage));
			Pager pager=busiCodeService.search(p, busiCode);
			this.genPageJson(response, pager);
			return null;
		}
	}
	
	
	/**
	 * 去到添加业务参数设置页面
	 * @creator: roilatD
	 * @createDate: 2016-08-17 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param busiCode
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toAdd") @DoLog(cnContent="去到添加业务参数设置页面") //@Permission(name="busiCode.add")
	public ModelAndView toAdd(HttpServletRequest request, HttpServletResponse response, BusiCode busiCode) throws Exception {
		return new ModelAndView("busiCode/add");
	}

	/**
	 * 添加业务参数设置
	 * @creator: roilatD
	 * @createDate: 2016-08-17 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param busiCode
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/add") @DoLog(cnContent="添加业务参数设置") //@Permission(name="busiCode.add")
	public String add(HttpServletRequest request, HttpServletResponse response, BusiCode busiCode) throws Exception {
		BusinessMap bm = busiCodeService.create(busiCode);
		return this.ajax(response, bm.getIsSucc() ? Constants.SUCCESS : bm.getAlertMesg());
	}
	
	/**
	 * 去到编辑业务参数设置页面
	 * @creator: roilatD
	 * @createDate: 2016-08-17 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param busiCode
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toEdit") @DoLog(cnContent="去到编辑业务参数设置页面") //@Permission(name="busiCode.edit")
	public ModelAndView toEdit(HttpServletRequest request, HttpServletResponse response, BusiCode busiCode) throws Exception {
		BusiCode result = busiCodeService.getById(busiCode.getBizTypeCode());
		return new ModelAndView("busiCode/edit").addObject("busiCode",result);
	}
	
	/**
	 * 编辑业务参数设置
	 * @creator: roilatD
	 * @createDate: 2016-08-17 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param busiCode
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/edit") @DoLog(cnContent="编辑业务参数设置") //@Permission(name="busiCode.edit")
	public String edit(HttpServletRequest request, HttpServletResponse response, BusiCode busiCode) throws Exception {
		BusinessMap bm = busiCodeService.edit(busiCode);
		return this.ajax(response, bm.getIsSucc() ? Constants.SUCCESS : bm.getAlertMesg());
	}
	
	/**
	 * 查看业务参数设置信息
	 * @creator: roilatD
	 * @createDate: 2016-08-17 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param busiCode
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/view") @DoLog(cnContent="查看业务参数设置信息") //@Permission(name="busiCode.view")
	public ModelAndView view(HttpServletRequest request, HttpServletResponse response, BusiCode busiCode) throws Exception {
		BusiCode result = busiCodeService.getById(busiCode.getBizTypeCode());
		return new ModelAndView("busiCode/view").addObject("busiCode",result);
	}
	
	/**
	 * 删除业务参数设置信息
	 * @creator: roilatD
	 * @createDate: 2016-08-17 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param busiCode
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete") @DoLog(cnContent="删除业务参数设置信息") //@Permission(name="busiCode.delete")
	public String delete(HttpServletRequest request, HttpServletResponse response, BusiCode busiCode) throws Exception {
		boolean flag = busiCodeService.delete(busiCode.getBizTypeCode());
		return this.ajax(response, flag ? Constants.SUCCESS : Constants.ERROR);
	}
	
}
