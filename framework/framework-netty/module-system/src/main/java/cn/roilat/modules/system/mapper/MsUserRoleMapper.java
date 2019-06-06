package cn.roilat.modules.system.mapper;

import java.util.List;

import cn.roilat.modules.system.entity.MsRole;
import cn.roilat.modules.system.entity.MsUserRole;

import tk.mybatis.mapper.common.Mapper;

public interface MsUserRoleMapper extends Mapper<MsUserRole>{
	public List<MsRole> getRoleByUserId(Integer userId);
}
