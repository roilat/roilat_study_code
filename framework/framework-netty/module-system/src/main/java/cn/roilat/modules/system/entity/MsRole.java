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
 * The persistent class for the ms_role database table.
 * 
 */
@Entity
@Table(name="ms_role")
public class MsRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="JDBC")
	private Integer id;

	@Column(name="create_time")
	@JSONField (format="yyyy-MM-dd HH:mm:ss") 
	private Date createTime;

	@Column(name="create_user")
	private String createUser;

	@Column(name="description")
	private String description;

	@Column(name="is_system_role")
	private Integer isSystemRole;

	@Column(name="modify_time")
	@JSONField (format="yyyy-MM-dd HH:mm:ss") 
	private Date modifyTime;

	@Column(name="modify_user")
	private String modifyUser;

	@Column(name="role_name")
	private String roleName;

	@Column(name="status")
	private Integer status;

	public MsRole() {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getIsSystemRole() {
		return this.isSystemRole;
	}

	public void setIsSystemRole(Integer isSystemRole) {
		this.isSystemRole = isSystemRole;
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

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return id.hashCode()+roleName.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;  
        if (!(obj instanceof MsRole)) {  
            return false;  
        }
        MsRole usRole = (MsRole) obj;  
        if(id == usRole.getId()){
        	return true;
        }else{
        	return false;
        }
	}
	
	
	
}