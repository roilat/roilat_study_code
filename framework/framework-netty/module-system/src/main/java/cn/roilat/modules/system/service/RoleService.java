package cn.roilat.modules.system.service;

import java.util.HashMap;
import java.util.List;

import cn.roilat.modules.system.entity.MsRole;
import cn.roilat.framework.core.service.BaseService;

public interface RoleService extends BaseService<MsRole> {
	public boolean addRole(MsRole role);
	public boolean updateRole(MsRole role);
	public List<MsRole> getRoleList(HashMap<String,Object> map);
	public List<MsRole> getRoleListWithoutPage(HashMap<String,Object> map);
	public Integer getRoleCount(HashMap<String,Object> map);
	public MsRole getRoleInfoById(MsRole role);
}
