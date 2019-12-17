package cn.roilat.modules.system.mapper;

import java.util.HashMap;
import java.util.List;

import cn.roilat.modules.system.entity.MsRolePermission;
import cn.roilat.modules.system.entity.dto.RolePermissionDTO;

import tk.mybatis.mapper.common.Mapper;

public interface RolePermissionMapper extends Mapper<MsRolePermission> {
	void deleteRolePermission(HashMap<String,Object> map);
	int saveRolePermission(List<MsRolePermission> mrp);
	List<MsRolePermission> selectRolePermissionByRoleId(RolePermissionDTO rpDto);
}
