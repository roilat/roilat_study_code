package cn.roilat.modules.system.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ms_role_permission database table.
 * 
 */
@Entity
@Table(name="ms_role_permission")
public class MsRolePermission implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="JDBC")
	private Integer id;

	@Column(name="permission_id")
	private Integer permissionId;

	@Column(name="role_id")
	private Integer roleId;

	public MsRolePermission() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPermissionId() {
		return this.permissionId;
	}

	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

}