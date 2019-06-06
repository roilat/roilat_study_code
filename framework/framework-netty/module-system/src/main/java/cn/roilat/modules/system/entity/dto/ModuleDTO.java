package cn.roilat.modules.system.entity.dto;

import java.io.Serializable;

import cn.roilat.framework.core.dto.PageHelper;

public class ModuleDTO extends PageHelper implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String ids;
	private String moduleName;
	private String createUser;
	private String all;
	
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getAll() {
		return all;
	}
	public void setAll(String all) {
		this.all = all;
	}
	
	
}
