package cn.roilat.modules.system.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ms_user_organization database table.
 * 
 */
@Entity
@Table(name="ms_user_organization")
public class MsUserOrganization implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="JDBC")
	private Integer id;

	@Column(name="is_admin")
	private Integer isAdmin;

	@Column(name="organization_id")
	private Integer organizationId;

	@Column(name="user_id")
	private Integer userId;

	public MsUserOrganization() {
	}

	
	
	public MsUserOrganization(Integer isAdmin, Integer organizationId, Integer userId) {
		this.isAdmin = isAdmin;
		this.organizationId = organizationId;
		this.userId = userId;
	}



	public Integer getId() {
		return this.id;
	}

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIsAdmin() {
		return this.isAdmin;
	}

	public void setIsAdmin(Integer isAdmin) {
		this.isAdmin = isAdmin;
	}
}