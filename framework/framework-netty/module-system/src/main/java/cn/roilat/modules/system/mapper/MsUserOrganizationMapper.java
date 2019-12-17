package cn.roilat.modules.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.roilat.modules.system.entity.MsOrganization;
import cn.roilat.modules.system.entity.MsUserOrganization;
import cn.roilat.modules.system.entity.dto.UserInfoDTO;
import cn.roilat.modules.system.entity.dto.UserOrganizationDto;

import tk.mybatis.mapper.common.Mapper;

public interface MsUserOrganizationMapper extends Mapper<MsUserOrganization>{
	public List<MsOrganization> getOrganizationByUserId(Integer userId);
	public List<UserInfoDTO> getSameOrganizationUserName(String userName);
	
	List<UserOrganizationDto> getUserOrganizationInfoByUserName(String userName);
	
	List<UserOrganizationDto> getOrgName(String treeId);
	
	String getDeptName(String treeId);
	
	public List<MsUserOrganization> getMsUserOrganizationByUserId(Integer userId);
}
