package cn.roilat.modules.system.entity.dto;

import java.io.Serializable;

public class ModulePermissionDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String userId;
	private String parentId;
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getParentId() {
		return parentId;
	}
	
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
}
