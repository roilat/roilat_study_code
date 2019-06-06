package cn.roilat.modules.system.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Maps;
import cn.roilat.framework.core.controller.BaseController;
import cn.roilat.framework.core.dto.DataDTO;
import cn.roilat.framework.core.dto.PageHelper;
import cn.roilat.framework.core.mvc.UrlMapping;
import cn.roilat.framework.result.ResponseResult;
import cn.roilat.modules.system.entity.MsRole;
import cn.roilat.modules.system.entity.dto.RoleDTO;
import cn.roilat.modules.system.service.RoleService;

@Component
@UrlMapping("/role")
public class RoleController extends BaseController<MsRole> {
	@Autowired
	private RoleService roleService;
	
	@UrlMapping("/addRole")
	public ResponseResult addRole(MsRole role) {
		boolean flag = roleService.addRole(role);
		if(flag){
			return ResponseResult.succ();
		}else{
			return ResponseResult.fail();
		}
	}
	
	@UrlMapping("/updateRole")
	public ResponseResult updateRole(MsRole role) {
		boolean flag = roleService.updateRole(role);
		if(flag){
			return ResponseResult.succ();
		}else{
			return ResponseResult.fail();
		}
	}
	
	@UrlMapping("/getRoleList")
	public ResponseResult getRoleList(RoleDTO roleDTO,PageHelper page) {
		HashMap<String,Object> condition = Maps.newHashMap();
		condition.put("all",roleDTO.getAll());
		condition.put("roleName",roleDTO.getRoleName());
		condition.put("createUser",roleDTO.getCreateUser());
		condition.put("offest",(page.getCurrentPage()-1)*page.getPageSize());
		condition.put("pageSize",page.getPageSize());
		List<MsRole> datas = roleService.getRoleList(condition);
		int totals =  (roleService.getRoleCount(condition)).intValue();

		if(datas != null && datas.size() >= 0) {
			DataDTO dto = DataDTO.getInstance(datas,page.getCurrentPage(), totals);
			return ResponseResult.succ(dto);
		}else{
			return ResponseResult.fail("获取角色信息失败，请检查相关参数是否正确");
		}
	}
	
	@UrlMapping("/getRoleListWithoutPage")
	public ResponseResult getRoleListWithoutPage() {
		HashMap<String,Object> condition = Maps.newHashMap();
		List<MsRole> datas = roleService.getRoleListWithoutPage(condition);

		if(datas != null && datas.size() >= 0) {
			return ResponseResult.succ(datas);
		}else{
			return ResponseResult.fail("获取角色信息失败，请检查相关参数是否正确");
		}
	}
	
	@UrlMapping("/getRoleInfoById")
	public ResponseResult getRoleInfoById(MsRole role) {
		MsRole roleData = roleService.getRoleInfoById(role);
		if(roleData != null){
			return ResponseResult.succ(roleData);
		} else {
			return ResponseResult.fail("暂无角色数据");
		}
	}
	
	@UrlMapping("/deleteRoles")
	public ResponseResult deleteRoles(RoleDTO roleDTO){
		String[] rolesId = roleDTO.getRoleIds().split(",");
		
		try {
			for (String roleId : rolesId) {
				MsRole role = new MsRole();
				role.setId(Integer.parseInt(roleId));
				roleService.delete(role);
			}
			return ResponseResult.succ();
		} catch (Exception e) {
			return ResponseResult.fail();
		} 
	}
}
