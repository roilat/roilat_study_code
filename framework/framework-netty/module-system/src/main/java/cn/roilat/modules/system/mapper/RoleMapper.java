package cn.roilat.modules.system.mapper;

import java.util.HashMap;
import java.util.List;

import cn.roilat.modules.system.entity.MsRole;

import tk.mybatis.mapper.common.Mapper;

public interface RoleMapper extends Mapper<MsRole> {
	public List<MsRole> getRoleList(HashMap<String, Object> map);
	public List<MsRole> getRoleListWithoutPage(HashMap<String, Object> map);
	public Integer getRoleCount(HashMap<String, Object> map);
}
