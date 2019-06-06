package cn.roilat.modules.system.mapper;

import java.util.List;
import java.util.Map;

import cn.roilat.modules.system.entity.MsOrganization;
import cn.roilat.modules.system.entity.MsUserOrganization;
import cn.roilat.modules.system.entity.dto.UserInfoDTO;

import tk.mybatis.mapper.common.Mapper;

public interface MsOaganizationMapper extends Mapper<MsOrganization>{
	
	
	public List<MsOrganization> getOrganizationList();
	
	public List<MsOrganization> getChildrenNode(Map<String,Object> map);
	
	public MsOrganization getOrganizationByTreeId(String treeId);
	
	public int getChildrenNodeCounts(Map<String,Object> map);
	
	public int batchDeleteOrganization(List<Integer> ids);
	
	public List<UserInfoDTO> getUserInfoListByOrganizationId(Map<String,Object> map);
	
	public int getUserCountByOrganizationId(Map<String,Object> map);
}
