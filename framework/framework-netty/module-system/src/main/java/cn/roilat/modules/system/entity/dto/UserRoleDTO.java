package cn.roilat.modules.system.entity.dto;

import java.io.Serializable;

public class UserRoleDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int roleId;
	private String userIds;
	
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getUserIds() {
		return userIds;
	}
	public void setUserIds(String userIds) {
		this.userIds = userIds;
	}
}
