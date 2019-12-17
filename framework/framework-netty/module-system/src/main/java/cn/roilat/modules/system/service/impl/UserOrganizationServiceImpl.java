package cn.roilat.modules.system.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import cn.roilat.framework.core.service.BaseServiceImpl;
import cn.roilat.framework.utils.EncryptorUtils;
import cn.roilat.framework.utils.MD5Util;
import cn.roilat.modules.system.entity.MsUser;
import cn.roilat.modules.system.entity.MsUserOrganization;
import cn.roilat.modules.system.entity.dto.UserInfoDTO;
import cn.roilat.modules.system.entity.dto.UserOrganizationDto;
import cn.roilat.modules.system.mapper.MsUserOrganizationMapper;
import cn.roilat.modules.system.service.UserOrganizationService;
import cn.roilat.modules.system.service.UserService;

@Service("userOrganizationService")
public class UserOrganizationServiceImpl extends BaseServiceImpl<MsUserOrganization> implements UserOrganizationService {
	@Autowired
	private MsUserOrganizationMapper msUserOrganizationMapper;
	@Autowired
	private UserService userService;
	
	@Transactional
	@Override
	public boolean addUserToOrganation(UserInfoDTO info) {
		try{
			String groupid = info.getGroupids();
			String userIds = info.getUserIds();
			if(StringUtils.hasText(userIds)){
				String[] ids = userIds.split(",");
				if(ids!=null && ids.length > 0){
					MsUserOrganization entity = null;
					for(int i=0;i<ids.length;i++){
						entity = new MsUserOrganization();
						entity.setUserId(Integer.parseInt(ids[i]));
						entity.setOrganizationId(Integer.parseInt(groupid));
						entity.setIsAdmin(0);
						super.save(entity);
					}
				}
			}
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	@Transactional
	@Override
	public boolean removeUserToOrganation(UserInfoDTO info) {
		try{
			String groupid = info.getGroupids();
			String userIds = info.getUserIds();
			if(StringUtils.hasText(userIds)){
				String[] ids = userIds.split(",");
				if(ids!=null && ids.length > 0){
					MsUserOrganization entity = null;
					for(int i=0;i<ids.length;i++){
						entity = new MsUserOrganization();
						entity.setUserId(Integer.parseInt(ids[i]));
						entity.setOrganizationId(Integer.parseInt(groupid));
						List<MsUserOrganization> list = get(entity);
						if(list != null && list.size() > 0){
							for( int j = 0; j<list.size(); j++) {
								MsUserOrganization muo = list.get(j);
								super.delete(muo);
							}
							
						}
					}
				}
			}
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateUserToOrganation(UserInfoDTO info) {
		try{
			String groupid = info.getGroupids();
			String userIds = info.getUserIds();
			int isAdmin = info.getIsAdmin();
			
			if(StringUtils.hasText(userIds)){
				String[] ids = userIds.split(",");
				if(ids!=null && ids.length > 0){
					MsUserOrganization entity = null;
					for(int i=0;i<ids.length;i++){
						entity = new MsUserOrganization();
						entity.setUserId(Integer.parseInt(ids[i]));
						entity.setOrganizationId(Integer.parseInt(groupid));
						List<MsUserOrganization> list = get(entity);
						if(list != null && list.size() > 0){
							for( int j = 0; j<list.size(); j++) {
								MsUserOrganization muo = list.get(j);
								muo.setIsAdmin(isAdmin);
								super.update(muo);
							}
							
						}
					}
				}
			}	
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean createUserToOrganation(UserInfoDTO info) {
		try{
			MsUser user1 = new MsUser();
			user1.setUserName(info.getUserName());
			List<MsUser> us = userService.get(user1);
			if(us != null && us.size()>0){  //用户名存在，则不能插入
				return false;
			}
			MsUser user = new MsUser();
			BeanUtils.copyProperties(info,user);
			user.setPassWord(MD5Util.getMD5Code(EncryptorUtils.Decrypt(EncryptorUtils.key, EncryptorUtils.initVector, user.getPassWord())));
			//user.setCreateUser(Constant.userInfo.get());
			user.setCreateTime(new Date());
			user.setStatus(1);  //默认插入的用户直接启用
			int i = userService.save(user);
			if(i == 1){
				info.setUserIds(String.valueOf(user.getId()));
				return addUserToOrganation(info);
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<UserOrganizationDto> getUserOrganizationInfoByUserName(String userName) {
		return msUserOrganizationMapper.getUserOrganizationInfoByUserName(userName);
	}

	@Override
	public UserOrganizationDto getOrgName(String treeId) {
		List<UserOrganizationDto> list = msUserOrganizationMapper.getOrgName(treeId);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public String getDeptName(String treeId) {
		return msUserOrganizationMapper.getDeptName(treeId);
	}

	@Override
	public MsUserOrganization getMsUserOrganizationByUserId(Integer userId) {
		// TODO Auto-generated method stub
		List<MsUserOrganization> lmo = msUserOrganizationMapper.getMsUserOrganizationByUserId(userId);
		
		if(lmo.size()>0){
			return lmo.get(0);
		}else{
			return null;
		}
		
		
	}
	
}
