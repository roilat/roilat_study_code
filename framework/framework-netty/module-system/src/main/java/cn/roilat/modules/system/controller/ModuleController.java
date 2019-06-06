package cn.roilat.modules.system.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.roilat.framework.core.controller.BaseController;
import cn.roilat.framework.core.dto.PageDTO;
import cn.roilat.framework.core.mvc.UrlMapping;
import cn.roilat.framework.result.ResponseResult;
import cn.roilat.modules.system.constant.Constant;
import cn.roilat.modules.system.entity.MsModule;
import cn.roilat.modules.system.entity.dto.ModuleDTO;
import cn.roilat.modules.system.service.ModuleService;

@Component
@UrlMapping("/module")
public class ModuleController extends BaseController<MsModule> {
	@Autowired
	private ModuleService moduleService;
	
	@UrlMapping("/saveModule")
	public ResponseResult saveModule(MsModule entity){
		int count = moduleService.selectModuleByName(entity);
		
		if(count != 0){
			return ResponseResult.fail("模块名称已存在");
		}
		entity.setCreateTime(new Date());
		entity.setCreateUser(Constant.userName.get());
		return super.save(entity);
	}
	
	@UrlMapping("/updateModule")
	public ResponseResult updateModule(MsModule entity){
		int count = moduleService.selectModuleByName(entity);
		
		if(count != 0){
			return ResponseResult.fail("模块名称已存在");
		}
		entity.setModifyTime(new Date());
		entity.setModifyUser(Constant.userName.get());
		return super.update(entity);
	}
	
	@UrlMapping("/updateOrderNum")
	public ResponseResult updateOrderNum(MsModule entity){
		return super.update(entity);
	}
	
	@UrlMapping("/deleteModule")
	public ResponseResult deleteModule(ModuleDTO moduleDto){
		String ids = moduleDto.getIds();
		int count = moduleService.deleteByIds(ids.split(","));
		if(count == 0){
			return ResponseResult.fail();
		} 
		return ResponseResult.succ();
	}
	
	/**
	 * 查询所有模块菜单，返回结果只包含id，moduleName字段
	 * @return
	 */
	@UrlMapping("/selectMenu")
	public ResponseResult selectMenu(){
		Map<String, List<ModuleDTO>> map = this.moduleService.listMenuAll();
		if(null != map.get("menus") && map.get("menus").size() > 0){
			return ResponseResult.succ(map);
		}
		return ResponseResult.succ(map);
	}
	
	/**
	 * 查询所有模块，返回结果为全字段
	 * @return
	 */
	@UrlMapping("/selectAll")
	public ResponseResult selectAll(ModuleDTO module){
		int totals = this.moduleService.getModuleTotals(module);
		if(totals != 0){
			int pageNum = module.getCurrentPage();
			int pageSize = module.getPageSize();
			int startIndex = (module.getCurrentPage() - 1) * module.getPageSize();
			module.setStartIndex(startIndex);
			List<MsModule> list = this.moduleService.getModuleList(module);
			PageDTO<MsModule> pd = new PageDTO<MsModule>(pageNum, pageSize, totals);
			pd.setList(list);
			return ResponseResult.succ(pd);
		} else {
			int pageNum = module.getCurrentPage();
			int pageSize = module.getPageSize();
			int startIndex = (module.getCurrentPage() - 1) * module.getPageSize();
			module.setStartIndex(startIndex);
			PageDTO<MsModule> pd = new PageDTO<MsModule>(pageNum, pageSize, totals);
			pd.setList(new ArrayList<>());
			return ResponseResult.succ(pd);
		}		
	}
}

