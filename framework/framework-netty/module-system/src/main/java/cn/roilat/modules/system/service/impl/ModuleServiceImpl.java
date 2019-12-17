package cn.roilat.modules.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.roilat.modules.system.entity.MsModule;
import cn.roilat.modules.system.entity.dto.ModuleDTO;
import cn.roilat.modules.system.mapper.ModuleMapper;
import cn.roilat.modules.system.service.ModuleService;
import cn.roilat.framework.core.service.BaseServiceImpl;

@Service("moduleService")
public class ModuleServiceImpl extends BaseServiceImpl<MsModule> implements ModuleService {
	@Autowired
	private ModuleMapper mapper;
	
	@Override
	public Map<String, List<ModuleDTO>> listMenuAll(){
		List<ModuleDTO> list = this.mapper.listModuleAll();
		Map<String, List<ModuleDTO>> map = new HashMap<String, List<ModuleDTO>>();
		map.put("datas", list);
		return map;
	}
	
	@Override
	public int deleteByIds(String[] ids) {
		return mapper.deleteByIds(ids);
	}

	@Override
	public boolean selectOne(MsModule entity){
		MsModule mm = mapper.selectOne(entity);
		if(null != mm){
			return true;
		}
		return false;
	}
	
	@Override
	public int selectModuleByName(MsModule entity){
		return mapper.selectModuleByName(entity);
	}

	@Override
	public int getModuleTotals(ModuleDTO module) {
		return mapper.getModuleTotals(module);
	}

	@Override
	public List<MsModule> getModuleList(ModuleDTO module) {
		return mapper.getModuleList(module);
	}

}
