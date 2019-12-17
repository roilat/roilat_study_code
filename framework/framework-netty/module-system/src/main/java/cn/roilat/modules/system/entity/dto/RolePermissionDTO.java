package cn.roilat.modules.system.entity.dto;

import java.io.Serializable;
import java.util.List;

public class RolePermissionDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer roleId;
	private String permissionIds;
	private Integer moduleId;
	private String[] checkedKeys;
	private List<PermissionDTO> checkedPermissionList;
	
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getPermissionIds() {
		return permissionIds;
	}
	public void setPermissionIds(String permissionIds) {
		this.permissionIds = permissionIds;
	}
	public Integer getModuleId() {
		return moduleId;
	}
	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}
	public String[] getCheckedKeys() {
		return checkedKeys;
	}
	public void setCheckedKeys(String[] checkedKeys) {
		this.checkedKeys = checkedKeys;
	}
	public List<PermissionDTO> getCheckedPermissionList() {
		return checkedPermissionList;
	}
	public void setCheckedPermissionList(List<PermissionDTO> checkedPermissionList) {
		this.checkedPermissionList = checkedPermissionList;
	}
	
}
