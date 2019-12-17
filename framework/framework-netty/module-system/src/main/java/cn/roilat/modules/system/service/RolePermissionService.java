package cn.roilat.modules.system.service;

import java.util.List;

import cn.roilat.modules.system.entity.MsRolePermission;
import cn.roilat.modules.system.entity.dto.RolePermissionDTO;
import cn.roilat.framework.core.service.BaseService;

public interface RolePermissionService extends BaseService<MsRolePermission>{
	int updateRolePermission(RolePermissionDTO rpDto);
	List<MsRolePermission> selectRolePermissionByRoleId(RolePermissionDTO rpDto);
}
