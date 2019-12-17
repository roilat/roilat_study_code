package cn.roilat.modules.system.service;

import java.util.Map;

import cn.roilat.framework.core.dto.DataDTO;
import cn.roilat.modules.system.entity.MsUserRole;

public interface UserRoleService {
	DataDTO getRoleUserList(Map<String,Object> map);
	public Integer deleteRoleUser(MsUserRole userRole);
	public Object addRoleUser(MsUserRole userRole);
	public Object emptyRoleUser(MsUserRole userRole);
}
