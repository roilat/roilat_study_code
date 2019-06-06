package cn.roilat.modules.system.service;

import java.util.List;

import cn.roilat.modules.system.entity.MsPermission;
import cn.roilat.modules.system.entity.dto.ModulePermissionDTO;
import cn.roilat.framework.core.service.BaseService;

public interface PermissionService extends BaseService<MsPermission>{
	public List<MsPermission> getPermissionByUserId(int id);
	public List<MsPermission> getRoleModulePermission(ModulePermissionDTO entity);
	int deletePermissionByIds(String[] ids);
	int selectPermissionByName(MsPermission entity);
	MsPermission selectEntityOne(MsPermission entity);
	public List<MsPermission> getAllWithModuleId(MsPermission permission);
}
