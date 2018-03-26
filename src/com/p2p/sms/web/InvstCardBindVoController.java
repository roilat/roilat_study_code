/*
 * InvstCardBindVoController.java created on 2016-05-27 下午 19:50:16 by roilatD
 */
package com.p2p.sms.web;

import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.BooleanUtils;
import com.p2p.sms.entity.InvstCardBindVo;
import com.p2p.sms.service.InvstCardBindVoService;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Constants;
import org.eking.framework.common.Pager;
import org.eking.framework.web.BaseController;
import org.eking.framework.web.system.interceptor.DoLog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 投资人银行卡绑定控制器
 * TODO javadoc for org.eking.InvstCardBindVo.web.InvstCardBindVoController
 * @Copyright: 2014海南易建科技股份有限公司
 * @author:roilatD
 * @since: 2016-05-27
 */
@Controller
@RequestMapping("/invstCardBindVo")
public class InvstCardBindVoController extends BaseController {
	
	@Resource(name = "invstCardBindVoService")
	private InvstCardBindVoService invstCardBindVoService;
	
	/**
	 * 去到投资人银行卡绑定列表页面
	 * @creator: roilatD
	 * @createDate: 2016-05-27 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param invstCardBindVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list") @DoLog(cnContent="查看投资人银行卡绑定列表信息") //@Permission(name="invstCardBindVo.view")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response,InvstCardBindVo invstCardBindVo) throws Exception{
		HashMap<String, Object> modelMap=new LinkedHashMap<String, Object>();
		modelMap.put("invstCardBindVo", invstCardBindVo);
		return new ModelAndView("invstCardBindVo/list").addAllObjects(modelMap);
	}
	
	/**
	 * 投资人银行卡绑定列表ajax分页
	 * @creator: roilatD
	 * @createDate: 2016-05-27  
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param invstCardBindVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/ajaxPage") @DoLog(cnContent="投资人银行卡绑定列表ajax分页") //@Permission(name="invstCardBindVo.view")
	public String ajaxPage(HttpServletRequest request,HttpServletResponse response,InvstCardBindVo invstCardBindVo) throws Exception{
		Pager p=new Pager();
		boolean exportExcel = BooleanUtils.toBoolean(request.getParameter(EXPORT_EXCEL));
		if (exportExcel) {
			return null;
		}else {
			String currentPage = request.getParameter(Pager.MY_PAGINATION_CURRENT_PAGE);
			p.setCurrentPage(Integer.parseInt(currentPage == null ? "1" : currentPage));
			Pager pager=invstCardBindVoService.search(p, invstCardBindVo);
			this.genPageJson(response, pager);
			return null;
		}
	}
	
	
	/**
	 * 去到添加投资人银行卡绑定页面
	 * @creator: roilatD
	 * @createDate: 2016-05-27 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param invstCardBindVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toAdd") @DoLog(cnContent="去到添加投资人银行卡绑定页面") //@Permission(name="invstCardBindVo.add")
	public ModelAndView toAdd(HttpServletRequest request, HttpServletResponse response, InvstCardBindVo invstCardBindVo) throws Exception {
		return new ModelAndView("invstCardBindVo/add");
	}

	/**
	 * 添加投资人银行卡绑定
	 * @creator: roilatD
	 * @createDate: 2016-05-27 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param invstCardBindVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/add") @DoLog(cnContent="添加投资人银行卡绑定") //@Permission(name="invstCardBindVo.add")
	public String add(HttpServletRequest request, HttpServletResponse response, InvstCardBindVo invstCardBindVo) throws Exception {
		BusinessMap bm = invstCardBindVoService.create(invstCardBindVo);
		return this.ajax(response, bm.getIsSucc() ? Constants.SUCCESS : bm.getAlertMesg());
	}
	
	/**
	 * 去到编辑投资人银行卡绑定页面
	 * @creator: roilatD
	 * @createDate: 2016-05-27 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param invstCardBindVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toEdit") @DoLog(cnContent="去到编辑投资人银行卡绑定页面") //@Permission(name="invstCardBindVo.edit")
	public ModelAndView toEdit(HttpServletRequest request, HttpServletResponse response, InvstCardBindVo invstCardBindVo) throws Exception {
		InvstCardBindVo result = invstCardBindVoService.getById(invstCardBindVo.getCardNo());
		return new ModelAndView("invstCardBindVo/edit").addObject("invstCardBindVo",result);
	}
	
	/**
	 * 编辑投资人银行卡绑定
	 * @creator: roilatD
	 * @createDate: 2016-05-27 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param invstCardBindVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/edit") @DoLog(cnContent="编辑投资人银行卡绑定") //@Permission(name="invstCardBindVo.edit")
	public String edit(HttpServletRequest request, HttpServletResponse response, InvstCardBindVo invstCardBindVo) throws Exception {
		BusinessMap bm = invstCardBindVoService.edit(invstCardBindVo);
		return this.ajax(response, bm.getIsSucc() ? Constants.SUCCESS : bm.getAlertMesg());
	}
	
	/**
	 * 查看投资人银行卡绑定信息
	 * @creator: roilatD
	 * @createDate: 2016-05-27 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param invstCardBindVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/view") @DoLog(cnContent="查看投资人银行卡绑定信息") //@Permission(name="invstCardBindVo.view")
	public ModelAndView view(HttpServletRequest request, HttpServletResponse response, InvstCardBindVo invstCardBindVo) throws Exception {
		InvstCardBindVo result = invstCardBindVoService.getById(invstCardBindVo.getCardNo());
		return new ModelAndView("invstCardBindVo/view").addObject("invstCardBindVo",result);
	}
	
	/**
	 * 删除投资人银行卡绑定信息
	 * @creator: roilatD
	 * @createDate: 2016-05-27 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param invstCardBindVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete") @DoLog(cnContent="删除投资人银行卡绑定信息") //@Permission(name="invstCardBindVo.delete")
	public String delete(HttpServletRequest request, HttpServletResponse response, InvstCardBindVo invstCardBindVo) throws Exception {
		boolean flag = invstCardBindVoService.delete(invstCardBindVo.getCardNo());
		return this.ajax(response, flag ? Constants.SUCCESS : Constants.ERROR);
	}
	
}
