package cn.roilat.modules.system.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ms_user_role database table.
 * 
 */
@Entity
@Table(name="ms_user_role")
public class MsUserRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="JDBC")
	private Integer id;

	@Column(name="user_id")
	private Integer userId;

	@Column(name="role_id")
	private Integer roleId;

	public MsUserRole() {
	}
	
	public MsUserRole(Integer userId, Integer roleId) {
		this.userId = userId;
		this.roleId = roleId;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}