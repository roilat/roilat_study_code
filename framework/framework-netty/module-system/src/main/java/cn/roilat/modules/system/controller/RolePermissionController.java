package cn.roilat.modules.system.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.roilat.framework.core.controller.BaseController;
import cn.roilat.framework.core.mvc.UrlMapping;
import cn.roilat.framework.result.ResponseResult;
import cn.roilat.modules.system.entity.MsPermission;
import cn.roilat.modules.system.entity.MsRolePermission;
import cn.roilat.modules.system.entity.dto.ModuleDTO;
import cn.roilat.modules.system.entity.dto.PermissionDTO;
import cn.roilat.modules.system.entity.dto.RolePermissionDTO;
import cn.roilat.modules.system.service.ModuleService;
import cn.roilat.modules.system.service.PermissionService;
import cn.roilat.modules.system.service.RolePermissionService;

@Component
@UrlMapping("/rolePermission")
public class RolePermissionController extends BaseController<MsRolePermission> {
	@Autowired
	private RolePermissionService rolePermissionService;
	@Autowired
	private ModuleService moduleService;
	@Autowired
	private PermissionService permissionService;
	
	/**
	 * 角色权限设置、修改
	 * @param rpDto
	 * @return
	 */
	@UrlMapping("/updateRolePermission")
	public ResponseResult updateRolePermission(RolePermissionDTO rpDto){
		int count = this.rolePermissionService.updateRolePermission(rpDto);
		if(count == 0){
			return ResponseResult.fail();
		}
		return ResponseResult.succ();
	}
	
	/**
	 * 模块菜单
	 * @return
	 */
	@UrlMapping("/selectMenu")
	public ResponseResult selectMenu(){
		Map<String, List<ModuleDTO>> map = this.moduleService.listMenuAll();
		if(null != map.get("menus") && map.get("menus").size() > 0){
			return ResponseResult.succ(map);
		}
		return ResponseResult.fail("暂无模块数据");
	}
	
	/**
	 * 根据模块、状态返回可用的权限树
	 * @param rpDto
	 * @return
	 */
	@UrlMapping("/permissionTree")
	public ResponseResult permissionTree(RolePermissionDTO rpDto){
		List<MsPermission> listAll = null;
		try {
			listAll = this.permissionService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(null != listAll && listAll.size() > 0){
			//已选中角色权限
			List<MsRolePermission> mrpList = this.rolePermissionService.selectRolePermissionByRoleId(rpDto);
			String[] checkedKey = new String[]{""};
			if(null != mrpList && mrpList.size() > 0){
				checkedKey = new String[mrpList.size()];
				for(int i=0;i<mrpList.size();i++){
					MsRolePermission mrp = mrpList.get(i);
					checkedKey[i] = String.valueOf(mrp.getPermissionId());
				}
			} 
			
			
			List<PermissionDTO> parentList = new ArrayList<PermissionDTO>();
			for(MsPermission parent : listAll){
				PermissionDTO parentDto = new PermissionDTO();
				if(parent.getParentId()==0 && parent.getStatus()==1 
						&& parent.getModuleId().equals(rpDto.getModuleId())){
					parentDto.setId(parent.getId());
					parentDto.setPermissionName(parent.getPermissionName());
					
//					for(MsPermission node : listAll){
//						if(parent.getId() == node.getParentId() && node.getStatus()==1 
//								&& parent.getModuleId().equals(rpDto.getModuleId())){
//							PermissionDTO nodeDto = new PermissionDTO();
//							nodeDto.setId(node.getId());
//							nodeDto.setLabel(node.getPermissionName());
//							parentDto.getChildren().add(nodeDto);
//						}
//					}
					parentList.add(parentDto);
					this.createTree(parentDto, listAll);
				}
			}
			rpDto.setCheckedKeys(checkedKey);
			rpDto.setCheckedPermissionList(parentList);
			return ResponseResult.succ(rpDto);
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
