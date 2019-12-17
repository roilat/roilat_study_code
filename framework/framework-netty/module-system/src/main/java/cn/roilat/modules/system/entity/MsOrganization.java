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
 * The persistent class for the ms_organization database table.
 * 
 */
@Entity
@Table(name="ms_organization")
public class MsOrganization implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="JDBC")
	private Integer id;
	@Column(name="organization_code")
	private String organizationCode;
	
	@Column(name="abbreviation")
	private String abbreviation;

	@JSONField(format="yyyy-MM-dd HH:mm:ss") 
	@Column(name="create_time")
	private Date createTime;
	
	@Column(name="create_user")
	private String createUser;

	@Column(name="description")
	private String description;
	
	@JSONField(format="yyyy-MM-dd HH:mm:ss") 
	@Column(name="modify_time")
	private Date modifyTime;

	@Column(name="modify_user")
	private String modifyUser;

	@Column(name="order_num")
	private Integer orderNum;

	@Column(name="organization_name")
	private String organizationName;

	@Column(name="parent_id")
	private Integer parentId;

	@Column(name="status")
	private Integer status;
	
	@Column(name="tree_id")
	private String treeId;
	
	@Column(name="organization_type")
	private String organizationType;
	@Column(name="hr_org_id")
	private String hrOrgId;
	
	private String flag;
	
	public String getHrOrgId() {
		return hrOrgId;
	}

	public void setHrOrgId(String hrOrgId) {
		this.hrOrgId = hrOrgId;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getOrganizationType() {
		return organizationType;
	}

	public void setOrganizationType(String organizationType) {
		this.organizationType = organizationType;
	}

	public String getOrganizationCode() {
		return organizationCode;
	}

	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}

	public String getTreeId() {
		return treeId;
	}

	public void setTreeId(String treeId) {
		this.treeId = treeId;
	}

	public MsOrganization() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAbbreviation() {
		return this.abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public String getOrganizationName() {
		return this.organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}