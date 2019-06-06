package cn.roilat.modules.system.service;

import java.util.List;
import java.util.Map;

import cn.roilat.framework.core.service.BaseService;
import cn.roilat.modules.system.entity.MsModule;
import cn.roilat.modules.system.entity.dto.ModuleDTO;

public interface ModuleService  extends BaseService<MsModule>{
	Map<String, List<ModuleDTO>> listMenuAll();
	boolean selectOne(MsModule entity);
	int deleteByIds(String[] ids);
	int selectModuleByName(MsModule entity);
	int getModuleTotals(ModuleDTO module);
	List<MsModule> getModuleList(ModuleDTO module);
}
