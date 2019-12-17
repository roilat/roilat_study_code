package cn.roilat.modules.system.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import cn.roilat.framework.core.controller.BaseController;
import cn.roilat.framework.core.dto.DataDTO;
import cn.roilat.framework.core.dto.PageHelper;
import cn.roilat.framework.core.dto.UuidDTO;
import cn.roilat.framework.core.mvc.UrlMapping;
import cn.roilat.framework.core.redis.RedisService;
import cn.roilat.framework.result.ResponseResult;
import cn.roilat.framework.utils.EncryptorUtils;
import cn.roilat.framework.utils.JwtUtil;
import cn.roilat.framework.utils.MD5Util;
import cn.roilat.modules.system.entity.MsPermission;
import cn.roilat.modules.system.entity.MsUser;
import cn.roilat.modules.system.entity.dto.LoginUserDTO;
import cn.roilat.modules.system.entity.dto.ModulePermissionDTO;
import cn.roilat.modules.system.entity.dto.PermissionDTO;
import cn.roilat.modules.system.entity.dto.UserInfoDTO;
import cn.roilat.modules.system.service.PermissionService;
import cn.roilat.modules.system.service.UserService;

@Component
@UrlMapping("/user")
public class UserController extends BaseController<MsUser>{
	
	@Autowired
	private UserService userService;
	@Autowired
	private RedisService jedisService;
	@Autowired
	private PermissionService permissionService;
	
	@UrlMapping("/login")
	public ResponseResult login(MsUser user, UuidDTO uuidDTO) throws UnsupportedEncodingException{
        user.setPassWord(MD5Util.getMD5Code(EncryptorUtils.Decrypt(EncryptorUtils.key, EncryptorUtils.initVector, user.getPassWord())));
        
		try{
			List<MsUser> list = userService.get(user);
			if(list == null || list.size() == 0){
				return ResponseResult.fail("用户名或密码错误");
			}else if(list.size() > 1){
				return ResponseResult.fail("存在多个用户");
			}
			MsUser us = list.get(0);
			if(us.getStatus() != 1){
				return ResponseResult.fail("该用户未启用，请联系管理员");
			}
			//用戶一旦登錄成功，即創建token
			JSONObject obj = new JSONObject();
			obj.put("username",us.getUserName());
			obj.put("uuid", uuidDTO.getUuid());
			System.out.println("json--->"+obj.toString());
			String token = JwtUtil.createJWT(obj.toString());
			System.out.println("token--->"+token);
			List<MsPermission> permissions = permissionService.getPermissionByUserId(us.getId());
			List<PermissionDTO> dtos = processPermission(permissions);
			
			List<PermissionDTO> menus = processPermissionMenu(permissions);
			LoginUserDTO userInfo = new LoginUserDTO();
			BeanUtils.copyProperties(us,userInfo);
			userInfo.setPermissions(dtos);
			userInfo.setMenus(menus);
			userInfo.setMsPermissions(permissions);
			//只在当前用户
			// SpringApplicationContext.msUser.set(userInfo);
			
			
			//將token保存在redis緩存中
			jedisService.set(us.getUserName(),token,1200);
			return ResponseResult.succ(userInfo,token,"1800");
		}catch(Exception e){
			e.printStackTrace();
			return ResponseResult.fail("数据库连接失败，请稍后重试");
		}
		
	}
	
	@UrlMapping("/getPermissionByParentId")
	public ResponseResult getPermissionByParentId(ModulePermissionDTO entity){
		List<MsPermission> permissions = permissionService.getRoleModulePermission(entity);
		return ResponseResult.succ(permissions);
	}
	
	@UrlMapping("/refresh")
	public ResponseResult refresh(){
		return ResponseResult.succ("登录成功");
	}
	
	private List<PermissionDTO> processPermission(List<MsPermission> permissions){
		List<PermissionDTO> list = Lists.newArrayList();
		if(permissions != null && permissions.size() > 0){
			for(MsPermission permission:permissions){
				if(permission.getParentId() == 0){
					PermissionDTO per = new PermissionDTO();
					BeanUtils.copyProperties(permission, per);
					list.add(per);
					createTree(per, permissions);
				}
			}
			
		}
		return list;
	}
	
	private void createTree(PermissionDTO dto, List<MsPermission> permissions ) {
		if(dto.getIsMenu() == 1) {
			for(MsPermission permission:permissions){
				if(dto.getId() == permission.getParentId()){
					PermissionDTO per = new PermissionDTO();
					BeanUtils.copyProperties(permission,per);
					dto.getChildren().add(per);
					createTree(per,permissions);
				}
			}
		}
	}
	
	private List<PermissionDTO> processPermissionMenu(List<MsPermission> permissions){
		List<PermissionDTO> list = Lists.newArrayList();
		if(permissions != null && permissions.size() > 0){
			for(MsPermission permission:permissions){
				if(permission.getParentId() == 0){
					PermissionDTO per = new PermissionDTO();
					BeanUtils.copyProperties(permission, per);
					list.add(per);
					createTreeMenu(per, permissions);
				}
			}
			
		}
		return list;
	}
	private void createTreeMenu(PermissionDTO dto, List<MsPermission> permissions ) {
		if(dto.getIsMenu() == 1) {
			for(MsPermission permission:permissions){
				if(dto.getId() == permission.getParentId() &&permission.getIsMenu() == 1){
					PermissionDTO per = new PermissionDTO();
					BeanUtils.copyProperties(permission,per);
					dto.getChildren().add(per);
					createTreeMenu(per,permissions);
				}
			}
		}
	}
	
	
	@UrlMapping("/getUserInfoList")
	public ResponseResult getUserInfoList(UserInfoDTO user,PageHelper page){
		HashMap<String,Object> condition = Maps.newHashMap();
		condition.put("userName",user.getUserName());
		condition.put("trueName",user.getTrueName());
		condition.put("roleName",user.getRoles());
		condition.put("status",user.getStatus());
		condition.put("all",user.getAll());
		condition.put("offest",(page.getCurrentPage()-1)*page.getPageSize());
		condition.put("pageSize",page.getPageSize());
		List<UserInfoDTO> datas = userService.getUserInfoList(condition);
		int totals = userService.getUserInfoCount(condition);
		if(datas != null && datas.size() >= 0){
		   DataDTO dto = DataDTO.getInstance(datas,page.getCurrentPage(), totals);
		   return ResponseResult.succ(dto);
		}else{
		   return ResponseResult.fail("获取用户信息失败，请检查相关参数是否正确");
		}
	}
	
	@UrlMapping("/getUserInfoListNotInRoleId")
	public ResponseResult getUserInfoListNotInRoleId(UserInfoDTO user,PageHelper page){
		HashMap<String,Object> condition = Maps.newHashMap();
		condition.put("userName",user.getUserName());
		condition.put("trueName",user.getTrueName());
		condition.put("roleName",user.getRoles());
		condition.put("status",user.getStatus());
		condition.put("all",user.getAll());
		condition.put("notRoleId",user.getNotRoleId());
		condition.put("offest",(page.getCurrentPage()-1)*page.getPageSize());
		condition.put("pageSize",page.getPageSize());
		List<UserInfoDTO> datas = userService.getUserInfoListNotInRoleId(condition);
		int totals = userService.getUserInfoCountNotInRoleId(condition);
		if(datas != null && datas.size() >= 0){
		   DataDTO dto = DataDTO.getInstance(datas,page.getCurrentPage(), totals);
		   return ResponseResult.succ(dto);
		}else{
		   return ResponseResult.fail("获取用户信息失败，请检查相关参数是否正确");
		}
	}
	
	
	@UrlMapping("/getUserInfoByUserId")
	public ResponseResult getUserInfoByUserId(MsUser user){
		Map<String,Object> map = userService.getUserInfoByUserId(user);
		return ResponseResult.succ(map);
	}
	
	@UrlMapping("/getUserInfoByUserName")
	public ResponseResult getUserInfoByUserName(MsUser user){
		List<MsUser> users = null;
		try {
			users = userService.get(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (users == null || users.size() == 0) {
			return ResponseResult.succ("用户可以注册");
		} else {
			return ResponseResult.succ("用户已经存在");
		}
		
	}
	
	@UrlMapping("/getUserInfoByTrueName")
	public ResponseResult getUserInfoByTrueName(MsUser user){
		List<MsUser> users = null;
		try {
			users = userService.get(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (users == null || users.size() == 0) {
			return ResponseResult.succ("姓名可以注册");
		} else {
			return ResponseResult.succ("姓名已经存在");
		}
		
	}
	
	
	
	@UrlMapping("/addUser")
	public ResponseResult addUser(UserInfoDTO user){
		user.setPassWord(MD5Util.getMD5Code(EncryptorUtils.Decrypt(EncryptorUtils.key, EncryptorUtils.initVector, user.getPassWord())));
		boolean flag = userService.addUser(user);
		if(flag){
			return ResponseResult.succ();
		}else{
			return ResponseResult.fail();
		}
	}
	
	@UrlMapping("/updateUserStatus")
	public ResponseResult updateUser(UserInfoDTO user){
		boolean flag = userService.updateUserStatus(user);
		if(flag){
			return ResponseResult.succ();
		}else{
			return ResponseResult.fail();
		}
	}
	
	@UrlMapping("/updatePassword")
	public ResponseResult updatePassword(UserInfoDTO user){
		int status = user.getModifyPwdType();
		if (status == 0) {
			user.setPassWord(MD5Util.getMD5Code(EncryptorUtils.Decrypt(EncryptorUtils.key, EncryptorUtils.initVector, user.getPassWord())));
		} else {
			user.setPassWord(MD5Util.getMD5Code(EncryptorUtils.Decrypt(EncryptorUtils.key, EncryptorUtils.initVector, user.getPassWord())));
			user.setNewPassword(MD5Util.getMD5Code(EncryptorUtils.Decrypt(EncryptorUtils.key, EncryptorUtils.initVector, user.getNewPassword())));
		}
		
		boolean flag = userService.updatePassword(user);
		if(flag){
			return ResponseResult.succ();
		}else{
			return ResponseResult.fail("原密码错误");
		}
	}
	
	@UrlMapping("/updateSkin")
	public ResponseResult updateSkin(UserInfoDTO user){
		boolean flag = userService.updateSkin(user);
		if(flag){
			return ResponseResult.succ();
		}else{
			return ResponseResult.fail();
		}
	}
	
	@UrlMapping("/updateUserInfo")
	public ResponseResult updateUserInfo(UserInfoDTO user){
		boolean flag = userService.updateUserInfo(user);
		if(flag){
			return ResponseResult.succ();
		}else{
			return ResponseResult.fail();
		}
	}
	
	@UrlMapping("/getUserInfoListNotOrganization")
	public ResponseResult getUserInfoListNotOrganization(UserInfoDTO user,PageHelper page){
		HashMap<String,Object> condition = Maps.newHashMap();
		condition.put("notOrganizationId",user.getNotOrganizationId());
		condition.put("userName",user.getUserName());
		condition.put("trueName",user.getTrueName());
		condition.put("roleName",user.getRoles());
		condition.put("status",user.getStatus());
		condition.put("all",user.getAll());
		condition.put("offest",(page.getCurrentPage()-1)*page.getPageSize());
		condition.put("pageSize",page.getPageSize());
		List<UserInfoDTO> datas = userService.getUserInfoListNotOrganization(condition);
		int totals = userService.getUserInfoCountNotOrganization(condition);
		if(datas != null && datas.size() >= 0){
		   DataDTO dto = DataDTO.getInstance(datas,page.getCurrentPage(), totals);
		   return ResponseResult.succ(dto);
		}else{
		   return ResponseResult.fail("获取用户信息失败，请检查相关参数是否正确");
		}
	}
	
}
