package cn.roilat.modules.system.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.roilat.framework.core.dto.DataDTO;
import cn.roilat.modules.system.entity.MsUser;
import cn.roilat.modules.system.entity.MsUserRole;
import cn.roilat.modules.system.mapper.UserRoleMapper;
import cn.roilat.modules.system.service.UserRoleService;

@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService {
	@Autowired
	private UserRoleMapper userRoleMapper;
	
	public DataDTO getRoleUserList(Map<String,Object> map) {
		int totals = userRoleMapper.getUserCountByRoleId(map);
		List<MsUser> datas = userRoleMapper.getRoleUserList(map);
		return DataDTO.getInstance(datas,(int)map.get("pageSize"), (int)map.get("currentPage"), totals);
	}
	
	public Integer deleteRoleUser(MsUserRole userRole) {
		return userRoleMapper.deleteRoleUser(userRole);
	}
	
	public Object addRoleUser(MsUserRole userRole) {
		return userRoleMapper.addRoleUser(userRole);
	}
	
	public Object emptyRoleUser(MsUserRole userRole) {
		return userRoleMapper.emptyRoleUser(userRole);
	}
}
