package cn.roilat.modules.system.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import cn.roilat.framework.core.controller.BaseController;
import cn.roilat.framework.core.dto.DataDTO;
import cn.roilat.framework.core.mvc.UrlMapping;
import cn.roilat.framework.result.ResponseResult;
import cn.roilat.modules.system.constant.Constant;
import cn.roilat.modules.system.entity.MsOrganization;
import cn.roilat.modules.system.entity.dto.OrganizationDTO;
import cn.roilat.modules.system.entity.dto.OrganizationTreeData;
import cn.roilat.modules.system.entity.dto.UserInfoDTO;
import cn.roilat.modules.system.service.OrganizationService;
import cn.roilat.modules.system.service.UserOrganizationService;

@Component
@UrlMapping("/organization")
public class OrganizationController extends BaseController<MsOrganization>{
	
	@Autowired
	private OrganizationService organizationService;
	
	@Autowired
	private UserOrganizationService userOrganizationService;
	@UrlMapping("/organizationTree")
	public ResponseResult organizationTree(){
		try{
			List<OrganizationTreeData> tree = Lists.newArrayList();
			List<OrganizationTreeData> datas = Lists.newArrayList();
			List<MsOrganization> lists = organizationService.getAll();
			if(lists != null && lists.size() > 0){
				for(MsOrganization organization:lists){
					
					if(organization.getFlag().equals("1")  && organization.getStatus().equals(1)){
						OrganizationTreeData data = new OrganizationTreeData();
						data.setId(organization.getId());
						data.setPid(organization.getParentId());
						data.setLabel(organization.getOrganizationName());
						data.setStatus(organization.getStatus());
						datas.add(data);
					}
					
				}
			}
			
			for(OrganizationTreeData node:datas){
				if(node.getPid() == 0){
					tree.add(node);
					createTree(node, datas);
				}
			}
			return ResponseResult.succ(tree);
		}catch(Exception e){
			e.printStackTrace();
			return ResponseResult.fail();
		}
	}
	private void createTree(OrganizationTreeData dto, List<OrganizationTreeData> Organizations ) {
		for(OrganizationTreeData organizationTreeData:Organizations){
			if(dto.getId().equals(organizationTreeData.getPid()) && organizationTreeData.getStatus() == 1){
				dto.getChildrenBak().add(organizationTreeData);
				createTree(organizationTreeData,Organizations);
			}
		}
	}
	
	@UrlMapping("/getChildrenNode")
	public ResponseResult getChildrenNode(OrganizationDTO orga, cn.roilat.framework.core.dto.PageHelper page){
		try{
			if(orga.getId() == null){
				return ResponseResult.fail("节点ID值不存在，请检查");
			}
			HashMap<String,Object> condition = Maps.newHashMap();
			condition.put("pid",orga.getId());
			condition.put("currentPage",page.getCurrentPage());
			condition.put("pageSize",page.getPageSize());
			condition.put("offest",(page.getCurrentPage()-1)*page.getPageSize());
			condition.put("organizationName",orga.getOrganizationName());
			condition.put("all",orga.getAll());
			condition.put("abbreviation", orga.getAbbreviation());
			DataDTO dto = organizationService.getChildrenNode(condition);
			return ResponseResult.succ(dto);
		}catch(Exception e){
			e.printStackTrace();
			return ResponseResult.fail();
		}
	}
	
	@UrlMapping("/addOrganization")
	public ResponseResult addOrganization(MsOrganization orga){
		try{
			orga.setCreateTime(new Date());
			orga.setCreateUser(Constant.userName.get());
			orga.setStatus(1);  //新建组织状态默认就是1
			return super.save(orga);
		}catch(Exception e){
			e.printStackTrace();
			return ResponseResult.fail();
		}
	} 
	
	@UrlMapping("/batchDeleteOrganization")
	public ResponseResult batchDeleteOrganization(OrganizationDTO dto){
		try{
			String[] ids = dto.getIds();
			if(null != ids){
				List<Integer> list = Lists.newArrayList();
				for(String id : ids){
					list.add(Integer.parseInt(id));
				}
				organizationService.batchDeleteOrganization(list);
				return ResponseResult.succ();
			}
			return ResponseResult.fail("IDS缺省");
			
		}catch(Exception e){
			e.printStackTrace();
			return ResponseResult.fail();
		}
	} 
	 
	@UrlMapping("/updateOrganization")
	public ResponseResult updateOrganization(MsOrganization orga){
		try{
			orga.setModifyTime(new Date());
			orga.setModifyUser(Constant.userName.get());
			return super.update(orga);
		}catch(Exception e){
			e.printStackTrace();
			return ResponseResult.fail();
		}
	}
	
	@UrlMapping("/getUserInfoListByOrganizationId")
	public ResponseResult getUserInfoListByOrganizationId(MsOrganization orga,cn.roilat.framework.core.dto.PageHelper page, UserInfoDTO user){
		try{
			HashMap<String,Object> condition = Maps.newHashMap();
			condition.put("id",orga.getId());
			condition.put("currentPage",page.getCurrentPage());
			condition.put("offest",(page.getCurrentPage()-1)*page.getPageSize());
			condition.put("pageSize",page.getPageSize());
			condition.put("userName", user.getUserName());
			condition.put("trueName", user.getTrueName());
			condition.put("all", user.getAll());
			condition.put("roleName", user.getRoles());
			DataDTO dto = organizationService.getUserInfoListByOrganizationId(condition);
			return ResponseResult.succ(dto);
		}catch(Exception e){
			e.printStackTrace();
			return ResponseResult.fail();
		}
	}
	
	
	@UrlMapping("/addUserToOrganation")
	public ResponseResult addUserToOrganation(UserInfoDTO info){
		boolean flag = userOrganizationService.addUserToOrganation(info);
		if(flag){
			return ResponseResult.succ();
		}else{
			return ResponseResult.fail();
		}
	}
	
	@UrlMapping("/removeUserToOrganation")
	public ResponseResult removeUserToOrganation(UserInfoDTO info){
		boolean flag = userOrganizationService.removeUserToOrganation(info);
		if(flag){
			return ResponseResult.succ();
		}else{
			return ResponseResult.fail();
		}
	}
	
	
	@UrlMapping("/changeUserToAdmin")
	public ResponseResult changeUserToAdmin(UserInfoDTO info){
		
		boolean flag = userOrganizationService.updateUserToOrganation(info);
		if(flag){
			return ResponseResult.succ();
		}else{
			return ResponseResult.fail();
		}
	}
	
	@UrlMapping("/createUserToOrganation")
	public ResponseResult createUserToOrganation(UserInfoDTO info){
		
		boolean flag = userOrganizationService.createUserToOrganation(info);
		if(flag){
			return ResponseResult.succ();
		}else{
			return ResponseResult.fail();
		}
	}
	
	
	@UrlMapping("/moveOrganation")
	public ResponseResult moveOrganation(OrganizationDTO dto){
		int i = organizationService.moveOrganization(dto);
		if(i == 1){
			return ResponseResult.succ();
		}else{
			return ResponseResult.fail();
		}
	}
	
}
