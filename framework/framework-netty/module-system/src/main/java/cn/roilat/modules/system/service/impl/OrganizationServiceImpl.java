package cn.roilat.modules.system.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.google.common.collect.Lists;
import cn.roilat.framework.core.dto.DataDTO;
import cn.roilat.framework.core.service.BaseServiceImpl;
import cn.roilat.framework.utils.DateUtil;
import cn.roilat.framework.utils.StringUtil;
import cn.roilat.modules.system.entity.MsOrganization;
import cn.roilat.modules.system.entity.dto.OrganizationDTO;
import cn.roilat.modules.system.entity.dto.UserInfoDTO;
import cn.roilat.modules.system.mapper.MsOaganizationMapper;
import cn.roilat.modules.system.service.OrganizationService;

@Service("organizationService")
public class OrganizationServiceImpl extends BaseServiceImpl<MsOrganization> implements OrganizationService {
	@Autowired
	private MsOaganizationMapper mapper;
	@Override
	public DataDTO getChildrenNode(Map<String,Object> map) {
		int totals = mapper.getChildrenNodeCounts(map);
		List<MsOrganization> datas = mapper.getChildrenNode(map);
		return DataDTO.getInstance(datas,(int)map.get("pageSize"), (int)map.get("currentPage"), totals);
	}
	@Override
	public int batchDeleteOrganization(List<Integer> ids) {
		return mapper.batchDeleteOrganization(ids);
	}
	
	@Override
	public DataDTO getUserInfoListByOrganizationId(Map<String,Object> map) {
		int totals = mapper.getUserCountByOrganizationId(map);
		List<UserInfoDTO> datas = mapper.getUserInfoListByOrganizationId(map);
/*		if(datas != null && datas.size() > 0){
			for(int i = 0; i < datas.size(); i++){
				UserInfoDTO uf = datas.get(i);
				if("1".equals(uf.getApproveUser())){
					uf.setMoneySection(uf.getStartMoney()+"-"+uf.getEndMoney());
				}
			}
		}
*/		return DataDTO.getInstance(datas,(int)map.get("pageSize"), (int)map.get("currentPage"), totals);
	}
	@Override
	public int moveOrganization(OrganizationDTO dto) {
		MsOrganization entity = new MsOrganization();
		BeanUtils.copyProperties(dto,entity);
		try {
			return super.update(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public void syncHrBranch() {
		BufferedReader buf = null;
		List<List<String>> result = Lists.newArrayList(); 
		List<List<String>> result_one = Lists.newArrayList(); 
		List<List<String>> result_two = Lists.newArrayList(); 
		List<List<String>> result_three = Lists.newArrayList(); 
		List<List<String>> result_four = Lists.newArrayList(); 
		try {
			buf = new BufferedReader(new FileReader(new File("d:\\KubBrchInfoAll_20180903.txt")));
            String temp = null ;
            while ((temp = buf.readLine()) != null ){
                List<String> strs = StringUtil.splitStringToList(temp, "\\|");
                result.add(strs);
            }
            result_one = result.stream().filter(e ->e.get(5).length()==3).collect(Collectors.toList());
            result_two = result.stream().filter(e ->e.get(5).length()==6).collect(Collectors.toList());
            result_three = result.stream().filter(e ->e.get(5).length()==9).collect(Collectors.toList());
            result_four = result.stream().filter(e ->e.get(5).length()==12).collect(Collectors.toList());
            addData(result_one);
            addData(result_two);
            addData(result_three);
            addData(result_four);
		} catch (Exception e1) {
			e1.printStackTrace();
		}finally{
            if(buf != null){
            	try {
					buf.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
		}
		
	}
	
	
	private void addData(List<List<String>> list) throws Exception {
		if(list != null && list.size() > 0){
			for(int i = 0; i < list.size(); i++){
				List<String> lineData = list.get(i);
				if(!CollectionUtils.isEmpty(lineData)){
					MsOrganization con = new MsOrganization();
		        	MsOrganization org = new MsOrganization();
		        	org.setOrganizationCode(lineData.get(1));
		        	org.setOrganizationName(lineData.get(2));
		        	String treeId = lineData.get(5);
		        	org.setTreeId(treeId);
		        	if(treeId.length() == 3){
		        		org.setParentId(0);
		        	}else if(treeId.length() == 6){
		        		con.setTreeId(treeId.substring(0,3));
		        		MsOrganization msOrganization = this.getOne(con);
			        	if(msOrganization == null){
			        		continue;
			        	}
			        	org.setParentId(msOrganization.getId());
		        	}else if(treeId.length() == 9){
		        		con.setTreeId(treeId.substring(0,6));
		        		MsOrganization msOrganization = this.getOne(con);
			        	if(msOrganization == null){
			        		continue;
			        	}
			        	org.setParentId(msOrganization.getId());
		        	}else if(treeId.length() == 12){
		        		con.setTreeId(treeId.substring(0,9));
		        		MsOrganization msOrganization = this.getOne(con);
			        	if(msOrganization == null){
			        		continue;
			        	}
			        	org.setParentId(msOrganization.getId());
		        	}else{
		        		continue;
		        	}
		        	
		        	String deleted = lineData.get(14);
		        	if("00900".equals(deleted)){
		        		org.setStatus(1);  //可用
		        	}else{
		        		org.setStatus(0);  //不可用
		        	}
		        	org.setCreateTime(DateUtil.getCurrentDate());
		        	org.setModifyTime(DateUtil.getCurrentDate());
		        	org.setCreateUser("admin");
		        	org.setModifyUser("admin");
		        	org.setFlag("1");
		        	MsOrganization condition = new MsOrganization();
		        	condition.setOrganizationCode(lineData.get(1));
		        	condition.setTreeId(org.getTreeId());
		    		MsOrganization msOrg = this.getOne(condition);
		    		if(msOrg != null){
		    			org.setId(msOrg.getId());
		    			this.update(org);
		    		}else{
		    			this.save(org);
		    		}
		        }
			}
		}
	}
	@Override
	public MsOrganization getOrganizationByTreeId(String treeId) {
		// TODO Auto-generated method stub
		return mapper.getOrganizationByTreeId(treeId);
	}
	
}
