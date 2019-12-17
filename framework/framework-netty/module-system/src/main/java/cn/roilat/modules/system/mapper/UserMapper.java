package cn.roilat.modules.system.mapper;


import java.util.HashMap;
import java.util.List;

import cn.roilat.modules.system.entity.MsUser;
import cn.roilat.modules.system.entity.dto.UserInfoDTO;

import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<MsUser>{
	public List<UserInfoDTO> getUserInfoList(HashMap<String,Object> map);
	public int getUserInfoCount(HashMap<String,Object> map);
	
	public List<UserInfoDTO> getUserInfoListNotInRoleId(HashMap<String,Object> map);
	public int getUserInfoCountNotInRoleId(HashMap<String,Object> map);
	
	public List<UserInfoDTO> getUserInfoListNotOrganization(HashMap<String,Object> map);
	public int getUserInfoCountNotOrganization(HashMap<String,Object> map);
	
}
