package cn.roilat.modules.system.service;

import java.util.List;

import cn.roilat.modules.system.entity.MsUserOrganization;
import cn.roilat.modules.system.entity.dto.UserInfoDTO;
import cn.roilat.modules.system.entity.dto.UserOrganizationDto;
import cn.roilat.framework.core.service.BaseService;

public interface UserOrganizationService extends BaseService<MsUserOrganization>{
	
	boolean addUserToOrganation(UserInfoDTO info);
	
	boolean updateUserToOrganation(UserInfoDTO info);
	
	boolean createUserToOrganation(UserInfoDTO info);
	
	boolean removeUserToOrganation(UserInfoDTO info);
	
	List<UserOrganizationDto> getUserOrganizationInfoByUserName(String userName);
	
	UserOrganizationDto getOrgName(String treeId);
	
	String getDeptName(String treeId);

	MsUserOrganization getMsUserOrganizationByUserId(Integer id);
}
