package cn.roilat.modules.system.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.roilat.framework.core.controller.BaseController;
import cn.roilat.framework.core.mvc.UrlMapping;
import cn.roilat.framework.result.ResponseResult;
import cn.roilat.modules.system.constant.Constant;
import cn.roilat.modules.system.entity.MsPermission;
import cn.roilat.modules.system.entity.dto.PermissionDTO;
import cn.roilat.modules.system.service.PermissionService;

@Component
@UrlMapping("/permission")
public class PermissionController extends BaseController<MsPermission> {
	@Autowired
	private PermissionService permissionService;
	
	@UrlMapping("/savePermission")
	public ResponseResult savePermission(MsPermission entity){
		int count = permissionService.selectPermissionByName(entity);
		if(count != 0){
			return ResponseResult.fail("权限名称已存在");
		}
		entity.setStatus(1);
		entity.setCreateTime(new Date());
		entity.setCreateUser(Constant.userName.get());
		entity.setIsSystemPermission(0);
		return super.save(entity);
	}
	
	@UrlMapping("/updatePermission")
	public ResponseResult updatePermission(MsPermission entity){
		int count = permissionService.selectPermissionByName(entity);
		if(count != 0){
			return ResponseResult.fail("权限名称已存在");
		}
		entity.setModifyTime(new Date());
		entity.setModifyUser(Constant.userName.get());
		return super.update(entity);
	}
	
	@UrlMapping("/deletePermission")
	public ResponseResult deletePermission(PermissionDTO permissionDto){
		String ids = permissionDto.getIds();
		int count = permissionService.deletePermissionByIds(ids.split(","));
		if(count == 0){
			return ResponseResult.fail();
		} 
		return ResponseResult.succ();
	}
	
	@UrlMapping("/selectEntityOne")
	public ResponseResult selectEntityOne(MsPermission entity){
		MsPermission mp = this.permissionService.selectEntityOne(entity);
		if(null != mp){
			return ResponseResult.succ(mp);
		}
		return ResponseResult.fail("暂无明细数据");
	}
	
	@UrlMapping("/permissionTree")
	public ResponseResult permissionTree(){
		List<MsPermission> listAll = null;
		try {
			listAll = this.permissionService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(null != listAll && listAll.size() > 0){
			List<PermissionDTO> parentList = new ArrayList<PermissionDTO>();
			for(MsPermission parent : listAll){
				PermissionDTO parentDto = new PermissionDTO();
				if(parent.getParentId()==0 && parent.getStatus()==1){
					parentDto.setId(parent.getId());
					parentDto.setPermissionName(parent.getPermissionName());
					parentDto.setUrl(parent.getUrl());
					parentDto.setPermissionType(parent.getPermissionType());
					parentDto.setPermissionCode(parent.getPermissionCode());
					parentDto.setPermissionUri(parent.getPermissionUri());
					parentDto.setStatus(parent.getStatus());
					parentDto.setIsMenu(parent.getIsMenu());
					parentDto.setModuleId(parent.getModuleId());
					parentDto.setParentId(parent.getParentId());
					parentDto.setIsSystemPermission(parent.getIsSystemPermission());
					parentDto.setCreateTime(parent.getCreateTime());
					parentDto.setCreateUser(parent.getCreateUser());
					parentDto.setParentName("");
					parentList.add(parentDto);
					createTree(parentDto, listAll);
				}
			}
			return ResponseResult.succ(parentList);
		}
		return ResponseResult.fail("暂无tree数据");
	}
	@UrlMapping("/permissionTreeWithModuleId")
	public ResponseResult permissionTreeWithModuleId(MsPermission entity){
		List<MsPermission> listAll = this.permissionService.getAllWithModuleId(entity);
		if(null != listAll && listAll.size() > 0){
			List<PermissionDTO> parentList = new ArrayList<PermissionDTO>();
			for(MsPermission parent : listAll){
				PermissionDTO parentDto = new PermissionDTO();
				if(parent.getParentId()==0 && parent.getStatus()==1){
					parentDto.setId(parent.getId());
					parentDto.setPermissionName(parent.getPermissionName());
					parentDto.setUrl(parent.getUrl());
					parentDto.setPermissionType(parent.getPermissionType());
					parentDto.setPermissionCode(parent.getPermissionCode());
					parentDto.setPermissionUri(parent.getPermissionUri());
					parentDto.setStatus(parent.getStatus());
					parentDto.setIsMenu(parent.getIsMenu());
					parentDto.setModuleId(parent.getModuleId());
					parentDto.setParentId(parent.getParentId());
					parentDto.setIsSystemPermission(parent.getIsSystemPermission());
					parentDto.setCreateTime(parent.getCreateTime());
					parentDto.setCreateUser(parent.getCreateUser());
					parentDto.setParentName("");
					parentList.add(parentDto);
					createTree(parentDto, listAll);
				}
			}
			return ResponseResult.succ(parentList);
		}
		return ResponseResult.fail("暂无tree数据");
	}
	private void createTree(PermissionDTO dto, List<MsPermission> listAll ) {
		for(MsPermission msPermission:listAll){
			if(dto.getId() == msPermission.getParentId() && msPermission.getStatus()==1){
				PermissionDTO nodeDto = new PermissionDTO();
				nodeDto.setId(msPermission.getId());
				nodeDto.setPermissionName(msPermission.getPermissionName());
				nodeDto.setUrl(msPermission.getUrl());
				nodeDto.setPermissionType(msPermission.getPermissionType());
				nodeDto.setPermissionCode(msPermission.getPermissionCode());
				nodeDto.setPermissionUri(msPermission.getPermissionUri());
				nodeDto.setStatus(msPermission.getStatus());
				nodeDto.setIsMenu(msPermission.getIsMenu());
				nodeDto.setModuleId(msPermission.getModuleId());
				nodeDto.setParentId(msPermission.getParentId());
				nodeDto.setIsSystemPermission(msPermission.getIsSystemPermission());
				nodeDto.setCreateTime(msPermission.getCreateTime());
				nodeDto.setCreateUser(msPermission.getCreateUser());
				nodeDto.setParentName(dto.getPermissionName());
				dto.getChildren().add(nodeDto);
				createTree(nodeDto,listAll);
			}
		}
	}
}
