package cn.roilat.modules.system.entity.dto;

import java.io.Serializable;

public class UserRoleListDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String roleId;
	private String all;
	private String userName;
	private String trueName;
	private String createUser;
	
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getAll() {
		return all;
	}
	public void setAll(String all) {
		this.all = all;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
}
