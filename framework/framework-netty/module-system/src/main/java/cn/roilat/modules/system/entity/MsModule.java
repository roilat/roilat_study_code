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
 * The persistent class for the ms_module database table.
 * 
 */
@Entity
@Table(name="ms_module")
public class MsModule implements Serializable {
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

	@Column(name="modify_time")
	@JSONField (format="yyyy-MM-dd HH:mm:ss") 
	private Date modifyTime;

	@Column(name="modify_user")
	private String modifyUser;

	@Column(name="module_name")
	private String moduleName;

	@Column(name="order_num")
	private Integer orderNum;

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
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getModuleName() {
		return this.moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public Integer getOrderNum() {
		return this.orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
}