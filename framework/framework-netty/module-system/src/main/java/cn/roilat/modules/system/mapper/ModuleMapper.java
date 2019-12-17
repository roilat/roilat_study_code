package cn.roilat.modules.system.mapper;

import java.util.List;

import cn.roilat.modules.system.entity.MsModule;
import cn.roilat.modules.system.entity.dto.ModuleDTO;

import tk.mybatis.mapper.common.Mapper;

public interface ModuleMapper extends Mapper<MsModule> {
	List<ModuleDTO> listModuleAll();
	int deleteByIds(String[] ids);
	int selectModuleByName(MsModule entity);
	int getModuleTotals(ModuleDTO module);
	List<MsModule> getModuleList(ModuleDTO module);
}
