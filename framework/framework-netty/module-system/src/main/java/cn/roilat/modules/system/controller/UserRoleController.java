package cn.roilat.modules.system.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Maps;
import cn.roilat.framework.core.dto.DataDTO;
import cn.roilat.framework.core.dto.PageHelper;
import cn.roilat.framework.core.mvc.UrlMapping;
import cn.roilat.framework.result.ResponseResult;
import cn.roilat.modules.system.entity.MsUserRole;
import cn.roilat.modules.system.entity.dto.UserRoleDTO;
import cn.roilat.modules.system.entity.dto.UserRoleListDTO;
import cn.roilat.modules.system.service.UserRoleService;

@Component
@UrlMapping("/userRole")
public class UserRoleController {
	@Autowired 
	UserRoleService userRoleService;
	
	@UrlMapping("/getRoleUserList")
	public ResponseResult getRoleUserList(UserRoleListDTO userRoleListDTO, PageHelper page) {		
		try{
			HashMap<String,Object> condition = Maps.newHashMap();
			condition.put("roleId",userRoleListDTO.getRoleId());
			condition.put("userName", userRoleListDTO.getUserName());
			condition.put("trueName", userRoleListDTO.getTrueName());
			condition.put("all", userRoleListDTO.getAll());
			condition.put("currentPage",page.getCurrentPage());
			condition.put("offest",(page.getCurrentPage()-1)*page.getPageSize());
			condition.put("pageSize",page.getPageSize());

			DataDTO dto = userRoleService.getRoleUserList(condition);
			return ResponseResult.succ(dto);
		}catch(Exception e){
			e.printStackTrace();
			return ResponseResult.fail();
		}
	}
	
	@UrlMapping("/deleteRoleUser")
	public ResponseResult deleteRoleUser(UserRoleDTO userRoleDTO) {
		int roleId = userRoleDTO.getRoleId();
		String[] usersId = userRoleDTO.getUserIds().split(",");
		
		try {
			for (String userId : usersId) {
				MsUserRole userRole = new MsUserRole();
				userRole.setRoleId(roleId);
				userRole.setUserId(Integer.parseInt(userId));
				userRoleService.deleteRoleUser(userRole);
			}
			return ResponseResult.succ();
		} catch (Exception e) {
			return ResponseResult.fail();
		} 
	}
	
	@UrlMapping("/addRoleUser")
	public ResponseResult addRoleUser(UserRoleDTO userRoleDTO) {
		int roleId = userRoleDTO.getRoleId();
		String[] usersId = userRoleDTO.getUserIds().split(",");
		
		try {
			MsUserRole emptyUserRole = new MsUserRole();
			emptyUserRole.setRoleId(roleId);
			userRoleService.emptyRoleUser(emptyUserRole);
			
			for (String userId : usersId) {
				MsUserRole userRole = new MsUserRole();
				userRole.setRoleId(roleId);
				userRole.setUserId(Integer.parseInt(userId));
				userRoleService.addRoleUser(userRole);
			}
			return ResponseResult.succ();
		} catch (Exception e) {
			return ResponseResult.fail();
		}
	}
	
	@UrlMapping("/emptyRoleUser")
	public ResponseResult emptyRoleUser(MsUserRole userRole) {
		userRoleService.emptyRoleUser(userRole);
		return ResponseResult.succ();
	}
}
