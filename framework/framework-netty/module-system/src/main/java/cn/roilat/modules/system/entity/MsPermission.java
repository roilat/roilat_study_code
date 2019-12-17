package cn.roilat.modules.system.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * The persistent class for the ms_permission database table.
 * 
 */
@Entity
@Table(name="ms_permission")
public class MsPermission implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="JDBC")
	private Integer id;
	

	@Column(name="create_time")
	@JSONField (format="yyyy-MM-dd HH:mm:ss") 
	private Date createTime;

	@Column(name="permission_code")
	private String permissionCode;
	
	@Column(name="permission_uri")
	private String permissionUri;
	
	@Column(name="create_user")
	private String createUser;

	@Column(name="is_menu")
	private Integer isMenu;

	@Column(name="is_system_permission")
	private Integer isSystemPermission;

	@Column(name="modify_time")
	@JSONField (format="yyyy-MM-dd HH:mm:ss") 
	private Date modifyTime;

	@Column(name="modify_user")
	private String modifyUser;

	@Column(name="parent_id")
	private Integer parentId;

	@Column(name="permission_name")
	private String permissionName;

	@Column(name="permission_type")
	private Integer permissionType;

	@Column(name="status")
	private Integer status;

	@Column(name="url")
	private String url;
	
	@Column(name="module_id")
	private Integer moduleId;

	public Integer getModuleId() {
		return moduleId;
	}

	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}

	public MsPermission() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Integer getIsMenu() {
		return this.isMenu;
	}

	public void setIsMenu(Integer isMenu) {
		this.isMenu = isMenu;
	}

	public Integer getIsSystemPermission() {
		return this.isSystemPermission;
	}

	public void setIsSystemPermission(Integer isSystemPermission) {
		this.isSystemPermission = isSystemPermission;
	}

	public Date getModifyTime() {
		return this.modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getModifyUser() {
		return this.modifyUser;
	}

	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}

	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getPermissionName() {
		return this.permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public Integer getPermissionType() {
		return this.permissionType;
	}

	public void setPermissionType(Integer permissionType) {
		this.permissionType = permissionType;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
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