package cn.roilat.modules.system.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.roilat.framework.core.service.BaseServiceImpl;
import cn.roilat.modules.system.entity.MsRole;
import cn.roilat.modules.system.mapper.RoleMapper;
import cn.roilat.modules.system.service.RoleService;

@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<MsRole> implements RoleService {
	@Autowired
	private RoleMapper roleMapper;
	
	@Transactional
	public boolean addRole(MsRole role) {
		try{
			MsRole roleInfo = new MsRole();
			BeanUtils.copyProperties(role, roleInfo);

			//roleInfo.setCreateUser(Constant.userInfo.get());
			roleInfo.setCreateTime(new Date());
			roleInfo.setStatus(1);  //默认插入直接启用
			roleInfo.setIsSystemRole(0);
			int i = roleMapper.insert(roleInfo);
			if(i == 1){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	@Transactional
	public boolean updateRole(MsRole role) {
		try{
			MsRole roleInfo = new MsRole();
			BeanUtils.copyProperties(role, roleInfo);

			//roleInfo.setModifyUser(Constant.userInfo.get());
			roleInfo.setModifyTime(new Date());
			roleMapper.updateByPrimaryKeySelective(roleInfo);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public List<MsRole> getRoleList(HashMap<String,Object> map) {
		List<MsRole> list = roleMapper.getRoleList(map);
		return list;
	}
	
	public List<MsRole> getRoleListWithoutPage(HashMap<String,Object> map) {
		List<MsRole> list = roleMapper.getRoleListWithoutPage(map);
		return list;
	}
	
	public Integer getRoleCount(HashMap<String,Object> map) {
		int counts = roleMapper.getRoleCount(map);
		return counts;
	}
	
	public MsRole getRoleInfoById(MsRole role) {
		return roleMapper.selectByPrimaryKey(role.getId());
	}
}
