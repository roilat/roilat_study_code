package cn.roilat.modules.system.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.roilat.modules.system.entity.MsOrganization;
import cn.roilat.modules.system.entity.MsRole;
import cn.roilat.modules.system.entity.MsUser;
import cn.roilat.modules.system.entity.dto.UserInfoDTO;
import cn.roilat.framework.core.service.BaseService;

public interface UserService extends BaseService<MsUser>{
	
	public List<UserInfoDTO> getUserInfoList(HashMap<String,Object> map);
	public int getUserInfoCount(HashMap<String,Object> map);
	
	public List<UserInfoDTO> getUserInfoListNotInRoleId(HashMap<String,Object> map);
	public int getUserInfoCountNotInRoleId(HashMap<String,Object> map);
	
	public List<MsRole> getRoleByUserId(Integer userId);
	
	public List<MsOrganization> getOrganizationByUserId(Integer userId);
	
	public Map<String,Object> getUserInfoByUserId(MsUser user);
	
	public boolean addUser(UserInfoDTO user);
	
	public boolean updateUserStatus(UserInfoDTO user);
	
	public boolean updatePassword(UserInfoDTO user);
	
	public boolean updateSkin(UserInfoDTO user);
	
	public boolean updateUserInfo(UserInfoDTO user);
	
	public List<UserInfoDTO> getUserInfoListNotOrganization(HashMap<String,Object> map);
	public int getUserInfoCountNotOrganization(HashMap<String,Object> map);
	
	public void syncHrUserInfo();
}
