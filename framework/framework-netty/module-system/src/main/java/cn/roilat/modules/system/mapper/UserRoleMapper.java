package cn.roilat.modules.system.mapper;

import java.util.List;
import java.util.Map;

import cn.roilat.modules.system.entity.MsUser;
import cn.roilat.modules.system.entity.MsUserRole;

public interface UserRoleMapper {
	public int getUserCountByRoleId(Map<String,Object> map);
	public List<MsUser> getRoleUserList(Map<String,Object> map);
	public Integer deleteRoleUser(MsUserRole userRole);
	public Object addRoleUser(MsUserRole userRole);
	public Object emptyRoleUser(MsUserRole userRole);
}
