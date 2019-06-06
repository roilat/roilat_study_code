package cn.roilat.modules.system.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import cn.roilat.framework.core.service.BaseServiceImpl;
import cn.roilat.framework.utils.DateUtil;
import cn.roilat.framework.utils.StringUtil;
import cn.roilat.modules.system.entity.MsOrganization;
import cn.roilat.modules.system.entity.MsRole;
import cn.roilat.modules.system.entity.MsUser;
import cn.roilat.modules.system.entity.MsUserOrganization;
import cn.roilat.modules.system.entity.MsUserRole;
import cn.roilat.modules.system.entity.dto.UserInfoDTO;
import cn.roilat.modules.system.mapper.MsUserOrganizationMapper;
import cn.roilat.modules.system.mapper.MsUserRoleMapper;
import cn.roilat.modules.system.mapper.RoleMapper;
import cn.roilat.modules.system.mapper.UserMapper;
import cn.roilat.modules.system.service.OrganizationService;
import cn.roilat.modules.system.service.UserOrganizationService;
import cn.roilat.modules.system.service.UserService;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<MsUser> implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private MsUserRoleMapper userRoleMapper;
	@Autowired
	private MsUserOrganizationMapper userOrganizationMapper;
	@Autowired
	private OrganizationService organizationService;
	@Autowired
	private UserOrganizationService userOrganizationService;
	@Autowired
	private RoleMapper roleMapper;
	@Override
	public List<UserInfoDTO> getUserInfoList(HashMap<String,Object> map) {
		return userMapper.getUserInfoList(map);
	}

	@Override
	public int getUserInfoCount(HashMap<String, Object> map) {
		return userMapper.getUserInfoCount(map);
	}

	public List<UserInfoDTO> getUserInfoListNotInRoleId(HashMap<String,Object> map) {
		return userMapper.getUserInfoListNotInRoleId(map);
	}

	public int getUserInfoCountNotInRoleId(HashMap<String, Object> map) {
		return userMapper.getUserInfoCountNotInRoleId(map);
	}
	
	@Transactional
	@Override
	public boolean addUser(UserInfoDTO user) {
		try{
			MsUser userInfo = new MsUser();
			BeanUtils.copyProperties(user,userInfo);
			//查询对应用户名是否存在
			List<MsUser> us = userMapper.select(userInfo);
			if(us != null && us.size()>0){  //用户名存在，则不能插入
				return false;
			}
			//userInfo.setCreateUser(Constant.userInfo.get());
			userInfo.setCreateTime(new Date());
			userInfo.setStatus(1);  //默认插入的用户直接启用
			int i = userMapper.insert(userInfo);
			if(i == 1){
				List<MsUser> users = userMapper.select(userInfo);
				if(users != null && users.size()>0){
					userInfo = users.get(0);
				}
			}else{
				return false;
			}
			
			int userId = userInfo.getId();
			String groupids = user.getGroupids();
			if(StringUtils.hasText(groupids)){
				String[] groupsid = user.getGroupids().split(",");
				for(String groupId:groupsid){
					MsUserOrganization mo = new MsUserOrganization(user.getIsAdmin(), Integer.parseInt(groupId), userId);
					userOrganizationMapper.insert(mo);
				}
			}
			String roleids = user.getRoleids();
			if(StringUtils.hasText(roleids)){
				String[] rolesid = user.getRoleids().split(",");
				for(String roleId:rolesid){
					MsUserRole ur = new MsUserRole(userId, Integer.parseInt(roleId));
					userRoleMapper.insert(ur);
				}
			}else{
				MsUserRole ur = new MsUserRole(userId, 1);
				userRoleMapper.insert(ur);
			}
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	@Override
	public boolean updateUserStatus(UserInfoDTO user) {
		try{
			String userIds = user.getUserIds();
			if(StringUtils.hasText(userIds)){
				String[] ids = userIds.split(",");
				if(ids != null && ids.length >0){
					MsUser us = null;
					for(int i=0;i<ids.length;i++){
						us = new MsUser();
						us.setId(Integer.parseInt(ids[i]));
						us.setStatus(user.getStatus());
						userMapper.updateByPrimaryKeySelective(us);
					}
				}
			}
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}

	/*********
	 * 修改密码
	 */
	@Override
	public boolean updatePassword(UserInfoDTO user) {
		try{
			MsUser us = new MsUser();
			BeanUtils.copyProperties(user,us);
			//0为管理员修改密码   1为用户自己修改密码  
			int status = user.getModifyPwdType();
			if(status == 0){
				userMapper.updateByPrimaryKeySelective(us);
				return true;
			}else{
//				us = userMapper.selectOne(us);
//				if(us != null){
				if(null != us.getId()){
					us.setPassWord(user.getNewPassword());
					userMapper.updateByPrimaryKeySelective(us);
					return true;
				}else{
					//用户密码错误，不能进行修改
					return false;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	/*********
	 * 修改皮肤
	 */
	@Override
	public boolean updateSkin(UserInfoDTO user) {
		try{
			MsUser us = new MsUser();
			BeanUtils.copyProperties(user,us);
			us = userMapper.selectByPrimaryKey(us);
			if(us != null){
				us.setSkin(user.getSkin());
				userMapper.updateByPrimaryKeySelective(us);
				return true;
			}else{
				//用户皮肤错误，不能进行修改
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	@Override
	public boolean updateUserInfo(UserInfoDTO user) {
		try{
			MsUser us = new MsUser();
			BeanUtils.copyProperties(user, us);
			userMapper.updateByPrimaryKeySelective(us);
			//管理员修改用户信息
			if(user.getModifyUserInfoType() == 0){
				MsUserRole ur = new MsUserRole();
				ur.setUserId(user.getId());
				userRoleMapper.delete(ur);
				MsUserOrganization mo = new MsUserOrganization();
				mo.setUserId(user.getId());
				userOrganizationMapper.delete(mo);
				String roleids = user.getRoleids();
				if(StringUtils.hasText(roleids)){
					MsUserRole mr = null;
					String[] rids = roleids.split(",");
					for(String rid:rids){
						mr = new MsUserRole();
						mr.setUserId(user.getId());
						mr.setRoleId(Integer.parseInt(rid));
						userRoleMapper.insert(mr);
					}
				}
				
				String groupids = user.getGroupids();
				if(StringUtils.hasText(groupids)){
					MsUserOrganization mr = null;
					String[] gids = groupids.split(",");
					for(String gid:gids){
						mr = new MsUserOrganization();
						mr.setUserId(user.getId());
						mr.setOrganizationId(Integer.parseInt(gid));
						userOrganizationMapper.insert(mr);
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public List<MsRole> getRoleByUserId(Integer userId) {
		return userRoleMapper.getRoleByUserId(userId);
	}

	@Override
	public List<MsOrganization> getOrganizationByUserId(Integer userId) {
		return userOrganizationMapper.getOrganizationByUserId(userId);
	}

	@Override
	public Map<String, Object> getUserInfoByUserId(MsUser user) {
		Map<String,Object> map = Maps.newHashMap();
		try{
			MsUser us = userMapper.selectOne(user);
			if(us != null){
				MsRole roleDefault =roleMapper.selectByPrimaryKey(1);
				
				List<MsRole> role = getRoleByUserId(us.getId());
				List<MsOrganization> orga = getOrganizationByUserId(us.getId());
				List<MsRole> roles = roleMapper.selectAll();
				
				if(roles.contains(roleDefault)){
					roles.remove(roleDefault);
				}
				
				ArrayList<MsRole> rs = Lists.newArrayList(Sets.difference(Sets.newHashSet(roles),Sets.newHashSet(role)));
				map.put("groupids", orga);
				map.put("checkedRoleids", role);
				map.put("roleids", rs);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	
	@Override
	public List<UserInfoDTO> getUserInfoListNotOrganization(HashMap<String,Object> map) {
		return userMapper.getUserInfoListNotOrganization(map);
	}

	@Override
	public int getUserInfoCountNotOrganization(HashMap<String, Object> map) {
		return userMapper.getUserInfoCountNotOrganization(map);
	}
	
	@Override
	public void syncHrUserInfo() {
		BufferedReader buf = null;
		try{
			buf = new BufferedReader(new FileReader(new File("d:\\UsinfoAll_20180903.txt")));
            String temp = null ;
            while ((temp = buf.readLine()) != null ){
                List<String> strs = StringUtil.splitStringToList(temp, "\\|");
                MsOrganization org = new MsOrganization();
                org.setOrganizationCode(strs.get(3));
                MsOrganization msOrg = organizationService.getOne(org);
                if(msOrg == null){
                	continue;
                }
                MsUser user = new MsUser();
                user.setCode(strs.get(0));
                user.setTrueName(strs.get(1));
                user.setIdCard(strs.get(2));
                user.setMobile(strs.get(13));
                user.setDetailAddress(strs.get(37));
                user.setQq(strs.get(38));
                user.setEmail(strs.get(7));
                user.setStatus(1);  //可用     0为禁用
                user.setCreateTime(DateUtil.getCurrentDate());
                user.setModifyTime(DateUtil.getCurrentDate());
                user.setCreateUser("admin");
                user.setModifyUser("admin");
                user.setSkin(0);
                user.setFlag("1");
                String status = strs.get(39);
                if("00900".equals(status)){
                	user.setStatus(1);
                }else{
                	user.setStatus(0);
                }
                MsUser condition = new MsUser();
                condition.setCode(strs.get(0));
                condition = this.getOne(condition);
                if(condition == null){
                	this.save(user);
                }else{
                	user.setId(condition.getId());
                	this.update(user);
                }
                MsUserOrganization mso= new MsUserOrganization();
                mso.setOrganizationId(msOrg.getId());
                mso.setUserId(user.getId());
                MsUserOrganization condi = new MsUserOrganization();
                condi.setUserId(user.getId());
                MsUserOrganization ms = userOrganizationService.getOne(condi);
            	if(ms != null){
            		mso.setId(ms.getId());
            	}
                userOrganizationService.insertOrUpdate(mso);
            }
		}catch(Exception e){
			e.printStackTrace();
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
}
