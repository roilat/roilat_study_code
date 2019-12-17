package cn.roilat.modules.system.entity.dto;

import java.io.Serializable;

public class RoleDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String roleIds;
	private String all;
	private String roleName;
	private String createUser;
	
	

	public String getAll() {
		return all;
	}

	public void setAll(String all) {
		this.all = all;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}
}
