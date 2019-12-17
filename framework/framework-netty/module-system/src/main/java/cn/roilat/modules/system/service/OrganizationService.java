package cn.roilat.modules.system.service;

import java.util.List;
import java.util.Map;

import cn.roilat.modules.system.entity.MsOrganization;
import cn.roilat.modules.system.entity.MsUserOrganization;
import cn.roilat.modules.system.entity.dto.OrganizationDTO;
import cn.roilat.framework.core.service.BaseService;
import cn.roilat.framework.core.dto.DataDTO;

public interface OrganizationService extends BaseService<MsOrganization>{
	public DataDTO getChildrenNode(Map<String,Object> map);
	
	
	public int batchDeleteOrganization(List<Integer> ids);
	
	public MsOrganization getOrganizationByTreeId(String treeId);
	
	public DataDTO getUserInfoListByOrganizationId(Map<String,Object> map);
	
	public int moveOrganization(OrganizationDTO dto);
	
	public void syncHrBranch();
}
