package cn.roilat.modules.system.entity.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.google.common.collect.Lists;


public class PermissionDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String permissionCode;
	
	private String permissionUri;
	
	private Date createTime;

	private String createUser;

	private Integer isMenu;

	private Integer isSystemPermission;

	private Date modifyTime;

	private String modifyUser;

	private Integer parentId;
	
	private String parentName;

	private String permissionName;

	private Integer permissionType;

	private Integer status;

	private String url;
	
	private Integer moduleId;
	
	private List<PermissionDTO> children = Lists.newArrayList();
	
	private String label;
	
	private String ids;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Integer getIsMenu() {
		return isMenu;
	}

	public void setIsMenu(Integer isMenu) {
		this.isMenu = isMenu;
	}

	public Integer getIsSystemPermission() {
		return isSystemPermission;
	}

	public void setIsSystemPermission(Integer isSystemPermission) {
		this.isSystemPermission = isSystemPermission;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getModifyUser() {
		return modifyUser;
	}

	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public Integer getPermissionType() {
		return permissionType;
	}

	public void setPermissionType(Integer permissionType) {
		this.permissionType = permissionType;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getModuleId() {
		return moduleId;
	}

	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}

	public List<PermissionDTO> getChildren() {
		return children;
	}

	public void setChildren(List<PermissionDTO> children) {
		this.children = children;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getPermissionCode() {
		return permissionCode;
	}

	public void setPermissionCode(String permissionCode) {
		this.permissionCode = permissionCode;
	}

	public String getPermissionUri() {
		return permissionUri;
	}

	public void setPermissionUri(String permissionUri) {
		this.permissionUri = permissionUri;
	}
	
	
}
