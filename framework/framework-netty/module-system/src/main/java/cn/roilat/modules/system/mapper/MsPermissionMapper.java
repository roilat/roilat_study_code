package cn.roilat.modules.system.mapper;

import java.util.List;

import cn.roilat.modules.system.entity.MsPermission;
import cn.roilat.modules.system.entity.dto.ModulePermissionDTO;

import tk.mybatis.mapper.common.Mapper;

public interface MsPermissionMapper extends Mapper<MsPermission>{
	public List<MsPermission> getPermissionByUserId(Integer id);
	public List<MsPermission> getRoleModulePermission(ModulePermissionDTO entity);
	int selectPermissionByName(MsPermission entity);
	int deletePermissionByIds(String[] ids);
	MsPermission selectEntityOne(MsPermission entity);
	public List<MsPermission> getAllWithModuleId(MsPermission entity);
}
