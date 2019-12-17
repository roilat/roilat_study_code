package cn.roilat.modules.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.roilat.framework.core.service.BaseServiceImpl;
import cn.roilat.modules.system.entity.MsPermission;
import cn.roilat.modules.system.entity.dto.ModulePermissionDTO;
import cn.roilat.modules.system.mapper.MsPermissionMapper;
import cn.roilat.modules.system.service.PermissionService;

@Service("permissionService")
public class PermissionServiceImpl extends BaseServiceImpl<MsPermission> implements PermissionService {
	
	@Autowired
	private MsPermissionMapper mapper;
	
	@Override
	public List<MsPermission> getPermissionByUserId(int id) {
		return mapper.getPermissionByUserId(id);
	}
	
	@Override
	public List<MsPermission> getRoleModulePermission(ModulePermissionDTO entity) {
		return mapper.getRoleModulePermission(entity);
	}

	@Override
	public int deletePermissionByIds(String[] ids) {
		return mapper.deletePermissionByIds(ids);
	}
	
	@Override
	public int selectPermissionByName(MsPermission entity) {
		return mapper.selectPermissionByName(entity);
	}

	@Override
	public MsPermission selectEntityOne(MsPermission entity) {
		return mapper.selectOne(entity);
	}
	
	public List<MsPermission> getAllWithModuleId(MsPermission entity) {
		return mapper.getAllWithModuleId(entity);
	}
}
