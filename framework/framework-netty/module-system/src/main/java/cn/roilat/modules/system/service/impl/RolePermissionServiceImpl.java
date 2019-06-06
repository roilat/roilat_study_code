package cn.roilat.modules.system.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.google.common.collect.Maps;
import cn.roilat.framework.core.service.BaseServiceImpl;
import cn.roilat.modules.system.entity.MsRolePermission;
import cn.roilat.modules.system.entity.dto.RolePermissionDTO;
import cn.roilat.modules.system.mapper.RolePermissionMapper;
import cn.roilat.modules.system.service.RolePermissionService;

@Service("rolePermissionService")
public class RolePermissionServiceImpl extends BaseServiceImpl<MsRolePermission> implements RolePermissionService {
	@Autowired
	private RolePermissionMapper mapper;
	
	@Override
	@Transactional
	public int updateRolePermission(RolePermissionDTO rpDto) {
		Integer roleId = rpDto.getRoleId();
		Integer moduleId = rpDto.getModuleId();
		String permissionIds = rpDto.getPermissionIds();
		if(null != roleId && null != moduleId){
			HashMap<String,Object> condition = Maps.newHashMap();
			condition.put("roleId", roleId);
			condition.put("moduleId", moduleId);
			mapper.deleteRolePermission(condition);
			
			if(StringUtils.hasText(permissionIds)) {
				String[] pIds = permissionIds.split(",");
				List<MsRolePermission> list = new ArrayList<MsRolePermission>();
				for(String pId : pIds){
					MsRolePermission mp = new MsRolePermission();
					mp.setRoleId(roleId);
					mp.setPermissionId(Integer.parseInt(pId));
					list.add(mp);
				}
				return mapper.saveRolePermission(list);
			}
			return 1;
		}
		return 0;
	}

	@Override
	public List<MsRolePermission> selectRolePermissionByRoleId(RolePermissionDTO rpDto) {
		return mapper.selectRolePermissionByRoleId(rpDto);
	}
}
